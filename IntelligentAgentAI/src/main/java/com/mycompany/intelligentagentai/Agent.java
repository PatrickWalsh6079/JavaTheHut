package com.mycompany.intelligentagentai;

// Table below represents the Agent logic. It takes in the turtle breed
// and age and determines the required tank size.
//Breed                 Age                Normal Turtle Size      Tank Size
//Box Turtle            Any                8 inches                100 gallons
//Eastern Box Turtle	Any                8 inches                80 gallons
//Mud Turtle            Any                5 inches                50 gallons
//Diamondback           0-15 years old	   Up to 5 inches          60 gallons
//Diamondback           Over 15 years old  8 inches                80 gallons
//Peninsula Cooter	Any                16 inches               160 gallons

public class Agent {
    public int suggestTankSize (int turtleBreed, int turtleAge)
    {
        // place agent logic here
        int tankSize = 8;
        
        try {
            switch (turtleBreed) {
                case 0:
//                    System.out.println("Box Turtle");
                    tankSize = 100;
                    break;
                case 1:
//                    System.out.println("Eastern Box Turtle");
                    tankSize = 80;
                    break;
                case 2:
//                    System.out.println("Mud Turtle");
                    tankSize = 50;
                    break;
                case 3:
//                    System.out.println("Diamondback");
                    if (turtleAge > 15){
                        tankSize = 80;
                    } else {
                        tankSize = 60;
                    }
                    break;
                case 4:
//                    System.out.println("Peninsula cooter");
                    tankSize = 160;
                    break;
                default:
                    System.out.println("Invalid selection! Must enter a number from the breed choices below:\n");
                    break;
            }
        } catch(Exception e) {
              //  Block of code to handle errors
              System.out.println(e);
        }

        return tankSize;
    }
}
