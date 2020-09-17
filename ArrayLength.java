/*
Filename: ArrayLength.Java
Author: Patrick Walsh
Class: CMIS 141
Date: 9/17/2020
Purpose: Program creates an array of 10 integers, then demonstrates how to see
the length of the array.
*/

// import Arrays class
import java.util.Arrays;

public class ArrayLength{

  // start of main
  public static void main(String args[]){

    // create array of ints with 10 positions
    int[] arrayInts = new int[10];

    // populate array with 10 random values between 0-10
    for (int i=0; i<arrayInts.length; i++){
      arrayInts[i] = (int)(Math.random() * 11);
    }

    System.out.println("Here is the array:\n");
    // display contents of array
    for (int i=0; i<arrayInts.length; i++){
      System.out.println(arrayInts[i]);
    }

    // determine length of array
    System.out.println("Use the .length method to find the length of the array:");
    System.out.println("The array is " + arrayInts.length + " values long.");

  } // end of main
}
