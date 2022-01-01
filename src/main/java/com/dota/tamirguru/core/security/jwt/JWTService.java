/*
 * @author : Oguz Kahraman
 * @since : 27.07.2021
 *
 * Copyright - Tamir Guru App Java API
 **/
package com.dota.tamirguru.core.security.jwt;

import com.dota.tamirguru.constants.GeneralMessageConstants;
import com.dota.tamirguru.core.exception.GuruException;
import com.dota.tamirguru.core.i18n.Translator;
import com.dota.tamirguru.core.utils.RoleUtil;
import com.dota.tamirguru.entitites.User;
import com.dota.tamirguru.repositories.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

@Service
public class JWTService {

    @Autowired
    private JWTUtil util;

    @Autowired
    private UserRepository userRepository;

    private Key signingKey;

    private JwtParser parser;

    /*
     * Initialize jwt service
     */
    @PostConstruct
    private void initialize() {
        signingKey = new SecretKeySpec(util.getSecret().getBytes(), SignatureAlgorithm.HS512.getJcaName());
        parser = Jwts.parserBuilder().setSigningKey(signingKey).build();
    }

    /*
     * Creates token for logged in user
     *
     * @param user user details
     * @return user token
     */
    public String createToken(User user) {
        return util.getTokenPrefix() + Jwts.builder()
                .setIssuer("Tamir Guru API")
                .setIssuedAt(Timestamp.valueOf(LocalDateTime.now()))
                .setSubject(user.getEmail())
                .setAudience("Tamir Guru")
                .setExpiration(Timestamp.valueOf(LocalDateTime.now().plusDays(1)))
                .claim("username", user.getEmail().toLowerCase())
                .claim("id", user.getId())
                .claim("roles", RoleUtil.getRole(user.getRole()))
                .signWith(signingKey)
                .compact();
    }

    /*
     * Parses token and returns user id
     *
     * @param token user token
     * @return user id
     */
    private Long getIdFromToken(String token) {
        Claims claims = getJwtToken(token);
        return claims.get("id", Double.class).longValue();
    }

    /*
     * Parses token and returns user data
     *
     * @return user data
     */
    public User getLoggedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (User) authentication.getPrincipal();
    }

    /*
     * Parses token and returns user data
     *
     * @return user data
     */
    public List<SimpleGrantedAuthority> getUserRoles(User user) {
        Set<String> roles = RoleUtil.getRole(user.getRole());

        return Arrays.stream(roles.toArray(new String[0]))
                .map(SimpleGrantedAuthority::new)
                .toList();
    }

    /*
     * Parses token and returns user data
     *
     * @param token user token
     * @return user data
     */
    public User getUserFromToken(String token) {
        return findById(getIdFromToken(token));
    }

    /*
     * Generates user authorities
     *
     * @param userDetails details
     * @return spring object
     */
    public UsernamePasswordAuthenticationToken getAuthenticationToken(final User userDetails) {
        return new UsernamePasswordAuthenticationToken(userDetails, "", getUserRoles(userDetails));
    }

    /*
     * Parses token and returns token data
     *
     * @param token user token
     * @return like user data, id, expire data etc.
     */
    private Claims getJwtToken(String token) {
        try {
            String reToken = token.replace(util.getTokenPrefix(), "");
            return parser.parseClaimsJws(reToken).getBody();
        } catch (SignatureException e) {
            throw new GuruException(HttpStatus.UNAUTHORIZED, Translator.getMessage("error.signature"), "SIGNATURE_ERR");
        } catch (MalformedJwtException | ExpiredJwtException e) {
            throw new GuruException(HttpStatus.UNAUTHORIZED, "JWT token is invalid", "JWT_TOKEN_INVALID");
        }

    }

    /*
     * Chceks if token expired
     *
     * @param token user token
     * @return expired true, not expired false
     */
    public boolean isTokenExpired(String token) {
        Claims claims = getJwtToken(token);
        LocalDateTime time = LocalDateTime.ofInstant(Instant.ofEpochMilli(claims.getExpiration().getTime()), TimeZone.getDefault().toZoneId());
        return time.isBefore(LocalDateTime.now());
    }

    /*
     * This method creates new individual user
     *
     * @param id id of user
     */
    private User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new GuruException(HttpStatus.BAD_REQUEST, Translator.getMessage(GeneralMessageConstants.USER_NOT_FOUND),
                        GeneralMessageConstants.USR_NOT_FOUND));
    }

}

