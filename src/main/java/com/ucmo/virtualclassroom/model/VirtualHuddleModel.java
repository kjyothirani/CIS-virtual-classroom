package com.ucmo.virtualclassroom.model;




import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="virtualhuddle")
public class VirtualHuddleModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Column(name ="huddlename")
	private String huddlename;
	
	
	@Column(name = "selectdate")
	private String selectdate;
	
	@Column(name="description")
	private String description;
	
	@Column(name="huddleplace")
	private String huddleplace;
	
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	
	public String getHuddlename() {
		return huddlename;
	}
	public void setHuddlename(String huddlename) {
		this.huddlename = huddlename;
	}
	
	
	
	public String getSelectdate() {
		return selectdate;
	}
	public void setSelectdate(String selectdate) {
		this.selectdate = selectdate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getHuddleplace() {
		return huddleplace;
	}
	public void setHuddleplace(String huddleplace) {
		this.huddleplace = huddleplace;
	}
	

}
