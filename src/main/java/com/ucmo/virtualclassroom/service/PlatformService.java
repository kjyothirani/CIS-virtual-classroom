package com.ucmo.virtualclassroom.service;

import java.util.List;

import com.ucmo.virtualclassroom.model.PlatformModel;
import com.ucmo.virtualclassroom.model.Platformdiscussion;

public interface PlatformService {
	public PlatformModel saveDiscussion(PlatformModel model);
	
	public List<PlatformModel> getAll();
	public PlatformModel getPlatformModel(Long id);
	
	public Platformdiscussion savePlatformDiscussion(Platformdiscussion discussion);
	
	public List<Platformdiscussion> getPlatformDiscussion(Long id);
	
	public void deleteDiscussion(Long id); 

}
