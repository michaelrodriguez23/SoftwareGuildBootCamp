/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.classroster.service;

import ClassRoster.service.ClassRosterDataValidationException;
import ClassRoster.service.ClassRosterDuplicateIdException;
import ClassRoster.service.ClassRosterServiceLayer;
import com.mr.classroster.dao.ClassRosterPersistenceException;
import com.mr.classroster.dto.Student;
import java.util.List;
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
public class ClassRosterServiceLayerTest {
    
    public ClassRosterServiceLayerTest() {
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
     * Test of createStudent method, of class ClassRosterServiceLayer.
     */
    @Test
    public void testCreateStudent() throws Exception {
    }

    /**
     * Test of getAllStudents method, of class ClassRosterServiceLayer.
     */
    @Test
    public void testGetAllStudents() throws Exception {
    }

    /**
     * Test of getStudent method, of class ClassRosterServiceLayer.
     */
    @Test
    public void testGetStudent() throws Exception {
    }

    /**
     * Test of removeStudent method, of class ClassRosterServiceLayer.
     */
    @Test
    public void testRemoveStudent() throws Exception {
    }

    public class ClassRosterServiceLayerImpl implements ClassRosterServiceLayer {

        public void createStudent(Student student) throws ClassRosterDuplicateIdException, ClassRosterDataValidationException, ClassRosterPersistenceException {
        }

        public List<Student> getAllStudents() throws ClassRosterPersistenceException {
            return null;
        }

        public Student getStudent(String studentId) throws ClassRosterPersistenceException {
            return null;
        }

        public Student removeStudent(String studentId) throws ClassRosterPersistenceException {
            return null;
        }
    }
    
}
