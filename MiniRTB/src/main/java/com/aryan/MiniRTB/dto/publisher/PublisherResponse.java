package com.aryan.MiniRTB.dto.publisher;

import com.aryan.MiniRTB.entity.PublisherStatus;

public record PublisherResponse(
    Long id,
    String name,
    PublisherStatus status
){
}
