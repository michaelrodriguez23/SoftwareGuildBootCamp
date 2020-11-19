/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.bullsandcows.service;

import java.time.ZonedDateTime;
import org.springframework.http.HttpStatus;

/**
 *
 * @author michaelrodriguez
 */
public class InvalidGameException extends Exception {
 
    private final String message; 
    private final HttpStatus httpStatus ; 
    private final ZonedDateTime timeStamp; 

    public InvalidGameException(String message, HttpStatus httpStatus, ZonedDateTime timeStamp) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.timeStamp = timeStamp;
    }

    public InvalidGameException() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public ZonedDateTime getTimeStamp() {
        return timeStamp;
    }
}
   