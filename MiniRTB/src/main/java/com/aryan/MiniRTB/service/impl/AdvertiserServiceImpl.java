package com.aryan.MiniRTB.service.impl;
import org.springframework.stereotype.Service;

import com.aryan.MiniRTB.dto.AdvertiserResponse;
import com.aryan.MiniRTB.dto.CreateAdvertiserRequest;
import com.aryan.MiniRTB.entity.Advertiser;
import com.aryan.MiniRTB.entity.AdvertiserStatus;
import com.aryan.MiniRTB.repository.AdvertiserRepository;
import com.aryan.MiniRTB.service.AdvertiserService;

@Service
public class AdvertiserServiceImpl implements AdvertiserService {

    private final AdvertiserRepository advertiserRepository; 
    
    public AdvertiserServiceImpl(AdvertiserRepository advertiserRepository){
        this.advertiserRepository = advertiserRepository;
    }

    @Override
    public AdvertiserResponse createAdvertiser(CreateAdvertiserRequest request){

        Advertiser advertiser = new Advertiser();
        advertiser.setName(request.name());
        advertiser.setStatus(AdvertiserStatus.ACTIVE);

        Advertiser saved = advertiserRepository.save(advertiser);

        return new AdvertiserResponse(saved.getId(),saved.getName(),saved.getStatus().name());

    }
}