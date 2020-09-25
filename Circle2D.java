/*
File: Circle2D.java
Author: Patrick Walsh
Date: 9/25/2020
Purpose: This program creates a class which allows you to calculate the area and circumfrence of a circle
 */

/**
 *
 * @author pwalsh
 */
public class Circle2D {

    // class variables
    private final double PI = 3.14;
    private static int numCircles = 0;
    private double x;
    private double y;
    private double radius;
    
    // default constructor
    public Circle2D(){
        this.x = 0.0;
        this.y = 0.0;
        this.radius = 1.0;
    }
    
    // constructor with 2 parameters
    public Circle2D(double x, double y){
        this.x = x; // this.x refers to the private x, and x refers to the x in the constructor
        this.y = y; // this.y refers to the private y, and y refers to the y in the constructor
    }
    public Circle2D(double r){
        this.radius = r; // this.radius refers to the private radius, and r refers to the r in the constructor
    }
    
    // create method to calculate the area of a cirlce
    // area = PI x radius^2
    public double computeArea(){
        double area = PI * Math.pow(radius, 2);
        return area;
    }
    
    // create method to calculate the circumfrence of a circle 
    // circumfrence of circle = 2 x PI x radius
    public double computeCircum(){
        double circum = 2 * PI * radius;
        return circum;
    }
    
    // create method to returns a string with variable values
    public String toString(){
        return "x = " + this.x + "\ny = " + this.y + "\nradius = " + this.radius + "\narea = " + computeArea() + "\ncircumfrence = " + computeCircum();
    }
    
    
    
    // start of MAIN METHOD
    public static void main(String args[]) {
        // create object from Circle2D class
        Circle2D myCircle = new Circle2D();
        System.out.println(myCircle.toString());
        System.out.println("numCircles = " + numCircles);
        System.out.println("\n");
        
        // create another object from Circle2D class
        Circle2D yourCircle = new Circle2D(2.5);
        System.out.println(yourCircle.toString());
        System.out.println("numCircles = " + numCircles);
        
    }
}
