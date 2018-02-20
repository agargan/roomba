package com.agar.roomba.domain.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorResponse<T> extends Response<T> {

    private String message;

    public void setMessage(String message) {
        this.message = message;
    }
}
