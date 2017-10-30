package com.ucmo.virtualclassroom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucmo.virtualclassroom.model.PlatformModel;
import com.ucmo.virtualclassroom.repository.PlatformRepository;
@Service
public class PlatformServiceImpl implements PlatformService {
	
	@Autowired
	PlatformRepository repository;

	@Override
	public boolean saveDiscussion(PlatformModel model) {

		repository.save(model);
		if(model!=null)
			return true;
			else
				return false;
	}

	@Override
	public List<PlatformModel> getAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

}
