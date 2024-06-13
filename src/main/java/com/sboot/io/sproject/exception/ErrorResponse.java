package com.sboot.io.sproject.exception;

public class ErrorResponse {

    private int statusCode;
    private String message;

    public ErrorResponse(int value, String message){
        super();
        this.message = message;
    }
}
