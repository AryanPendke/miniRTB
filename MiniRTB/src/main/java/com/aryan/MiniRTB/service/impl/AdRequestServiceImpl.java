package com.aryan.MiniRTB.service.impl;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.aryan.MiniRTB.dto.AdRequest.AdRequestResponse;
import com.aryan.MiniRTB.dto.AdRequest.CreateAdRequestRequest;
import com.aryan.MiniRTB.entity.AdRequest;
import com.aryan.MiniRTB.mapper.AdRequestMapper;
import com.aryan.MiniRTB.repository.AdRequestRepository;
import com.aryan.MiniRTB.repository.PublisherRepository;
import com.aryan.MiniRTB.service.AdRequestService;
import jakarta.transaction.Transactional;
import com.aryan.MiniRTB.entity.Publisher;

@Service
public class AdRequestServiceImpl implements AdRequestService{

    private final AdRequestRepository adRequestRepository;
    private final AdRequestMapper adRequestMapper;
    private final PublisherRepository publisherRepository;

    public AdRequestServiceImpl(AdRequestRepository adRequestRepository, AdRequestMapper adRequestMapper, PublisherRepository publisherRepository){
        this.adRequestMapper = adRequestMapper;
        this.adRequestRepository = adRequestRepository;
        this.publisherRepository = publisherRepository;
    }

    @Transactional
    @Override
    public AdRequestResponse createAdRequest(CreateAdRequestRequest request){

        Publisher publisher =
    publisherRepository.findById(request.publisherId())
        .orElseThrow();

        AdRequest adRequest = adRequestMapper.toEntity(request);
        adRequest.setPublisher(publisher);
        adRequest.setTimestamp(LocalDateTime.now());
        AdRequest saved = adRequestRepository.save(adRequest);
        AdRequestResponse response = adRequestMapper.toResponse(saved);
        return response;

    }
}
