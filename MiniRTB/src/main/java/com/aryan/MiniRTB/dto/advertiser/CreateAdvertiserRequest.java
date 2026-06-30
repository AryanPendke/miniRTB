package com.aryan.MiniRTB.dto.advertiser;

import jakarta.validation.constraints.NotBlank;

public record CreateAdvertiserRequest(
    @NotBlank(message = "Advertiser name is required")
    String name
) {
}
