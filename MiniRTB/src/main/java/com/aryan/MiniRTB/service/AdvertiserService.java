package com.aryan.MiniRTB.service;

import com.aryan.MiniRTB.dto.AdvertiserResponse;
import com.aryan.MiniRTB.dto.CreateAdvertiserRequest;

public interface AdvertiserService {
    AdvertiserResponse createAdvertiser(CreateAdvertiserRequest advertiserRequest);
}