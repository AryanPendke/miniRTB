package com.aryan.MiniRTB.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aryan.MiniRTB.dto.advertiser.AdvertiserResponse;
import com.aryan.MiniRTB.dto.advertiser.CreateAdvertiserRequest;
import com.aryan.MiniRTB.service.AdvertiserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/advertisers")
public class AdvertiserController {
    
    private final AdvertiserService advertiserService;
    
    public AdvertiserController(AdvertiserService advertiserService){
        this.advertiserService = advertiserService;
    }

    @PostMapping
    public AdvertiserResponse createAdvertiser(
        @Valid 
        @RequestBody 
        CreateAdvertiserRequest request
    ){
        return advertiserService.createAdvertiser(request);
    }
}
