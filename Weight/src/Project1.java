/*
 * Filename: Project1.java
 *  Author: Patrick Walsh
 *  Date: 11/3/2020
 *  Purpose: Program contains main method to run Weight class, as well as running
 *  Project1 class to read the contents of file (chosen by user at runtime) and
 *  displaying the smallest weight in file, largest weight in file, and average weight.
 */

// import necessary libraries
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;


public class Project1 {

	// method checks in the weights file and finds the smallest weight
	private static int findMinimum(int[] arrayWeights, int count) {
		int smallestWeight = arrayWeights[0];
		for (int i=0; i<count; i++) {
			if (arrayWeights[i] < smallestWeight) {
				smallestWeight = arrayWeights[i];
			}
		}
		System.out.println("The smallest weight in the file is: " + smallestWeight + " oz");
		return smallestWeight;
	}
	
	// method checks in the weights file and finds the largest weight
	private static int findMaximum(int[] arrayWeights, int count) {
		int largestWeight = arrayWeights[0];
		for (int i=0; i<count; i++) {
			if (arrayWeights[i] > largestWeight) {
				largestWeight = arrayWeights[i];
			}
		}
		System.out.println("The largest weight in the file is: " + largestWeight + " oz");
		return largestWeight;
	}
	
	// method checks in the weights file and finds the average weight of all weights present
	private static double findAverage(int[] arrayWeights) {
		double averageWeight = 0;
		for (int i=0; i<arrayWeights.length; i++) {
			averageWeight += arrayWeights[i];
		}
		averageWeight = averageWeight / arrayWeights.length;
		System.out.println("The average weight in the file is: " + averageWeight + " oz");
		return averageWeight;
	}
	
	

	
	// MAIN METHOD
	public static void main(String[] args) {
		
		
		// TEST WEIGHT CLASS:
		System.out.println("***************************************");
		System.out.println("******** TESTING WEIGHT CLASS ********\n");
		
		// create Weight object  parameters(int, double)
//		Weight w1 = new Weight(3, 14.54278);
//		System.out.println(w1);
//		Weight w2 = new Weight(6, 2.042147);
//		System.out.println(w2);
		Weight w3 = new Weight(423, 2.00521);
		System.out.println(w3);

		
		System.out.println("");
		
		// Test lessThan() method
		// parameter(double)
		System.out.println("lessthan()");
//		w1.lessThan(40.21);
//		w2.lessThan(65.243);
		w3.lessThan(25.1);


		
		System.out.println("");
		
		// Test addTo() method
		// parameter(double)
		System.out.println("addTo()");
//		w1.addTo(5.11);
//		w2.addTo(442.1);
		w3.addTo(32.0);

		
		System.out.println("");
		
		// Test divide() method
		// parameter(int)
		System.out.println("divide()");
//		w1.divide(2);
//		w2.divide(5);
		w3.divide(3);

		
		
		System.out.println("\n***** END OF TESTING WEIGHT CLASS ******");
		System.out.println("***************************************");
		
		
		

		
		
//		TEST PROJECT1 CLASS
		System.out.println("\n\n******** TESTING PROJECT1 CLASS*******");
		
        BufferedReader inputStream = null;

        String fileLine;
        try {
        	// opens JFileChooser box at Desktop
        	JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        	// opens JFileChooser box at path below:
//        	JFileChooser jfc = new JFileChooser("C:\\Users\\pwalsh\\eclipse-workspace\\Weight\\src");

            int returnValue = jfc.showOpenDialog(null);

            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = jfc.getSelectedFile();
                System.out.println("File:");
                System.out.println(selectedFile.getAbsolutePath() + "\n\n");
                String newFile = selectedFile.getAbsolutePath();
                inputStream = new BufferedReader(new FileReader(newFile));
            }

            // read contents of Weights.txt file
            int[] arrayWeights = new int[25];
            int count = 0;
            try { // check if file is more than 25 lines
	            while ((fileLine = inputStream.readLine()) != null) {
	//                System.out.println(fileLine);
	            	int ounceInt;
	            	ounceInt = Integer.parseInt(fileLine);
	            	arrayWeights[count] = ounceInt;
	                count++;
	                
	            }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("File IO exception" + e.getMessage());
                System.out.println("File is larger than 25 lines, terminating program!!!!");
                System.out.println("\n***** END OF TESTING PROJECT1 CLASS ******");
                System.out.println("***************************************");
                System.exit(0);
            } // end of checking if file is more than 25 lines
            
            
            
            // print out contents of weights array
//            for (int i=0; i<count; i++) {
//            	System.out.println(arrayWeights[i] + " oz");
//            }
//            
            
            
            // call findMinimum() method to see smallest weight from file
            // paramters(int[], int)      
            // the int[] is the array of weights from the file
            // the int is the number of weights in the file
            System.out.println("findMinimum()");
            Project1.findMinimum(arrayWeights, count);
            
            
            // call findMaximum() method to see largest weight from file
            // paramters(int[], int)      
            // the int[] is the array of weights from the file
            // the int is the number of weights in the file
            System.out.println("\nfindMaximum()");
            Project1.findMaximum(arrayWeights, count);
            
            
         // call findAverage() method to see average weight from file
            System.out.println("\nfindAverage()");
            Project1.findAverage(arrayWeights);    
            
            
    		
    		
        } catch (IOException io) {
            System.out.println("File IO exception" + io.getMessage());
        }finally {
        	System.out.println("\n***** END OF TESTING PROJECT1 CLASS ******");
        	System.out.println("***************************************");
            // Need another catch for closing 
            // the streams          
            try {               
                if (inputStream != null) {
                inputStream.close();
            }                
            } catch (IOException io) {
                System.out.println("Issue closing the Files" + io.getMessage());
            }
        
        }

    } // end of main
	
	
}
