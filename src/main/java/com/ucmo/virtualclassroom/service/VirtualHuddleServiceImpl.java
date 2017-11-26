package com.ucmo.virtualclassroom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucmo.virtualclassroom.model.Subscribe;
import com.ucmo.virtualclassroom.model.VirtualHuddleModel;
import com.ucmo.virtualclassroom.repository.SubscribeRepository;
import com.ucmo.virtualclassroom.repository.VirtualHuddleRepository;
@Service
public class VirtualHuddleServiceImpl implements VirtualHuddleService {

	@Autowired
	private VirtualHuddleRepository repository;
	@Autowired
	private SubscribeRepository subscribeRepository;
	
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

	@Override
	public boolean subscribeHuddle(Subscribe model) {
		model = subscribeRepository.save(model);
		if(model!=null)
			return true;
			else
				return false;
	}

	@Override
	public VirtualHuddleModel getHuddle(Long id) {
		// TODO Auto-generated method stub
		return repository.getOne(id);
	}
	
	@Override
	public void  deletesubscribe(Long id) {
		// TODO Auto-generated method stub
		subscribeRepository.delete(id);
	}

	@Override
	public List<Subscribe> getSubscribedHuddles(Long id) {
		
		return subscribeRepository.findByUserid(id);
	}
	

	@Override
	public List<Subscribe> findByHuddle(Long id) {
		
		return subscribeRepository.findByHuddleid(id);
	}


}
