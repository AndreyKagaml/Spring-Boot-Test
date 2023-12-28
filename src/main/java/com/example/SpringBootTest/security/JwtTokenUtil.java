package com.example.SpringBootTest.security;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class JwtTokenUtil {

    private JwtTokenUtil() {}

    static byte[] encodeSecretKey(String secretKey) {
        return Base64.getEncoder()
                .encodeToString(secretKey.getBytes())
                .getBytes(StandardCharsets.UTF_8);
    }
}
