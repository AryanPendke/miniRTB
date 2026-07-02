package com.aryan.MiniRTB.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aryan.MiniRTB.entity.Campaign;
import com.aryan.MiniRTB.entity.CampaignCategory;
import com.aryan.MiniRTB.entity.CampaignStatus;
import com.aryan.MiniRTB.entity.Country;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign, Long> {
    
    List<Campaign> findByStatusAndCountryAndCategory(
        CampaignStatus status,
        Country country,
        CampaignCategory category
    );

}