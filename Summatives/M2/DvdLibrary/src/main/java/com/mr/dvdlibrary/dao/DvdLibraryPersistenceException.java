/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.dvdlibrary.dao;

/**
 *
 * @author michaelrodriguez
 */
public class DvdLibraryPersistenceException extends Exception {
    
    public DvdLibraryPersistenceException(String message) {
        super(message);
    }
    
    public DvdLibraryPersistenceException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
