package com.example.PalindromeChecker.Validators;

import com.example.PalindromeChecker.Common.Validator;

public class BasicValidator implements Validator {
    @Override
    public Boolean validate(String value) {
        if (value == null) return false;
        for (char c : value.toCharArray()) {
            if (Character.isDigit(c) || c == ' ') {
                return false;
            }
        }
        return true;
    }
}
