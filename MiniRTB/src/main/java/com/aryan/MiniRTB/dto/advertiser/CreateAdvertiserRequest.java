package com.aryan.MiniRTB.dto.advertiser;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateAdvertiserRequest(
    @NotBlank(message = "Advertiser name is required")
    @Size(max = 100, message = "Advertiser name must not exceed 100 chars")
    String name
) {
}
