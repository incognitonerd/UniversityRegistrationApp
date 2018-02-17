package com.universityregistration.ui.students;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.universityregistration.model.entity.Student;
import com.universityregistration.services.ShowStudentsService;
import com.universityregistration.ui.views.UIComponentBuilder;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;

@org.springframework.stereotype.Component
public class ShowAllStudentsLayoutFactory implements UIComponentBuilder {
	private List<Student> students;
	private BeanItemContainer<Student> container;
	
	private class ShowAllStudentsLayout extends VerticalLayout {
		private Grid studentsTable;
		
		public ShowAllStudentsLayout init(){
			setMargin(true);
			container = new BeanItemContainer<Student>(Student.class, students);
			studentsTable = new Grid(container);
			studentsTable.setColumnOrder("firstName", "lastName", "age", "gender");
			studentsTable.removeColumn("id");
			studentsTable.removeColumn("university");
			studentsTable.setImmediate(true);
			studentsTable.setSizeFull();
			//studentsTable.setHeight("90%");
			//studentsTable.setWidth("90%");
			return this;
		}
		
		public ShowAllStudentsLayout layout(){
			addComponent(studentsTable);
			return this;
		}
		
		public ShowAllStudentsLayout load(){
			students = showStudentsService.getAllStudents();
			return this;
		}
	}
	
	public void refreshTables(){
		students = showStudentsService.getAllStudents();
		container.removeAllItems();
		container.addAll(students);
	}
	
	@Autowired
	private ShowStudentsService showStudentsService;
	
	public Component createComponent(){
		return new ShowAllStudentsLayout().load().init().layout();
	}
}