package com.alphadev.portfolio.dto;

public class ResponseDTO {

    private String statusMessage;

    public ResponseDTO(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }
}
