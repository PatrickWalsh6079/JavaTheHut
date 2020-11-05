
public class ExceptPropExample {
		
	public static void main(String[] args) {
		
		// try, catch statement to attempt to call test1() method
		try {
			System.out.println("main() running...");
			test1();
		} catch (Exception e) {
			// print error message if exception occurs
			System.out.println("Exception message: " + e.getMessage());
		}
	
	} // end of main method
	
	// test1() calls test2()
	public static void test1() {
		System.out.println("test1() running...");
		test2();
	}
	// test2() calls test3()
	public static void test2() {
		System.out.println("test2() running...");
		test3();
	}
	//test3() creates array and prints out a value from array
	public static void test3() {
		System.out.println("test3() running...");
		int[] numbers = {1,2,3};
		System.out.println(numbers[5]);
	}
	

}
