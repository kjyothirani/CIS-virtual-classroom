package com.ucmo.virtualclassroom.service;

import java.util.List;

import com.ucmo.virtualclassroom.model.AcademicWikiModel;

public interface WikiService {
	
	public boolean saveWiki(AcademicWikiModel model);
	
	public List<AcademicWikiModel> getWikiList( );

	public List<AcademicWikiModel> getwikilistBySubject(String subject);

}
