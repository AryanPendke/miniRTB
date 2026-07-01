package com.aryan.MiniRTB.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aryan.MiniRTB.entity.AdRequest;

@Repository
public interface AdRequestRepository extends JpaRepository<AdRequest,Long>{
}
