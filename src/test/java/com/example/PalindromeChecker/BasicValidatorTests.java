package com.example.PalindromeChecker;

import com.example.PalindromeChecker.Validators.BasicValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class BasicValidatorTests {
    @InjectMocks
    private BasicValidator basicValidator;

    @ParameterizedTest
    @CsvSource({"abc, true", "ab c, false", "ab4, false", ", false", "'', true"})
    void validate_Test1(String value, boolean is) {
        Boolean result = basicValidator.validate(value);
        assertEquals(is, result);
    }
}
