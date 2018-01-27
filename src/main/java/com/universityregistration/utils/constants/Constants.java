package com.universityregistration.utils.constants;
public enum Constants{
	MENU_STUDENT("STUDENT"), MENU_UNIVERSITY("UNIVERSITY"), MENU_ADD_STUDENT("Add Student"), MENU_REMOVE_STUDENT(
			"Remove Student"), MENU_OPERATIONS("Operations"), LOGO_BANNER("../vaadin/images/uwfBanner.png");
	private final String string;
	
	private Constants(String string){
		this.string = string;
	}
	
	public String getString(){
		return this.string;
	}
}
