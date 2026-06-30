package com.aryan.MiniRTB.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.aryan.MiniRTB.dto.common.ApiError;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AdvertiserAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ApiError handleAdvertiserAlreadyExists(
            AdvertiserAlreadyExistsException ex,
            HttpServletRequest request) {

        return new ApiError(
                LocalDateTime.now(),
                409,
                "Conflict",
                ex.getMessage(),
                request.getRequestURI()
        );
    }
}