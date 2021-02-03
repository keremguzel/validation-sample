package com.boot.k.service;

import com.boot.k.entity.Application;
import com.boot.k.shared.ErrorCode;
import com.boot.k.shared.ValidationResult;
import org.springframework.stereotype.Service;

@Service
public class ApplicantNameValidationService implements ValidationService<Application> {

    @Override
    public ValidationResult validate(Application application) {
        String applicantName = application.getApplicantName();

        if(applicantName == null || applicantName.isEmpty()){
            return ValidationResult.error("Applicant name should not be empty", ErrorCode.APPLICANT_NAME_EMPTY);
        }
        return ValidationResult.success();
    }
}
