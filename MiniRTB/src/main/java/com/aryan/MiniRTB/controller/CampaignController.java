package com.aryan.MiniRTB.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.aryan.MiniRTB.dto.campaign.CampaignResponse;
import com.aryan.MiniRTB.dto.campaign.CreateCampaignRequest;
import com.aryan.MiniRTB.service.CampaignService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/campaigns")
public class CampaignController {

    private final CampaignService campaignService;

    public CampaignController(CampaignService campaignService) {
        this.campaignService = campaignService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CampaignResponse createCampaign(
            @Valid @RequestBody CreateCampaignRequest request) {

        return campaignService.createCampaign(request); 
    }
}