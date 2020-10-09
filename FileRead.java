/*
Filename: FileRead.java
Author: Patrick Walsh
Date: 10/8/2020
Purpose: The purpose of this program is to show how to read data
from files in Java. There are two sets of try,catch statements.
The first try,catch is in case there are no files to open, and
the second try,catch is if there are issues closing the files.
*/


// import necessary packages
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class FileRead{

	// start of MAIN METHOD
	public static void main(String[] args){

		// create Scanner object to take file input
		Scanner scannerIn = null;
		FileInputStream in = null;
		BufferedReader inputStream = null;

		// initialize variables
		int fileChar;
		String fileLine;
		try{
			// file should be located in same directory as this Java file
			in = new FileInputStream("ReadIt.txt");

			System.out.println("ReadIt.txt file contents:");
			
			// use while loop to read one char at a time
			while((fileChar = in.read()) != -1){
				// convert int to char
				System.out.println((char) fileChar);

			} // end of while loop
			System.out.println("");


			System.out.println("Numbers.txt file contents:");

			// use of Scanner
			inputStream = new BufferedReader(new FileReader("Numbers.txt"));
			scannerIn = new Scanner(inputStream);
			while (scannerIn.hasNext()){
				if (scannerIn.hasNextInt()){
					System.out.println(scannerIn.nextInt());
				}
				if (scannerIn.hasNextDouble()){
					System.out.println(scannerIn.nextDouble());
				} else{
					scannerIn.next();
				}
			} // end of while loop
			System.out.println("");



			// use of BufferedReader
			inputStream = new BufferedReader(new FileReader("Strings.txt"));

			System.out.println("Strings.txt file contents:");
			// read each line at a time using BufferedReader
			while ((fileLine = inputStream.readLine() ) != null){
				System.out.println(fileLine);
			} // end of while loop

			// catch exceptions

		} catch (IOException io){
			System.out.println("File IO exception: " + io.getMessage());
		} finally{ // runs no matter what

			// use another try, catch for closing the files
			try{
				if (in != null){
					in.close();
				}
				if (inputStream != null){
					inputStream.close();
				}
			} catch (IOException io){
				System.out.println("Issue closing the files: " + io.getMessage());

			}
		} // end of main try, catch, finally
	}
}