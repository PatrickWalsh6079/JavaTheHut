package com.mycompany.intelligentagentai;

import java.util.Scanner;


public class TurtleTanksSuggestionEnvironment {

    public static String[] breeds = {"Box Turtle", "Eastern Box Turtle", "Mud Turtle", "Diamondback", "Peninsula Cooter"};
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("What is the turtle breed:");
        System.out.println(" 0 - Box Turtle\n 1 - Eastern Box Turtle\n 2 - Mud Turtle\n 3 - Diamondback\n 4 - Peninsula Cooter");
        int turtleBreed = scan.nextInt();
	System.out.println("What is the turtle's age:");
        int turtleAge = scan.nextInt();
        
        Sensor s = new Sensor();
        int tankSize = s.preception(turtleBreed, turtleAge);
        System.out.println("The recommended tank size for a " + breeds[turtleBreed]+ " of age " +
                turtleAge + " is " + tankSize + " gallons.");
        
        scan.close();        
    }
    
}
