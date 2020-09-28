/*
Filename: HeadPhone.java
Author: Patrick Walsh
Date: 9/27/2020
Purpose: This program creates a class of headphones that uses a combination
of constants, private data fields, and methods to use for headphones objects.
The program then tests the HeadPhone class by creating 3 objects
with various field values to show the class in action.
 */

// import color to use color class
import java.awt.Color;




public class HeadPhone {

    // constants for volume
    public static final int LOW = 1;
    public static final int MEDIUM = 2;
    public static final int HIGH = 3;
    
    // private data fields
    private int volume;
    private boolean pluggedIn;
    private String manufacturer;
    private Color headPhoneColor;
    private String headPhoneModel;
    
    // constructor
    public HeadPhone(int valVolume, boolean valPluggedIn, String valManufacturer, Color valHeadPhoneColor, String valHeadPhoneModel){
        this.volume = valVolume;
        this.pluggedIn = valPluggedIn;
        this.manufacturer = valManufacturer;
        this.headPhoneColor = valHeadPhoneColor;
        this.headPhoneModel = valHeadPhoneModel;
    }
    
    // default constructor (no arguments)
    public HeadPhone(){
        volume = MEDIUM;
        pluggedIn = false;
    }
    
    // getter methods
    public int getVolume(){
        return this.volume;
    }
    public boolean getPluggedIn(){
        return this.pluggedIn;
    }
    public String getManufacturer(){
        return this.manufacturer;
    }
    public Color getColor(){
        return this.headPhoneColor;
    }
    public String getHeadPhoneModel(){
        return this.headPhoneModel;
    }
    
    // setter methods
    public void setVolume(int valVolume){
        volume = valVolume;
    }
    public void setPluggedIn(boolean valPluggedIn){
        pluggedIn = valPluggedIn;
    }
    public void setManufacturer(String valManufacturer){
        manufacturer = valManufacturer;
    }
    public void setColor(Color valHeadPhoneColor){
        headPhoneColor = valHeadPhoneColor;
    }
    public void setHeadPhoneModel(String valHeadPhoneModel){
        headPhoneModel = valHeadPhoneModel;
    }
    
    // toString() method
    public String toString(){
        String msg = "Volume: " + this.volume +
                "\nPlugged in? " + this.pluggedIn +
                "\nManufacturer: " + this.manufacturer +
                "\nColor: " + this.headPhoneColor +
                "\nModel: " + this.headPhoneModel;
        return msg;
    }
    
    // changeVolume() method to modify volume
    public int changeVolume(int volume){
        this.volume = volume;
        return volume;
    }
    
    
    // main method
    public static void main(String args[]) {
        
        // create 3 HeadPhone objects
        HeadPhone myHeadPhones = new HeadPhone(HeadPhone.HIGH, true, "Honda", Color.GREEN, "Selenium 3");
        
        
                
        // display object values with toString method
        System.out.println(myHeadPhones.toString());
        
        // use the changeVolume() method to modify the volume of the object
        myHeadPhones.changeVolume(HeadPhone.LOW);
        // use the getVolume() method to display the new volume
        String displayVolume = "\nThe new volume is: " + myHeadPhones.getVolume();
        System.out.println(displayVolume);
        
        
        
    } // end of main
}
