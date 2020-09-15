/*
Author: Patrick Walsh
File name: Guitar.java
Class: CMIS 141
Date 9/14/2020
Purpose: This program creates a class called Guitar with fields for the guitar's number
of strings, length, manufacturer, and color. When run, the program will also generate
a set of 16 random notes of random duration, represented in string format.
*/

// import for using color field
import java.awt.Color;
// import for use of Random module
import java.util.Random;
// import for using Arrays
import java.util.Arrays;


public class Guitar{

  // private data fields
  private int numStrings; // default value = 6
  private double guitarLength; // default value = 28.2 inches
  private String guitarManufacturer; // default value = "Gibson"
  private Color guitarColor; // default value = Color.RED

  // class constructor
  public Guitar(int strings, double length, String manufacturer, Color color){
    numStrings = strings;
    guitarLength = length;
    guitarManufacturer = manufacturer;
    guitarColor = color;
  }

  // a "no-argument" constructor using the default values
  public Guitar(){
    numStrings = 6;
    guitarLength = 28.2;
    guitarManufacturer = "Gibson";
    guitarColor = Color.RED;
  }

  // getter methods for each data field
  public int getNumStrings(){
    return numStrings;
  }
  public double getGuitarLength(){
    return guitarLength;
  }
  public String getGuitarManufacturer(){
    return guitarManufacturer;
  }
  public Color getGuitarColor(){
    return guitarColor;
  }


  // method that displays the number of strings, length, manufacturer, and color in string format
  public String toString(){
    String str = "toString(): (numStrings = " + numStrings + ", Length = " + guitarLength + ", Manufacturer = " + guitarManufacturer + ", Color = " + guitarColor + ")";
    return str;
  }


  // method that returns a string of 16 randomly generated musical notes Letter(duration) - i.e. D(2)
  public String playGuitar(){

    // blank Array with 16 positions
    String[] play = {"","","","","","","","","","","","","","","",""};
    // loop through 16 times and add the randomly generated notes
    for (int i=0; i<16; i++){
      // start with random object
      Random random = new Random();
      // pick a random letter from chars
      String chars = "ABCDEFG";
      char c = chars.charAt(random.nextInt(chars.length()));
      String note = "" + c + "";
      // pick a random number from d
      String[] d = {"0.25", "0.5", "1", "2", "4"};
      int rand = new Random().nextInt(d.length);
      String duration = "" + d[rand] + "";

      // combine randomized letter and number and add it to previously blank array
      play[i] = note + "(" + duration + ")";

    }
    // display array as String
    String playNotes = "" + Arrays.toString(play) + "";
    return playNotes;
  }



}
