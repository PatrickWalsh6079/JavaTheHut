/*
Filename: StatesData.java
Author: Patrick Walsh
Date: 10/2/2020
Purpose: This program lets the user enter the name of a state
and returns the state bird and state flower.
*/

import java.util.Scanner;
import java.util.Arrays;



public class StatesData{

    private String stateName;
    private String stateBird;
    private String stateFlower;
    private String[][] stateInfo = new String[][]{ // 50 states, each array element with 3 entries (state, bird, flower).
        {"Alabama","Yellow-hammer","Camelia"},
        {"Alaska","Alaska Willow Ptarmigan","Forget-me-not"},
        {"Arizona","Coues Cactus Wren","Saguaro cactus blossom"},
        {"Arkansas","Mockingbird","Apple blossom"},
        {"California","California Valley Quail","California Poppy"},
        {"Colorado","Lark Bunting","Rocky Mountain Columbine"},
        {"Connecticut","American Robin","Mountain laurel"},
        {"Delaware","Blue Hen Chicken","Peach blossom"},
        {"Florida","Mockingbird","Orange blossom"},
        {"Georgia","Brown Thrasher","Cherokee rose"},
        {"Hawaii","Nene (Hawaiian Goose)","Pua aloalo"},
        {"Idaho","Mountain Bluebird","Syringa mock orange"},
        {"Illinois","Cardinal","Purple violet"},
        {"Indiana","Cardinal","Peony"},
        {"Iowa","Eastern Goldfinch","Wild prairie rose"},
        {"Kansas","Western Meadowlark","Sunflower"},
        {"Kentucky","Cardinal","Goldenrod"},
        {"Louisiana","Brown Pelican","Magnolia"},
        {"Maine","Chickadee","Eastern white pine tassel and cone"},
        {"Maryland","Baltimore Oriole","Black-eyed Susan"},
        {"Massachusetts","Chickadee","Mayflower"},
        {"Michigan","Robin Red Breast","Apple blossom"},
        {"Minnesota","Common Loon","Pink and white lady slipper"},
        {"Mississippi","Mockingbird","Magnolia"},
        {"Missouri","Bluebird","Hawthorn"},
        {"Montana","Western Meadowlark","Bitterroot"},
        {"Nebraska","Western Meadowlark","Goldenrod"},
        {"Nevada","Mountain Bluebird","Sagebrush"},
        {"New Hampshire","Purple Finch","Purple lilac"},
        {"New Jersey","Eastern Goldfinch","Violet"},
        {"New Mexico","Chaparral Bird (Roadrunner)","Yucca"},
        {"New York","Bluebird","Rose"},
        {"North Carolina","Cardinal","American Dogwood"},
        {"North Dakota","Western Meadowlark","Wild prairie rose"},
        {"Ohio","Cardinal","Scarlet Carnation"},
        {"Oklahoma","Scissor-tailed Flycatcher","Mistletoe"},
        {"Oregon","Western Meadowlark","Oregon grape"},
        {"Pennsylvania","Ruffed grouse","Mountain laurel"},
        {"Rhode Island","Rhode Island Red","Violet"},
        {"South Carolina","Carolina Wren","Yellow Jessamine"},
        {"South Dakota","Ring-necked Pheasant","Pasque flower"},
        {"Tennessee","Mockingbird","Iris"},
        {"Texas","Mockingbird","Texas bluebonnet"},
        {"Utah","California Gull","Sego lily"},
        {"Vermont","Hermit Thrush","Red clover"},
        {"Virginia","Cardinal","Flowering dogwood"},
        {"Washington","Willow Goldfinch","Coast rhododendron"},
        {"West Virginia","Cardinal","Rhododendron"},
        {"Wisconsin","Robin","Wood violet"},
        {"Wyoming","Western Meadowlark","Indian paintbrush"}
    };


    // constructor
    public StatesData(String name, String bird, String flower){
      this.stateName = name;
      this.stateBird = bird;
      this.stateFlower = flower;
    }

    // default constructor
    public StatesData(){
      stateName = "none";
      stateBird = "none";
      stateFlower = "none";
    }


    public int findState(String state) {

      // Use a for loop to check each element in 2D array (50 states in the 2D array)
      for (int i=0; i<stateInfo.length; i++){
        String checkName = stateInfo[i][0];
        String checkBird = stateInfo[i][1];
        String checkFlower = stateInfo[i][2];

        if (state.toLowerCase().trim().equals(checkName.toLowerCase().trim())){
          // IF true, then append state + bird + flower to a StringBuilder (say output).
          StringBuilder[] output = new StringBuilder[50];
          output[i] = new StringBuilder("");
          output[i].append(checkName).append("'s state bird is: ").append(checkBird).append("\nThe state flower is: ").append(checkFlower);
          System.out.println("\n");
          System.out.println(output[i]);

          // In addition, save state, bird and flower to the private data variables in class.
          this.stateName = checkName;
          this.stateBird = checkBird;
          this.stateFlower = checkFlower;
          break;
        }
        if (i==49){
          System.out.println("State not found!");
        }
      } // end of for loop

      return -1;

    } // end of findState



    // getter methods
    public String getName(){
      return stateName;
    }
    public String getBird(){
      return stateBird;
    }
    public String getFlower(){
      return stateFlower;
    }





    // MAIN METHOD
    public static void main(String[] args){

      // initialize variables
      String state = "";
      StringBuilder summary;
      summary = new StringBuilder("");

      // Use a while loop that runs until user enters "none"
      while (!state.equals("none")){
        // create Scanner object for user input
        Scanner input = new Scanner(System.in);
        System.out.println("\nPlease enter the name of a state (or enter 'none' to finish):");
        state = input.nextLine();

        // create class object and call findState method
        StatesData stateObject = new StatesData();
        stateObject.findState(state);


        // check to see if user has entered "none"
        if (state.equals("none")){
          System.out.println("\n***** Thank you! *****");
          System.out.println("Summary for each state, bird, and flower:\n");
          System.out.println(summary);
          System.out.println("\n***** Come again next time!!! *****\n");
        }

        // compile state info for summary at the end of program
        summary.append(stateObject.getName()).append(", ");
        summary.append(stateObject.getBird()).append(", ");
        summary.append(stateObject.getFlower()).append("\n");

      } // end of while


    } // end of main


} // end of class StatesData
