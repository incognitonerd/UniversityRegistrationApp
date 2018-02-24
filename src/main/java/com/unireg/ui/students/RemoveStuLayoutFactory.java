package com.unireg.ui.students;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.unireg.model.entities.Student;
import com.unireg.services.RemoveStuService;
import com.unireg.services.ShowStuService;
import com.unireg.ui.commons.UniMainUI;
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

@SpringView(name = RemoveStuLayoutFactory.NAME, ui = UniMainUI.class)
public class RemoveStuLayoutFactory extends VerticalLayout implements View, Button.ClickListener {
	private static final long serialVersionUID = 1L;
	@Autowired
	private ShowStuService showStudentService;
	@Autowired
	private RemoveStuService removeStuService;
	public static final String NAME = "removestudent";
	private Grid studentsTable;
	private Button removeButton;
	private Button cancelButton;
	private List<Student> students;
	BeanItemContainer<Student> container;
	
	private void init(){
		removeButton = new Button(Constants.REMOVE.getStr());
		cancelButton = new Button(Constants.CANCEL.getStr());
		container = new BeanItemContainer<Student>(Student.class, students);
		studentsTable = new Grid(container);
	}
	
	private void addLayout(){
		setMargin(true);
		studentsTable.setColumnOrder("firstName", "lastName", "age", "gender");
		studentsTable.removeColumn("id");
		studentsTable.removeColumn("university");
		studentsTable.setImmediate(true);
		studentsTable.setSelectionMode(SelectionMode.MULTI);
		studentsTable.setSizeFull();
		cancelButton.addClickListener(this);
		removeButton.addClickListener(this);
		removeButton.setStyleName(ValoTheme.BUTTON_FRIENDLY);
		cancelButton.setStyleName(ValoTheme.BUTTON_PRIMARY);
		addComponent(studentsTable);
		addComponent(new Label(""));
		addComponent(new HorizontalLayout(cancelButton, removeButton));
	}
	
	public void buttonClick(ClickEvent event){
		if(event.getSource() == this.removeButton){
			remove();
		} else{
			clearFields();
		}
	}
	
	private void remove(){
		Notification n;
		MultiSelectionModel selectionModel = (MultiSelectionModel) studentsTable.getSelectionModel();
		if(selectionModel.getSelectedRows().isEmpty()){
			n = new Notification(Constants.ERROR.getStr(), Constants.NO_STUDENT_SELECTED.getStr(), Type.ERROR_MESSAGE, true);
			n.setDelayMsec(200000);
			n.setStyleName(ValoTheme.NOTIFICATION_ERROR + " " + ValoTheme.NOTIFICATION_CLOSABLE);
			n.show(Page.getCurrent());
		} else{
			for(Object selectedItem: selectionModel.getSelectedRows()){
				Student student = (Student) selectedItem;
				studentsTable.getContainerDataSource().removeItem(student);
				removeStuService.removeStu(student);
			}
			n = new Notification(Constants.STUDENT_SUCCESSFULLY_REMOVED.getStr(), Type.WARNING_MESSAGE);
			n.setStyleName(ValoTheme.NOTIFICATION_SUCCESS + " " + ValoTheme.NOTIFICATION_CLOSABLE);
			n.setDelayMsec(200000);
			n.show(Page.getCurrent());
		}
	}
	
	private void clearFields(){
		studentsTable.getSelectionModel().reset();
	}
	
	private void loadStudents(){
		students = showStudentService.getAllStu();
	}
	
	public void enter(ViewChangeEvent event){
		if(studentsTable != null)
			return;
		loadStudents();
		init();
		addLayout();
	}
}
