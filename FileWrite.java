/*
Filename: FileWrite.java
Author: Patrick Walsh
Date: 10/8/2020
Purpose: This program reads data from one file 
and writes it to another file.
*/


// import necessary packages
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class FileWrite{

	// start of MAIN METHOD
	public static void main(String[] args){

		// create objects for reading and writing files
		Scanner scannerIn = null;
		FileInputStream in = null;
		BufferedReader inputStream = null;
		BufferedWriter outputStream = null;
		PrintWriter fileOut = null;



		// create a new file
		File summaryOut = new File("DataSummary.txt");



		// use Scanner
		// initialize variables
		int[] ages = new int[100];
		int cnt = 0;
		int ageSum = 0;


		try{

			inputStream = new BufferedReader(new FileReader("Ages.txt"));
			// open copy of file
			outputStream = new BufferedWriter(new FileWriter("AgesCopy.txt"));

			scannerIn = new Scanner(inputStream);
			while (scannerIn.hasNext()){

				ages[cnt] = scannerIn.nextInt();
				// write output to copy file
				outputStream.write(ages[cnt] + "\r\n");
				ageSum += ages[cnt];
				cnt++;
			} // end of while loop


			// send summary data to output file
			fileOut = new PrintWriter(summaryOut);
			fileOut.print("Average age = " + (ageSum/cnt));
		} catch (IOException io){
			System.out.print("File IO exception: " + io.getMessage());

		} finally { // runs regardless of exceptions


			// attempt to close files if open
			try{
				if (outputStream != null){
					outputStream.close();
				}
				if (inputStream != null){
					inputStream.close();
				}
				if (fileOut != null){
					fileOut.close();
				}

			} catch (IOException io){
				System.out.println("Issue closing file: " + io.getMessage());
			}

		} // end of main try,catch,finally statement




		System.out.println("\nFiles writing application complete.");


	} // end of MAIN METHOD
}
