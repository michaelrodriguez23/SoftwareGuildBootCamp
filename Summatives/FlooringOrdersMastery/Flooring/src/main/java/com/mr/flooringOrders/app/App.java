/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.flooringOrders.app;
import com.mr.flooringOrders.controllers.FlooringController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author michaelrodriguez
 */
public class App {

    public static void main(String[] args) throws Exception {
//        UserIo myIo = new UserIoConsoleImpl();
//        FlooringOrdersView myView = new FlooringOrdersView(myIo);
//        OrderDao myOrderDao = new OrderDaoFileProdImpl();
//        ProductDao myProductDao = new ProductDaoFileImpl();
//        StateTaxDao myStateTaxDao = new StateTaxDaoFileImpl();
//        FlooringOrderService myService = new FlooringOrderServiceImpl(myOrderDao, myProductDao, myStateTaxDao);
//        FlooringController controller = new FlooringController(myService, myView);
//        controller.run();
//        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
         FlooringController controller = ctx.getBean("controller", FlooringController.class);
        
        
        controller.run();
    }

}
