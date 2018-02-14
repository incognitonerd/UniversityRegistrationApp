package com.universityregistration.utils;
public enum Constants{
	AGE("Age"), //
	CLEAR("Clear"), //
	CANCEL("Cancel"), //
	ERROR("Error!"), //
	FIRST_NAME("First Name"), //
	FEMALE("Female"), //
	GENDER("Gender"), //
	LAST_NAME("Last Name"), //
	LOGO_BANNER("../../images/uwfBanner.png"), //
	MAIN_MENU("MAIN MENU"), //
	MENU_STUDENTS("STUDENTS"), //
	MENU_UNIVERSITIES("UNIVERSITIES"), //
	MENU_LOGOUT("LOGOUT"), //
	MENU_OPERATIONS_UNIVERSITY("Operations"), //
	MENU_LOGOUT_LABEL("Logout"), //
	MENU_ADD_UNIVERSITY("ADD UNIVERSITY"), //
	MENU_SHOW_UNIVERSITY("SHOW ALL UNIVERSITIES"), //
	MENU_CHART_UNIVERSITY("STATISTICS"), //
	MALE("Male"), //
	MENU_STUDENT("STUDENT"), //
	MENU_UNIVERSITY("UNIVERSITY"), //
	MENU_ADD_STUDENT("Add Student"), //
	MENU_REMOVE_STUDENT("Remove Student"), //
	MENU_OPERATIONS("Operations"), //
	REMOVE_STUDENT("Remove"), //
	SAVE_SUCCESSFUL("Successfully Saved!"), //
	SAVE("Save"), //
	STUDENT_MAIN_MENU("MAIN MENU"), //
	STUDENT_SHOW_ALL_STUDENTS("SHOW ALL STUDENTS"), //
	STUDENT_SAVE_ERROR_TITLE("ERROR"), //
	STUDENT_SAVE_ERROR_DESCRIPTION("Must have at least one university!"), //
	STUDENT_SAVE_SUCCESS_TITLE("SAVE"), //
	STUDENT_SAVE_SUCCESS_DESCRIPTION("Student successfully saved!"), //
	STUDENT_SAVE_VALIDATION_ERROR_TITLE("ERROR"), //
	STUDENT_SAVE_VALIDATION_ERROR_DESCRIPTION("Fields must be filled!"), //
	STUDENT_REMOVE_SUCCESS_TITLE("REMOVE"), //
	STUDENT_REMOVE_SUCCESS_DESCRIPTION("Student(s) successfully removed!"), //
	SHOW_ALL_STUDENTS("SHOW ALL STUDENTS"), //
	UNIVERSITY("University");
	private final String string;
	
	private Constants(String string){
		this.string = string;
	}
	
	public String getString(){
		return this.string;
	}
}
