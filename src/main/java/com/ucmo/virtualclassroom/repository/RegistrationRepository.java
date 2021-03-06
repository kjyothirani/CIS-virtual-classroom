package com.ucmo.virtualclassroom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.ucmo.virtualclassroom.model.RegistrationModel;


@Repository
public interface RegistrationRepository extends JpaRepository<RegistrationModel, Long> {
	public RegistrationModel findByStudentIDAndPassword(@RequestParam("studentid")String key, @RequestParam("password")String tenant);
	
	public RegistrationModel findByStudentID(@RequestParam("studentid")String key);
	
	public RegistrationModel findByUsername(@RequestParam("username")String key);
	
	public RegistrationModel findById(@RequestParam("id")Long id);


}
