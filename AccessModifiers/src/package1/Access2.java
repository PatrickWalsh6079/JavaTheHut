package package1;

public class Access2 {

	public static void main(String[] args) {
		// create object of Access1 class
		Access1 x = new Access1();
		
		// Access2 is in different class but same package as Access1, so
		// it has access to default, protected, and public
		// Access2 does not have access to anything privatein Access1 since it is in a different class/file
		System.out.println(x.defaultStr);
		System.out.println(x.protectedStr);
		System.out.println(x.publicStr);
		
		

	}

}
