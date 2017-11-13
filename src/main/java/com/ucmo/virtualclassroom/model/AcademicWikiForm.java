package com.ucmo.virtualclassroom.model;

import org.springframework.web.multipart.MultipartFile;

public class AcademicWikiForm {
	
	public String resource;
	public String link;
	public MultipartFile pdf;
	public String date;
	public String articleName;
	public String studentName;
	
	
	public String getResource() {
		return resource;
	}
	public void setResource(String resource) {
		this.resource = resource;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getArticleName() {
		return articleName;
	}
	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public MultipartFile getPdf() {
		return pdf;
	}
	public void setPdf(MultipartFile pdf) {
		this.pdf = pdf;
	}
	

}
