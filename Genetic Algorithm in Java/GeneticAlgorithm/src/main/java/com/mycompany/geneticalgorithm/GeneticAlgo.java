/*
 * Filename: GeneticAlgo.java
 * Author: Patrick Walsh
 * Date: 7/30/2021
 * Purpose: 
 */
package com.mycompany.geneticalgorithm;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author pwalsh
 */
public class GeneticAlgo {
    
    // Domain = 1 - 65,536
    final static int GENES_PER_INDIVIDUAL = 15;  // number of genes (in 0s and 1s) for each individual
    final static int INDIVIDUALS_PER_GENERATION = 50;  // number of individuals per generation
    final static float MUTATION_RATE = 0.015f;  // probability that a gene will mutate
    final static int NUMBER_OF_GENERATIONS = 150;  // number of generations
    
    public static String[] currentGeneration = new String[INDIVIDUALS_PER_GENERATION];  // the current generation
    public static String[] nextGeneration = new String[INDIVIDUALS_PER_GENERATION];  // the next generation
    
    public static Random rand = new Random();  // create random seed for algorithm
    public static Date d = new Date();  // generate random seed through current datetime
    public static java.text.DateFormat df = new java.text.SimpleDateFormat("ssHHMMmm");
    
    
    /*
    Convert genes (strings) into a domain value of numbers.
    */
    public static double individualToValue(String individual){
        // set a LowerBound and UpperBound for domain
        double lowerBound = 1.0f;
        double upperBound = 65536.0f;
//        double lowerBound = 0.0f;
//        double upperBound = 314.0f;
        double sumValues = 0;
        
        for (int i = 0; i < individual.length(); i++){  // loop through each character of individual
            if (individual.charAt(i) == '1'){
                sumValues = sumValues + java.lang.StrictMath.pow(2.0, i);
            }
        }
        
        double value = lowerBound + (sumValues/(java.lang.StrictMath.pow(2.0, GENES_PER_INDIVIDUAL) - 1)) * (upperBound - lowerBound);
        return value;
    }
    
    
    /*
    Create fitness function to produce solutions to problem.
    */
    public static double fitness(String individual){
        // If the water-system-size is less than 1,000 kiloliters the health is 0.0.  [It is just too small]
        // If the water-system-size is more than 10,000 kiloliters the health is 0.5.  [It is just too large.  There are too many big fish that can eat the eggs.]
        // If the water-system-size is between 1,000 and 10,000 kiloliters:
        // Take the number of kiloliters and add 150.
        // Take that number and divide by 140.  That number is the health of that population.

        // value to be returned
        double solution;
        
//        solution = 100.0 * java.lang.StrictMath.sin((individualToValue(individual)/100.0));
        if (individualToValue(individual) < 1000.0){
            solution = 0.0;
        } else if (individualToValue(individual) > 10000.0){
            solution = 0.5;
        } else{
            solution = ((individualToValue(individual) + 150) / 140);
        }

        return solution;
    }
    
    
    /*
    Creates initial generation of random gene values
    */
    public static String[] createInitialGeneration(){
        String[] tempArray = new String[INDIVIDUALS_PER_GENERATION];
        // loop once for each individual needed
        for (int x = 0; x < INDIVIDUALS_PER_GENERATION; x++)
        {
            String temp = new String();
            // for for each gene needed.
            for (int y = 0; y < GENES_PER_INDIVIDUAL; y++)
            {
            	// randomly decide on 0 or 1
                if (rand.nextFloat() > 0.5)
                    temp = temp.concat("1");  // append 1 to individual
                else
                    temp = temp.concat("0");  // append 0 to individual
            }
            tempArray[x] = temp;  // add individual to array
        }
        return tempArray;  // return array
    }
    
    
    /*
    Print out the current generation to show results of random inputs.
    */
    public static void printGeneration(String[] generation )
    {
    	// loop through each individual in generation
        for (int x = 0; x < INDIVIDUALS_PER_GENERATION; x++)
        {
            String individualX = generation[x];  // get individual
            System.out.println("Individual " + (x + 1) + " " + individualX + " equals " + individualToValue(individualX) +
                " kiloliters of water and has fitness " + fitness(individualX));  // print it
        }
    }
    
    
    /*
    Select random individual weighted by their fitness.
    */
    public static String getIndividual(String[] generation, double totalFitness)
    {
        String tempString = new String(); // place holder for selected individual
        double fitnessNumber = rand.nextDouble() * totalFitness; // pick random # between 0 and total fitness
        int x = 0;  // index to array
          
        while (fitnessNumber >= 0.0)  // loop until fitness number is 0
        {
          tempString = generation[x];  // holds individual to return
          fitnessNumber = fitnessNumber - fitness(tempString);   // submit individuals fitness from fitness number
          x = x + 1;  // add 1 to array index
        }
            
        return tempString;  // return selected individual
    }
    
    
    /*
    Apply Selection and Crossover to Genetic Algorithm
    */
    public static double totalFitness(String[] generation)
    {
        double temp = 0.0f;   // temporary variable to hold fitness
        // loop through each individual
        for (int x = 0; x < INDIVIDUALS_PER_GENERATION; x++) 
        {
            temp = temp + fitness(generation[x]);  // add individual's fitness to temp variable
        }
        return temp;  // return temp variable.
    }
    
    
    
