/*
Filename: xRandomNumbers.java
Author: Patrick Walsh
Date: 10/1/2020
Purpose: This program lets the user create a set of random numbers
and specify the length X and range from 0-Y of these numbers.
*/

// import Scanner to allow user input
import java.util.Scanner;

// import Random class to create random numbers
import java.util.Random;

public class xRandomNumbers{

  public static void main(String[] args) {


    // use these two lines to run as command-line arguments
    int lengthNumbers = Integer.parseInt(args[0]);
    int highestNumber = Integer.parseInt(args[1]);



    // use these lines to run as traditional Scanner input
    // // create scanner object for user input
    // Scanner input = new Scanner(System.in);
    //
    // System.out.println("***** WELCOME TO RANDOM NUMBER GENERATOR *****");
    //
    // // ask user for the number of random numbers
    // System.out.println("\nHow many numbers would you like to generate?");
    // int lengthNumbers = input.nextInt();
    //
    // // ask user for the highest number allowed
    // System.out.println("\nWhat is the highest number allowed?");
    // int highestNumber = input.nextInt();




    System.out.println("\n\n***** CALCULATING YOUR RANDOM NUMBERS.... *****");

    // initialize random number value
    int randInt;

    // Generate a random Int
    Random randomNum = new Random();
    for (int i=0; i<lengthNumbers; i++){
      // range will be from 0 to highestNumber specified by user
      randInt = randomNum.nextInt(highestNumber);
      System.out.println(randInt);
    }


  } // end of main
}
