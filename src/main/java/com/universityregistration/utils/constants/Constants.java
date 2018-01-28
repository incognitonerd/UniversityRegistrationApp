package com.universityregistration.utils.constants;
public enum Constants{
	MENU_STUDENT("STUDENT"), MENU_UNIVERSITY("UNIVERSITY"), MENU_ADD_STUDENT("Add Student"), MENU_REMOVE_STUDENT(
			"Remove Student"), MENU_OPERATIONS("Operations"), LOGO_BANNER("../vaadin/images/uwfBanner.png"), STUDENT_MAIN_MENU(
			"MAIN MENU"), STUDENT_SHOW_ALL_STUDENTS("SHOW ALL STUDENTS"), FIRST_NAME("First Name"), LAST_NAME("Last Name"), AGE(
			"Age"), GENDER("Gender"), SAVE("Save"), FEMALE("Female"), CLEAR("Clear"), MALE("Male");
	private final String string;
	
	private Constants(String string){
		this.string = string;
	}
	
	public String getStr(){
		return this.string;
	}
}
