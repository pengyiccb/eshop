package com.tfx0one.center.AccountCenter.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 2fx0one on 2018/6/4.
 */
@Component
public class JwtTokenUtils {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiredTimeOutSecond}")
    private int expiredTimeOutSecond;


    public Date generateExpirationDate(int expiredTimeSecond) {
//        expiredTimeSecond
        return new Date(System.currentTimeMillis() + expiredTimeSecond*1000);
    }

    public String generateTokenThenCacheUser(Map<String, Object> claims, String secret, int expiredTimeOutSecond) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate(expiredTimeOutSecond))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public Claims getClaimsFromToken(String token, String secret) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    public String getUsernameFromToken(String authToken) {
//        System.out.println("getUsernameFromToken() " + authToken);
        Claims claims = this.getClaimsFromToken(authToken, this.secret);
//        System.out.println("getUsernameFromToken() " + claims);
//        if (claims != null) {
//            return claims.get("username", String.class);
//        }
        return (null != claims) ? claims.get("username", String.class) : null;
    }

    public boolean validateToken(String authToken, UserDetails userDetails) {
        //TODO 验证需要完成更多逻辑
        return authToken != null && userDetails != null;
    }

    public String generateTokenThenCacheUser(UserDetails userDetails) {
        Map<String, Object> data = new HashMap<>();
        data.put("username", userDetails.getUsername());
        return this.generateTokenThenCacheUser(data, this.secret, this.expiredTimeOutSecond);
    }
}
