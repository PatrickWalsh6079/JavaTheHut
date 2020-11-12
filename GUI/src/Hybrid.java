
/*
 * Filename: Hybrid.java
 * Author: Patrick Walsh
 * Date: 11/12/2020
 * Purpose: Creates Hybrid subclass of Automobile for GUI
 */

import javax.swing.JOptionPane;

public class Hybrid extends Automobile {
	
	private int milesPerGallon;
	private boolean discountApplied = false;
	private int discount = 100;
	
	// constructor
	public Hybrid(String make, String model, int price, int milesPerGallon) {
		super(make, model, price);
		this.milesPerGallon = milesPerGallon;
	}
	
	
	@Override
	public double salesTax(int price) {
		// Sales Tax is 5% of price, minus discount
		// Discount is $100 if gas mileage is less than 40 MPG. If MPH is over 40, there is an additional
		// $2 discount for every mile after 40
		int tempMiles = milesPerGallon;
		if (tempMiles > 40) {
			tempMiles -= 40;
			discount += tempMiles * 2;
			discountApplied = true;
		}
//		System.out.println("Discount: $" + discount);
		double tax = price * 0.05;
		tax -= discount;
		return tax;
	}
	
	@Override
	public String toString() {
		String display;
		display = super.toString() + "\nGas mileage: " + milesPerGallon + " MPG";
		if (discountApplied) {
			JOptionPane.showMessageDialog(null, "***$" + discount + " DISCOUNT! Vehicle gas mileage over 40 MPG***", "DISCOUNT!", JOptionPane.ERROR_MESSAGE);
		}
		return display;
	}

}
