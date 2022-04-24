package com.example.PalindromeChecker.Common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Palindrome {
    @Id
    private String value;
    private Boolean isPalindrome;
}
