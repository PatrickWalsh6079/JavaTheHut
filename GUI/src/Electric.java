
/*
 * Filename: Electric.java
 * Author: Patrick Walsh
 * Date: 11/12/2020
 * Purpose: Creates Electric subclass of Automobile for GUI
 */

import javax.swing.JOptionPane;

public class Electric extends Automobile {
	
	
	private int weight;
	private boolean discountApplied = false;
	private int discount = 150;
	
	// constructor
	public Electric (String make, String model, int price, int weight) {
		super(make, model, price);
		this.weight = weight;
		
	}
	
	
	@Override
	public double salesTax(int price) {
		// Sales Tax is 5% of price, minus discount
		// Discount for electric vehicles is $150 for 3000 lbs or more and $200 for vehicles less than 3000 lbs
		if (weight < 3000) {
			discount = 200;
			discountApplied = true;
//			System.out.println("Discount applied!");
		}
		double tax = price * 0.05;
		tax -= discount;
		return tax;
	}
	
	@Override
	public String toString() {
		String display;
		display = super.toString() + "\nWeight: " + weight + " lbs.";
		if (discountApplied) {
			JOptionPane.showMessageDialog(null, "***$200 DISCOUNT! Vehicle under 3000 lbs***", "DISCOUNT!", JOptionPane.ERROR_MESSAGE);
		} 
		return display;
	}
	
	
}
