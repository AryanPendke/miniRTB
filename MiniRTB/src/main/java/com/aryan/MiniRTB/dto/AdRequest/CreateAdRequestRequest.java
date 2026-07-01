package com.aryan.MiniRTB.dto.AdRequest;

import com.aryan.MiniRTB.entity.CampaignCategory;
import com.aryan.MiniRTB.entity.Country;
import com.aryan.MiniRTB.entity.Device;

public record CreateAdRequestRequest (
    Long publisherId,
    Country country,
    Device device,
    CampaignCategory category
){
}
