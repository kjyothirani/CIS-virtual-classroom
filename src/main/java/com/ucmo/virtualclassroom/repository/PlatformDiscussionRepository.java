package com.ucmo.virtualclassroom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.ucmo.virtualclassroom.model.Platformdiscussion;

	@Repository
	public interface PlatformDiscussionRepository extends JpaRepository<Platformdiscussion, Long> {
		
		public List<Platformdiscussion> findByPlatformid(@RequestParam("platformid")Long platformid);

}
