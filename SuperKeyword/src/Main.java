
public class Main {

	public static void main(String[] args) {
		
		// create Computer object and call toString() method
		Computer c = new Computer(16, 3.8);
		System.out.println("Computer (superclass):");
		System.out.println(c.toString());
		
		// create Windows object and call toString() method
		Windows w = new Windows(8, 3.6, 16.7);
		System.out.println(w.toString());

	}

}
