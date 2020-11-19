/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.dvdlibrary.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

/**
 *
 * @author michaelrodriguez
 */
public class DvdLibraryAuditDaoFileImpl implements DvdLibraryAuditDao {

    // All finals are all caps, and seperated by _ 
    public static final String AUDIT_FILE = "audit.txt"; 
    
    @Override
    public void writeAuditEntry(String entry) throws DvdLibraryPersistenceException {
    
     PrintWriter out ; 
        try {
            // We want to append , We add a 2nd parameter to
            out = new PrintWriter(new FileWriter(AUDIT_FILE, true));
        } catch (IOException ex) {
            // We want to take this IOException and translate it into a DvdLibraryPersistence Exception
            throw new DvdLibraryPersistenceException("Could not persist audit information", ex);
        }
        //Static factory method, not a constructor. 
        LocalDateTime timeStamp =  LocalDateTime.now(); 
        out.println(timeStamp.toString() + " : " + entry);
        out.flush();
    }
    
}
