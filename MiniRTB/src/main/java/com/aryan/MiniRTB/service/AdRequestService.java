package com.aryan.MiniRTB.service;

import com.aryan.MiniRTB.dto.adRequest.CreateAdRequestRequest;
import com.aryan.MiniRTB.dto.auction.AuctionResponse;

public interface AdRequestService{
    AuctionResponse createAdRequest(CreateAdRequestRequest request);
}