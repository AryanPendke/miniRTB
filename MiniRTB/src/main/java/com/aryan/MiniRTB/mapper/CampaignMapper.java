package com.aryan.MiniRTB.mapper;

import org.springframework.stereotype.Component;

import com.aryan.MiniRTB.dto.campaign.CampaignResponse;
import com.aryan.MiniRTB.dto.campaign.CreateCampaignRequest;
import com.aryan.MiniRTB.entity.Campaign;

@Component
public class CampaignMapper {

    public Campaign toEntity(CreateCampaignRequest request) {

        Campaign campaign = new Campaign();

        campaign.setName(request.name());
        campaign.setDailyBudget(request.dailyBudget());
        campaign.setBidAmount(request.bidAmount());
        campaign.setCountry(request.country());
        campaign.setCategory(request.category());

        return campaign;
    }

    public CampaignResponse toResponse(Campaign campaign) {

        return new CampaignResponse(
                campaign.getId(),
                campaign.getAdvertiser().getId(),
                campaign.getName(),
                campaign.getDailyBudget(),
                campaign.getBidAmount(),
                campaign.getCountry(),
                campaign.getCategory(),
                campaign.getStatus()
        );
    }
}