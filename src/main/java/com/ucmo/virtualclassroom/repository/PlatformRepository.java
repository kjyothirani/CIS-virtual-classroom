package com.ucmo.virtualclassroom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ucmo.virtualclassroom.model.PlatformModel;

	@Repository
	public interface PlatformRepository extends JpaRepository<PlatformModel, Long> {

}
