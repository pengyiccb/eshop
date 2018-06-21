package com.tfx0one.center.AccountCenter.JwtAuth;

import com.tfx0one.center.AccountCenter.model.UserAccount;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
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

    private static final String KEY_USERNAME = "username";
    private static final String KEY_ID = "id";

    //过期时间
    private Date generateExpirationDate(int expiredTimeSecond) {
        return new Date(System.currentTimeMillis() + expiredTimeSecond*1000);
    }

    private String generateToken(Map<String, Object> claims, String secret, int expiredTimeOutSecond) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate(expiredTimeOutSecond))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public String generateToken(UserAccount user) {
        Map<String, Object> data = new HashMap<>();
        data.put(KEY_USERNAME, user.getUsername());
        data.put(KEY_ID, user.getId().toString());
        return this.generateToken(data, this.secret, this.expiredTimeOutSecond);
    }

    private Claims getClaimsFromToken(String token, String secret) {
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

    private String getValueFromToken(String authToken, String key) {
//        System.out.println("getUsernameFromToken() " + authToken);
        Claims claims = this.getClaimsFromToken(authToken, this.secret);

        return (null != claims) ? claims.get(key, String.class) : null;
    }

    public String getUsernameFromToken(String token) {
        return getValueFromToken(token, KEY_USERNAME);
    }

    public String getIdFromToken(String token) {
        return getValueFromToken(token, KEY_ID);
    }


    public boolean validateToken(String authToken, JwtUser userDetails) {
        if (authToken == null || userDetails == null) {
            return false;
        }

        if(getIdFromToken(authToken) == null || userDetails.getId() ==null) {
            return false;
        }

        //id必须一致
        if (!getIdFromToken(authToken).equals(userDetails.getId())) {
            return false;
        }

        //TODO 验证需要完成更多逻辑
        return true;
    }

//    public String generateTokenThenCacheUser(JwtUser userDetails) {
//        Map<String, Object> data = new HashMap<>();
//        data.put(KEY_USERNAME, userDetails.getUsername());
//        data.put(KEY_ID, userDetails.getId());
//        return this.generateTokenThenCacheUser(data, this.secret, this.expiredTimeOutSecond);
//    }

}
