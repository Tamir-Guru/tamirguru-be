/*
 * @author : Oguz Kahraman
 * @since : 31 Ara 2021
 *
 * Copyright - TamirGuru
 */
package com.dota.tamirguru.core.security.config;

import com.dota.tamirguru.core.utils.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class DocumentAuthProvider implements AuthenticationProvider {

    @Value("${spring.security.user.password}")
    private String systemPassword;

    @Autowired
    private PasswordUtil passwordUtil;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        if (passwordUtil.encodePassword(password, username).equals(systemPassword)) {
            return new UsernamePasswordAuthenticationToken(username, "", authentication.getAuthorities());
        }
        throw new BadCredentialsException("Bad Credentials");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
