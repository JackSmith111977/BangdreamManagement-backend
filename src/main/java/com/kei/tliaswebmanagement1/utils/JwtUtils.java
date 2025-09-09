package com.kei.tliaswebmanagement1.utils;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;
import java.util.Map;

public class JwtUtils {
    private static final String SECRET_STRING = "S2FydWl6YXdhS2VpS2FydWl6YXdhS2VpS2FydWl6YXdhS2Vp";// 密钥
    private static final SecretKey SECRET_KEY = Keys.hmacShaKeyFor(
            Base64.getDecoder().decode(SECRET_STRING)
    );
    private static final long EXPIRATION_TIME = 12*60*60*1000;// 12 hours

    /* 生成Jwt令牌*/
    public static String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256,  SECRET_KEY)
                .addClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .compact();
    }

    /* 解析Jwt令牌*/
    public static Map<String, Object> parseToken(String token) {
        return Jwts.parser()
                .verifyWith(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

}
