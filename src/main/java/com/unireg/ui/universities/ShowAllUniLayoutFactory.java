package com.unireg.ui.universities;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.unireg.model.entities.University;
import com.unireg.services.ShowAllUnisService;
import com.unireg.ui.views.ComponentBuilder;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;

@org.springframework.stereotype.Component
public class ShowAllUniLayoutFactory implements ComponentBuilder {
	private static final Logger LOG = LoggerFactory.getLogger(ShowAllUniLayoutFactory.class);
	private List<University> unis;
	private BeanItemContainer<University> beanContainer;
	@Autowired
	private ShowAllUnisService showUnisService;
	
	private class ShowUniversityLayout extends VerticalLayout {
		private static final long serialVersionUID = 1L;
		private Grid uniTable;
		
		public ShowUniversityLayout init(){
			setMargin(true);
			beanContainer = new BeanItemContainer<University>(University.class, unis);
			uniTable = new Grid(beanContainer);
			uniTable.setColumnOrder("name", "city", "country");
			uniTable.removeColumn("id");
			uniTable.setImmediate(true);
			uniTable.setSizeFull();
			return this;
		}
		
		public ShowUniversityLayout layout(){
			addComponent(uniTable);
			return this;
		}
		
		public ShowUniversityLayout load(){
			unis = showUnisService.getAllUnis();
			return this;
		}
	}
	
	public void refreshTables(){
		try{
			unis = showUnisService.getAllUnis();
			beanContainer.removeAllItems();
			beanContainer.addAll(unis);
		} catch(Exception e){
			LOG.info("Exception: " + e);
		}
	}
	
	public Component buildComponent(){
		return new ShowUniversityLayout().load().init().layout();
	}
}