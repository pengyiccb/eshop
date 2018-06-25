package com.tfx0one.common.util;

import com.tfx0one.center.AccountCenter.JwtAuth.JWTokenUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by 2fx0one on 2018/6/4.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JWTokenUtilsTest {


    @Test
    public void test_token() {
        JWTokenUtils JWTokenUtils = new JWTokenUtils();

//        String autToken = "eyJhbGciOiJIUzUxMiJ9.eyJleHAiOjE1MjgwOTY4NTQsInVzZXJuYW1lIjoid2FuZ2t1biJ9.s6vMZNUAbsmZ9TWqFEIXN05OI5IAs3Qg_SVBxR3-eXT21HHDqDCMHSRaBPfgr3TcXE606pwRYna38yH57y1xGQ";
//        String u = jwtTokenUtils.getUsernameFromToken(autToken);
//        System.out.println(u);
//        Map<String, Object> c = new HashMap<>();
//        c.put("a", 1);
//        String secret = "a2Vsdmlu";
//        String token = jwtTokenUtils.generateTokenThenCacheUser(c, secret, 1000);
//
//        System.out.println(token);
//
//        Claims claims = jwtTokenUtils.getClaimsFromToken(token, secret);
////        System.out.println(claims.getId());
//        System.out.println(claims);
//        System.out.println(claims.getSubject());


    }

}