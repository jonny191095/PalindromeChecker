package com.example.PalindromeChecker.Web;

import com.example.PalindromeChecker.Common.InvalidInputException;
import com.example.PalindromeChecker.Common.PalindromeDto;
import com.example.PalindromeChecker.Services.PalindromeCheckerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class PalindromeCheckerController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PalindromeCheckerController.class);

    @Autowired
    private PalindromeCheckerService palindromeCheckerService;

    @PostMapping(value = "palindrome")
    public Boolean checkPalindrome(@RequestBody final PalindromeDto palindromeDto) throws InvalidInputException {
        LOGGER.info("Received {} from user {}", palindromeDto.getValue(), palindromeDto.getUsername());
        return palindromeCheckerService.checkPalindrome(palindromeDto.getValue());
    }
}
