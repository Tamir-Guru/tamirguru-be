/*
 * @author : oguzkahraman
 * @since : 27.07.2021
 *
 * Copyright - Tamir Guru App Java API
 **/
package com.dota.tamirguru.core.security.jwt;

import com.dota.tamirguru.core.annotations.SkipSecurity;
import com.dota.tamirguru.core.exception.GuruException;
import com.dota.tamirguru.entitites.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("java:S3516")
public class JWTInterceptor implements HandlerInterceptor {

    @Autowired
    private JWTService jwtService;

    @Autowired
    private JWTUtil util;

    @Override
    public boolean preHandle(HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler) {
        if (handler instanceof HandlerMethod hm && (hm.getMethod().getDeclaredAnnotation(SkipSecurity.class) != null ||
                hm.getBeanType().getDeclaredAnnotation(SkipSecurity.class) != null)) {
            return true;
        }
        String token = request.getHeader(util.getHeaderString());
        if (token == null || !token.contains(util.getTokenPrefix()) || !jwtService.checkIsValid(token)) {
            throw new GuruException(HttpStatus.UNAUTHORIZED, "JWT token is invalid", "JWT_TOKEN_INVALID");
        }
        try {
            if (jwtService.isTokenExpired(token)) {
                throw new GuruException(HttpStatus.UNAUTHORIZED, "JWT token is expired", "JWT_TOKEN_EXPIRED");
            }
        } catch (Exception e) {
            throw new GuruException(HttpStatus.UNAUTHORIZED, "JWT token is invalid", "JWT_TOKEN_INVALID");
        }
        User user = jwtService.getUserFromToken(token);
        if (!Boolean.TRUE.equals(user.isVerified())) {
            throw new GuruException(HttpStatus.FORBIDDEN, "Pls validate mail address", "NOT_VALIDATED");
        }
        UsernamePasswordAuthenticationToken authentication = jwtService.getAuthenticationToken(user);
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return true;
    }


}
