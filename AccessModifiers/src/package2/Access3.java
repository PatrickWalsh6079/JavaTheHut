package package2;

import package1.Access1;

public class Access3 {

	public static void main(String[] args) {

		// create object of Access1 class
		Access1 y = new Access1();
		
		// Access3 is in different class and different package as Access1, so
		// it only has access to public
		System.out.println(y.publicStr);
		

	}

}
