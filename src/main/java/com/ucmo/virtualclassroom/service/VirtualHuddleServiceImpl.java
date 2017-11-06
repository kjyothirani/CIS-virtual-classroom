package com.ucmo.virtualclassroom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucmo.virtualclassroom.model.VirtualHuddleModel;
import com.ucmo.virtualclassroom.repository.VirtualHuddleRepository;
@Service
public class VirtualHuddleServiceImpl implements VirtualHuddleService {

	@Autowired
	private VirtualHuddleRepository repository;
	
	@Override
	public boolean saveHuddle(VirtualHuddleModel model) {
		model = repository.save(model);
		if(model!=null)
			return true;
			else
				return false;
	}

	@Override
	public List<VirtualHuddleModel> getAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

}
