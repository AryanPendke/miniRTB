package com.aryan.MiniRTB.service;

import com.aryan.MiniRTB.dto.advertiser.AdvertiserResponse;
import com.aryan.MiniRTB.dto.advertiser.CreateAdvertiserRequest;

public interface AdvertiserService {
    AdvertiserResponse createAdvertiser(CreateAdvertiserRequest advertiserRequest);
}