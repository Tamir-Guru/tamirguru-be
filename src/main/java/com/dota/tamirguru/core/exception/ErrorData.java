/*
 * @author : Oguz Kahraman
 * @since : 10.12.2020
 *
 * Copyright - analytics
 **/
package com.dota.tamirguru.core.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ErrorData {

    private String timestamp;
    private int status;
    private String error;
    private String message;
    private String path;

}