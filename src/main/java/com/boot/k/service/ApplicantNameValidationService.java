package com.boot.k.service;

import com.boot.k.entity.Application;
import com.boot.k.shared.ErrorCode;
import com.boot.k.shared.ValidationResult;
import com.boot.k.validation.ValidationService;
import org.springframework.stereotype.Service;

@Service
public class ApplicantNameValidationService implements ValidationService<Application> {

    @Override
    public ValidationResult validate(Application application) {
        String applicantName = application.getApplicantName();
        Integer applicantSalary = application.getApplicantSalary();

        if((applicantName == null || applicantName.isEmpty()) && applicantSalary == null){
            return ValidationResult.error("Application fields should not be empty", ErrorCode.APPLICATION_FIELDS_EMPTY);
        }
        if(applicantName == null || applicantName.isEmpty()){
            return ValidationResult.error("Applicant name should not be empty", ErrorCode.APPLICANT_NAME_EMPTY);
        }
        if(applicantSalary == null){
            return ValidationResult.error("Applicant salary should not be null", ErrorCode.APPLICANT_SALARY_EMPTY);
        }
        return ValidationResult.success();
    }
}
