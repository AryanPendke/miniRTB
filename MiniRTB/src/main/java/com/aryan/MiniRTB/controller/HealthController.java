package com.aryan.MiniRTB.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aryan.MiniRTB.dto.HealthResponse;

@RestController
public class HealthController {
    
    @GetMapping("/health")
    public HealthResponse health(){
        return new HealthResponse(
            "UP",
            "MiniRTB",
            "v1"
        );
    }

}
