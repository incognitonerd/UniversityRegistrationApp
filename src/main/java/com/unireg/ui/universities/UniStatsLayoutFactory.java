package com.unireg.ui.universities;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.unireg.model.entities.University;
import com.unireg.services.ShowAllUnisService;
import com.unireg.services.ShowUniStatsService;
import com.unireg.ui.views.ComponentBuilder;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@org.springframework.stereotype.Component
public class UniStatsLayoutFactory implements ComponentBuilder {
	private List<University> universities;
	@Autowired
	private ShowUniStatsService showUniStatsService;
	@Autowired
	private ShowAllUnisService universitiesService;
	
	private class StatisticsUniversityLayout extends VerticalLayout {
		private static final long serialVersionUID = 1L;
		
		public Component layout(){
			setMargin(true);
			for(University uni: universities){
				int numOfStudent = showUniStatsService.getStats(uni.getId());
				Label label = new Label("<p><b>" + uni.getName() + "</b>" + "  -  " + numOfStudent + " students" + "</p>",
						ContentMode.HTML);
				addComponent(label);
			}
			return this;
		}
		
		public StatisticsUniversityLayout load(){
			universities = universitiesService.getAllUnis();
			return this;
		}
	}
	
	public Component createComponent(){
		return new StatisticsUniversityLayout().load().layout();
	}
}
