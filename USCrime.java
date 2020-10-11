/*
Filename: USCrime.java
Author: Patrick Walsh
Date: 10/10/2020
Purpose: This program allows the user to look up crime statistics
for the United States between 1994-2013.
*/


// import array package 
import java.util.Arrays;


public class USCrime{

  // define fields
  // private String fileName;
  private int[] year;
  private int[] population;
  private double[] murderRate;
  private double[] robberyRate;


  // constructor
	public USCrime(int[] year, int[] population, double[] murderRate, double[] robberyRate) {
    // this.fileName = fileName;
    this.year = year;
		this.population = population;
    this.murderRate = murderRate;
    this.robberyRate = robberyRate;
	}

	// default constructor
	public USCrime(){
    // fileName = null;
    year = null;
		population = null;
    murderRate = null;
    robberyRate = null;
	}





  // GETTER METHODS
  // get year as array of years from Crime.csv file
  public int[] getYear(){
    return year;
  }
  public int[] getPopulation(){
    return population;
  }
  public double[] getMurderRate(){
    return murderRate;
  }
  public double[] getRobberyRate(){
    return robberyRate;
  }



  // popGrowth() method returns the growth in
  // population for each consecutive year
  public String popGrowth(){
    String[] growthStats = new String[year.length-1];
    double changePop;
    for (int i=0; i<year.length-1; i++){
      // calculate change in population percentage for each consecutive year
      changePop = Math.abs(population[i] - population[i+1]);
      changePop = changePop / population[i] * 100;
      growthStats[i] = year[i] + "-" + year[i+1] + ": " + String.format("%.2f",changePop) + "%";
    } // end of for loop
    String showGrowth = Arrays.toString(growthStats);
    return showGrowth;
  }


  // murderRateHigh() returns the year with the highest
  // murder rate
  public String murderRateHigh(){
    // set highest murder rate and year to default value,
    // then check if there is a year that has a higher murder rate
    String murderYearHigh = "" + year[0];
    double highestMurderRate = murderRate[0];
    for (int i=0; i<year.length; i++){
      double temp = murderRate[i];
      if (temp >= highestMurderRate){
        murderYearHigh = "" + year[i] + " - murder rate: " + murderRate[i] + "%";
      }
    } // end of loop
    return murderYearHigh;
  }


  // murderRateLow() returns the year with the lowest
  // murder rate
  public String murderRateLow(){
    // set lowest murder rate and year to default value,
    // then check if there is a year that has a lower murder rate
    String murderYearLow = "" + year[0];
    double lowestMurderRate = murderRate[0];
    for (int i=0; i<year.length; i++){
      double temp = murderRate[i];
      if (temp <= lowestMurderRate){
        murderYearLow = "" + year[i] + " - murder rate: " + murderRate[i] + "%";
      }
    } // end of loop
    return murderYearLow;
  }

  // robberyRateHigh() returns the year with the lowest
  // robbery rate
  public String robberyRateHigh(){
    // set highest robbery rate and year to default value,
    // then check if there is a year that has a higher robbery rate
    String robberyYearHigh = "" + year[0];
    double highestRobberyRate = robberyRate[0];
    for (int i=0; i<year.length; i++){
      double temp = robberyRate[i];
      if (temp >= highestRobberyRate){
        robberyYearHigh = "" + year[i] + " - robbery rate: " + robberyRate[i] + "%";
      }
    } // end of loop
    return robberyYearHigh;
  }


  // robberyRateLow() returns the year with the lowest
  // robbery rate
  public String robberyRateLow(){
    // set highest robbery rate and year to default value,
    // then check if there is a year that has a higher robbery rate
    String robberyYearLow = "" + year[0];
    double lowestRobberyRate = robberyRate[0];
    for (int i=0; i<year.length; i++){
      double temp = robberyRate[i];
      if (temp <= lowestRobberyRate){
        robberyYearLow = "" + year[i] + " - robbery rate: " + robberyRate[i] + "%";
      }
    } // end of loop
    return robberyYearLow;
  }
  // end of methods

}
