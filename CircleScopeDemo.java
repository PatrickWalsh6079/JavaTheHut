/*
File: circleScopeDemo.java
Author: Dr. Robertson
Date: January 1, 2015
Purpose: This program demonstrates the scope
of class and local variables.
 */

/**
 *
 * @author pwalsh
 */
public class CircleScopeDemo {

    // define a static class variable
    // hold number of obejcts
    private static int numCircles = 0;
    // define a class variable
    private double radius = 1.0;
    
    // constructors
    // default constructor
    public CircleScopeDemo(){
        this.radius = 1.0;
        numCircles ++;
    }
    public CircleScopeDemo(double r){
        radius = r;
        numCircles ++;
    }
    
    // area method 
    public double getArea(){
        double area = Math.PI*Math.pow(radius, 2);
        return area;
    }
    
    // getter method
    public double getRadius(){
        return radius;
    }
    public static int getNumCircles(){
        return numCircles;
    }
}

