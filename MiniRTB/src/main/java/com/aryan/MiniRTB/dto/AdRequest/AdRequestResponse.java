package com.aryan.MiniRTB.dto.adRequest;

import java.time.LocalDateTime;

import com.aryan.MiniRTB.entity.CampaignCategory;
import com.aryan.MiniRTB.entity.Country;
import com.aryan.MiniRTB.entity.Device;

public record AdRequestResponse(
    Long adRequestId,
    Long publisherId,
    Country country,
    Device device,
    CampaignCategory campaignCategory,
    LocalDateTime timestamp
) {
}
