/*
 * @author : Oguz Kahraman
 * @since : 26 Şub 2022
 *
 * Copyright - TamirGuru
 */
package com.dota.tamirguru.services;

public interface CloudService {
    String uploadPhoto(byte[] photoData, String userMail);

    String uploadMerchantPhoto(byte[] photoData, Long id);
}
