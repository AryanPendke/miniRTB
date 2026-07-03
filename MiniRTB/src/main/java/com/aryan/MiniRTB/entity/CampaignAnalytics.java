package com.aryan.MiniRTB.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "campaign_analytics")
public class CampaignAnalytics {

    @Id
    private Long campaignId;

    private Long impressions;

    private BigDecimal totalSpend;

    @UpdateTimestamp
    private LocalDateTime lastUpdated;

    public CampaignAnalytics() {
    }

    public Long getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(Long campaignId) {
        this.campaignId = campaignId;
    }

    public Long getImpressions() {
        return impressions;
    }

    public void setImpressions(Long impressions) {
        this.impressions = impressions;
    }

    public BigDecimal getTotalSpend() {
        return totalSpend;
    }

    public void setTotalSpend(BigDecimal totalSpend) {
        this.totalSpend = totalSpend;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }
}