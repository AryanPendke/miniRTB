package com.aryan.MiniRTB.dto.auction;

import java.math.BigDecimal;

public record AuctionResponse(
    Long campaignId,
    String campaignName,
    Long advertiserId,
    BigDecimal bidAmount
) {
}
