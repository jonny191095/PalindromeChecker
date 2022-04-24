package com.example.PalindromeChecker.Repositories;

import com.example.PalindromeChecker.Common.Palindrome;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;

import java.util.List;

@Repository
public class PalindromeCache implements CommandLineRunner {

    @Autowired
    private PalindromeRepository palindromeRepository;

    private final Jedis jedis;
    private final String setName;
    private static final Logger LOGGER = LoggerFactory.getLogger(PalindromeCache.class);

    public PalindromeCache() {
        this.jedis = new Jedis();
        this.setName = "name";
    }

    public PalindromeCache(Jedis jedis, String isKey) {
        this.jedis = jedis;
        this.setName = isKey;
    }

    public void savePalindrome(String palindrome, String is) {
        LOGGER.info("Saving: {} at {}", is, palindrome);
        jedis.hset(setName, palindrome, is);
    }

    public Boolean getIsKey(String palindrome) {
        LOGGER.info("Retrieving at {}", palindrome);
        String is = jedis.hget(setName, palindrome);
        return is == null ? null : Boolean.valueOf(is);
    }

    @Override
    public void run(String... args) {
        LOGGER.info("Pre-populating cache");
        List<Palindrome> palindromeList = palindromeRepository.findAll();
        for (Palindrome p : palindromeList) {
            jedis.hset(setName, p.getValue(), p.getIsPalindrome().toString());
        }
        LOGGER.info("Pre-populating complete");
    }
}
