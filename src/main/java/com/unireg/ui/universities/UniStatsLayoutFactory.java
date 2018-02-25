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
	private List<University> unis;
	@Autowired
	private ShowUniStatsService showUniStatsService;
	@Autowired
	private ShowAllUnisService showAllUnisService;
	
	private class UniStatsLayout extends VerticalLayout {
		private static final long serialVersionUID = 1L;
		
		public Component layout(){
			setMargin(true);
			for(University uni: unis){
				int numOfStus = showUniStatsService.getStats(uni.getId());
				Label l = new Label("<p><b>" + uni.getName() + "</b>" + "  -  " + numOfStus + " students" + "</p>",
						ContentMode.HTML);
				addComponent(l);
			}
			return this;
		}
		
		public UniStatsLayout load(){
			unis = showAllUnisService.getAllUnis();
			return this;
		}
	}
	
	public Component buildComponent(){
		return new UniStatsLayout().load().layout();
	}
}
