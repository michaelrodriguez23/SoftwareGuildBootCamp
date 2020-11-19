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
public class VendingMachineAuditDaoStubImpl implements VendingMachineAuditDao {

    @Override
    public void writeAuditEntry(String entry) throws VendingMachinePersistenceException {
        // DO NOTHING...
        // We dont care, we just want to simulate call to the Audit Log
        // But not do anything
    }
    
}
