/*
 *  Filename: Weight.java
 *  Author: Patrick Walsh
 *  Date: 11/3/2020
 *  Purpose: Creates Weight class which does comparisons of various weight
 *  values and shows if object weight is more or less than an input value,
 *  adds an input value to total weight, and divides total weight by given divisor.
 *
 */

public class Weight {
	// initialize weight object variables pounds and ounces
	private int pounds;
	private double ounces;
	private static final int OUNCES_IN_POUND = 16;
	
	// constructor
	public Weight(int pounds, double ounces) {
		this.pounds = pounds;
		this.ounces = ounces;
	}
	

	// take the weight object's weight in ounces and check if it is less or more than the input parameter weight in ounces
	public double lessThan(double inputOunces) {
		System.out.println("Object weight (in oz): " + String.format("%.3f", toOunces()) + " oz\nInput test weight: " + String.format("%.3f", inputOunces) + " oz");
		if (toOunces() < inputOunces) {
			System.out.println("The object weight is LESS than the input test weight.");
		} else {
			System.out.println("The object weight is MORE than the input test weight.");
		}
		return inputOunces;
	}
	
	// take the weight object's weight and add the amount in the input parameter
	public double addTo(double addedWeight) {
		System.out.println("Starting weight:");
		normalize(toOunces());
		System.out.println("Added weight: " + String.format("%.3f", addedWeight) + " oz");
		double newOunces = toOunces() + addedWeight;
		System.out.println("New total weight:");
		normalize(newOunces);
		return addedWeight;
	}
	
	// divide the object's weight by an input parameter and normalize the results to show in pounds and ounces
	public int divide(int divisor) {
		// call toOunces() method to get total number of ounces
		double divOunces = toOunces();
		divOunces = divOunces / divisor;
		System.out.println("Starting weight: ");
		System.out.println(pounds + " lbs, " + String.format("%.3f", ounces) + " oz");
		System.out.println("Object weight after divided by " + divisor + ": ");
		normalize(divOunces);
		return divisor;
	}
	
	// display the object weight in pounds and ounces as a string
	public String toString() {
		String displayWeight;
//		String.format("%.3f", ounces);
		displayWeight = "Weight object:\n" + pounds + " lbs, " + String.format("%.3f", ounces) + " oz";
		return displayWeight;
	}
	
	// display the total number of ounces in the weight object
	private double toOunces() {
		double totalOunces = pounds * OUNCES_IN_POUND;
		totalOunces += ounces;
//		System.out.println("Total number of ounces in Weight object: " + totalOunces + " oz");
		return totalOunces;
	}
	
	
	private int normalize(double totalOz) {
		int normPounds = 0;
		while (totalOz >= OUNCES_IN_POUND) {
			if (totalOz / OUNCES_IN_POUND >= 1) {
				normPounds++;
			}
			totalOz -= 16;
		}
//		System.out.println("Normalized into pounds and ounces:");
		System.out.println(normPounds + " lbs, " + String.format("%.3f", totalOz) + " oz");
		return 0;
	}
	
	
	
	
}
