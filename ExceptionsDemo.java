/*
Filename: ExcemptionsDemo.java
Author: Patrick Walsh
Date: 10/8/2020
Purpose: This program demonstrates how to use try, catch, and finally
*/

// import Scanner for user input
import java.util.Scanner;


public class ExceptionsDemo{

	// create a private variable for age
	private static int age = 30;




	// start of MAIN MEHTHOD
	public static void main(String[] args){

		// create Scanner object for user input
		Scanner myScanner = new Scanner(System.in);



		// prompt for user input in while loop
		while (true){

			try{
				System.out.println("Enter your age (i.e. 32): ");
				age = Integer.parseInt(myScanner.next());
				break;
			} catch(NumberFormatException ne){
				System.err.println("NumberFormatException: " + ne.getMessage());
				System.out.println("Please enter a valid age: ");
			} finally{ // this runs regardless of outcome
				System.out.println("Age is just a number.....");
			}

		} // end of while loop



		// now use catch ArithmeticException 
		try{
			// this will produce an error because you can't divide by zero
			int newAge = age / 0;
		} catch(ArithmeticException ae){
			System.out.println("ArithmeticException: " + ae.getMessage());
		}



		// now use catch ArrayIndexOutofBoundsException
		int[] examGrades = {85, 90, 53, 97, 92};
		try{
			for (int i=0; i<=examGrades.length; i++){
				System.out.println("Exam grades are: " + examGrades[i]);
			} 
		} catch (ArrayIndexOutOfBoundsException outOfBounds){
				System.out.println("ArrayIndexOutOfBoundsException: " 
					+ outOfBounds.getMessage());
		}



	} // end of MAIN METHOD
}