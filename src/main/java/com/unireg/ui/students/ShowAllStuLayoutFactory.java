package com.unireg.ui.students;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private static final Logger LOG = LoggerFactory.getLogger(ShowAllStuLayoutFactory.class);
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
			try{
				addComponent(stuTable);
				return this;
			} catch(Exception e){
				LOG.info("Exception: " + e);
				return null;
			}
		}
		
		public ShowAllStusLayout load(){
			stus = showStuService.getAllStu();
			return this;
		}
	}
	
	public void refreshTables(){
		try{
			stus = showStuService.getAllStu();
			beanContainer.removeAllItems();
			beanContainer.addAll(stus);
		} catch(Exception e){
			LOG.info("Exception: " + e);
		}
	}
	
	public Component buildComponent(){
		return new ShowAllStusLayout().load().init().layout();
	}
}