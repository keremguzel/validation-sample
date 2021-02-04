package com.boot.k.service;

import com.boot.k.entity.Application;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ApplicationService {
    List<Application> getApplications();
    ResponseEntity saveApplication(Application application);
}
