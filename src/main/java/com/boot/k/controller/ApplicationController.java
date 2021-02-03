package com.boot.k.controller;

import com.boot.k.entity.Application;
import com.boot.k.error.ApiError;
import com.boot.k.service.ApplicantNameValidationService;
import com.boot.k.service.ApplicationService;
import com.boot.k.shared.ValidationResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/1.0")
public class ApplicationController {

    private final ApplicationService applicationService;
    private final ApplicantNameValidationService applicantNameValidationService;
    //private final ValidationService<Application> applicantNameValidation;

    public ApplicationController(ApplicationService applicationService, ApplicantNameValidationService applicantNameValidationService){
        this.applicationService = applicationService;
        this.applicantNameValidationService = applicantNameValidationService;
    }

    @GetMapping("/applications")
    public List<Application> getApplications(){
        return applicationService.getApplications();
    }

    @PostMapping("/apply")
    public ResponseEntity createApplication(@RequestBody Application application){
        ValidationResult validationResult = applicantNameValidationService.validate(application);
        if(!validationResult.getIsValid()){
             ApiError.create("400 Bad Request",validationResult.getMessage(),validationResult.getErrorCode().getCode());
             return ResponseEntity.badRequest().body(validationResult.getMessage());
        }
       return applicationService.saveApplication(application);
    }
}
