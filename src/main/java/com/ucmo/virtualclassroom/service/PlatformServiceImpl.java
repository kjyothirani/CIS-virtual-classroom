package com.ucmo.virtualclassroom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucmo.virtualclassroom.model.PlatformModel;
import com.ucmo.virtualclassroom.model.Platformdiscussion;
import com.ucmo.virtualclassroom.repository.PlatformDiscussionRepository;
import com.ucmo.virtualclassroom.repository.PlatformRepository;
@Service
public class PlatformServiceImpl implements PlatformService {
	
	@Autowired
	PlatformRepository repository;
	@Autowired
	PlatformDiscussionRepository platformDiscusionRepository;

	@Override
	public PlatformModel saveDiscussion(PlatformModel model) {

		return repository.save(model);
		
	}

	@Override
	public List<PlatformModel> getAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public PlatformModel getPlatformModel(Long id) {
		// TODO Auto-generated method stub
		return repository.findOne(id);
	}

	@Override
	public Platformdiscussion savePlatformDiscussion(Platformdiscussion discussion) {
		// TODO Auto-generated method stub
		try{
		return platformDiscusionRepository.save(discussion);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return discussion;
	}

	@Override
	public List<Platformdiscussion> getPlatformDiscussion(Long id) {
		// TODO Auto-generated method stub
		return platformDiscusionRepository.findByPlatformid(id);
	}

}
