package com.ucmo.virtualclassroom.service;

import java.util.List;

import com.ucmo.virtualclassroom.model.PlatformModel;

public interface PlatformService {
	public boolean saveDiscussion(PlatformModel model);
	
	public List<PlatformModel> getAll();

}
