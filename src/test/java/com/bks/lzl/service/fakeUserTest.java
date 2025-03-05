package com.bks.lzl.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

@SpringBootTest
public class fakeUserTest {
    private static final String SALT = "bkslzl";

    @Test
    public void generateUser(){
        String password = "123456789";
        String encryptPassword = DigestUtils.md5DigestAsHex((SALT + password).getBytes());
        System.out.println(encryptPassword);
    }
}
