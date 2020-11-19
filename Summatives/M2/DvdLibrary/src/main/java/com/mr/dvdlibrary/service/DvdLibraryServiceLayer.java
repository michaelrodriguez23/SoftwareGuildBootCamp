/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.dvdlibrary.service;

import com.mr.dvdlibrary.dao.DvdLibraryPersistenceException;
import com.mr.dvdlibrary.dto.Dvd;
import java.util.List;

/**
 *
 * @author michaelrodriguez
 */
public interface DvdLibraryServiceLayer {
    
   void createDvd(Dvd dvd) throws
            DvdLibraryDuplicateIdException,
            DvdLibraryDataValidationException,
            DvdLibraryPersistenceException;
 
    List<Dvd> getAllDvds() throws
            DvdLibraryPersistenceException;
 
    Dvd getDvd(String title) throws
            DvdLibraryPersistenceException;
 
    Dvd removeDvd(String title) throws
            DvdLibraryPersistenceException;
    Dvd editDvd(String title, Dvd dvd) throws
            DvdLibraryPersistenceException;
 
    
    
}
