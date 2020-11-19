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
public class InvalidMaterialException extends Exception {

    public InvalidMaterialException(String message) {
        super(message);
    }

    public InvalidMaterialException(String message,
            Throwable cause) {
        super(message, cause);
    }

}
