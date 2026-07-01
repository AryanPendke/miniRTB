package com.aryan.MiniRTB.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.aryan.MiniRTB.dto.common.ApiError;
import com.aryan.MiniRTB.dto.common.ValidationErrorResponse;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationErrorResponse handleValidation(
        MethodArgumentNotValidException ex,
        HttpServletRequest request
    ){
        ex.getBindingResult();
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult()
                .getFieldErrors()
                .forEach(error ->
        
                        errors.put(
        
                                error.getField(),
        
                                error.getDefaultMessage()
        
                        )
        
                );
                
                return new ValidationErrorResponse(

                    LocalDateTime.now(),
            
                    400,
            
                    "Validation Failed",
            
                    errors,
            
                    request.getRequestURI()
            
            );
    }
}