/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.flooringOrders.daos;

import com.mr.flooringOrders.dto.StateTax;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class StateTaxDaoFileImpl implements StateTaxDao {

    private Map<StateTax, BigDecimal> stateTaxes = new HashMap<StateTax, BigDecimal>();
    String STATEFILENAME = "productInventory.txt";
    public static final String DELIMITER = ",";

    @Override
    public List<StateTax> readAll() {
        try {
            loadLibrary();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(StateTaxDaoFileImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<StateTax> stateList =  new ArrayList<StateTax>();
        for (StateTax s : stateList ){ 
           
                
                
       
        } return stateList;
    }

    @Override
    public StateTax readStateTax(String stateId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void loadLibrary() throws FileNotFoundException {
        Map<StateTax, BigDecimal> stateTaxes = new HashMap<>();
        Scanner scanner;

        scanner = new Scanner(new BufferedReader(new FileReader(STATEFILENAME)));
        String currentLine;
        StateTax currentState;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentState = unmarshall(currentLine);

           stateTaxes.put(currentState, currentState.getTaxRate());
        }
        scanner.close();
    }

    private StateTax unmarshall(String STATEFILENAME) {
        String[] orderTokens = STATEFILENAME.split(DELIMITER);

        StateTax stateFromFile = new StateTax();

        stateFromFile.setState(orderTokens[0]);
        stateFromFile.setTaxRate(new BigDecimal(orderTokens[1]));
        
        return stateFromFile; 

    }

}


