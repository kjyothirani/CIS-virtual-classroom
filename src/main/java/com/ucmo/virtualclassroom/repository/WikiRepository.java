package com.ucmo.virtualclassroom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.ucmo.virtualclassroom.model.AcademicWikiModel;

@Repository
public interface WikiRepository extends JpaRepository<AcademicWikiModel, Long> {

	public List<AcademicWikiModel> findBySubject(@RequestParam("subject") String subject);

}
