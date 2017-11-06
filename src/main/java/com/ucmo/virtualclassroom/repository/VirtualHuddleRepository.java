package com.ucmo.virtualclassroom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ucmo.virtualclassroom.model.VirtualHuddleModel;

public interface VirtualHuddleRepository extends JpaRepository<VirtualHuddleModel, Long> {

}
