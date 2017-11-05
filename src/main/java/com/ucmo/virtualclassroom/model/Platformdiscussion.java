package com.ucmo.virtualclassroom.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="platformdiscussion")
@Entity
public class Platformdiscussion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	
	@Column(name = "ordervalue")
	private int ordervalue;
	
	@Column(name = "value")
	private String value;
	
	@Column(name = "firstname")
	private String firstName;
	
	@Column(name = "lastname")
	private String lastName;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "platformid")
	private Long platformid;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getOrdervalue() {
		return ordervalue;
	}

	public void setOrdervalue(int ordervalue) {
		this.ordervalue = ordervalue;
	}

	public Long getPlatformid() {
		return platformid;
	}

	public void setPlatformid(Long platformid) {
		this.platformid = platformid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	

	


	
}
