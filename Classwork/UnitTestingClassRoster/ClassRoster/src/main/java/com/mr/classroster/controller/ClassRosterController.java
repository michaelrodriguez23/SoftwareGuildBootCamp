package com.mr.classroster.controller;

import ClassRoster.service.ClassRosterDataValidationException;
import ClassRoster.service.ClassRosterDuplicateIdException;
import ClassRoster.service.ClassRosterServiceLayer;
import com.mr.classroster.dao.ClassRosterPersistenceException;
import com.mr.classroster.dto.Student;
import com.mr.classroster.ui.ClassRosterView;

public class ClassRosterController {

    ClassRosterView view;

    private ClassRosterServiceLayer service;

    public ClassRosterController(ClassRosterServiceLayer service, ClassRosterView view) {
        this.service = service;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while (keepGoing) {
                menuSelection = getMenuSelection();
                switch (menuSelection) {
                    case 1:
                        allStudent();
                        break;
                    case 2:
                        createStudent();
                        break;
                    case 3:
                        viewStudent();
                        break;
                    case 4:
                        removeStudent();
                        break;
                    case 5:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
            }
            exitMessage();
        } catch (ClassRosterPersistenceException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void createStudent() throws ClassRosterPersistenceException {
        view.displayCreateStudentBanner();
        boolean hasErrors = false;
        do {
            Student currentStudent = view.getNewStudentInfo();
            try {
                service.createStudent(currentStudent);
                view.displayCreateSuccessBanner();
                hasErrors = false;
            } catch (ClassRosterDuplicateIdException | ClassRosterDataValidationException e) {
                hasErrors = true;
                view.displayErrorMessage(e.getMessage());
            }
        } while (hasErrors);
    }

    private void allStudent() throws ClassRosterPersistenceException {
        view.displayAllBanner();
        view.displayStudentList(service.getAllStudents());
    }

    private void viewStudent() throws ClassRosterPersistenceException {
        view.displayGetStudentBanner();
        String studentId = view.getStudent();
        Student student = service.getStudent(studentId);
        view.displayStudent(student);
    }

    private void removeStudent() throws ClassRosterPersistenceException {
        view.displayRemoveStudentBanner();
        String studentId = view.getStudent();
        Student student = service.removeStudent(studentId);
        view.displayRemoveSuccessBanner();
    }

    private void unknownCommand() {
        view.displayUnknownCommand();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
}
