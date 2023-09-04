/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentapp;

import java.io.*;
import java.util.*;
import za.ac.tut.bl.*;
import za.ac.tut.entities.*;

/**
 *
 * @author MNCEDISI
 */
public class StudentApp 
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        try
        {
            StudentManager sm = new StudentManager();
            int option = showOption();
            
            do
            {
                switch(option)
                {
                    case 1:
                        Student student = student();

                        if(sm.addStudent(student))
                            System.out.println("The student is added");
                        else
                            System.err.println("The student is not added");
                        break;

                    case 2:
                        Set<Student> theStudent = sm.displayAllStudent();

                        if(!theStudent.isEmpty())
                            displayAllStudents(theStudent);
                        else
                            System.err.println("Nothing no the list");
                    break;

                    case 3:
                        Long studentNum = promptingStudentNo();

                        if(sm.removeStudent(studentNum))
                            System.out.println("The student is removed");
                        else
                            System.err.println("The student is not removed");
                    break;

                    case 4:
                        studentNum =  promptingStudentNo();

                        student = sm.searchStudent(studentNum);

                        if(student!=null)
                            displayStudent(student);
                        else
                            System.err.println("No student much this student number");
                    break;

                    case 5:
                        System.out.println("Please enter following details with same student that you want to update");

                        student = student();

                        if(sm.updateStudent(student))
                            System.out.println("The student is updated");
                        else
                            System.err.println("The student is not updated");
                    break;

                    case 6:
                        File file = new File("C:\\Users\\MNCEDISI\\Desktop\\Student.txt");

                        theStudent = sm.displayAllStudent();

                        if(sm.storeContent(theStudent, file))
                            System.out.println("The information is stored in the text file");
                        else
                            System.err.println("The information is not stored");
                    break;

                    default:
                        System.err.println("Invalid option. Please re-enter again");
                    break;
                }

                option = showOption();
            }
            while(option!=7);
        }
        
        catch(InputMismatchException ex)
        {
            System.err.println("Invalid option.Please enter a digit option");
        }
    }

    private static int showOption() 
    {
        Scanner sc = new Scanner(System.in);
        
        String menu = "\nPlease select one of the following option :\n\n"+
                      "1. Add a student in the classlist. No duplicates are allowed\n"+
                      "2. Display the details of all the students in the classlist\n"+
                      "3. Remove a student from the classlist\n"+
                      "4. Search for a student\n"+
                      "5. Update the details of a student\n"+
                      "6. Store the contents of the list in a text file\n"+
                      "7. Exit\n\n"+
                      "Your option :";
       
        System.out.print(menu);
        
        return sc.nextInt();
    }

    private static Student student() 
    {
        Scanner sc = new Scanner(System.in);
        Scanner sca = new Scanner(System.in);
        
        System.out.print("Enter your student number to[add/update]:");
        Long studentNum = sc.nextLong();
        
        System.out.print("Enter your name\t\t\t\t:");
        String name = sca.nextLine();
        
        System.out.print("Enter your surname\t\t\t:");
        String surname = sca.nextLine();
        
        System.out.print("\nHow many subject did you do :");
        Integer numOfSubj = sc.nextInt();
        
        sc.nextLine();
        
        ArrayList<Subject> theSubject = new ArrayList<>();
        
        for (int i = 0; i < numOfSubj; i++)
        {
            System.out.print("Enter the subject "+(1+i)+"\t:");
            String subjName = sc.nextLine();
           
            theSubject.add(new Subject(subjName));
        }
        
        Student student = new Student(studentNum, name, surname);
        student.setSubject(theSubject);
        
        return student;
    }

    private static void displayAllStudents(Set<Student> theStudent) 
    {
        String output = "";
        
        for (Student display : theStudent)
        {
            output+="\nStudent Number\t:"+display.getStudentNum()+"\n"+
                    "Name\t\t:"+display.getName()+"\n"+
                    "Surname\t\t:"+display.getSurname()+"\n"+
                    "Subject<s>\t:"+display.getSubject()+"\n";
        }
        
        System.out.println(output);
    }

    private static Long promptingStudentNo() 
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Please enter the student number you want to[remove/search] :");
        
        return sc.nextLong();
    }

    private static void displayStudent(Student student)
    {
        String output = "Student Number\t:"+student.getStudentNum()+"\n"+
                        "Name\t\t:"+student.getName()+"\n"+
                        "Surname\t\t:"+student.getSurname()+"\n"+
                        "Subject<s>\t:"+student.getSubject()+"\n";
        
        System.out.print(output);
    }
}
