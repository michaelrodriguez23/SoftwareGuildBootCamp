/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.flooringOrders.daos;

import com.mr.flooringOrders.dto.Order;
import com.mr.flooringOrders.service.PersistenceException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 *
 * @author michaelrodriguez
 */

public class OrderDaoFileProdImpl implements OrderDao {

    // Creating a Map containing LocalDates as a key 
    // and Another map within it as the value
    // The Innermap has an integer as
    // OrderId as the Key
    // & Order Object  as a value.
    private Map<LocalDate, Map<Integer, Order>> orders = new HashMap<>();

    public Map<LocalDate, Map<Integer, Order>> getMasterMap() {
        return orders;
    }

    public static final String DELIMITER = ",";

    LocalDate ld = LocalDate.now();

    private void loadLibrary() throws FileNotFoundException {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddyyyy");

        File file = new File("./data");
        String[] fileList = file.list();

        for (int i = 0; i < fileList.length; i++) {
            Map<Integer, Order> orderList = new HashMap<>();

            String orderFileName = fileList[i];

            String removeSpecialChar = orderFileName.replaceAll("[_.]", "");
            String removeChars = removeSpecialChar.replaceAll("Orders", "");
            String finalDate = removeChars.replaceAll("txt", "");
            LocalDate parsedDate = LocalDate.parse(finalDate, formatter);

            // create a new map to iterate orders to map into an object for each file. 
            Scanner scanner = new Scanner(
                    new BufferedReader(
                            new FileReader("./data/" + orderFileName)));

            String currentLine;
            Order currentOrder;

            // While the Scanner has a next Line
            // initialize then unmarshall that line into an order. 
            // Then put that order in the order List. 
            while (scanner.hasNextLine()) {
                currentLine = scanner.nextLine();
                currentOrder = unmarshall(currentLine);

                orderList.put(currentOrder.getOrderId(), currentOrder);

                // Both OrderList is being loaded above, and below the orders hashmap is Being loaded.
            }

            orders.put(parsedDate, orderList);
            //put the date of the filename here first parameter
            scanner.close();
        }

    }

    public void writeLibrary(LocalDate selectedDate) throws PersistenceException, FileNotFoundException {
        // loadLibrary();

        Map<Integer, Order> orderMap = new HashMap<>();
        if (orders.get(selectedDate) == null) {

            orders.put(ld, orderMap);
        }

        orderMap = orders.get(selectedDate);

        List<Order> orderList = orderMap.values()
                .stream()
                .collect(Collectors.toList());

        String ldToString = selectedDate.format(DateTimeFormatter.ofPattern("MMddyyyy"));
        // orderFileName = Orders_ + localDate
        String orderFileName = "Orders_" + ldToString + ".txt";
        PrintWriter out;
        try {
            // PrintWriter Instantiated : with fileName pointing at the Orders_dateTimetoString.txt.
            out = new PrintWriter(new FileWriter("/Users/michaelrodriguez/Documents/OnlineProjects/Code/SoftwareGuildBootCamp/Summatives/FlooringOrdersMastery/Flooring/data/" + orderFileName));

            String orderAsText;

            for (Order currentOrder : orderList) {
                orderAsText = marshall(currentOrder);
                out.append(orderAsText);
                out.println();
                out.flush();
            }
            out.close();
        } catch (IOException e) {
            throw new PersistenceException("COULD NOT SAVE THE ORDER") {

            };

        }
    }

    private String marshall(Order orderAsObject) {

        // Instantiated orderAsText to be as text
        // gets the objects fields then adds a delimeter to create a line to be read when unmarshalling
        String orderAsText = orderAsObject.getOrderId() + DELIMITER;

        orderAsText += orderAsObject.getCustomerName() + DELIMITER;

        orderAsText += orderAsObject.getState() + DELIMITER;

        orderAsText += orderAsObject.getStateTaxes() + DELIMITER;

        orderAsText += orderAsObject.getProductType() + DELIMITER;

        orderAsText += orderAsObject.getArea() + DELIMITER;

        orderAsText += orderAsObject.getCostPerSqFoot() + DELIMITER;

        orderAsText += orderAsObject.getLaborCostPerSqFoot() + DELIMITER;

        orderAsText += orderAsObject.getMaterialCost() + DELIMITER;

        orderAsText += orderAsObject.getLaborCost() + DELIMITER;

        orderAsText += orderAsObject.getTax() + DELIMITER;

        orderAsText += orderAsObject.getTotal();

        return orderAsText;

    }

