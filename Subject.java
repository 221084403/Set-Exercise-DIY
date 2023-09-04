/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.entities;

/**
 *
 * @author MNCEDISI
 */
public class Subject
{
    private String subjName;

    public Subject(String subjName) 
    {
        this.subjName = subjName;
    }

    public String getSubjName() {
        return subjName;
    }

    public void setSubjName(String subjName) {
        this.subjName = subjName;
    }

    @Override
    public String toString() 
    {
        return getSubjName();
    }
}
