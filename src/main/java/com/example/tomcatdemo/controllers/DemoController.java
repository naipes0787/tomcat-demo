package com.example.tomcatdemo.controllers;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Random random;

    private DemoController() throws NoSuchAlgorithmException {
        this.random = SecureRandom.getInstanceStrong();
    }

    @GetMapping("/random-strings")
    public String getRandomStrings() {
        var leftLimit = 97; // letter 'a'
        var rightLimit = 122; // letter 'z'
        var targetStringLength = 10;
        return random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    @GetMapping("/random-numbers")
    public Integer getRandomIntegers() {
        return random.nextInt();
    }

}
