/**
 * Hello world program in Java. Checks value of variable.
 */
 
public class HelloJava {
	public static void main(String[] args) {
    	System.out.println("Hello in Java from AWS Cloud9!");
    	
    	String course = "SDEV325";  // name of course
    	
    	System.out.println("\nExpected course: SDEV325");
    	System.out.println("Actual course: " + course);
    	
    	// check if in the right course
    	if (course.equals("SDEV325")){
    		System.out.println("Congrats! You are in the right course!");
    	} else {
    		System.out.println("Sorry! You are not in the right course.");
    	}
    	
    	
	} // end of main
}