/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pwalsh
 */
public class ThisPerson {

    // define class field name
    private int age = 0;
    
    // create default constructor
    public ThisPerson(){
        age = 0;
    }
    // use "this" in setter method
    public void setAge(int age){
        this.age = age;
    }
    
    // use "this" in getter method
    public int getAge(){
        return this.age;
    }
    
    // main method to create class object and call method
    public static void main(String args[]){
        
        // create two objects using ThisPerson class
        ThisPerson tom = new ThisPerson();
        ThisPerson jane = new ThisPerson();
        
        // call setAge() method to set the age for each object
        tom.setAge(43);
        jane.setAge(26);
        
        // call getAge() method to see the object's age
        System.out.println(tom.getAge());
        System.out.println(jane.getAge());
        
    }
}
