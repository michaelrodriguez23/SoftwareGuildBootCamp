/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.classroster.dao;

import com.mr.classroster.dao.ClassRosterDao;
import com.mr.classroster.dao.ClassRosterDaoFileImpl;
import com.mr.classroster.dto.Student;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * ˆ
 *
 * @author michaelrodriguez
 */
public class ClassRosterDaoTest {

    private ClassRosterDao dao = new ClassRosterDaoFileImpl();

    public ClassRosterDaoTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {

    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
        List<Student> studentList = dao.getAllStudents();
        for (Student student : studentList) {
            dao.removeStudent(student.getStudentID());
        }
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }

    /**
     * Test of addStudent method, of class ClassRosterDao.
     */
    @org.junit.jupiter.api.Test
    public void testAddStudent() throws Exception {
        Student student = new Student("001");
        student.setFirstName("Miguel");
        student.setLastName("Jablonka");
        student.setCohort("Java");

        dao.addStudent(student.getStudentID(), student);
        // Since we are passing in the infromation from the dao. 
        // we are using the constructors to then use the student
        // objects to create a new object called fromDao 
        Student fromDao = dao.getStudent(student.getStudentID());
        // Here we are comparing if our student equals the student From the Dao. 
        // Expected result would be student, and then compared to fromDao
        assertEquals(student, fromDao);

//        ARRANGE 
//        System.out.println("addStudent");
//        String studentId = "001";
//        Student student = new Student(studentId);
//        student.setCohort("Java");
//        student.setFirstName("Michael");
//        student.setLastName("Rodriguez");
//
//        ClassRosterDao instance = new ClassRosterDaoFileImpl();
//        Student expResult = new Student(studentId);
//        expResult.setCohort("Java");
//        expResult.setFirstName("Michael");
//        expResult.setLastName("Rodriguez");
//
////        ACT 
//        Student result = instance.addStudent(studentId, student);
//
////        ASSERT
//        assertEquals(expResult, result);
    }

    /**
     * Test of getAllStudents method, of class ClassRosterDao.
     */
    // Here we are testing if the getAllStudents Method
    // is running properly. By creating two student scenerios, and
    // adding them to the List. 
    @org.junit.jupiter.api.Test
    public void testGetAllStudents() throws Exception {
        Student student1 = new Student("001");
        student1.setFirstName("Joe");
        student1.setLastName("Smith");
        student1.setCohort("Python");

        dao.addStudent(student1.getStudentID(), student1);
        Student student2 = new Student("002");
        student1.setFirstName("Patty");
        student1.setLastName("Reef");
        student1.setCohort("Ruby on rails");

        dao.addStudent(student2.getStudentID(), student2);

        // Here we are testing if assertEquals 2 student objects, 
        // then using getAllStudents method then going to its size class
        // to compare to the first parameter
        assertEquals(2, dao.getAllStudents().size());

    }

    /**
     * Test of removeStudent method, of class ClassRosterDao.
     */
    @org.junit.jupiter.api.Test
    // We have copy and pasted the testGetStudent, and updated
    // because we wanted to add students in the test, then after
    // remove a student. 

    public void testRemoveStudent() throws Exception {
        Student student1 = new Student("001");
        student1.setFirstName("Joe");
        student1.setLastName("Smith");
        student1.setCohort("Python");

        //Here is where we added a student info 
        dao.addStudent(student1.getStudentID(), student1);
        Student student2 = new Student("002");
        student1.setFirstName("Patty");
        student1.setLastName("Reef");
        student1.setCohort("Ruby on rails");
        
       // Here is where student 2 was added.  

        dao.addStudent(student2.getStudentID(), student2);
        
        //This is where we removed a student. 
        dao.removeStudent(student1.getStudentID());

        // Here is where we tested after removing a student
        // We are expecting the # of students to be 1. 
        // and expectng if we were trying to retrieve 
        // that same student to equal null. b.c they were 
        // deleted. 
        assertEquals(1, dao.getAllStudents().size());
        assertNull(dao.getStudent(student1.getStudentID()));

        // Rinsed and Repeated with student2 . 
        dao.removeStudent(student2.getStudentID());
        
        // Notice that 0 is in the first parameter, bc
        // we expect to have 0 students now. 
        assertEquals(0, dao.getAllStudents().size());
        assertNull(dao.getStudent(student2.getStudentID()));

    }

}
