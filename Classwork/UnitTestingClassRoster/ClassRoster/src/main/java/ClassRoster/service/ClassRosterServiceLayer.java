/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassRoster.service;

import com.mr.classroster.dao.ClassRosterPersistenceException;
import com.mr.classroster.dto.Student;
import java.util.List;

/**
 *
 * @author michaelrodriguez
 */
public interface ClassRosterServiceLayer {
 
    void createStudent(Student student) throws
            ClassRosterDuplicateIdException,
            ClassRosterDataValidationException,
            ClassRosterPersistenceException;
 
    List<Student> getAllStudents() throws
            ClassRosterPersistenceException;
 
    Student getStudent(String studentId) throws
            ClassRosterPersistenceException;
 
    Student removeStudent(String studentId) throws
            ClassRosterPersistenceException;
 
}

