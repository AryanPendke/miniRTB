package com.aryan.MiniRTB.service.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aryan.MiniRTB.dto.event.ImpressionCreatedEvent;
import com.aryan.MiniRTB.entity.CampaignAnalytics;
import com.aryan.MiniRTB.repository.CampaignAnalyticsRepository;
import com.aryan.MiniRTB.service.AnalyticsService;

@Service
public class AnalyticsServiceImpl implements AnalyticsService {

    private final CampaignAnalyticsRepository campaignAnalyticsRepository;

    public AnalyticsServiceImpl(
            CampaignAnalyticsRepository campaignAnalyticsRepository) {

        this.campaignAnalyticsRepository = campaignAnalyticsRepository;
    }

    @Override
    @Transactional
    public void updateCampaignAnalytics(ImpressionCreatedEvent event) {

        CampaignAnalytics analytics =
                campaignAnalyticsRepository
                        .findById(event.campaignId())
                        .orElseGet(() -> {

                            CampaignAnalytics newAnalytics =
                                    new CampaignAnalytics();

                            newAnalytics.setCampaignId(event.campaignId());
                            newAnalytics.setImpressions(0L);
                            newAnalytics.setTotalSpend(BigDecimal.ZERO);

                            return newAnalytics;
                        });

        analytics.setImpressions(
                analytics.getImpressions() + 1
        );

        analytics.setTotalSpend(
                analytics.getTotalSpend().add(event.bidAmount())
        );

        campaignAnalyticsRepository.save(analytics);
    }
}