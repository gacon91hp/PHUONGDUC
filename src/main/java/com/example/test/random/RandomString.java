package com.example.test.random;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

@Component
public class RandomString {

    public String genString(){
        String characters = "abcdefghijklmnopqrstuvwxyz";
        String a = "123456789";
        String b = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String randomid = RandomStringUtils.random( 2, b) +
                RandomStringUtils.random( 2, a) +
                RandomStringUtils.random( 4, characters);
        return randomid;
    }
}
