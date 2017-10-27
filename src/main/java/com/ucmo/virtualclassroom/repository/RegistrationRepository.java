package com.ucmo.virtualclassroom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ucmo.virtualclassroom.model.RegistrationModel;


@Repository
public interface RegistrationRepository extends JpaRepository<RegistrationModel, Long> {

}
