package com.aryan.MiniRTB.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aryan.MiniRTB.entity.AdRequest;
import com.aryan.MiniRTB.entity.Campaign;
import com.aryan.MiniRTB.entity.CampaignStatus;
import com.aryan.MiniRTB.repository.CampaignRepository;
import com.aryan.MiniRTB.service.AuctionService;

@Service
public class AuctionServiceImpl implements AuctionService{
    
    private final CampaignRepository campaignRepository;

    public AuctionServiceImpl(CampaignRepository campaignRepository){
        this.campaignRepository = campaignRepository;
    }

    @Override
    public Campaign findWinningCampaign(AdRequest adRequest){

        List<Campaign> campaigns = campaignRepository.findByStatusAndCountryAndCategory(
            CampaignStatus.ACTIVE,
            adRequest.getCountry(),
            adRequest.getCategory()
        );
        
        if(campaigns.isEmpty()) throw new RuntimeException("No Eligible Campaign found");

        Campaign winner = campaigns.get(0);

        for(Campaign campaign: campaigns){
            if(campaign.getBidAmount().compareTo(winner.getBidAmount())>0){
                winner = campaign;
            }
        }

        return winner;
    }
}
