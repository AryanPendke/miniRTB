package com.aryan.MiniRTB.mapper;

import org.springframework.stereotype.Component;

import com.aryan.MiniRTB.dto.publisher.CreatePublisherRequest;
import com.aryan.MiniRTB.dto.publisher.PublisherResponse;
import com.aryan.MiniRTB.entity.Publisher;

@Component
public class PublisherMapper {
    
    public Publisher toEntity(CreatePublisherRequest request){
        Publisher publisher = new Publisher();
        publisher.setName(request.name());
        return publisher;
    }

    public PublisherResponse toResponse(Publisher publisher){
        PublisherResponse response = new PublisherResponse(
            publisher.getId(),
            publisher.getName(),
            publisher.getStatus()
        );
        return response;
    }

}
