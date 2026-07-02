package com.aryan.MiniRTB.mapper;

import org.springframework.stereotype.Component;

import com.aryan.MiniRTB.dto.adRequest.AdRequestResponse;
import com.aryan.MiniRTB.dto.adRequest.CreateAdRequestRequest;
import com.aryan.MiniRTB.entity.AdRequest;

@Component
public class AdRequestMapper {
    
    public AdRequest toEntity(CreateAdRequestRequest request){
        AdRequest adRequest = new AdRequest();
        adRequest.setCountry(request.country());
        adRequest.setDevice(request.device());
        adRequest.setCategory(request.category());
        return adRequest;
    }

    public AdRequestResponse toResponse(AdRequest adRequest){
        return new AdRequestResponse(
        adRequest.getId(),
        adRequest.getPublisher().getId(),
        adRequest.getCountry(),
        adRequest.getDevice(),
        adRequest.getCategory(),
        adRequest.getTimestamp());
    }

}
