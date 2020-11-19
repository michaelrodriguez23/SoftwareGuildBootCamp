/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.classmodeling;

/**
 *
 * @author michaelrodriguez
 * - Enrollment: int 
-numberOfTeachers : int
- coursesOffered: String[]
- sportsNickName: String
- clubsOffered: String[]
- studentRoster: Student[] 
 */
public class School2 {
    private int Enrollment;
    private int numberOfTeachers;
    private String[] coursesOffered;
    private String sportsNicknamed; 
    private String[] clubsOffered; 
    private Student[] studentRoster; 
    
    public void enrollStudent(Student student){
        
    }
    public void unenrollStudent(Student student){ 
        
    }

    public int getEnrollment() {
        return Enrollment;
    }

    public void setEnrollment(int Enrollment) {
        this.Enrollment = Enrollment;
    }

    public int getNumberOfTeachers() {
        return numberOfTeachers;
    }

    public void setNumberOfTeachers(int numberOfTeachers) {
        this.numberOfTeachers = numberOfTeachers;
    }

    public String[] getCoursesOffered() {
        return coursesOffered;
    }

    public void setCoursesOffered(String[] coursesOffered) {
        this.coursesOffered = coursesOffered;
    }

    public String getSportsNicknamed() {
        return sportsNicknamed;
    }

    public void setSportsNicknamed(String sportsNicknamed) {
        this.sportsNicknamed = sportsNicknamed;
    }

    public String[] getClubsOffered() {
        return clubsOffered;
    }

    public void setClubsOffered(String[] clubsOffered) {
        this.clubsOffered = clubsOffered;
    }

    public Student[] getStudentRoster() {
        return studentRoster;
    }

    public void setStudentRoster(Student[] studentRoster) {
        this.studentRoster = studentRoster;
    }
    
    
}
