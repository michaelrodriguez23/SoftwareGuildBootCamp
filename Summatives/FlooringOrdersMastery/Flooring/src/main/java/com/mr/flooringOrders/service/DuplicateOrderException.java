/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.flooringOrders.service;

/**
 *
 * @author michaelrodriguez
 */
public class DuplicateOrderException extends Exception {

    public DuplicateOrderException(String message) {
        super(message);
    }

    public DuplicateOrderException(String message,
            Throwable cause) {
        super(message, cause);
    }
}
