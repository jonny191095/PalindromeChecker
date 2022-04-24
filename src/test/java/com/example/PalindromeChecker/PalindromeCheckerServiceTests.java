package com.example.PalindromeChecker;

import com.example.PalindromeChecker.Common.InvalidInputException;
import com.example.PalindromeChecker.Repositories.PalindromeCache;
import com.example.PalindromeChecker.Repositories.PalindromeRepository;
import com.example.PalindromeChecker.Services.PalindromeCheckerService;
import com.example.PalindromeChecker.Services.ValidatorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PalindromeCheckerServiceTests {
    @Mock
    private ValidatorService validatorService;
    @Mock
    private PalindromeCache palindromeCache;
    @Mock
    private PalindromeRepository palindromeRepository;

    @InjectMocks
    private PalindromeCheckerService palindromeCheckerService;

    @Test
    void checkPalindrome_Test1() throws InvalidInputException {
        String input = "abc";

        when(validatorService.ValidateValue(anyString())).thenReturn(true);
        when(palindromeCache.getIsKey(anyString())).thenReturn(null);

        Boolean result = palindromeCheckerService.checkPalindrome(input);

        assertEquals(false, result);
    }

    @Test
    void checkPalindrome_Test2() throws InvalidInputException {
        String input = "aba";

        when(validatorService.ValidateValue(anyString())).thenReturn(true);
        when(palindromeCache.getIsKey(anyString())).thenReturn(null);

        Boolean result = palindromeCheckerService.checkPalindrome(input);

        assertEquals(true, result);
    }

    @Test
    void checkPalindrome_Test3() throws InvalidInputException {
        String input = "abc";

        when(validatorService.ValidateValue(anyString())).thenReturn(true);
        when(palindromeCache.getIsKey(anyString())).thenReturn(true);

        Boolean result = palindromeCheckerService.checkPalindrome(input);

        assertEquals(true, result);
    }

    @Test
    void checkPalindrome_Test4() throws InvalidInputException {
        String input = "aba";

        when(validatorService.ValidateValue(anyString())).thenReturn(true);
        when(palindromeCache.getIsKey(anyString())).thenReturn(false);

        Boolean result = palindromeCheckerService.checkPalindrome(input);

        assertEquals(false, result);
    }
}
