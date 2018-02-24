package com.universityregistration.ui.universities;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.universityregistration.model.entities.University;
import com.universityregistration.services.ShowAllUnisService;
import com.universityregistration.ui.views.ComponentBuilder;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;

@org.springframework.stereotype.Component
public class ShowAllUniLayoutFactory implements ComponentBuilder {
	private List<University> universities;
	private BeanItemContainer<University> container;
	@Autowired
	private ShowAllUnisService showUniversitiesService;
	
	private class ShowUniversityLayout extends VerticalLayout {
		private static final long serialVersionUID = 1L;
		private Grid universityTable;
		
		public ShowUniversityLayout init(){
			setMargin(true);
			container = new BeanItemContainer<University>(University.class, universities);
			universityTable = new Grid(container);
			universityTable.setColumnOrder("name", "city", "country");
			universityTable.removeColumn("id");
			universityTable.setImmediate(true);
			universityTable.setSizeFull();
			return this;
		}
		
		public ShowUniversityLayout layout(){
			addComponent(universityTable);
			return this;
		}
		
		public ShowUniversityLayout load(){
			universities = showUniversitiesService.getAllUnis();
			return this;
		}
	}
	
	public void refreshTables(){
		universities = showUniversitiesService.getAllUnis();
		container.removeAllItems();
		container.addAll(universities);
	}
	
	public Component createComponent(){
		return new ShowUniversityLayout().load().init().layout();
	}
}