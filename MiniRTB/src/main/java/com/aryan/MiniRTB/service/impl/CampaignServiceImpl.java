package com.aryan.MiniRTB.service.impl;

import org.springframework.stereotype.Service;

import com.aryan.MiniRTB.dto.campaign.CampaignResponse;
import com.aryan.MiniRTB.dto.campaign.CreateCampaignRequest;
import com.aryan.MiniRTB.entity.Advertiser;
import com.aryan.MiniRTB.entity.Campaign;
import com.aryan.MiniRTB.entity.CampaignStatus;
import com.aryan.MiniRTB.mapper.CampaignMapper;
import com.aryan.MiniRTB.repository.AdvertiserRepository;
import com.aryan.MiniRTB.repository.CampaignRepository;
import com.aryan.MiniRTB.service.CampaignService;

import jakarta.transaction.Transactional;

@Service
public class CampaignServiceImpl implements CampaignService{
    
    private final CampaignRepository campaignRepository;
    private final CampaignMapper campaignMapper;
    private final AdvertiserRepository advertiserRepository;

    public CampaignServiceImpl(CampaignMapper campaignMapper, CampaignRepository campaignRepository, AdvertiserRepository advertiserRepository){
        this.campaignMapper = campaignMapper;
        this.campaignRepository = campaignRepository;
        this.advertiserRepository = advertiserRepository;
    } 

    @Transactional
    @Override
    public CampaignResponse createCampaign(CreateCampaignRequest request){
        
        Advertiser advertiser = advertiserRepository.findById(request.advertiserId()).orElseThrow();

        Campaign campaign = campaignMapper.toEntity(request);

        campaign.setAdvertiser(advertiser);

        campaign.setRemainingBudget(campaign.getDailyBudget());

        campaign.setStatus(CampaignStatus.ACTIVE);

        Campaign saved = campaignRepository.save(campaign);

        CampaignResponse response = campaignMapper.toResponse(saved);
        
        return response;
    }

}
