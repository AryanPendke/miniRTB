package com.aryan.MiniRTB.service;

import com.aryan.MiniRTB.dto.publisher.CreatePublisherRequest;
import com.aryan.MiniRTB.dto.publisher.PublisherResponse;

public interface PublisherService {
    PublisherResponse createPublisher(CreatePublisherRequest request);
}
