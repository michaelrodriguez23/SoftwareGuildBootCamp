/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.flooringOrders.daos;

import com.mr.flooringOrders.dto.Product;
import java.util.List;


public class ProductDaoFileImpl implements ProductDao {
    
     public static final String PRODUCT_INVENTORY_FILE = "productLibrary.txt";

    @Override
    public List<ProductDao> readAll() {
             throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.


    }
    @Override
    public Product readByProduct(String productName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void loadProductLibrary() { 
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }
    
}
