/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.dvdlibrary.service;

import com.mr.dvdlibrary.dao.DvdLibraryAuditDao;
import com.mr.dvdlibrary.dao.DvdLibraryDao;
import com.mr.dvdlibrary.dao.DvdLibraryPersistenceException;
import com.mr.dvdlibrary.dto.Dvd;
import java.util.List;

/**
 *
 * @author michaelrodriguez
 */
public class DvdLibraryServiceLayerImpl implements DvdLibraryServiceLayer {
    

    // Since We already created a shell of our Service Layer implementation we
    // can start adding some functionality. 
    // The Service Layer needs to use the Dao for Student object Crud Operations.
    // The DvdLibraryDao was added to our Service Layer impl
    // It was initialized throught the S.Layer implementation constructor.
    private DvdLibraryDao dao;
    private DvdLibraryAuditDao auditDao;

    public DvdLibraryServiceLayerImpl(DvdLibraryDao dao, DvdLibraryAuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao; 
        
        
    }

    @Override
    public void createDvd(Dvd dvd) throws DvdLibraryDuplicateIdException, DvdLibraryDataValidationException, DvdLibraryPersistenceException {
        // First We need to check to see if theres already a Dvd
        // Associated with the given Dvd Title
        // If So, We are all done
        // throw DvdLibraryDuplicateIdException 

        if (dao.getDvd(dvd.getTitle()) != null) {
            throw new DvdLibraryDuplicateIdException(
                    "ERROR: Could not create Dvd. Dvd title" + dvd.getTitle() + " already exist");

        }
        // Now Validate all the fields on the given Dvd object / 
        // This ethod will throw an exeption if any of the validation rules are violated. 

        validateDvdData(dvd);

        //We passed all our business rules checks so go ahead
        // and persist the Dvd Object. 
        dao.addDvd(dvd.getTitle(), dvd);
        auditDao.writeAuditEntry("Dvd " + dvd.getTitle() + " CREATED");
        

    }
// This method is straightforward b.c its a pass through method
// We simply turn around and call getAllDvds method on the Dao 
    // and return the results. 

    @Override
    public List<Dvd> getAllDvds() throws DvdLibraryPersistenceException {
        return dao.getAllDvds();
    }
// This is another pass through method. 
// We simply call the getDvd method on the Dao and return results

    @Override
    public Dvd getDvd(String title) throws DvdLibraryPersistenceException {
        return dao.getDvd(title);
    }
    
// This is a pass- through method as well
// We have to write to the audit log. Before we return the removedDvd. 
    @Override
    public Dvd removeDvd(String title) throws DvdLibraryPersistenceException {
        Dvd removedDvd = dao.removeDvd(title); 
        auditDao.writeAuditEntry("Dvd " + title + "REMOVED");
        return removedDvd; 
    }
    @Override
   public Dvd editDvd(String title, Dvd dvd) throws DvdLibraryPersistenceException { 
       return dao.editDvd(title, dvd); 
   }
   
//
//      @Override
//    public Dvd editDvd(String title, Dvd dvd) throws DvdLibraryPersistenceException {
//       loadLibrary();
//       Dvds.remove(title);
//       Dvd editDvd = Dvds.put(title, dvd);
//       writeLibrary();
//       return editDvd; 
//    }
    // We need to enforce in the service layer
    // that every student in the system must have values for 
    // first,last name + cohort. If empty, the student object should 
    // not be persisted. 
    // If the student object fails validation, the method will 
    // throw a ClassRosterDataValidationException. 
    private void validateDvdData(Dvd dvd) throws DvdLibraryDataValidationException {
        //  **** Here we are checking if each field in the Dvd Object it not Null, 
        // and or no white space on some of the fields.
        if (dvd.getTitle() == null
                || dvd.getTitle().trim().length() == 0
                || dvd.getDirectorsName() == null
                || dvd.getMpaaRating() == null
                || dvd.getMpaaRating().trim().length() == 0
                || dvd.getStudio() == null
                || dvd.getReleaseDate() == null
                || dvd.getReleaseDate().trim().length() == 0
                || dvd.getUserCustomNote() == null) {
            throw new DvdLibraryDataValidationException("Error: All fields [Dvd Title, Directors Name, Mpaa Rating, Studio, Release Data, Custom Note ] are required ");
        }
    }
}
       

