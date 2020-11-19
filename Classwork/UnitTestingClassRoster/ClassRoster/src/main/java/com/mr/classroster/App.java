package com.mr.classroster;

import ClassRoster.service.ClassRosterServiceLayer;
import ClassRoster.service.ClassRosterServiceLayerImpl;
import com.mr.classroster.controller.ClassRosterController;
import com.mr.classroster.dao.ClassRosterAuditDao;
import com.mr.classroster.dao.ClassRosterAuditDaoImpl;
import com.mr.classroster.dao.ClassRosterDao;
import com.mr.classroster.dao.ClassRosterDaoFileImpl;
import com.mr.classroster.ui.ClassRosterView;
import com.mr.classroster.ui.UserIO;
import com.mr.classroster.ui.UserIOConsoleImpl;

public class App {

    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl(); //interface using UserIOConsoleImpl
        ClassRosterView myView = new ClassRosterView(myIo);
        ClassRosterDao myDao = new ClassRosterDaoFileImpl(); //interface using ClassRosterDaoFile
        ClassRosterAuditDao myAuditDao = new ClassRosterAuditDaoImpl();
        ClassRosterServiceLayer myService = new ClassRosterServiceLayerImpl(myDao, myAuditDao);
        ClassRosterController myController = new ClassRosterController(myService, myView);
        myController.run();
    }
}
