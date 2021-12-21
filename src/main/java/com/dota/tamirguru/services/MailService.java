/*
 * @author : Oguz Kahraman
 * @since : 22.02.2021
 *
 * Copyright - Collige Java API
 **/
package com.dota.tamirguru.services;


import com.dota.tamirguru.models.internals.mail.GenericMailRequest;

public interface MailService {

    void sendMailValidation(GenericMailRequest requestDto);

    void sendPasswordResetMail(GenericMailRequest requestDto);

    void sendInvitationMail(GenericMailRequest requestDto);

    void sendScheduledInvitation(GenericMailRequest requestDto);

}

