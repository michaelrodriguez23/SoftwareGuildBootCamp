/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.flooringOrders.daos;

import com.mr.flooringOrders.dto.Product;
import java.util.List;

/**
 *
 * @author michaelrodriguez
 */
public interface ProductDao {

    public List<ProductDao> readAll();

    public Product readByProduct(String productName);

}
