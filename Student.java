/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.entities;

import java.util.*;

/**
 *
 * @author MNCEDISI
 */
public class Student 
{
    private Long studentNum;
    private String name;
    private String surname;
    private ArrayList<Subject> subject;

    public Student(Long studentNum, String name, String surname) 
    {
        this.studentNum = studentNum;
        this.name = name;
        this.surname = surname;
    }

    public Long getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(Long studentNum) {
        this.studentNum = studentNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Subject> getSubject() {
        return subject;
    }

    public void setSubject(ArrayList<Subject> subject) {
        this.subject = subject;
    }

}
