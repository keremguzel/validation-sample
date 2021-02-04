package com.boot.k.validation;

import com.boot.k.shared.ValidationResult;



public interface ValidationService<T> {
    ValidationResult validate(T request);
}
