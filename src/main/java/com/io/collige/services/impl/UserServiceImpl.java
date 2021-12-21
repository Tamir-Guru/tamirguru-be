/*
 * @author : Oguz Kahraman
 * @since : 3.08.2021
 *
 * Copyright - Tamir Guru App Java API
 **/
package com.io.collige.services.impl;

import com.io.collige.constants.GeneralMessageConstants;
import com.io.collige.core.exception.CalendarAppException;
import com.io.collige.core.i18n.Translator;
import com.io.collige.core.security.jwt.JWTService;
import com.io.collige.entitites.User;
import com.io.collige.entitites.Validation;
import com.io.collige.enums.ValidationType;
import com.io.collige.mappers.UserMapper;
import com.io.collige.models.internals.mail.GenericMailRequest;
import com.io.collige.models.internals.mail.ResendValidationRequest;
import com.io.collige.models.requests.user.AuthRequest;
import com.io.collige.models.requests.user.ChangePasswordRequest;
import com.io.collige.models.requests.user.ResendVerificationMailRequest;
import com.io.collige.models.requests.user.ResetPasswordMailRequest;
import com.io.collige.models.requests.user.ResetPasswordRequest;
import com.io.collige.models.requests.user.UserCreateRequest;
import com.io.collige.models.requests.user.UserUpdateRequest;
import com.io.collige.models.requests.user.ValidationRequest;
import com.io.collige.models.responses.user.UserResponse;
import com.io.collige.repositories.UserRepository;
import com.io.collige.services.MailService;
import com.io.collige.services.UserService;
import com.io.collige.services.ValidationService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.text.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Collections;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JWTService jwtService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MailService mailService;

    @Autowired
    private ValidationService validationService;

    /**
     * This method creates new individual user
     *
     * @param request user details
     */
    @Override
    public UserResponse createIndividualUser(UserCreateRequest request) {
        ifUserExistWithError(request.getEmail().toLowerCase());
        User user = new User();
        user.setEmail(request.getEmail().toLowerCase());
        user.setName(WordUtils.capitalize(request.getName()));
        userRepository.save(user);
        mailService.sendMailValidation(new GenericMailRequest(Collections.singleton(user.getEmail()), user.getName(),
                validationService.createValidationInfo(user, ValidationType.EMAIL), Translator.getLanguage()));
        UserResponse response = userMapper.mapToModel(user);
        response.setToken(jwtService.createToken(user));
        return response;
    }

    /**
     * Performs login functions
     * Checks user
     * Checks password
     *
     * @param authRequest request data
     * @return user data
     */
    @Override
    public UserResponse loginUser(AuthRequest authRequest) {
        User user = userRepository.findByEmail(authRequest.getUsername().toLowerCase())
                .orElseThrow(() -> new CalendarAppException(HttpStatus.FORBIDDEN, Translator.getMessage(GeneralMessageConstants.WRONG_INFO),
                        GeneralMessageConstants.WRONG_INFO_ERR));
        if (encodePassword(authRequest.getPassword(), user.getEmail().toLowerCase()).equals(user.getPassword())) {
            UserResponse userResponse = userMapper.mapToModel(user);
            userResponse.setToken(jwtService.createToken(user));
            return userResponse;
        }
        throw new CalendarAppException(HttpStatus.FORBIDDEN, Translator.getMessage(GeneralMessageConstants.WRONG_INFO),
                GeneralMessageConstants.WRONG_INFO_ERR);
    }

    /**
     * This method gets user information
     *
     * @param email mail of user
     */
    @Override
    public UserResponse findByMail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new CalendarAppException(HttpStatus.BAD_REQUEST, Translator.getMessage(GeneralMessageConstants.USER_NOT_FOUND),
                        GeneralMessageConstants.USR_NOT_FOUND));
        UserResponse userResponse = userMapper.mapToModel(user);
        userResponse.setToken(jwtService.createToken(user));
        return userResponse;
    }

    /**
     * Checks if user exist or not
     *
     * @param mail user
     */
    @Override
    public boolean ifUserExist(String mail) {
        return userRepository.existsByEmail(mail);
    }

    /**
     * Get details by user token
     *
     * @return User detail object
     * @throws CalendarAppException if user not exist
     * @see com.io.collige.models.responses.user.UserResponse for return object details
     */
    @Override
    public UserResponse getUserDetailsFromToken() {
        User user = jwtService.getLoggedUser();
        UserResponse response = userMapper.mapToModel(user);
        response.setToken(jwtService.createToken(user));
        return response;
    }

    /**
     * Update user
     *
     * @param userUpdateRequest new details
     * @throws CalendarAppException if user not exist
     */
    @Override
    public UserResponse updateUser(UserUpdateRequest userUpdateRequest) {
        User user = jwtService.getLoggedUser();
        if (!userUpdateRequest.getEmail().equals(user.getEmail())) {
            user.setVerified(false);
            mailService.sendMailValidation(new GenericMailRequest(Collections.singleton(user.getEmail()), user.getName(),
                    validationService.createValidationInfo(user, ValidationType.EMAIL), Translator.getLanguage()));
        }
        user.setEmail(userUpdateRequest.getEmail());
        user.setName(userUpdateRequest.getName());
        return userMapper.mapToModel(userRepository.save(user));
    }

    /**
     * Performs change password for logged in user
     *
     * @param request new and old password
     * @throws CalendarAppException if user not exist or infos wrong
     */
    @Override
    public void changePassword(ChangePasswordRequest request) {
        User user = jwtService.getLoggedUser();
        if (!encodePassword(request.getOldPassword(), user.getEmail().toLowerCase()).equals(user.getPassword())) {
            throw new CalendarAppException(HttpStatus.FORBIDDEN, Translator.getMessage(GeneralMessageConstants.WRONG_INFO),
                    GeneralMessageConstants.WRONG_INFO_ERR);
        }
        user.setPassword(encodePassword(request.getNewPassword(), user.getEmail()));
        userRepository.save(user);
    }

    /**
     * Performs change password for logged in user
     *
     * @param request user mail
     * @throws CalendarAppException if user not exist or infos wrong
     */
    @Override
    public void resetPasswordRequest(ResetPasswordMailRequest request) {
        User user = userRepository.findByEmail(request.getEmail().toLowerCase())
                .orElseThrow(() -> new CalendarAppException(HttpStatus.BAD_REQUEST, Translator.getMessage(GeneralMessageConstants.USER_NOT_FOUND),
                        GeneralMessageConstants.USR_NOT_FOUND));
        GenericMailRequest mailRequest = new GenericMailRequest();
        mailRequest.setName(user.getName());
        mailRequest.setCode(validationService.createValidationInfo(user, ValidationType.PASSWORD));
        mailRequest.setEmails(Collections.singleton(request.getEmail()));
        mailService.sendPasswordResetMail(mailRequest);
    }

    /**
     * Reset password
     *
     * @param request password details
     * @throws CalendarAppException if user not exist or infos wrong
     */
    @Override
    public void resetPassword(ResetPasswordRequest request) {
        User user = userRepository.findByEmail(request.getEmail().toLowerCase())
                .orElseThrow(() -> new CalendarAppException(HttpStatus.BAD_REQUEST, Translator.getMessage(GeneralMessageConstants.USER_NOT_FOUND),
                        GeneralMessageConstants.USR_NOT_FOUND));
        validationService.verify(new ValidationRequest(request.getCode(), request.getEmail()));
        user.setPassword(encodePassword(request.getPassword(), user.getEmail()));
    }


    /**
     * Resend validation
     *
     * @param request mail details
     * @throws CalendarAppException if validation info not exist
     */
    @Override
    public void resendValidationMail(ResendVerificationMailRequest request) {
        Validation validation = validationService.getValidationDetail(new ResendValidationRequest(request.getEmail(), request.getType()));
        User user = userRepository.findByEmail(request.getEmail().toLowerCase())
                .orElseThrow(() -> new CalendarAppException(HttpStatus.BAD_REQUEST, Translator.getMessage(GeneralMessageConstants.USER_NOT_FOUND),
                        GeneralMessageConstants.USR_NOT_FOUND));
        if (ValidationType.EMAIL.equals(request.getType())) {
            mailService.sendMailValidation(new GenericMailRequest(Collections.singleton(request.getEmail()), user.getName(),
                    validation.getCode(), Translator.getLanguage()));
        } else {
            mailService.sendPasswordResetMail(new GenericMailRequest(Collections.singleton(request.getEmail()), user.getName(),
                    validation.getCode(), Translator.getLanguage()));
        }
    }

    /**
     * Checks if user already added to db by user mail
     *
     * @param mail given mail address
     * @throws CalendarAppException if user not exist
     */
    private void ifUserExistWithError(String mail) {
        if (userRepository.existsByEmail(mail)) {
            throw new CalendarAppException(HttpStatus.BAD_REQUEST, Translator.getMessage(GeneralMessageConstants.USER_FOUND),
                    GeneralMessageConstants.USR_FOUND);
        }
    }

    /**
     * Encode user password for security
     * Combine username, usernameid and security
     *
     * @param password password information
     * @param userMail mail of user
     * @return encoded password
     */
    private synchronized String encodePassword(String password, String userMail) {
        String concat = userMail.toLowerCase();
        MessageDigest md = DigestUtils.getSha256Digest();
        md.update(concat.getBytes(StandardCharsets.UTF_8));
        byte[] bytes = md.digest(password.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte aByte : bytes) {
            sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }

}
