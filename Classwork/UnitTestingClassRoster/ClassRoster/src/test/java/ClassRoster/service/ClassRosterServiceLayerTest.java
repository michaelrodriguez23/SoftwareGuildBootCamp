/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassRoster.service;

import com.mr.classroster.dao.ClassRosterAuditDao;
import com.mr.classroster.dao.ClassRosterAuditDaoStubImpl;
import com.mr.classroster.dao.ClassRosterDao;
import com.mr.classroster.dao.ClassRosterDaoStubImpl;
import com.mr.classroster.dto.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 *
 * @author michaelrodriguez
 */

// We are creating 6 different test. 
//DAO's & Service Layer. 
// 1. Testing the (happy path) , testing everything working fine.
// 2. Testing Duplicate ID exception
// 3. Testing Validation Data error.
// 4. Testing Getting Student
// 5. Testing Getting All Students. 
// 6. Testing Removing Student. 

public class ClassRosterServiceLayerTest {

    private ClassRosterServiceLayer service;
      Calculator calculator = new Calculator();
    
    

    public ClassRosterServiceLayerTest() {
        ClassRosterDao dao = new ClassRosterDaoStubImpl();
        ClassRosterAuditDao auditDao = new ClassRosterAuditDaoStubImpl();

        service = new ClassRosterServiceLayerImpl(dao, auditDao);
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
    // So this test is a little different
    // Since we are testing the business rules
    // Our assertions to see if the test passes. 
    // If our methods dont throw an exception Junit Considers the test to pass . 
    @Test
    public void testCreateStudent() throws Exception {
        Student student = new Student("002");
        student.setFirstName("Sally");
        student.setLastName("Smith");
        student.setCohort("Ruby");
        service.createStudent(student);
    }

    @Test
    public void testCreateStudentDuplicateId() throws Exception {
        Student student = new Student("001");
        student.setFirstName("John");
        student.setLastName("Doe");
        student.setCohort("java");

        // We want to see if this test passes. If we have
        // a duplicate ID. For our test to pass, we expect
        // our test to throw an exception 
        // If the test does not throw the duplicateIdException
        // the test failed. 
        try {
            service.createStudent(student);
            
            // Fail is a method that allows you to print a message. 
            // this is part of JUnit Api library. 
            fail("Expected ClassRosterDuplicateIdException was not thrown");
        } catch (ClassRosterDuplicateIdException e) {
            // This is sort of just annotation that everything worked. 
            // the return key is not neccassary but it helps understand the flow.
            // Showing that the test passed, and the catch caught the exception. 
            return; 
        }
    }
    // Here we are creating our 2nd test method . 
    
     
    @Test 
    public void testCreateStudentInvalidData() throws Exception {
        // We are changing the student Id to 002 again, Because we dont 
        // want to test a duplicate ID, but instead a blank invalid input. 
        Student student = new Student("002");
        student.setFirstName("");
        student.setLastName("Doe");
        student.setCohort("java");
        
        // We are testing to see if the is any Validation Errors when 
        // creating a student. 
        
        
        try { 
            service.createStudent(student);
            fail("Expected ClassRosterDataValidationException was not thrown. "); 
            
        } catch (ClassRosterDataValidationException e) { 
            return; 
        }
    }

    /**
     * Test of getAllStudents method, of class ClassRosterServiceLayer.
     * Our Stub impl of our Dao has exactly one student. 
     * We need to assert when we call the service layer it gives us
     * the dao correctly. 
     */
    
    @Test
    public void testGetAllStudents() throws Exception {
        
        // We expecting one student, then we are passing in 
        // the size of the list. 
        // Our Stub implementation of the Dao has exactly one student. 
        // So this is the canned data we are expecting to see. 
        assertEquals(1, service.getAllStudents().size());
    }

    /**
     * Test of getStudent method, of class ClassRosterServiceLayer.
     * Here we tested two conditions. 
     * 1. Tested getting a student that does exist . ("001") which is in our Dao 
     * 2. Tested a student that doesn't existed. ("999"). 
     * 
     *Imported two Junit methods. Passing in the student object. 
     * 1. AssertNotNull();  
     * 2. AssertNull();
     */
    @Test
    public void testGetStudent() throws Exception {
        Student student = service.getStudent("001"); 
        assertNotNull(student);
        student = service.getStudent("999"); 
        assertNull(student);
    }

    /**
     * Test of removeStudent method, of class ClassRosterServiceLayer.
     * We have one student in the Dao
     * In the underlying Student DAO  API.
     * If we try to  remove a student with an existing student ID ,
     * It will return and remove that student
     * BUT * if we remove a student that doesnt exist . Junit
     * will return null. 
     * Which is pretty similar to the testGetStudent() test above. 
     * It wont throw an exception
     * 
     * We are not testing if this is persisting but instead 
     * we are testing if things are plugging in , and outputting correctly. 
     */
    @Test
    public void testRemoveStudent() throws Exception {
         Student student = service.removeStudent("001");
        assertNotNull(student);
        student = service.removeStudent("999");
        assertNull(student);
        
    }
  

}