    private Order unmarshall(String orderAsString) {

        // unMarshalling is reading the OrderAsText -> orderAsString + then 
        // split by the Delimiter :: 
        // Reading the file then setting the Orders fields based on ordertoken 
        // 0-11 fields on that String array. 
        String[] orderTokens = orderAsString.split(DELIMITER);

        Order orderFromFile = new Order();
        orderFromFile.setOrderId(Integer.parseInt(orderTokens[0]));
        orderFromFile.setCustomerName(orderTokens[1]);
        orderFromFile.setState(orderTokens[2]);
        orderFromFile.setStateTaxes(new BigDecimal(orderTokens[3]));
        orderFromFile.setProductType(orderTokens[4]);
        orderFromFile.setArea(Double.parseDouble(orderTokens[5]));
        orderFromFile.setCostPerSqFoot(new BigDecimal(orderTokens[6]));
        orderFromFile.setLaborCostPerSqFoot(new BigDecimal(orderTokens[7]));
        orderFromFile.setMaterialCost(new BigDecimal(orderTokens[8]));
        orderFromFile.setLaborCost(new BigDecimal(orderTokens[9]));
        orderFromFile.setTax(new BigDecimal(orderTokens[10]));
        orderFromFile.setTotal(new BigDecimal(orderTokens[11]));

        return orderFromFile;

    }

    public int getLastId() throws FileNotFoundException {

        loadLibrary();
        Map<Integer, Order> todaysOrder = orders.get(ld);
        int size = todaysOrder.size();
        Stream<Order> orderStream = todaysOrder.values().stream();
        Order lastOrder = orderStream.skip(size - 1).findFirst().get();
        int lastId = lastOrder.getOrderId() + 1;
        return lastId;
    }

    @Override
    public Order create(Order order) throws IOException, PersistenceException {
        LocalDate ld = LocalDate.now();
        Order createdOrder = new Order();

        if (orders.get(ld) == null) {
            loadLibrary();

        }

        Map<Integer, Order> nestedMap = orders.get(ld);

        if (nestedMap == null || orders.size() == 0) {
            orders.put(ld, new HashMap<>());
            int id = 1;

            createdOrder.setOrderId(id);

        } else {
            int id = getLastId();
            createdOrder.setOrderId(id);

        }

        createdOrder.setCustomerName(order.getCustomerName());
        createdOrder.setState(order.getState());
        createdOrder.setStateTaxes(order.getStateTaxes());
        createdOrder.setProductType(order.getProductType());
        createdOrder.setArea(order.getArea());
        createdOrder.setCostPerSqFoot(order.getCostPerSqFoot());
        createdOrder.setLaborCostPerSqFoot(order.getLaborCostPerSqFoot());
        createdOrder.setMaterialCost(order.getMaterialCost());
        createdOrder.setLaborCost(order.getLaborCost());
        createdOrder.setTax(order.getTax());
        createdOrder.setTotal(order.getTotal());

        orders.get(ld).put(createdOrder.getOrderId(), createdOrder);
        return createdOrder;
    }

    @Override
    public List<Order> readAll(LocalDate selectedDate) throws FileNotFoundException {
        // Loading the files -> Which iterates through the folder of files. 
        // Unmarshalls -> Adds them to orderList. To be retrievable via orderId 
        loadLibrary();

        Map<Integer, Order> localOrders;
        localOrders = orders.get(selectedDate);

        List<Order> localOrderObjects = null;

        if (localOrders != null) {
            localOrderObjects = new ArrayList<>(localOrders.values());
        }
        // if I dont have a date this is set to null we can send this back for the exception to be called . 
        return localOrderObjects;
    }

    @Override
    public Order readById(LocalDate selectedDate, Integer orderId) throws FileNotFoundException {
        Map<Integer, Order> orderList = new HashMap<Integer, Order>();

        loadLibrary();

        if (orders.containsKey(selectedDate)) {
            orderList = orders.get(selectedDate);
         

        } if(orderList.get(orderId)==null) {
           
            System.out.println("NO such order exist");

        }
    

        return orderList.get(orderId);
    }

    @Override
    public Order update(LocalDate selectedDate, Integer orderId, Order editedOrder) throws FileNotFoundException {

//        Map<Integer, Order> orderList = new HashMap<Integer, Order>();
//
//        if (orders.containsKey(selectedDate)) {
//            orderList = orders.get(selectedDate);
//            if (orderList.containsKey(orderId)) {
//                orderList.remove(orderId);
//                Stream ordersStream = orderList.values().stream();
//
//                orderList.put(orderId, editedOrder);
//                orderList.remove(ordersStream.skip(orderList.size() - 1).findFirst());
//                this.orders.put(selectedDate, orderList);
//
//            }
//        }

        return editedOrder;

    }

    @Override
    public void delete(LocalDate selectedDate, Order order) throws FileNotFoundException {
        Map<Integer, Order> orderList = new HashMap<Integer, Order>();
        loadLibrary();

        if (orders.containsKey(selectedDate)) {
            orderList = orders.get(selectedDate);
            if (orderList.containsKey(order.getOrderId())) {
                orderList.remove(order.getOrderId());
                this.orders.put(selectedDate, orderList);
                try {
                    saveOrder(selectedDate);
                } catch (PersistenceException ex) {
                    ex.getLocalizedMessage();
                } catch (IOException ex) {
                    ex.getLocalizedMessage();
                }

            }
        }
    }

    public void saveOrder(LocalDate selectedDate) throws PersistenceException, IOException {

        writeLibrary(selectedDate);

    }

}
