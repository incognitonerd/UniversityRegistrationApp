package com.universityregistration.model.entity;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Student {
	private Integer id;
	@NotNull(message = "Cannot be blank!")
	private String fName;
	@NotNull(message = "Cannot be blank!")
	private String lName;
	@NotNull(message = "Cannot be blank!")
	@Min(value = 0, message = "Minimum age is 0!")
	@Max(value = 150, message = "Maximum age is 150!")
	private Integer age;
	@NotNull(message = "Cannot be blank!")
	private String gender;
	
	public Student(){
	}
	
	public Integer getId(){
		return id;
	}
	
	public void setId(Integer id){
		this.id = id;
	}
	
	public String getfName(){
		return fName;
	}
	
	public void setfName(String fName){
		this.fName = fName;
	}
	
	public String getlName(){
		return lName;
	}
	
	public void setlName(String lName){
		this.lName = lName;
	}
	
	public Integer getAge(){
		return age;
	}
	
	public void setAge(Integer age){
		this.age = age;
	}
	
	public String getGender(){
		return gender;
	}
	
	public void setGender(String gender){
		this.gender = gender;
	}
	
	@Override
	public String toString(){
		// TODO Auto-generated method stub
		return fName + " - " + lName + " - " + age;
	}
}
