/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.bl;

import java.io.*;
import java.util.*;
import za.ac.tut.entities.*;

/**
 *
 * @author MNCEDISI
 */
public class StudentManager implements StudentInterface<Student>
{
    private Set<Student> theStudent;

    public StudentManager() 
    {
        theStudent = new HashSet<>();
    }

    @Override
    public boolean addStudent(Student student) 
    {
        if(theStudent.add(student))
            return true;
        else
            return false;
    }

    @Override
    public Set<Student> displayAllStudent() 
    {
        return theStudent;
    }

    @Override
    public  boolean removeStudent(Long studentNum) 
    {
        boolean remove = false;
        
        ArrayList<Student> theList = new ArrayList<>();
        
        for (Student display : theStudent) 
        {
            if(display.getStudentNum().equals(studentNum))
            {
                theList.add(display);
                remove  = true;
            }             
        }
        
        theStudent.removeAll(theList);
        
        return remove;
    }

    @Override
    public Student searchStudent(Long studentNum) 
    {
        Student student = null;
        
        for (Student display : theStudent) 
        {
            if(display.getStudentNum().equals(studentNum))
                student = display;
        }
        
        return student;
    }

    @Override
    public boolean updateStudent(Student student)
    {
        boolean update = false;
        
        List<Student> list = new ArrayList<>();
        
        list.addAll(theStudent);
        
        for (Student display : list)
        {
            if(display.getStudentNum().equals(student.getStudentNum()))
            {
                int index = list.indexOf(display);
                list.set(index, student);
                update = true;
            }
        }
        
        theStudent.clear();
        
        theStudent.addAll(list);
        
        return update;
    }

    @Override
    public boolean storeContent(Set<Student> theStudent , File file) 
    {
        boolean store = false;
        
        try
        {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            
            String outcome = "";
            
            for (Student display : theStudent)
            {
                outcome+="Student Number :"+display.getStudentNum()+"\n"+
                         "Name           :"+display.getName()+"\n"+
                         "Surname        :"+display.getSurname()+"\n"+
                         "Subject<s>     :"+display.getSubject()+"\n\n";
            }
            
            bw.write(outcome);
            
            bw.close();
            
            store = true;
        } 
        
        catch (IOException ex) 
        {
            System.err.println("Something went wrong\n"+ex.getMessage());
        } 
        
        return store;
    }
    
}
