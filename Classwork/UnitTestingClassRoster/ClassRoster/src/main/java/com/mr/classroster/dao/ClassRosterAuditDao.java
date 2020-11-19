/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.classroster.dao;

/**
 *
 * @author michaelrodriguez
 */
public interface ClassRosterAuditDao  {
    void writeAuditEntry(String entry) throws ClassRosterPersistenceException; 
    
}
