package com.unireg.ui.students;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.unireg.model.entities.Student;
import com.unireg.services.RemoveStuService;
import com.unireg.services.ShowStuService;
import com.unireg.ui.commons.HomeUI;
import com.unireg.utils.Constants;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Page;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.MultiSelectionModel;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@SpringView(name = RemoveStuLayoutFactory.NAME, ui = HomeUI.class)
public class RemoveStuLayoutFactory extends VerticalLayout implements View, Button.ClickListener {
	private static final Logger LOG = LoggerFactory.getLogger(RemoveStuLayoutFactory.class);
	public static final String NAME = "removestudent";
	private static final long serialVersionUID = 1L;
	@Autowired
	private ShowStuService showStuService;
	@Autowired
	private RemoveStuService removeStuService;
	private Grid stuTable;
	private Button remove;
	private Button cancel;
	private List<Student> stus;
	BeanItemContainer<Student> beanContainer;
	private Notification n;
	
	private void init(){
		remove = new Button(Constants.REMOVE.getStr(), this);
		cancel = new Button(Constants.CANCEL.getStr(), this);
		beanContainer = new BeanItemContainer<Student>(Student.class, stus);
		stuTable = new Grid(beanContainer);
	}
	
	private void addLayout(){
		setMargin(true);
		stuTable.setColumnOrder("firstName", "lastName", "age", "gender");
		stuTable.removeColumn("id");
		stuTable.removeColumn("university");
		stuTable.setImmediate(true);
		stuTable.setSelectionMode(SelectionMode.MULTI);
		stuTable.setSizeFull();
		remove.setStyleName(ValoTheme.BUTTON_FRIENDLY);
		cancel.setStyleName(ValoTheme.BUTTON_PRIMARY);
		addComponent(stuTable);
		addComponent(new Label(""));
		addComponent(new HorizontalLayout(cancel, remove));
	}
	
	public void buttonClick(ClickEvent e){
		if(e.getSource() == this.remove){
			remove();
		} else{
			clearFields();
		}
	}
	
	private void remove(){
		try{
			MultiSelectionModel selModel = (MultiSelectionModel) stuTable.getSelectionModel();
			if(selModel.getSelectedRows().isEmpty()){
				noStudentSelectedErr();
			} else{
				for(Object selItem: selModel.getSelectedRows()){
					Student s = (Student) selItem;
					stuTable.getContainerDataSource().removeItem(s);
					removeStuService.removeStu(s);
				}
				clearFields();
				successNotification();
			}
		} catch(Exception e){
			LOG.info("Exception: " + e);
		}
	}
	
	private void clearFields(){
		stuTable.getSelectionModel().reset();
	}
	
	private void loadStudents(){
		stus = showStuService.getAllStu();
	}
	
	public void enter(ViewChangeEvent e){
		if(stuTable != null)
			return;
		loadStudents();
		init();
		addLayout();
	}
	
	public void noStudentSelectedErr(){
		n = new Notification(Constants.ERROR.getStr(), Constants.NO_STUDENT_SELECTED.getStr(), Type.ERROR_MESSAGE, true);
		n.setDelayMsec(Integer.parseInt(Constants.NEG_ONE.getStr()));
		n.setStyleName(ValoTheme.NOTIFICATION_ERROR + " " + ValoTheme.NOTIFICATION_CLOSABLE);
		n.show(Page.getCurrent());
	}
	
	private void successNotification(){
		n = new Notification(Constants.STUDENT_SUCCESSFULLY_REMOVED.getStr(), Type.WARNING_MESSAGE);
		n.setStyleName(ValoTheme.NOTIFICATION_SUCCESS + " " + ValoTheme.NOTIFICATION_CLOSABLE);
		n.setDelayMsec(Integer.parseInt(Constants.NEG_ONE.getStr()));
		n.show(Page.getCurrent());
	}
}
