package com.boot.k.service;

import com.boot.k.shared.ValidationResult;


import org.springframework.stereotype.Service;

@Service
public interface ValidationService<T> {
    ValidationResult validate(T request);
}
