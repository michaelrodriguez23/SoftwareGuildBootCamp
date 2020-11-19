/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.vendingmachine.dao;

import com.mr.vendingmachine.dto.Item;
import com.mr.vendingmachine.service.VendingMachinePersistenceException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author michaelrodriguez
 */
public class VendingMachineDaoFileImpl implements VendingMachineDao {

    private Map<String, Item> items = new HashMap<String, Item>();
    public static final String ITEM_INVENTORY_FILE = "itemInventory.txt";
    public static final String DELIMITER = "::";

    @Override
    public Item getItem(String id) throws VendingMachinePersistenceException {
        loadLibrary();
        return items.get(id);
    }

    @Override
    public Item editItem(String id, Item item) throws VendingMachinePersistenceException {
        loadLibrary();
        Item editItem = items.put(id, item);
        writeLibrary();
        return editItem;
    }

    @Override
    public List<Item> getAllItems() throws VendingMachinePersistenceException {
        loadLibrary();
        return items.values()
                .stream()
                .collect(Collectors.toList());
    }

    ; 
        
    

    private String marshallItem(Item anItem) {

        String itemAsText = anItem.getId() + DELIMITER;

        itemAsText += anItem.getName() + DELIMITER;

        itemAsText += anItem.getCost() + DELIMITER;

        itemAsText += anItem.getQty();

        return itemAsText;

    }

    private Item unmarshallItem(String itemsAsText) {

        String[] itemTokens = itemsAsText.split(DELIMITER);

        String id = itemTokens[0];

        Item itemFromFile = new Item(id);

        itemFromFile.setName(itemTokens[1]);
        BigDecimal cost = new BigDecimal(itemTokens[2]);
        itemFromFile.setCost(cost);

        itemFromFile.setQty(Integer.parseInt(itemTokens[3]));

        return itemFromFile;

    }

    private void writeLibrary() throws VendingMachinePersistenceException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(ITEM_INVENTORY_FILE));
        } catch (IOException e) {
            throw new VendingMachinePersistenceException(
                    "Could not save item Information .", e);
        }

        String itemAsText;
        List<Item> itemList = this.getAllItems();
        for (Item currentItem : itemList) {
            itemAsText = marshallItem(currentItem);
            out.println(itemAsText);
            out.flush();

        }

    }

    private void loadLibrary() throws VendingMachinePersistenceException {
        Scanner scanner;

        try {

            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(ITEM_INVENTORY_FILE)));
        } catch (FileNotFoundException e) {
            throw new VendingMachinePersistenceException(
                    "-_____- Could not load Item collection data into memory.", e);
        }

        String currentLine;
        Item currentItem;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentItem = unmarshallItem(currentLine);
            items.put(currentItem.getId(), currentItem);
        }
        scanner.close();
    }

}
