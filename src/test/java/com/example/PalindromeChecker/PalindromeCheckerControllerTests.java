package com.example.PalindromeChecker;

import com.example.PalindromeChecker.Common.PalindromeDto;
import com.example.PalindromeChecker.Services.PalindromeCheckerService;
import com.example.PalindromeChecker.Web.PalindromeCheckerController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PalindromeCheckerController.class)
public class PalindromeCheckerControllerTests {
    @MockBean
    private PalindromeCheckerService palindromeCheckerService;

    @Autowired
    private MockMvc mockMvc;

    ObjectMapper mapper = new ObjectMapper();

    @Test
    void palindrome200() throws Exception {
        when(palindromeCheckerService.checkPalindrome(anyString())).thenReturn(true);

        mockMvc.perform(post("/palindrome")
                .content(mapper.writeValueAsString(new PalindromeDto("user", "input")))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(palindromeCheckerService, times(1)).checkPalindrome(anyString());
        verifyNoMoreInteractions(palindromeCheckerService);
    }
}
