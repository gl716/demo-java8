package com.leon;


import java.util.Arrays;
import java.util.Base64;

/**
 * @author Leon
 * @since 2021年09月24日 9:58
 **/
public class StringTest {

    public static void main(String[] args) throws Exception{

        byte[] base64Token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9".getBytes("utf-8");

        byte[] decoded;
        try {
            decoded = Base64.getUrlDecoder().decode(base64Token);
        } catch (IllegalArgumentException var7) {
            throw new RuntimeException("failed to decode basic authentication token");
        }

        String token = new String(decoded, "utf-8");
        System.out.println(token);
//        String str = "1438032755197431809,123";
//        boolean contains = Arrays.stream("1438032755197431809".split(",")).anyMatch(str::contains);
//        System.out.println(contains);
    }
}
