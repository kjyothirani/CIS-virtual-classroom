package com.ucmo.virtualclassroom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ucmo.virtualclassroom.model.Subscribe;

public interface SubscribeRepository extends JpaRepository<Subscribe, Long> {
	public List<Subscribe> findByHuddleid(Long id);
	
	public List<Subscribe> findByUserid(Long id);
	
}
