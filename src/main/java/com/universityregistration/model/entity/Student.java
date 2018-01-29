package com.universityregistration.model.entity;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

// @Entity
// @Table(name = "Students")
public class Student {
	// @Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	// @Column(name = "id")
	private Integer id;
	//@NotNull(message = "Cannot be blank!")
	// @Column(name = "first_name")
	private String fName;
	//@NotNull(message = "Cannot be blank!")
	// @Column(name = "last_name")
	private String lName;
	//@NotNull(message = "Cannot be blank!")
	//@Min(value = 0, message = "Minimum age is 0!")
	//@Max(value = 150, message = "Maximum age is 150!")
	// @Column(name = "age")
	private Integer age;
	//@NotNull(message = "Cannot be blank!")
	// @Column(name = "gender")
	private String gender;
	
	// @ManyToOne(fetch = FetchType.LAZY)
	// @JoinColumn(name = "university_id")
	// @NotNull(message = "Cannot be blank!")
	// private University university;
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
		return " firstName - " + this.fName + " lastName - " + this.lName + " age - " + this.age + " gender - "
				+ this.gender;
	}
}
