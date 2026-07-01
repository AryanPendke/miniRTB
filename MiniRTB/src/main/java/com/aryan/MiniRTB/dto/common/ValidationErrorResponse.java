package com.aryan.MiniRTB.dto.common;

import java.time.LocalDateTime;
import java.util.Map;

public record ValidationErrorResponse(
    LocalDateTime timestamp,
    int status,
    String error,
    Map<String,String>errors,
    String path
) {
}