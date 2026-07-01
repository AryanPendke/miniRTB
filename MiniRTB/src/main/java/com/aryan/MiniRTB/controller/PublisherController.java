package com.aryan.MiniRTB.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.aryan.MiniRTB.dto.publisher.CreatePublisherRequest;
import com.aryan.MiniRTB.dto.publisher.PublisherResponse;
import com.aryan.MiniRTB.service.PublisherService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/publishers")
public class PublisherController {
    
    private final PublisherService publisherService;
    public PublisherController(PublisherService publisherService){
        this.publisherService = publisherService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PublisherResponse createCampaign(
        @Valid @RequestBody CreatePublisherRequest request){
            return publisherService.createPublisher(request);
    }
}
