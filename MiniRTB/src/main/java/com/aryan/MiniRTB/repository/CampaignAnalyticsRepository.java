package com.aryan.MiniRTB.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aryan.MiniRTB.entity.CampaignAnalytics;

public interface CampaignAnalyticsRepository
        extends JpaRepository<CampaignAnalytics, Long> {

}