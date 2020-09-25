/*
File: TestCircleScopeDemo.java
Author: Dr. Robertson
Date: January 1, 2015
Purpose: This program constructs instances
of the CircleScopeDemo
 */

/**
 *
 * @author pwalsh
 */             
public class TestCircleScopeDemo {
    public static void main(String[] args){
        // construct a default circle
        CircleScopeDemo circleLeft = new CircleScopeDemo();

        // call get values
        System.out.println("Circle Left is: " + circleLeft.getRadius());
        System.out.println("Number Circles is: " + CircleScopeDemo.getNumCircles());
        System.out.println("Circle Left Area is: " + String.format("%.2f",circleLeft.getArea()));
        
        //construct another circle 
        CircleScopeDemo circleRight = new CircleScopeDemo(2.0);
        System.out.println("Circle Right is: " + circleRight.getRadius());
        System.out.println("Number Circles is: " + CircleScopeDemo.getNumCircles());
        System.out.println("Circle Right Area is: " + String.format("%.2f",circleRight.getArea()));
        
        // Construct another Circle
        CircleScopeDemo circleCenter = new CircleScopeDemo(3.0);
        System.out.println("Circle Center is: " + circleCenter.getRadius());
        System.out.println("Number Circles is: " + CircleScopeDemo.getNumCircles());
        System.out.println("Circle Center Area is: " + String.format("%.2f",circleCenter.getArea()));  
        
    } // end of main
}
