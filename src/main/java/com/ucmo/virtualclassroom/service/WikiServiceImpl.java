package com.ucmo.virtualclassroom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucmo.virtualclassroom.model.AcademicWikiModel;
import com.ucmo.virtualclassroom.repository.WikiRepository;
@Service
public class WikiServiceImpl implements WikiService {
	
	@Autowired
	private WikiRepository repository;

	@Override
	public boolean saveWiki(AcademicWikiModel model) {
		model =repository.save(model);
		if(model!=null)
			return true;
			else
				return false;
	}
	
	public List<AcademicWikiModel> getWikiList( ) {
		List<AcademicWikiModel> model =repository.findAll();
		if(model!=null)
			return model;
			else
				return null;
	}

}
