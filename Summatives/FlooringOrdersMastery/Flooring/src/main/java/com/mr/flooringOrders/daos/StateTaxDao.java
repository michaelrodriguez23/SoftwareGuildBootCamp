/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.flooringOrders.daos;

import com.mr.flooringOrders.dto.StateTax;
import java.util.List;

/**
 *
 * @author michaelrodriguez
 */
public interface StateTaxDao {

    public List<StateTax> readAll();

    public StateTax readStateTax(String stateId);

}
