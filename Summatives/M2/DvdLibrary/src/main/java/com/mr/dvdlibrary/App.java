/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.dvdlibrary;

import com.mr.dvdlibrary.controller.DvdLibraryController;
import com.mr.dvdlibrary.dao.DvdLibraryAuditDao;
import com.mr.dvdlibrary.dao.DvdLibraryAuditDaoFileImpl;
import com.mr.dvdlibrary.dao.DvdLibraryDaoFileImpl;
import com.mr.dvdlibrary.ui.DvdPlayerView;
import com.mr.dvdlibrary.ui.UserIO;
import com.mr.dvdlibrary.ui.UserIOConsoleImpl;
import com.mr.dvdlibrary.dao.DvdLibraryDao;
import com.mr.dvdlibrary.service.DvdLibraryDataValidationException;
import com.mr.dvdlibrary.service.DvdLibraryDuplicateIdException;
import com.mr.dvdlibrary.service.DvdLibraryServiceLayer;
import com.mr.dvdlibrary.service.DvdLibraryServiceLayerImpl;


/**
 *
 * @author michaelrodriguez
 */
public class App {

    public static void main(String[] args) throws DvdLibraryDuplicateIdException, DvdLibraryDataValidationException {
        UserIO myIo = new UserIOConsoleImpl();
        DvdPlayerView myView = new DvdPlayerView(myIo);
        DvdLibraryDao myDao = new DvdLibraryDaoFileImpl();
        DvdLibraryAuditDao myAuditDao = new DvdLibraryAuditDaoFileImpl();
        DvdLibraryServiceLayer myService = new DvdLibraryServiceLayerImpl(myDao, myAuditDao); 
        DvdLibraryController controller = new DvdLibraryController(myService, myView);
        controller.run();
    }

} 

