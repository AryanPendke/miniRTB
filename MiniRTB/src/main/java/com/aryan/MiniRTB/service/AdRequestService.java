package com.aryan.MiniRTB.service;

import com.aryan.MiniRTB.dto.AdRequest.AdRequestResponse;
import com.aryan.MiniRTB.dto.AdRequest.CreateAdRequestRequest;

public interface AdRequestService{
    AdRequestResponse createAdRequest(CreateAdRequestRequest request);
}