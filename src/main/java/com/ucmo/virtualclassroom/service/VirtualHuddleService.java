package com.ucmo.virtualclassroom.service;

import java.util.List;

import com.ucmo.virtualclassroom.model.Subscribe;
import com.ucmo.virtualclassroom.model.VirtualHuddleModel;

public interface VirtualHuddleService {
	
	public boolean saveHuddle(VirtualHuddleModel model);
	
	public List<VirtualHuddleModel> getAll() ;
	public List<Subscribe> getSubscribedHuddles(Long id) ;
	
	public boolean subscribeHuddle(Subscribe model);
	public VirtualHuddleModel getHuddle(Long id);
	
	public void  deletesubscribe(Long id) ;
	public List<Subscribe> findByHuddle(Long id) ;

}
