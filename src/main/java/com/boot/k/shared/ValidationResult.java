package com.boot.k.shared;

public class ValidationResult {
    private Boolean isValid;
    private String message;
    private ErrorCode errorCode;

    private ValidationResult(Boolean isValid, String message, ErrorCode errorCode) {
        this(isValid);
        this.message = message;
        this.errorCode = errorCode;
    }
    private ValidationResult(Boolean isValid) {
        this.isValid = isValid;
    }

    public static ValidationResult error(String message, ErrorCode errorCode){
        return new ValidationResult(Boolean.FALSE,message,errorCode);
    }
    public static ValidationResult success(){
        return new ValidationResult(Boolean.TRUE);
    }

    public Boolean getIsValid() {
        return isValid;
    }

    public void setIsValid(Boolean valid) {
        isValid = valid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
