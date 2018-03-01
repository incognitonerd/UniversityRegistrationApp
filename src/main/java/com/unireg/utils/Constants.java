package com.unireg.utils;
public enum Constants{
	LOGIN_URL("/ZaysUniversityRegistrationApp/login"), //
	SIGNUP_URL("/ZaysUniversityRegistrationApp/signup"), //
	UI_URL("/ZaysUniversityRegistrationApp/ui"), //
	VAADIN_SERVLET_ENDPOINT("/vaadinServlet/**"), //
	VAADIN_ENDPOINT("/VAADIN/**"), //
	PUSH_ENDPOINT("/PUSH/**"), //
	UIDL_ENDPOINT("/UIDL/**"), //
	LOGIN_ENDPOINT("/login"), //
	LOGIN_CHILDREN_ENDPOINT("/login/**"), //
	LOGOUT_ENDPOINT("/logout"), //
	SIGNUP_ENDPOINT("/signup"), //
	UI_ENDPOINT("/ui"), //
	UI_CHILDREN_ENDPOINT("/ui/**"), //
	//
	LOGIN("Log In"), //
	USERNAME("Username"), //
	PASSWORD("Password"), //
	SIGN_UP("Sign Up"), //
	//
	LOGO_BANNER("../../images/homeHeaderBanner.png"),
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
	ADD_STUDENT_SHOW_ALL_STUDENTS("SHOW ALL STUDENTS"), //
	//
	STUDENTS_REMOVE_STUDENT("Remove Student"), //
	//
	UNIVERSITIES_PARENT("UNIVERSITIES"), //
	UNIVERSITIES_ADD_UNIVERSITY("Add University"), //
	ADD_UNIVERSITY_MAIN_MENU("ADD UNIVERSITY"), //
	ADD_UNIVERSITY_NAME("Name"), //
	ADD_UNIVERSITY_CITY("City"), //
	ADD_UNIVERSITY_COUNTRY("Country"), //
	MENU_SHOW_UNIVERSITY("SHOW ALL UNIVERSITIES"), //
	MENU_CHART_UNIVERSITY("STATISTICS"), //
	//
	LOG_OUT_PARENT("LOG OUT"), //
	LOG_OUT("Log Out"), //
	//
	NEG_ONE("-1"), //
	//
	ERROR("Error!"), //
	UNRECOGNIZED_USERNAME_PASSWORD("Unrecognized Username And Password"), //
	PASSWORDS_DO_NOT_MATCH("Passwords Must Match"), //
	IS_UNAVAILABLE(" Is Unavailable"), //
	SUCCESSFULLY_REGISTERED("Successfully Registered!"), SUCCESSFULLY_SAVED("Successfully Saved!"), //
	STUDENT_SUCCESSFULLY_REMOVED("Successfully Removed!"), //
	BLANK_FIELDS_SAVE_ERROR_DESCRIPTION("All Fields Must Be filled!"), //
	NO_STUDENT_SELECTED("Select At Least One Student!"), //
	UNIVERSITY_SAVE_ERROR_DESCRIPTION("Please Enter A University!"), //
	//
	CANCEL("Cancel"), //
	SAVE("Save"), //
	REMOVE("Remove"), //
	//
	NAME_TESTER("Joe"), //
	AGE_TESTER("5"), //
	GENDER_TESTER("FEMALE"), //
	ID_TESTER("045491"), //
	CITY_TESTER("Abijan"), //
	COUNTRY_TESTER("Ivory Coast"), //
	USERNAME_TESTER("wakamba"), //
	PASSWORD_TESTER("africa"); //
	//
	//
	//
	private final String string;
	
	private Constants(String string){
		this.string = string;
	}
	
	public String getStr(){
		return this.string;
	}
}
