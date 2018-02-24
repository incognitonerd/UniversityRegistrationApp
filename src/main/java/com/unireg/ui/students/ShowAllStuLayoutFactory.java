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
	private List<Student> students;
	private BeanItemContainer<Student> container;
	@Autowired
	private ShowStuService showStuService;
	
	private class ShowAllStudentsLayout extends VerticalLayout {
		private static final long serialVersionUID = 1L;
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
			// studentsTable.setHeight("90%");
			// studentsTable.setWidth("90%");
			return this;
		}
		
		public ShowAllStudentsLayout layout(){
			addComponent(studentsTable);
			return this;
		}
		
		public ShowAllStudentsLayout load(){
			students = showStuService.getAllStu();
			return this;
		}
	}
	
	public void refreshTables(){
		students = showStuService.getAllStu();
		container.removeAllItems();
		container.addAll(students);
	}
	
	public Component createComponent(){
		return new ShowAllStudentsLayout().load().init().layout();
	}
}