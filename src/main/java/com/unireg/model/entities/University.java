package com.unireg.model.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = University.TABLE_NAME)
public class University {
	public static final String TABLE_NAME = "UNIVERSITY";
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	@Column(name = "university_name")
	@NotNull(message = "Name must be filled!")
	private String name;
	@NotNull(message = "Country must be filled!")
	@Column(name = "university_country")
	private String country;
	@NotNull(message = "City must be filled!")
	@Column(name = "university_city")
	private String city;
	
	public University(){
	}
	
	public Integer getId(){
		return id;
	}
	
	public void setId(Integer id){
		this.id = id;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getCountry(){
		return country;
	}
	
	public void setCountry(String country){
		this.country = country;
	}
	
	public String getCity(){
		return city;
	}
	
	public void setCity(String city){
		this.city = city;
	}
	
	@Override
	public String toString(){
		return this.name;
	}
}
