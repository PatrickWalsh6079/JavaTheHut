/*
* File: SortDemo.java
* Author: Dr. Robertson
* Date: January 1, 2015
* Purpose: This program demonstrates how to sort
* primitives using the selection sort
* and the Arrays quick sort algorithm
*/

// import Arrays class
import java.util.Arrays;

public class SortDemo{

  // define constant array size
  static final int ARRAYSIZE = 10;

  // selectionSort method
  public static void selectionSort(int[] array){

    // iterate for each position in the array
    for (int i=0; i<(array.length - 1); i++){
      int min = i;
      // find the smallest value in the array
      for (int j=i; j<(array.length); j++){
        if (array[j] < array[min]){
          min = j;
        }
      } // end of for

      int temp = array[min];
      array[min] = array[i];
      array[i] = temp;
    } // end of for
  } // end of selectionSort


  // start of main method
  public static void main(String args[]){
    System.out.println("Welcome to the Sort Array Demo!");

    // create array of ints
    int[] intValues = new int[ARRAYSIZE];
    // assign random values between 0-100
    for (int i=0; i<intValues.length; i++){
      intValues[i] = (int)(Math.random() * 100);
    }

    // print the unsorted array
    System.out.println("\nUnsorted intValues:");
    for (int i=0; i<intValues.length; i++){
      System.out.println(intValues[i] + "");
    }

    // call the selectionSort method to display ints in sorted arrangement
    selectionSort(intValues);
    System.out.println("\nSorted intValues:");
    for (int i=0; i<intValues.length; i++){
      System.out.println(intValues[i] + "");
    }



    // create array of doubles
    double[] doubleValues = new double[ARRAYSIZE];
    // assign random values to array between 0.00-100.00
    for (int i=0; i<doubleValues.length; i++){
      doubleValues[i] = (Math.random() *100);
    }

    // print the unsorted array
    System.out.println("\nUnsorted doubleValues:");
    for (int i=0; i<doubleValues.length; i++){
      System.out.println(doubleValues[i] + "");
    }

    // call the selectionSort method to display ints in sorted arrangement
    Arrays.sort(doubleValues);
    System.out.println("\nSorted doubleValues:");
    for (int i=0; i<doubleValues.length; i++){
      System.out.println(doubleValues[i] + "");
    }

  } // end of main

}
