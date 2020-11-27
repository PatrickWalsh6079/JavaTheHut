
public class RecursionExample {
	
	// the Fibonacci sequence adds the values of two numbers,
	// then updates the value of the first number as the current
	// value of the second number, and the value of the second number
	// as the value of the sum of both numbers. See below:
	/*
	 * 0 + 1 = 1
	 * 1 + 1 = 2
	 * 1 + 2 = 3
	 * 2 + 3 = 5
	 * 3 + 5 = 8
	 */
	public static void fibonacci(int n1, int n2) {
		// base case ensures that method does not lead to an infinite loop
		if (n1 > 50) {
			System.out.println("Done!");
		} else {
			System.out.println(n1 + n2); // show current sum of n1 and n2	
			// recursive method calls itself within itself
			fibonacci(n2, n1 + n2); 
		}
			
	}
	
	public static void main(String[] args) {
		System.out.println("THE FIBONACCI SEQUENCE:\n");
		fibonacci(0, 1);

	}

}
