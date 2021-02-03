package com.boot.k.shared;

public enum ErrorCode {
    APPLICANT_NAME_EMPTY("Applicant name should not be empty");

    private String code;

    ErrorCode(String code){
        this.code = code;
    }

    public String getCode(){
        return code;
    }
}
