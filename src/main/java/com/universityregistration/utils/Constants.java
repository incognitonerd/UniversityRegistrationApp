package com.universityregistration.utils;
public enum Constants{
	LOGO_BANNER("../../images/uwfBanner.png"),
	//
	STUDENTS_PARENT("STUDENTS"), //
	STUDENTS_ADD_STUDENT("Add Student"), //
	ADD_STUDENT_MAIN_MENU("ADD STUDENT"), //
	ADD_STUDENT_FIRST_NAME("First Name"), //
	ADD_STUDENT_LAST_NAME("Last Name"), //
	ADD_STUDENT_AGE("Age"), //
	ADD_STUDENT_GENDER("Gender"), //
	ADD_STUDENT_FEMALE("Female"), //
	ADD_STUDENT_MALE("Male"), //
	ADD_STUDENT_UNIVERSITY("University"), //
	ADD_STUDENT_CANCEL("Cancel"), //
	ADD_STUDENT_SAVE("Save"), //
	ADD_STUDENT_SHOW_ALL_STUDENTS("SHOW ALL STUDENTS"), //
	//
	STUDENTS_REMOVE_STUDENT("Remove Student"), //
	REMOVE_STUDENT_CANCEL("Cancel"), //
	REMOVE_STUDENT("Remove"), //
	//
	//
	UNIVERSITIES_PARENT("UNIVERSITIES"), //
	UNIVERSITIES_ADD_UNIVERSITY("Add University"), //
	ADD_UNIVERSITY_MAIN_MENU("ADD UNIVERSITY"), //
	ADD_UNIVERSITY_NAME("Name"), //
	ADD_UNIVERSITY_CITY("City"), //
	ADD_UNIVERSITY_COUNTRY("Country"), //
	ADD_UNIVERSITY_SAVE("Save"), //
	MENU_SHOW_UNIVERSITY("SHOW ALL UNIVERSITIES"), //
	MENU_CHART_UNIVERSITY("STATISTICS"), //
	//
	ERROR("Error!"), //
	SUCCESSFULLY_SAVED("Successfully Saved!"), //
	STUDENT_SUCCESSFULLY_REMOVED("Successfully Removed!"), //
	BLANK_FIELDS_SAVE_ERROR_DESCRIPTION("All Fields Must Be filled!"), //
	NO_STUDENT_SELECTED("Select At Least One Student!"), //
	//
	UNIVERSITY_SAVE_ERROR_DESCRIPTION("Please Enter A University!"), //
	ADD_UNIVERSITY_CANCEL("Cancel"); //
	private final String string;
	
	private Constants(String string){
		this.string = string;
	}
	
	public String getStr(){
		return this.string;
	}
}
