package com.mr.dvdlibrary.controller;

import com.mr.dvdlibrary.dao.DvdLibraryPersistenceException;
import com.mr.dvdlibrary.dto.Dvd;
import com.mr.dvdlibrary.ui.DvdPlayerView;
import com.mr.dvdlibrary.ui.UserIO;
import com.mr.dvdlibrary.ui.UserIOConsoleImpl;
import java.util.List;
import com.mr.dvdlibrary.service.DvdLibraryDataValidationException;
import com.mr.dvdlibrary.service.DvdLibraryDuplicateIdException;
import com.mr.dvdlibrary.service.DvdLibraryServiceLayer;

/**
 *
 * @author michaelrodriguez
 */
public class DvdLibraryController {

    private DvdLibraryServiceLayer service;
    private DvdPlayerView view;

    public DvdLibraryController(DvdLibraryServiceLayer service, DvdPlayerView view) {
        this.service = service;
        this.view = view;
    }

    private UserIO io = new UserIOConsoleImpl();

    public void run() throws DvdLibraryDuplicateIdException, DvdLibraryDataValidationException {

        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while (keepGoing) {
                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        listDvds();
                        break;
                    case 2:
                        createDvd();
                        break;
                    case 3:
                        viewDvd();
                        break;
                    case 4:
                        removeDvd();
                        break;
                    case 5:
                        editDvd();
                        break;
                    case 6:
                        viewDvdByDirector();
                        break;

                    case 7:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }

            }
            exitMessage();
        } catch (DvdLibraryPersistenceException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void createDvd() throws DvdLibraryPersistenceException, DvdLibraryDuplicateIdException, DvdLibraryDataValidationException {
        view.displayCreateDVDBanner();
        boolean hasErrors = false;
        do {
            Dvd newDvd = view.getNewDvdInfo();
            try {
                service.createDvd(newDvd);
                view.displayCreateSuccessBanner();
                hasErrors = false;
                // The catch block demonstrates the syntax for handling more than one type
                // of exception in a single catch block. I had to make sure that the method above has all three exceptions thrown 
            } catch (DvdLibraryDuplicateIdException | DvdLibraryDataValidationException e) {
                hasErrors = true;
                view.displayErrorMessage(e.getMessage());
            }
        } while (hasErrors);
    }

    private void listDvds() throws DvdLibraryPersistenceException {
        view.displayDisplayAllBanner();
        List<Dvd> dvdList = service.getAllDvds();
        view.displayDvdList(dvdList);

    }

    private void viewDvd() throws DvdLibraryPersistenceException {
        view.displayDisplayDvdBanner();
        String dvdTitle = view.getDvdByTitle();
        Dvd dvd = service.getDvd(dvdTitle);
        view.displayDvd(dvd);
    }

    private void removeDvd() throws DvdLibraryPersistenceException {
        view.displayRemoveDvdBanner();
        String dvdTitle = view.getDvdByTitle();
        service.removeDvd(dvdTitle);
        view.displayRemoveSuccessBanner();

    }

    private void viewDvdByDirector() throws DvdLibraryPersistenceException {
        view.displayFindBanner();
        String director = view.getByDirector();
        Dvd dvdInfo = view.getNewDvdInfo();
        view.displayDirector(director);
        view.displayDvd(dvdInfo);

    }

    private void editDvd() throws DvdLibraryPersistenceException, DvdLibraryDuplicateIdException, DvdLibraryDataValidationException {
        view.displayEditDvdbanner();
        String dvdTitle = view.getDvdByTitle();
        Dvd dvd = service.getDvd(dvdTitle);
        service.editDvd(dvdTitle, dvd);

        boolean keepGoing = true;
        int editSelection = 0;

        while (keepGoing) {
            editSelection = view.printConfirmationAndGetSelection(dvd);

            switch (editSelection) {
                case 1:
                    service.removeDvd(dvdTitle);
                    view.displayEditDvdSlotWiped();
                    Dvd newDvd = view.getNewDvdInfo();
                    service.createDvd(newDvd);
                    view.displayEditSuccessBanner();
                    keepGoing = (false);
                    break;
                case 2:
                    editDvd();
                    keepGoing = (false);
                    break;
                default:
                    unknownCommand();
                    break;

            }

        }
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }

}
