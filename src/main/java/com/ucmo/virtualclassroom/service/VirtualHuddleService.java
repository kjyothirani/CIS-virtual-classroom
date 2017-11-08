package com.ucmo.virtualclassroom.service;

import java.util.List;

import com.ucmo.virtualclassroom.model.VirtualHuddleModel;

public interface VirtualHuddleService {
	
	public boolean saveHuddle(VirtualHuddleModel model);
	
	public List<VirtualHuddleModel> getAll() ;

}
