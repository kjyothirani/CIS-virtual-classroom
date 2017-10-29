package com.ucmo.virtualclassroom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ucmo.virtualclassroom.model.AcademicWikiModel;

@Repository
public interface WikiRepository extends JpaRepository<AcademicWikiModel, Long> {

}
