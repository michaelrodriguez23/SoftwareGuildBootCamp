/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.section03unittest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author michaelrodriguez
 */
public class GreatPartyTest {
    
    public GreatPartyTest() {
        GreatParty party = new GreatParty();
    }
    // Junit FrameWork is Instantiating these classes. 
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of greatParty method, of class GreatParty.
     */
    @Test
    public void testGreatParty() {
        fail("The test case is a prototype.");
    }
    
}
