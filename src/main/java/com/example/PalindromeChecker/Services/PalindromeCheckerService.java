package com.example.PalindromeChecker.Services;

import com.example.PalindromeChecker.Common.InvalidInputException;
import com.example.PalindromeChecker.Common.Palindrome;
import com.example.PalindromeChecker.Repositories.PalindromeCache;
import com.example.PalindromeChecker.Repositories.PalindromeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PalindromeCheckerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PalindromeCheckerService.class);

    @Autowired
    private ValidatorService validatorService;
    @Autowired
    private PalindromeCache palindromeCache;
    @Autowired
    private PalindromeRepository palindromeRepository;

    public Boolean checkPalindrome(String value) throws InvalidInputException {
        if (validatorService.ValidateValue(value)) {
            Boolean isPalindrome = checkCache(value);
            if (isPalindrome != null) return isPalindrome;
            isPalindrome = performPalindromeCheck(value);
            saveToCache(value, isPalindrome.toString());
            return isPalindrome;
        }
        throw new InvalidInputException("Input not valid");
    }

    private boolean performPalindromeCheck(String value) {
        LOGGER.info("Checking {}", value);
        int forward = 0;
        int backward = value.length() - 1;
        while (forward < backward) {
            if (value.charAt(forward++) != value.charAt(backward--))
            return false;
        }
        return true;
    }

    private Boolean checkCache(String value) {
        LOGGER.info("Checking cache for {}", value);
        return palindromeCache.getIsKey(value);
    }

    private void saveToCache(String value, String isPalindrome) {
        LOGGER.info("Caching {} is {}", value, isPalindrome);
        palindromeCache.savePalindrome(value, isPalindrome);
        palindromeRepository.save(new Palindrome(value, Boolean.valueOf(isPalindrome)));
    }
}
