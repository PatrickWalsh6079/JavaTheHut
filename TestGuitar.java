/*
Author: Patrick Walsh
File name: TestGuitar.java
Class: CMIS 141
Date 9/14/2020
Purpose: This program creates an object from the Guitar class and prints out
values for the class's fields
*/

// import for using color field
import java.awt.Color;

class TestGuitar{
  public static void main(String[] args){


    // create object with Guitar class
    // TEST CASE 1 - uses default values
    // Guitar myGuitar = new Guitar();
    // TEST CASE 2
    // Guitar myGuitar = new Guitar(4, 34.1, "Kawasaki", Color.BLUE);
    // TEST CASE 3
    Guitar myGuitar = new Guitar(8, 25.7, "Stravinski", Color.YELLOW);



    // call Movie methods
    // TEST CASE 1
    System.out.println("");
    System.out.println("----- TEST CASE -----");
    System.out.println(myGuitar.toString());
    System.out.println("getNumStrings: " + myGuitar.getNumStrings());
    System.out.println("getGuitarLength: " + myGuitar.getGuitarLength());
    System.out.println("getGuitarManufacturer: " + myGuitar.getGuitarManufacturer());
    System.out.println("getGuitarColor: " + myGuitar.getGuitarColor());
    System.out.println("playGuitar(): " + myGuitar.playGuitar());
    System.out.println("----- END OF TEST CASE -----");
    System.out.println("");



  } // end of main
}
