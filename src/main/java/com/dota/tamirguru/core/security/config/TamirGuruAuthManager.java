/*
 * @author : Oguz Kahraman
 * @since : 31 Ara 2021
 *
 * Copyright - TamirGuru
 */
package com.dota.tamirguru.core.security.config;

import com.dota.tamirguru.core.utils.PasswordUtil;
import com.dota.tamirguru.entitites.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public record TamirGuruAuthManager(PasswordUtil passwordUtil) implements AuthenticationManager {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        User user = (User) authentication.getPrincipal();
        if (passwordUtil.encodePassword(authentication.getCredentials().toString(), user.getEmail().toLowerCase()).equals(user.getPassword())) {
            return new UsernamePasswordAuthenticationToken(user, "", authentication.getAuthorities());
        }
        throw new BadCredentialsException("Bad Credentials");
    }
}
