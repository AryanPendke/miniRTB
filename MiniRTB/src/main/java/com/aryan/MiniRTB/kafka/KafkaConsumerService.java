package com.aryan.MiniRTB.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.aryan.MiniRTB.dto.event.ImpressionCreatedEvent;
import com.aryan.MiniRTB.service.AnalyticsService;

    @Service
    public class KafkaConsumerService {

        private final AnalyticsService analyticsService;

        public KafkaConsumerService(AnalyticsService analyticsService) {
        this.analyticsService = analyticsService;
        }

        @KafkaListener(
            topics = "impressions",
            groupId = "mini-rtb"
    )
    public void consume(ImpressionCreatedEvent event) {

        analyticsService.updateCampaignAnalytics(event);

        System.out.println(
                "Analytics updated for Campaign "
                + event.campaignId()
        );
    }

}