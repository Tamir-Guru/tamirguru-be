/*
 * @author : Oguz Kahraman
 * @since : 26 Şub 2022
 *
 * Copyright - TamirGuru
 */
package com.dota.tamirguru.services.impl;

import com.cloudinary.Cloudinary;
import com.dota.tamirguru.services.CloudService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class CloudServiceImpl implements CloudService {

    private static final String FOLDER = "folder";
    private static final String OVERWRITE = "overwrite";
    private static final String USE_FILENAME = "use_filename";
    private static final String PUBLIC_ID = "public_id";

    @Value("${cloudinary.api_key}")
    private String apiKey;

    @Value("${cloudinary.api_secret}")
    private String apiSecret;

    @Value("${cloudinary.cloud_name}")
    private String cloudName;

    @Value("${cloudinary.blank_url}")
    private String blankUrl;

    private Cloudinary cloudinary = null;

    @PostConstruct
    public void init() {
        Map<String, String> cloudinaryMap = new HashMap<>();
        cloudinaryMap.put("api_key", apiKey);
        cloudinaryMap.put("api_secret", apiSecret);
        cloudinaryMap.put("cloud_name", cloudName);
        cloudinary = new Cloudinary(cloudinaryMap);
    }

    @Override
    public String uploadPhoto(byte[] photoData, String userMail) {
        Map<String, Object> cloudinaryMap = new HashMap<>();
        cloudinaryMap.put(FOLDER, "tamirguru/profile");
        cloudinaryMap.put(PUBLIC_ID, userMail);
        cloudinaryMap.put(OVERWRITE, true);
        cloudinaryMap.put(USE_FILENAME, true);
        try {
            if (photoData != null) {
                Map<String, Object> response = cloudinary.uploader().upload(photoData, cloudinaryMap);
                return response.get("url").toString();
            }
            Map<String, Object> response = cloudinary.uploader().upload(blankUrl, cloudinaryMap);
            return response.get("url").toString();
        } catch (Exception e) {
            log.error("User photo upload error {}", e.getMessage());
            return blankUrl;
        }
    }


}
