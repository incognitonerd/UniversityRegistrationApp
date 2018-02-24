package com.universityregistration.ui.universities;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.universityregistration.model.entities.University;
import com.universityregistration.services.ShowAllUniversitiesService;
import com.universityregistration.services.UniversityStatsService;
import com.universityregistration.ui.views.UIComponentBuilder;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@org.springframework.stereotype.Component
public class StatisticsUniversityLayoutFactory implements UIComponentBuilder {
	private List<University> universities;
	@Autowired
	private UniversityStatsService universityStatsService;
	@Autowired
	private ShowAllUniversitiesService universitiesService;
	
	private class StatisticsUniversityLayout extends VerticalLayout {
		private static final long serialVersionUID = 1L;
		
		public Component layout(){
			setMargin(true);
			for(University uni: universities){
				int numOfStudent = universityStatsService.getStatistics(uni.getId());
				Label label = new Label("<p><b>" + uni.getName() + "</b>" + "  -  " + numOfStudent + " students" + "</p>",
						ContentMode.HTML);
				addComponent(label);
			}
			return this;
		}
		
		public StatisticsUniversityLayout load(){
			universities = universitiesService.getAllUniversities();
			return this;
		}
	}
	
	public Component createComponent(){
		return new StatisticsUniversityLayout().load().layout();
	}
}
