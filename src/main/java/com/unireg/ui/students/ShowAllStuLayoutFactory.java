package com.unireg.ui.students;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.unireg.model.entities.Student;
import com.unireg.services.ShowStuService;
import com.unireg.ui.views.ComponentBuilder;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;

@org.springframework.stereotype.Component
public class ShowAllStuLayoutFactory implements ComponentBuilder {
	private List<Student> stus;
	private BeanItemContainer<Student> beanContainer;
	@Autowired
	private ShowStuService showStuService;
	
	private class ShowAllStusLayout extends VerticalLayout {
		private static final long serialVersionUID = 1L;
		private Grid stuTable;
		
		public ShowAllStusLayout init(){
			setMargin(true);
			beanContainer = new BeanItemContainer<Student>(Student.class, stus);
			stuTable = new Grid(beanContainer);
			stuTable.setColumnOrder("firstName", "lastName", "age", "gender");
			stuTable.removeColumn("id");
			stuTable.removeColumn("university");
			stuTable.setImmediate(true);
			stuTable.setSizeFull();
			return this;
		}
		
		public ShowAllStusLayout layout(){
			addComponent(stuTable);
			return this;
		}
		
		public ShowAllStusLayout load(){
			stus = showStuService.getAllStu();
			return this;
		}
	}
	
	public void refreshTables(){
		stus = showStuService.getAllStu();
		beanContainer.removeAllItems();
		beanContainer.addAll(stus);
	}
	
	public Component buildComponent(){
		return new ShowAllStusLayout().load().init().layout();
	}
}