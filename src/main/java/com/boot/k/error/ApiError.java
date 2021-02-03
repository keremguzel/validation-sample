package com.boot.k.error;

public class ApiError {
    private String status;
    private String message;
    private String errorCode;

    private ApiError(String status, String message, String errorCode) {
        this.status = status;
        this.message = message;
        this.errorCode = errorCode;
    }

    public static ApiError create(String status, String message, String errorCode){
        return new ApiError(status,message,errorCode);
    }
}
