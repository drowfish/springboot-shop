package com.example.util;

import com.example.exception.LoginException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtil {
    final static String base64EncodedSecretKey = "pass";//私钥

    final static long TOKEN_EXP = 1000 * 60 * 10;//过期时间,测试使用十分钟



    public static String getToken(String userName) {

        return Jwts.builder()

        .setSubject(userName)

        .claim("roles", "user")

        .setIssuedAt(new Date())

        .setExpiration(new Date(System.currentTimeMillis() + TOKEN_EXP)) /*过期时间*/

        .signWith(SignatureAlgorithm.HS256, base64EncodedSecretKey)

        .compact();

    }

    public static Claims checkToken(String token) throws Exception {

        try {

            final Claims claims = Jwts.parser().setSigningKey(base64EncodedSecretKey).parseClaimsJws(token).getBody();

            return claims;

        } catch (ExpiredJwtException e1) {

            throw new LoginException("登录信息过期，请重新登录");

        } catch (Exception e) {

            throw new LoginException("用户未登录，请重新登录");

        }

    }
}
