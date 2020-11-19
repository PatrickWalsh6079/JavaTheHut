
// interface creates the blueprint for a perfect date
interface PerfectDate {
	
	// abstract methods
	// you can use "abstract void methodName()" OR "void methodName()"
	// these methods are assumed to be abstract regardless.
	void dinner();
	void movie();
}

// this class implements the PerfectDate interface, defining what the methods do
class DateThisFriday implements PerfectDate {
	
	@Override
	public void dinner() {
		System.out.println("Pizza and beer!!");
	}
	@Override
	public void movie() {
		System.out.println("SciFi movie");
	}
		
}

//this is a second class implements the same PerfectDate interface, defining what the methods do
class DateTonight implements PerfectDate {
	
	@Override
	public void dinner() {
		System.out.println("Chinese takeout");
	}
	@Override
	public void movie() {
		System.out.println("Jackie Chan film!!!");
	}
	
}




// abstract classes
abstract class Computer {
	public void hasCPU() {
		System.out.println("This computer has a fast CPU!");
	}

}

class Windows extends Computer {
	String message = "This is a Windows";
}

class Mac extends Computer {
	String message = "This is a Mac";
}

public class InterfaceExample {
	
	
	public static void main(String[] args) {
		System.out.println("INTERFACES:\n");
		// create instance of DateThisFriday class
		PerfectDate date1 = new DateThisFriday();
		System.out.println("Date1 consists of: ");
		date1.dinner();
		date1.movie();
		
		System.out.println("");
		
		// create instance of DateTonight class
		PerfectDate date2 = new DateTonight();
		System.out.println("Date2 consists of: ");
		date2.dinner();
		date2.movie();
		
		
		System.out.println("\n\nABSTRACT CLASSES:\n");
		
		Windows c1 = new Windows();
		System.out.println(c1.message);
		c1.hasCPU();
		
		System.out.println("");
		
		Mac c2 = new Mac();
		System.out.println(c2.message);
		c2.hasCPU();
	}

}
