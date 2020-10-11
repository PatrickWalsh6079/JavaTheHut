/*
Filename: TestUSCrime.java
Author: Patrick Walsh
Date: 10/10/2020
Purpose: This program allows the user to look up crime statistics
for the United States between 1994-2013.
*/

// import necessary packages
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;




public class TestUSCrime{

  // start of main method
  public static void main(String[] args) {


    // OPEN CSV FILE AND READ CONTENTS
    int[] arrayYears = new int[20];
    int[] arrayPop = new int[20];
    double[] arrayMurderRate = new double[20];
    double[] arrayRobberyRate = new double[20];
    // use of BufferedReader
		FileInputStream in = null;
		BufferedReader inputStream = null;
    String fileLine;
    try{
    // user must enter filename as argument (i.e. java TestUSCrime Crime.csv)
    String fileName = args[0];
    // open Crime.csv file
    inputStream = new BufferedReader(new FileReader(fileName));
    // ignore first line
    inputStream.readLine();
    int count = 0;
    // read each line at a time using BufferedReader
    while ((fileLine = inputStream.readLine() ) != null){
      String yearStr = fileLine.split(",")[0];
      String popStr = fileLine.split(",")[1];
      String murderRateStr = fileLine.split(",")[5];
      String robberyRateStr = fileLine.split(",")[9];
      // convert string to int
      int yearInt = Integer.parseInt(yearStr);
      int popInt = Integer.parseInt(popStr);
      double murderRateDouble = Double.parseDouble(murderRateStr);
      double robberyRateDouble = Double.parseDouble(robberyRateStr);
      // append year to arrayYears
      arrayYears[count] = yearInt;
      arrayPop[count] = popInt;
      arrayMurderRate[count] = murderRateDouble;
      arrayRobberyRate[count] = robberyRateDouble;

      // System.out.println(fileLine);
      count++;
    } // end of while loop
    } catch (IOException io){
      System.out.println("File IO exception: " + io.getMessage());
    } finally{ // runs no matter what
      // attempt to close Crime.csv file
      try{
        if (inputStream != null){
          inputStream.close();
        }
      } catch (IOException io){
        System.out.println("Issue closing the files: " + io.getMessage());
      }
    } // end of main try, catch, finally
    // System.out.println("Years: " + Arrays.toString(arrayYears));



    // create USCrime class object
    USCrime crimeObj1 = new USCrime(arrayYears, arrayPop, arrayMurderRate, arrayRobberyRate);




    // System.out.println("\nInfo for each year:");
    // for (int i=0; i<arrayYears.length; i++){
    //   System.out.println(crimeObj1.getYear()[i]);
    //   System.out.println(crimeObj1.getPopulation()[i]);
    //   System.out.println(crimeObj1.getMurderRate()[i]);
    //   System.out.println(crimeObj1.getRobberyRate()[i]);
    //   System.out.println("");
    // }

    // start keeping track of elapsed time
    long startTime = System.currentTimeMillis();



    System.out.println("\n*********************************************");
    System.out.println("WELCOME TO THE US CRIMES STATISTICS DATABASE");
    System.out.println("*********************************************\n\n");

    // keep asking for user input until user chooses to quit by hitting "Q"
    String userChoice = "";
    while (userChoice.equalsIgnoreCase("Q") != true) {
      Scanner scannerIn = new Scanner(System.in);
      System.out.println("Make a selection from the choices below:\n");
      System.out.println("1. Percentage growth for each consecutive year from 1994-2013.\n2. Year with the highest murder rate.\n3. Year with the lowest murder rate.\n4. Year with the highest robbery rate.\n5. Year with the lowest robbery rate.\nQ. Terminal program and exit.\n\nUser choice:\n");
      userChoice = scannerIn.next();


    	// check user choice and respond with appropriate information
    	switch(userChoice) {
    		case "1":
          System.out.println("\n\n\n\n\n\n\n\n");
          System.out.println("\n\n\n1. Population growth between 1994-2013:\n");
          for (int i=0; i<arrayYears.length-1; i++){
            String populationStat = crimeObj1.popGrowth().split(",")[i];
            System.out.println(populationStat);
          }
          System.out.println("\n\n\n");
    			break;
    		case "2":
          System.out.println("\n\n\n\n\n\n\n\n");
          System.out.println("\n\n\n2. Year with the Highest murder rate:\n");
          System.out.println(crimeObj1.murderRateHigh());
          System.out.println("\n\n\n");
    			break;
        case "3":
          System.out.println("\n\n\n\n\n\n\n\n");
          System.out.println("\n\n\n3. Year with the Lowest murder rate:\n");
          System.out.println(crimeObj1.murderRateLow());
          System.out.println("\n\n\n");
      		break;
        case "4":
          System.out.println("\n\n\n\n\n\n\n\n");
          System.out.println("\n\n\n4. Year with the Highest robbery rate:\n");
          System.out.println(crimeObj1.robberyRateHigh());
          System.out.println("\n\n\n");
      		break;
        case "5":
          System.out.println("\n\n\n\n\n\n\n\n");
          System.out.println("\n\n\n5. Year with the Lowest robbery rate:\n");
          System.out.println(crimeObj1.robberyRateLow());
          System.out.println("\n\n\n");
      		break;
        case "Q":
          break;
        case "q":
          break;
        // print is user hits any key other than 1,2,3,4,5, or Q
        default:
          System.out.println("\n\n\nINVALID SELECTION!\n");
          System.out.println("\n\n\n");
          break;
  	  } // end switch

      // thank user for using program and display how long the program ran
      if (userChoice.equalsIgnoreCase("Q")){
        System.out.println("\n\n******************************************************");
        System.out.println("THANK YOU FOR USING THE US CRIMES STATISTICS DATABASE");
        System.out.println("******************************************************\n");
        // get time elapsed in milliseconds and convert to seconds
        long endTime = System.currentTimeMillis();
        double time = (endTime - startTime) / 1000.0;
        System.out.println("Program runtime: " + time + " seconds\n");
      }

  	} // end of while loop

  } // end of main method

}
