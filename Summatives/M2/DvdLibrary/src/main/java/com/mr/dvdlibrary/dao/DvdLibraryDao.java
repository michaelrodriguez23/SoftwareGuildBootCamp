/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.dvdlibrary.dao;

import com.mr.dvdlibrary.dto.Dvd;
import java.util.List;

/**
 *
 * @author michaelrodriguez
 */
public interface DvdLibraryDao {

    /**
     * Adds the given Student to the roster and associates it with the given
     * student id.If there is already a student associated with the given
 student id it will return that student object, otherwise it will return
 null.
     *
     * @param title
     * @param dvd
     * @param Title which the Dvd is associated with.
     * @param Dvd dvd will be added to the List.
     * @return the Dvd object previously associated with the given title if it
     * exists, null otherwise
     */
    Dvd addDvd(String title, Dvd dvd) throws DvdLibraryPersistenceException;

    /**
     * Returns a String array containing the student ids of all students in the
     * roster.
     *
     * @return String array containing the ids of all the students in the roster
     */
    List<Dvd> getAllDvds() throws DvdLibraryPersistenceException;

    /**
     * Returns the student object associated with the given student id.Returns
 null if no such student exists
     *
     * @return the Dvd object associated with the given title, null if no such
     * student exists
     */
    Dvd getDvd(String title) throws DvdLibraryPersistenceException;

    /**
     * Removes from the roster the student associated with the given id. Returns
     * the student object that is being removed or null if there is no student
     * associated with the given id
     *
     * @param Dvd title of sDvd object to be removed from list.
     * @return Dvd object that was removed or null if no Dvd object was
     * associated with the given title
     */
    Dvd removeDvd(String title) throws DvdLibraryPersistenceException;

    // These are the additional requirements for M2. 
    // * DONT FORGET ABOUT THESE, SINCE THEY ARE NOT IN 
    //    THE CODE ALONG*
    
    /**
     * 
     * @param Passing in the title to editDvd 
     * @return The DVD object associated the title.
     */
    Dvd editDvd(String title, Dvd dvd)throws DvdLibraryPersistenceException;
/**
 * 
     * @param dvd
 * @param passing in the title of the DVD object. 
 * @return The DVD associated with the DVD's title.
     * @throws com.mr.dvdlibrary.dao.DvdLibraryPersistenceException 
 */
    Dvd findByDirector(Dvd dvd)throws DvdLibraryPersistenceException;
    
}
