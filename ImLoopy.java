/*
* File: ImLoopy.java
* Author: Patrick Walsh
* Date: 9/3/2020
* Purpose: allow user to choose how many times a number gets doubled using a for loop
*/

// import scanner to take user input
import java.util.Scanner;

public class ImLoopy{
  public static void main(String[] args){
    // initialize variables
    int num;
    int loops;

    // setup scanner to take user input
    Scanner scannerIn = new Scanner(System.in);

    // user enters number to double
    System.out.println("Which number would you like to double (enter an integer)?:");
    num = scannerIn.nextInt();

    // user enters how many times they want the number doubled
    System.out.println("How many times would you like to double it (enter an integer)?:");
    loops = scannerIn.nextInt();

    System.out.println("The number: " + num + " was doubled " + loops + " times");

    // double the user's number with a for loop
    for (int i=0; i<loops; i++){
      num *= 2;
    }
    System.out.println("Final value of the number = " + num);


  } // end of main
}
