package com.aryan.MiniRTB.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aryan.MiniRTB.dto.AdRequest.AdRequestResponse;
import com.aryan.MiniRTB.dto.AdRequest.CreateAdRequestRequest;
import com.aryan.MiniRTB.service.AdRequestService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/ad-requests")
public class AdRequestController {

    private final AdRequestService adRequestService;

    public AdRequestController(AdRequestService adRequestService){
        this.adRequestService = adRequestService;
    }

    @PostMapping
    public AdRequestResponse createAdRequest(
        @Valid
        @RequestBody CreateAdRequestRequest request){
        return adRequestService.createAdRequest(request);
    }

}
