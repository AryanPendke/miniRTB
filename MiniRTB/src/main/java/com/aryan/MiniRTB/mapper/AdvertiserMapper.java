package com.aryan.MiniRTB.mapper;

import org.springframework.stereotype.Component;

import com.aryan.MiniRTB.dto.advertiser.AdvertiserResponse;
import com.aryan.MiniRTB.dto.advertiser.CreateAdvertiserRequest;
import com.aryan.MiniRTB.entity.Advertiser;

@Component
public class AdvertiserMapper {
    
    public Advertiser toEntity(CreateAdvertiserRequest request){
        Advertiser advertiser = new Advertiser();
        advertiser.setName(request.name());
        return advertiser;
    }

    public AdvertiserResponse toResponse(Advertiser advertiser){
        return new AdvertiserResponse(
            advertiser.getId(),
            advertiser.getName(),
            advertiser.getStatus().name()
        );
    }
}
