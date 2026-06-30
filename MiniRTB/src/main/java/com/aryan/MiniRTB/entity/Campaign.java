package com.aryan.MiniRTB.entity;
import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "campaigns")
public class Campaign {
    
    public Campaign(){
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private BigDecimal dailyBudget;

    private BigDecimal remainingBudget;

    private BigDecimal bidAmount;

    @Enumerated(EnumType.STRING)
    private Country country;

    @Enumerated(EnumType.STRING)
    private CampaignCategory category;

    @Enumerated(EnumType.STRING)
    private CampaignStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "advertiser_id")
    private Advertiser advertiser;

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public BigDecimal getBidAmount() {
        return bidAmount;
    }
    public void setBidAmount(BigDecimal bidAmount) {
        this.bidAmount = bidAmount;
    }
    public BigDecimal getDailyBudget() {
        return dailyBudget;
    }
    public void setDailyBudget(BigDecimal dailyBudget) {
        this.dailyBudget = dailyBudget;
    }
    public BigDecimal getRemainingBudget() {
        return remainingBudget;
    }
    public void setRemainingBudget(BigDecimal remainingBudget) {
        this.remainingBudget = remainingBudget;
    }
    public Country getCountry() {
        return country;
    }
    public void setCountry(Country country) {
        this.country = country;
    }
    public CampaignCategory getCategory() {
        return category;
    }
    public void setCategory(CampaignCategory category) {
        this.category = category;
    }
    public CampaignStatus getStatus() {
        return status;
    }
    public void setStatus(CampaignStatus status) {
        this.status = status;
    }
    public Advertiser getAdvertiser() {
        return advertiser;
    }
    public void setAdvertiser(Advertiser advertiser) {
        this.advertiser = advertiser;
    }
}
