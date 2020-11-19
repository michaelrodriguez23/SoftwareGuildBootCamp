/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.vendingmachine.app;

import com.mr.vendingmachine.controller.VendingMachineController;
import com.mr.vendingmachine.service.InsufficientFundException;
import com.mr.vendingmachine.service.ItemNotFoundException;
import com.mr.vendingmachine.service.ItemOutOfStockException;
import com.mr.vendingmachine.service.VendingMachinePersistenceException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.annotation.Order;

public class App {

    public static void main(String[] args) throws VendingMachinePersistenceException, ItemNotFoundException, ItemOutOfStockException, InsufficientFundException {
        
  
   
//
//        UserIo myIo = new UserIoConsoleImpl();
//        VendingMachineView myView = new VendingMachineView(myIo);
//        VendingMachineDao myDao = new VendingMachineDaoFileImpl();
//        VendingMachineAuditDao myAuditDao = new VendingMachineAuditDaoFileImpl();
//        VendingMachineServiceLayer myService = new VendingMachineServiceLayerImpl(myDao, myAuditDao);
//        VendingMachineController controller = new VendingMachineController(myService, myView);
//        controller.run();

//        This is creating a ApplicationContext object that is linked to the XML AppContext File in the parameter
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        // We are using the controller to search the the XML -> CTX -> to retrieve a defined
        // bean by its reference "controller" , the 2nd parameter is the type of bean we want to retrieve
        // This getBean has two parameters, which the container can cast it to the correct type for us
        // the other version of getBean has 1 parameter : the id of the object
        // and returns an object reference, then we have to explicitly cast object to the correct type manually.
        VendingMachineController controller = ctx.getBean("controller", VendingMachineController.class);
        
        
        controller.run();
        

    }

}
