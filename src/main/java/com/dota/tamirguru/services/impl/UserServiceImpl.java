/*
 * @author : Oguz Kahraman
 * @since : 3.08.2021
 *
 * Copyright - Tamir Guru App Java API
 **/
package com.dota.tamirguru.services.impl;

import annotations.com.dota.tamirguru.nvi.KPSPublic;
import com.dota.tamirguru.constants.GeneralMessageConstants;
import com.dota.tamirguru.core.exception.GuruException;
import com.dota.tamirguru.core.i18n.Translator;
import com.dota.tamirguru.core.security.config.TamirGuruAuthProvider;
import com.dota.tamirguru.core.security.jwt.JWTService;
import com.dota.tamirguru.core.utils.PasswordUtil;
import com.dota.tamirguru.entitites.User;
import com.dota.tamirguru.entitites.Validation;
import com.dota.tamirguru.enums.RoleEnum;
import com.dota.tamirguru.enums.ValidationType;
import com.dota.tamirguru.mappers.UserMapper;
import com.dota.tamirguru.models.internals.mail.GenericMailRequest;
import com.dota.tamirguru.models.internals.mail.ResendValidationRequest;
import com.dota.tamirguru.models.requests.user.AuthRequest;
import com.dota.tamirguru.models.requests.user.ChangePasswordRequest;
import com.dota.tamirguru.models.requests.user.ResendVerificationMailRequest;
import com.dota.tamirguru.models.requests.user.ResetPasswordMailRequest;
import com.dota.tamirguru.models.requests.user.ResetPasswordRequest;
import com.dota.tamirguru.models.requests.user.UserCreateRequest;
import com.dota.tamirguru.models.requests.user.UserUpdateRequest;
import com.dota.tamirguru.models.requests.user.ValidationRequest;
import com.dota.tamirguru.models.responses.user.UserResponse;
import com.dota.tamirguru.repositories.UserRepository;
import com.dota.tamirguru.services.CloudService;
import com.dota.tamirguru.services.MailService;
import com.dota.tamirguru.services.UserService;
import com.dota.tamirguru.services.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private TamirGuruAuthProvider authProvider;

    @Autowired
    private PasswordUtil passwordUtil;

    @Autowired
    private CloudService cloudService;

    @Value("${spring.profiles.active:}")
    private String activeProfiles;

    /**
     * This method creates new individual user
     *
     * @param request user details
     */
    @Override
    public UserResponse createUser(UserCreateRequest request) {
        ifUserExistWithError(request.getEmail().toLowerCase());
        User user = userMapper.mapToModel(request);
        user.setPassword(passwordUtil.encodePassword(request.getPassword(), user.getEmail()));
        nviCheck(user);
        userRepository.save(user);
        if (!RoleEnum.COMMERCIAL.equals(user.getRole())) {
            mailService.sendMailValidation(new GenericMailRequest(Collections.singleton(user.getEmail()), user.getName(),
                    validationService.createValidationInfo(user, ValidationType.EMAIL), Translator.getLanguage()));
        }
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
     **/
    @Override
    public UserResponse loginUser(AuthRequest authRequest) {
        User user = userRepository.findByEmail(authRequest.getUsername().toLowerCase())
                .orElseThrow(() -> new GuruException(HttpStatus.FORBIDDEN, Translator.getMessage(GeneralMessageConstants.WRONG_INFO),
                        GeneralMessageConstants.WRONG_INFO_ERR));
        authProvider.authenticate(new UsernamePasswordAuthenticationToken(user, authRequest.getPassword(), jwtService.getUserRoles(user)));
        UserResponse userResponse = userMapper.mapToModel(user);
        userResponse.setToken(jwtService.createToken(user));
        return userResponse;
    }

    /**
     * Performs login functions
     * Checks user
     * Checks password
     *
     * @return user data
     **/
    @Override
    public User getFromUserName(String userName) {
        return userRepository.findByEmail(userName.toLowerCase())
                .orElseThrow(() -> new GuruException(HttpStatus.FORBIDDEN, Translator.getMessage(GeneralMessageConstants.WRONG_INFO),
                        GeneralMessageConstants.WRONG_INFO_ERR));
    }

    /**
     * This method gets user information
     *
     * @param email mail of user
     **/
    @Override
    public UserResponse findByMail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new GuruException(HttpStatus.BAD_REQUEST, Translator.getMessage(GeneralMessageConstants.USER_NOT_FOUND),
                        GeneralMessageConstants.USR_NOT_FOUND));
        UserResponse userResponse = userMapper.mapToModel(user);
        userResponse.setToken(jwtService.createToken(user));
        return userResponse;
    }

    /**
     * Checks if user exist or not
     *
     * @param mail user
     **/
    @Override
    public boolean ifUserExist(String mail) {
        return userRepository.existsByEmail(mail);
    }

    /**
     * Get details by user token
     *
     * @return User detail object
     * @throws GuruException if user not exist
     * @see UserResponse for return object details
     **/
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
     * @throws GuruException if user not exist
     **/
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
        user.setSurname(userUpdateRequest.getSurname());
        user.setCreateDate(user.getCreateDate());
        nviCheck(user);
        return userMapper.mapToModel(userRepository.save(user));
    }

    /**
     * Performs change password for logged in user
     *
     * @param request new and old password
     * @throws GuruException if user not exist or infos wrong
     **/
    @Override
    public void changePassword(ChangePasswordRequest request) {
        User user = jwtService.getLoggedUser();
        if (!passwordUtil.encodePassword(request.getOldPassword(), user.getEmail().toLowerCase()).equals(user.getPassword())) {
            throw new GuruException(HttpStatus.FORBIDDEN, Translator.getMessage(GeneralMessageConstants.WRONG_INFO),
                    GeneralMessageConstants.WRONG_INFO_ERR);
        }
        user.setPassword(passwordUtil.encodePassword(request.getNewPassword(), user.getEmail()));
        userRepository.save(user);
    }

    /**
     * Performs change password for logged in user
     *
     * @param request user mail
     * @throws GuruException if user not exist or infos wrong
     **/
    @Override
    public void resetPasswordRequest(ResetPasswordMailRequest request) {
        User user = userRepository.findByEmail(request.getEmail().toLowerCase())
                .orElseThrow(() -> new GuruException(HttpStatus.BAD_REQUEST, Translator.getMessage(GeneralMessageConstants.USER_NOT_FOUND),
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
     * @throws GuruException if user not exist or infos wrong
     **/
    @Override
    public void resetPassword(ResetPasswordRequest request) {
        User user = userRepository.findByEmail(request.getEmail().toLowerCase())
                .orElseThrow(() -> new GuruException(HttpStatus.BAD_REQUEST, Translator.getMessage(GeneralMessageConstants.USER_NOT_FOUND),
                        GeneralMessageConstants.USR_NOT_FOUND));
        validationService.verify(new ValidationRequest(request.getCode(), request.getEmail()));
        user.setPassword(passwordUtil.encodePassword(request.getPassword(), user.getEmail()));
    }


    /**
     * Resend validation
     *
     * @param request mail details
     * @throws GuruException if validation info not exist
     **/
    @Override
    public void resendValidationMail(ResendVerificationMailRequest request) {
        Validation validation = validationService.getValidationDetail(new ResendValidationRequest(request.getEmail(), request.getType()));
        User user = userRepository.findByEmail(request.getEmail().toLowerCase())
                .orElseThrow(() -> new GuruException(HttpStatus.BAD_REQUEST, Translator.getMessage(GeneralMessageConstants.USER_NOT_FOUND),
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
     * Upload avatar4
     *
     * @param photo photo data
     * @throws GuruException if user not exist
     **/
    @Override
    public UserResponse uploadUserPhoto(byte[] photo) {
        User user = jwtService.getLoggedUser();
        user.setPhoto(cloudService.uploadPhoto(photo, user.getEmail()));
        userRepository.save(user);
        return userMapper.mapToModel(user);
    }

    /**
     * Checks if user already added to db by user mail
     *
     * @param mail given mail address
     * @throws GuruException if user not exist
     **/
    private void ifUserExistWithError(String mail) {
        if (userRepository.existsByEmail(mail)) {
            throw new GuruException(HttpStatus.BAD_REQUEST, Translator.getMessage(GeneralMessageConstants.USER_FOUND),
                    GeneralMessageConstants.USR_FOUND);
        }
    }

    private void nviCheck(User user) {
        if (RoleEnum.COMMERCIAL.equals(user.getRole()) && "test".equals(activeProfiles)) {
            KPSPublic soap = new KPSPublic();
            boolean bool = soap.getKPSPublicSoap().tcKimlikNoDogrula(Long.parseLong(user.getTckn()), user.getName(),
                    user.getSurname(), user.getBirthdate().getYear());
            if (!bool) {
                throw new GuruException(HttpStatus.FORBIDDEN, "User information not valid", "NOT_VALID_INFO");
            }
            user.setVerified(true);
        }
    }

}
