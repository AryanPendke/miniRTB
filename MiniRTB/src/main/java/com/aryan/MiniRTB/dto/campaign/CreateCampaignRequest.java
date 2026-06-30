package com.aryan.MiniRTB.dto.campaign;

import java.math.BigDecimal;

import com.aryan.MiniRTB.entity.CampaignCategory;
import com.aryan.MiniRTB.entity.Country;


public record CreateCampaignRequest(
    Long advertiserId,
    String name,
    BigDecimal dailyBudget,
    BigDecimal bidAmount,
    Country country,
    CampaignCategory category
){

}
