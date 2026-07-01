package com.aryan.MiniRTB.dto.publisher;

import jakarta.validation.constraints.NotBlank;

public record CreatePublisherRequest(

    @NotBlank(message = "publisher name is required")
    String name

){
}
