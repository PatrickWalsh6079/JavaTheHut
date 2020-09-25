/*
File: ComputerClass.java
Author: Patrick Walsh
Date: 9/25/2020
Purpose: This program creates a class called ComputerClass with the following fields:
- OS (i.e. Windows, Mac, Chrome, or Linux)
- Software updated (a boolean)
- Processor (in GHz, i.e. 2.5 GHz)
- RAM (in GB, i.e. 16 GB)

The program comes with a standard computer (default contructor), but allows the
user to create additional computer objects and input their specs.
 */


// import Scanner to receive user input
import java.util.Scanner;


public class ComputerClass {

    
    // class variables
    private String operatingSystem;
    private boolean isUpToDate;
    private double processor;
    private double ram;
    private static int numComputers = 1; // static class variable is shared amongst all objects of this class
    
    // default constructor
    public ComputerClass(){
        operatingSystem = "Windows";
        isUpToDate = true;
        processor = 2.5;
        ram = 8.0;
    }
    
    // constructor
    public ComputerClass(String operatingSystem, boolean isUpToDate, double processor, double ram){
        this.operatingSystem = operatingSystem;
        this.isUpToDate = isUpToDate;
        this.processor = processor;
        this.ram = ram;
        numComputers++;
    }
    

    
    // toString method to display computer specs
    public String toString(){
        String specs = "OS: " + this.operatingSystem +
                "\nSoftware up-to-date? " + this.isUpToDate +
                "\nProcessor: " + this.processor + " GHz" +
                "\nRAM: " + this.ram + " GB" +
                "\nComputers in house: " + numComputers + "\n";
        return specs;
    }
    
    
    
    
    // MAIN METHOD
    public static void main(String args[]) {
        
        
        // create new object from computer class using default values
        ComputerClass sharedComputer = new ComputerClass();
        System.out.println("\n\n**************************************");
        System.out.println("\nSHARED COMPUTER:");
        System.out.println(sharedComputer.toString());
        
        
        
        // create Scanner object to receive user input
        Scanner input = new Scanner(System.in);
        
        // create new objects
        System.out.println("\nHow many additional computers would you like to add to the household??\nPlease type an integer:");
        int computersInHouse = input.nextInt();
        
        
        
        
        // create array to store objects that will be created
        ComputerClass[] newComputer = new ComputerClass[computersInHouse];
        
        
        // user chooses the number of computers enters their variable values
        for (int i=0; i<computersInHouse; i++){

            // user chooses the values for each computer object
            System.out.println("\nCOMPUTER # " + (i+1));
            System.out.println("What is the OS? Please enter Windows, Mac, Linux, or Chrome:");
            String operatingSystem = input.next();
            System.out.println("\nIs it up-to-date? Please enter true or false:");
            boolean isUpToDate = input.nextBoolean();
            System.out.println("\nWhat is its processor? Please enter a double:");
            double processor = input.nextDouble();
            System.out.println("\nHow much RAM does it have? Please enter a double:");
            double ram = input.nextDouble();
            // new object is created based on user inputs
            newComputer[i] = new ComputerClass(operatingSystem, isUpToDate, processor, ram);
            
        } // end of for loop
         
        
        
        // display all the values of the computer objects created
        System.out.println("\n\n**************************************");
        System.out.println("\nSHARED COMPUTER:");
        System.out.println(sharedComputer.toString());
        System.out.println("\nADDITIONAL USER-CREATED COMPUTERS:\n");
        for (int i=0; i<computersInHouse; i++){
            System.out.println("\nCOMPUTER # " + (i+1));
            System.out.println(newComputer[i].toString());       
        } // end of for loop
        System.out.println("\n**************************************");
        
        
        
        
    } // end of main method
}
