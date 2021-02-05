package com.hanko.auth.utils;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Author: hanko
 * @Date: 2021-2-4 9:35
 */
public class PasswordTest {
    @Test
    void test(){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String dest = passwordEncoder.encode("123456");

        System.out.println(dest);



    }
}
