package com.aryan.MiniRTB.service.impl;

import org.springframework.stereotype.Service;

import com.aryan.MiniRTB.dto.publisher.CreatePublisherRequest;
import com.aryan.MiniRTB.dto.publisher.PublisherResponse;
import com.aryan.MiniRTB.entity.Publisher;
import com.aryan.MiniRTB.entity.PublisherStatus;
import com.aryan.MiniRTB.mapper.PublisherMapper;
import com.aryan.MiniRTB.repository.PublisherRepository;
import com.aryan.MiniRTB.service.PublisherService;

import jakarta.transaction.Transactional;

@Service
public class PublisherServiceImpl implements PublisherService{
    
    private final PublisherRepository publisherReposity;
    private final PublisherMapper publisherMapper;
    public PublisherServiceImpl(PublisherRepository publisherRepository, PublisherMapper publisherMapper){
        this.publisherReposity = publisherRepository;
        this.publisherMapper = publisherMapper;
    }

    @Override
    @Transactional
    public PublisherResponse createPublisher(CreatePublisherRequest request){

        Publisher publisher = publisherMapper.toEntity(request);
        publisher.setStatus(PublisherStatus.ACTIVE);
        Publisher saved = publisherReposity.save(publisher);

        return publisherMapper.toResponse(saved);
    }
}
