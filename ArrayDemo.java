/*
* File: ArrayDemo.java
* Author: Dr. Robertson
* Date: January 1, 2015
* Purpose: This program demonstrates the creation
* and use of J
ava arrays
*/

// import color class
import java.awt.Color;

public class ArrayDemo{

// define constant array size
static final int ARRAYSIZE = 20;
static final int STRARRAYSIZE = 5;

  // main method
  public static void main(String args[]){
    System.out.println("Welcome to the Array Demo!");



    // create array of ints
    int[] intValues = new int[ARRAYSIZE];
    // use for loop to assign random values
    for (int i=0; i<intValues.length; i++){
      intValues[i] = (int)(Math.random() * 10);
    }


    // create array of strings
    String[] stringValues = new String[STRARRAYSIZE];
    stringValues[0] = "Have a Nice day!";
    stringValues[1] = "I'll be back!";
    stringValues[2] = "Welcome again!";
    stringValues[3] = "Work hard, play hard!";
    stringValues[4] = "I can program arrays in Java!";


    // create array of doubles
    double[] doubleValues = new double[ARRAYSIZE];
    // use for loop to assign random values
    for (int i=0; i<doubleValues.length; i++){
      doubleValues[i] = Math.random() * 100.0;
    }


    // create array of colors
    Color[] colorValues = new Color[ARRAYSIZE];
    // use for loop to assign random values
    for (int i=0; i<colorValues.length; i++){
      int red = (int)(Math.random() * 255);
      int green = (int)(Math.random() * 255);
      int blue = (int)(Math.random() * 255);
      colorValues[i] = new Color(red, green, blue);
    }


    // DISPLAY ARRAY VALUES

    // int values
    System.out.println("\nInt values:");
    for (int i=0; i<intValues.length; i++){
      // print new line every 10 items
      if ((i % 10) == 0){
        System.out.print("\n");
      }
      System.out.print(intValues[i]);
    }

    // double values
    System.out.println("\n");
    System.out.println("\nDouble values:");
    for (int i=0; i<doubleValues.length; i++){
      // print new line every 10 items
      if ((i % 10) == 0){
        System.out.print("\n");
      }
      // use string.format to display 2 decimals
      System.out.print(String.format("%.2f\t", doubleValues[i]));
    }

    // string values
    System.out.println("\n");
    System.out.println("\nString values:");
    for (int i=0; i<stringValues.length; i++){
      System.out.println(stringValues[i]);
    }

    // color values
    System.out.println("\n");
    System.out.println("\nColor values:");
    for (int i=0; i<colorValues.length; i++){
      // toString shows RGB values
      System.out.print(colorValues[i].toString() + "\n");
    }




  } // end of main
}
