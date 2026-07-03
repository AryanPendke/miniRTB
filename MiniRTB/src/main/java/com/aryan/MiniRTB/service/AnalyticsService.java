package com.aryan.MiniRTB.service;

import com.aryan.MiniRTB.dto.event.ImpressionCreatedEvent;

public interface AnalyticsService {

    void updateCampaignAnalytics(ImpressionCreatedEvent event);

}