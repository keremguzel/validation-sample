package com.boot.k.service;

import com.boot.k.entity.Application;
import com.boot.k.repository.ApplicationRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {
    private final ApplicationRepository applicationRepository;

    public ApplicationService(ApplicationRepository applicationRepository){
        this.applicationRepository = applicationRepository;
    }

    public List<Application> getApplications(){
       return applicationRepository.findAll();
    }

    public ResponseEntity saveApplication(Application application){
        applicationRepository.save(application);

        return ResponseEntity.ok().body("Application submitted");
    }
}
