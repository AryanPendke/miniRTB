package com.aryan.MiniRTB.dto.event;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ImpressionCreatedEvent (
    Long adImpressionId,
    Long campaignId,
    Long publisherId,
    BigDecimal bidAmount,
    LocalDateTime createdAt
){
}
