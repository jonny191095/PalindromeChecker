package com.example.PalindromeChecker.Repositories;

import com.example.PalindromeChecker.Common.Palindrome;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PalindromeRepository extends CrudRepository<Palindrome, Long> {
    Palindrome findByValue(String value);
    List<Palindrome> findAll();
}