    // main class
    public static void main(String[] args) {
        // To enter gene values manually:
//        Scanner s = new Scanner(System.in);
//        System.out.println("Enter individual as set of 15 1s and/or 0s:\n");
//        String individualX = s.nextLine();
//        System.out.println("Individual " + individualX + " equals " + individualToValue(individualX));
//        System.out.println("Fitness = " + fitness(individualX));


        // To generate gene values randomly:
        rand.setSeed(Long.parseLong(df.format(d)));
        
        // create initial generation
        currentGeneration = createInitialGeneration();
        
        // loop for each generation
        for (int x = 0; x < NUMBER_OF_GENERATIONS; x++){
        	// print current generation
            System.out.println("\nGeneration " + x);
            printGeneration(currentGeneration);
            
            double totalFitness = totalFitness(currentGeneration);  // get the some of the fitnesses
            
            // loop for (number of individuals per generation)/2
            for (int y = 0; y < INDIVIDUALS_PER_GENERATION - 1; y = y + 2){
                // get two individuals based upon their fitness
                String individual1 = getIndividual(currentGeneration, totalFitness);
                String individual2 = getIndividual(currentGeneration, totalFitness);
                
                // select crossover point
                int crossoverPoint = rand.nextInt(GENES_PER_INDIVIDUAL - 2);
                // add two new individual to next generation
                nextGeneration[y] = individual1.substring(0, crossoverPoint) + individual2.substring(crossoverPoint, GENES_PER_INDIVIDUAL);
                nextGeneration[y + 1] = individual2.substring(0, crossoverPoint) + individual1.substring(crossoverPoint, GENES_PER_INDIVIDUAL);
            }  // end of for loop
            
            // mutation - check each gene for mutation
            for (int z = 0; z < INDIVIDUALS_PER_GENERATION; z++){ // loop through each individual
                for (int a = 0; a < GENES_PER_INDIVIDUAL; a++){  // loop through each gene
                    if (rand.nextDouble() <= MUTATION_RATE){ // mutation the gene
                        // change gene 1 to 0 and 0 to 1
                        if (nextGeneration[z].charAt(a) == '1') 
                            nextGeneration[z] = nextGeneration[z].substring(0, a) +
                                    '0' + nextGeneration[z].substring(a+1, GENES_PER_INDIVIDUAL);
                        else
                            nextGeneration[z] = nextGeneration[z].substring(0, a) +
                                    '1' + nextGeneration[z].substring(a+1, GENES_PER_INDIVIDUAL);
                    }
                }  // end of for loop
            }  // end of for loop
            
            currentGeneration = nextGeneration;  // the next generation becomes the current generation
            nextGeneration = new String[INDIVIDUALS_PER_GENERATION]; // create new next generation
        }  // end of for loop
        
    }  // end of main
    
}
