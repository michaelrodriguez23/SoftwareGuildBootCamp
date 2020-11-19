/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassRoster.service;

import com.mr.classroster.dao.ClassRosterAuditDao;
import com.mr.classroster.dao.ClassRosterDao;
import com.mr.classroster.dao.ClassRosterPersistenceException;
import com.mr.classroster.dto.Student;
import java.util.List;

public class ClassRosterServiceLayerImpl implements ClassRosterServiceLayer {

    ClassRosterDao dao;
    ClassRosterAuditDao auditDao;

    public ClassRosterServiceLayerImpl(ClassRosterDao dao, ClassRosterAuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }

    @Override
    public void createStudent(Student student) throws ClassRosterDuplicateIdException, ClassRosterDataValidationException, ClassRosterPersistenceException {
        if (dao.getStudent(student.getStudentID()) != null) {
            throw new ClassRosterDuplicateIdException("ERROR : Could not create student. Student id " + student.getStudentID() + "already exist");

        }
        validateStudentData(student);

        dao.addStudent(student.getStudentID(), student);
        auditDao.writeAuditEntry("Student : " + student.getStudentID() + " CREATED.");

    }

    @Override
    public List<Student> getAllStudents() throws ClassRosterPersistenceException {
        return dao.getAllStudents();
    }

    @Override
    public Student getStudent(String studentId) throws ClassRosterPersistenceException {
        return dao.getStudent(studentId);
    }

    @Override
    public Student removeStudent(String studentId) throws ClassRosterPersistenceException {
        auditDao.writeAuditEntry("Student" + studentId + " REMOVED");
        return dao.removeStudent(studentId);
    }

    private void validateStudentData(Student student) throws
            ClassRosterDataValidationException {

        if (student.getFirstName() == null
                || student.getFirstName().trim().length() == 0
                || student.getLastName() == null
                || student.getLastName().trim().length() == 0
                || student.getCohort() == null
                || student.getCohort().trim().length() == 0) {

            throw new ClassRosterDataValidationException(
                    "ERROR: All fields [First Name, Last Name, Cohort] are required.");
        }
    }

}
