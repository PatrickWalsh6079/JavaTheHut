/*
 * Filename: Automobile.java
 * Author: Patrick Walsh
 * Date: 11/12/2020
 * Purpose: Creates Automobile superclass for GUI
 */

public class Automobile {
	
	private String make;
	private String model;
	private int price;
	
	// constructor
	public Automobile(String make, String model, int price) {
		this.make = make;
		this.model = model;
		this.price = price;
	}
	
	public double salesTax(int price) {
		double tax = price * 0.05;
		return tax;
	}
	
	public String toString() {
		String display;
		display = "Make and Model: " + make + " " + model + "\nPrice: $" + price + "\nSales tax: $" + String.format("%.2f", salesTax(price));
		return display;
	}
	
	
}
