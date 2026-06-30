package com.aryan.MiniRTB.dto;
import lombok.Getter;

@Getter
public class HealthResponse {
    private String status;
    private String application;
    private String version;

    public HealthResponse(String status, String application, String version){
        this.status = status;
        this.application = application;
        this.version = version;
    }
}
