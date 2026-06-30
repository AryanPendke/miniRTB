package com.aryan.MiniRTB.service.impl;
import org.springframework.stereotype.Service;

import com.aryan.MiniRTB.dto.AdvertiserResponse;
import com.aryan.MiniRTB.dto.CreateAdvertiserRequest;
import com.aryan.MiniRTB.entity.Advertiser;
import com.aryan.MiniRTB.entity.AdvertiserStatus;
import com.aryan.MiniRTB.exception.AdvertiserAlreadyExistsException;
import com.aryan.MiniRTB.mapper.AdvertiserMapper;
import com.aryan.MiniRTB.repository.AdvertiserRepository;
import com.aryan.MiniRTB.service.AdvertiserService;

@Service
public class AdvertiserServiceImpl implements AdvertiserService {

    private final AdvertiserRepository advertiserRepository; 
    private final AdvertiserMapper advertiserMapper;
    
    public AdvertiserServiceImpl(AdvertiserRepository advertiserRepository, AdvertiserMapper advertiserMapper){
        this.advertiserRepository = advertiserRepository;
        this.advertiserMapper = advertiserMapper;
    }

    @Override
    public AdvertiserResponse createAdvertiser(CreateAdvertiserRequest request){

        if(advertiserRepository.existsByName(request.name())){
            throw new AdvertiserAlreadyExistsException(request.name());
        }

        Advertiser advertiser = advertiserMapper.toEntity(request);
        advertiser.setStatus(AdvertiserStatus.ACTIVE);
        Advertiser saved = advertiserRepository.save(advertiser);

        return advertiserMapper.toResponse(saved);

    }
}