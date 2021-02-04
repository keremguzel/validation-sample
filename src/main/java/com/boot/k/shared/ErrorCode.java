package com.boot.k.shared;

public enum ErrorCode {
    APPLICANT_NAME_EMPTY("APPLICANT_NAME_EMPTY"),
    APPLICANT_SALARY_EMPTY("APPLICANT_SALARY_EMPTY"),
    APPLICATION_FIELDS_EMPTY("APPLICATION_FIELDS_EMPTY");

    private String code;

    ErrorCode(String code){
        this.code = code;
    }

    public String getCode(){
        return code;
    }
}
