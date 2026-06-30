package com.aryan.MiniRTB.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aryan.MiniRTB.entity.Campaign;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign, Long> {
    
}