
/*
 * Filename: Property.java
 * Author: Patrick Walsh
 * Date: 12/9/2020
 * Purpose: Class which specifies Property object with
 * variables for address, number of bedrooms, square footage,
 * price, and its sales status.
 * 
 */

interface StateChangeable {
	void changeState(Status propertyStatus);

}

enum Status {
	FOR_SALE, UNDER_CONTRACT, SOLD;
}

public class Property<T extends Enum<T>> implements StateChangeable {
	
	
	
	// instance variables:
	private String propertyAddress;
	private int numBedrooms;
	private int squareFeet;
	private int price;
	private Status propertyStatus;
	
	
	
	// constructor
	public Property (String propertyAddress, int numBedrooms, int squareFeet, int price){
		this.propertyAddress = propertyAddress;
		this.numBedrooms = numBedrooms;
		this.squareFeet = squareFeet;
		this.price = price;
		propertyStatus = Status.FOR_SALE;
	}
	
	
	// two methods:
	public void changeState(Status newStatus) {

		propertyStatus = newStatus;
	}
	
	@Override
	public String toString() {
		String message;
		message = "Address: " + propertyAddress + "\nNumber of Bedrooms: " + numBedrooms + "\nSquare Footage: " + squareFeet + "\nPrice: $" + price + "\nStatus: " + propertyStatus;
		return message;
	}



	
	
}
