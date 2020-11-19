/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.vendingmachine.service;

import java.io.IOException;

/**
 *
 * @author michaelrodriguez
 */
public class VendingMachinePersistenceException extends Exception {

    public VendingMachinePersistenceException(String message) {
        super("VendingMachine Persistence Exception");
    }

    public VendingMachinePersistenceException(String message, Throwable cause) {
        super(message, cause);
    }

   
}
