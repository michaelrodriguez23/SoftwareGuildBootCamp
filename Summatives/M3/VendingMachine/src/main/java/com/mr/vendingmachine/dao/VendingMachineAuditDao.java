/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.vendingmachine.dao;

import com.mr.vendingmachine.service.VendingMachinePersistenceException;

/**
 *
 * @author michaelrodriguez
 */
public interface VendingMachineAuditDao {

    public void writeAuditEntry(String entry) throws VendingMachinePersistenceException;

}
