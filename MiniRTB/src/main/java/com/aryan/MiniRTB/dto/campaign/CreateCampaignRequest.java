package com.aryan.MiniRTB.dto.campaign;

import java.math.BigDecimal;

import com.aryan.MiniRTB.entity.CampaignCategory;
import com.aryan.MiniRTB.entity.Country;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;


public record CreateCampaignRequest(
    @NotNull(message = "advertiser id is required")
    Long advertiserId,

    @NotBlank(message = "campaign name is required")
    @Size(max = 100, message = "campaign name must not exceed 100 chars")
    String name,

    @NotNull(message = "daily budget is required")
    @Positive(message = "daily budget must be positive")
    BigDecimal dailyBudget,

    @NotNull(message = "bid budget is required")
    @Positive(message = "bid budget must be positive")
    BigDecimal bidAmount,

    @NotNull(message = "country is required")
    Country country,

    @NotNull(message = "category is required")
    CampaignCategory category
){

}
