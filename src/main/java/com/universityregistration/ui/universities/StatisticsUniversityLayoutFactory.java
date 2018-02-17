package com.universityregistration.ui.universities;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.universityregistration.model.entity.University;
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
		public Component layout(){
			setMargin(true);
			for(University university: universities){
				int numOfStudent = universityStatsService.getStatistics(university.getId());
				Label label = new Label("<p><b>" + university.getUniversityName() + "</b>" + "  -  " + numOfStudent
						+ " students" + "</p>", ContentMode.HTML);
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
