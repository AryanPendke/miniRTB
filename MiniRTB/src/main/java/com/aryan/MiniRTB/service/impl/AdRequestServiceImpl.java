package com.aryan.MiniRTB.service.impl;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;


import com.aryan.MiniRTB.dto.adRequest.AdRequestResponse;
import com.aryan.MiniRTB.dto.adRequest.CreateAdRequestRequest;
import com.aryan.MiniRTB.dto.auction.AuctionResponse;
import com.aryan.MiniRTB.entity.AdRequest;
import com.aryan.MiniRTB.entity.Campaign;
import com.aryan.MiniRTB.mapper.AdRequestMapper;
import com.aryan.MiniRTB.repository.AdRequestRepository;
import com.aryan.MiniRTB.repository.PublisherRepository;
import com.aryan.MiniRTB.service.AdRequestService;
import com.aryan.MiniRTB.service.AuctionService;

import jakarta.transaction.Transactional;
import com.aryan.MiniRTB.entity.Publisher;

@Service
public class AdRequestServiceImpl implements AdRequestService{

    private final AdRequestRepository adRequestRepository;
    private final AdRequestMapper adRequestMapper;
    private final PublisherRepository publisherRepository;
    private final AuctionService auctionService;

    public AdRequestServiceImpl(AdRequestRepository adRequestRepository, AdRequestMapper adRequestMapper, PublisherRepository publisherRepository, AuctionService auctionService){
        this.adRequestMapper = adRequestMapper;
        this.adRequestRepository = adRequestRepository;
        this.publisherRepository = publisherRepository;
        this.auctionService = auctionService;
    }

    @Transactional
    @Override
    public AuctionResponse createAdRequest(CreateAdRequestRequest request){

        Publisher publisher =
    publisherRepository.findById(request.publisherId())
        .orElseThrow();

        AdRequest adRequest = adRequestMapper.toEntity(request);
        adRequest.setPublisher(publisher);
        adRequest.setTimestamp(LocalDateTime.now());
        AdRequest saved = adRequestRepository.save(adRequest);
        Campaign winner = auctionService.findWinningCampaign(saved);
        //AdRequestResponse response = adRequestMapper.toResponse(saved);
        //return response;

        return new AuctionResponse(
            winner.getId(),
            winner.getName(),
            winner.getAdvertiser().getId(),
            winner.getBidAmount()
        );
        
    }
}
