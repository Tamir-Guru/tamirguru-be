/*
 * @author : Oguz Kahraman
 * @since : 31 Ara 2021
 *
 * Copyright - TamirGuru
 */
package com.dota.tamirguru.core.security.config;

import com.dota.tamirguru.core.exception.GuruException;
import com.dota.tamirguru.core.security.jwt.JWTService;
import com.dota.tamirguru.core.security.jwt.JWTUtil;
import com.dota.tamirguru.entitites.User;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtFilter extends OncePerRequestFilter {

    private final JWTService jwtService;

    private final JWTUtil util;

    public JwtFilter(JWTService jwtService, JWTUtil util) {
        this.jwtService = jwtService;
        this.util = util;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader(util.getHeaderString());
        if (token != null) {
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
        }
        filterChain.doFilter(request, response);
    }

}
