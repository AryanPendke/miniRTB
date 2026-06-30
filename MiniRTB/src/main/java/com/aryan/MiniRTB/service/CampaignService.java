package com.aryan.MiniRTB.service;

import com.aryan.MiniRTB.dto.campaign.CampaignResponse;
import com.aryan.MiniRTB.dto.campaign.CreateCampaignRequest;

public interface CampaignService {
    CampaignResponse createCampaign(CreateCampaignRequest request);
}
