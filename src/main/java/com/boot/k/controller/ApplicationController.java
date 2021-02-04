package com.boot.k.controller;

import com.boot.k.entity.Application;
import com.boot.k.error.ApiError;
import com.boot.k.service.ApplicantNameValidationService;
import com.boot.k.service.DefaultApplicationService;
import com.boot.k.shared.ValidationResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/1.0")
public class ApplicationController {

    private final DefaultApplicationService defaultApplicationService;
    private final ApplicantNameValidationService applicantNameValidationService;


    public ApplicationController(DefaultApplicationService defaultApplicationService, ApplicantNameValidationService applicantNameValidationService){
        this.defaultApplicationService = defaultApplicationService;
        this.applicantNameValidationService = applicantNameValidationService;
    }

    @GetMapping("/applications")
    public List<Application> getApplications(){
        return defaultApplicationService.getApplications();
    }

    @PostMapping("/apply")
    public ResponseEntity createApplication(@RequestBody Application application){
        ValidationResult validationResult = applicantNameValidationService.validate(application);
        if(!validationResult.getIsValid()){
             ApiError.create("400 Bad Request",validationResult.getMessage(),validationResult.getErrorCode().getCode());
             return ResponseEntity.badRequest().body(validationResult.getMessage());
        }
       return defaultApplicationService.saveApplication(application);
    }
}
