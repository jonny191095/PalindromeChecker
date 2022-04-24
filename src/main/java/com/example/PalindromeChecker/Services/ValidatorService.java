package com.example.PalindromeChecker.Services;

import com.example.PalindromeChecker.Common.Validator;
import com.example.PalindromeChecker.Validators.BasicValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ValidatorService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ValidatorService.class);

    private Validator validator = new BasicValidator();

    public Boolean ValidateValue(String value) {
        LOGGER.info("Validating {}", value);
        return validator.validate(value);
    }
}
