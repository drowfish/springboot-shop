package com.example.inteceptor;

import com.example.exception.LoginException;
import com.example.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JwtInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String authHeader = request.getHeader("Authorization");
        System.out.println("autherHeader:"+authHeader);
        if (authHeader == null || !authHeader.startsWith("Bearer:")) {

            throw new LoginException("用户未登录");

        }

        //取得token

        String token = authHeader.substring(7);

        //验证token

        Claims claims = JwtUtil.checkToken(token);

        request.setAttribute("username",claims.getSubject());

        return true;

    }

}
