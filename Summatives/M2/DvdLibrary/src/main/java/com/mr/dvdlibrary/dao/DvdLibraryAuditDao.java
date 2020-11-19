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
public interface DvdLibraryAuditDao {
// AuditDao Allows us to write an audit entry

public void writeAuditEntry(String entry) throws DvdLibraryPersistenceException;
   
    
}
