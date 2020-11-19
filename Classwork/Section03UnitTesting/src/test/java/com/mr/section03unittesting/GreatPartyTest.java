/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.section03unittesting;

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

    GreatParty party = new GreatParty();

    public GreatPartyTest() {
    }

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
    // Here we are testing one of the possible input/output configs
    // test30False and we are assertigFalse. Inside the parameters
    // are the number of cigars, and boolean isWeekend. 
    // We expect false to comeback . This will verify if false is returned. 
    // If false doesn't come back, our test has failed. 
    @Test
    public void test30False() {
        assertFalse(party.greatParty(30, false));
    }

    @Test
    public void test50False() {
        assertTrue(party.greatParty(50, false));
    }

    @Test
    public void test70True() {
        assertTrue(party.greatParty(70, true));
    }

    @Test
    public void test39False() {
        assertFalse(party.greatParty(39, false));
    }

    @Test
    public void test39True() {
        assertFalse(party.greatParty(39, false));
    }

    @Test
    public void test40False() {
        assertTrue(party.greatParty(40, false));
    }

    @Test
    public void test40True() {
        assertTrue(party.greatParty(40, true));
    }

    @Test
    public void test60False() {
        assertTrue(party.greatParty(60, false));
    }

    @Test
    public void test60True() {
        assertTrue(party.greatParty(40, true));
    }

    @Test
    public void test61False() {
        assertFalse(party.greatParty(61, false));
    }

    @Test
    public void test61True() {
        assertTrue(party.greatParty(61, true));
    }
}
