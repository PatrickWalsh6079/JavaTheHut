package package2;

import package1.Access1;

public class Access4 extends Access1 {

	public static void main(String[] args) {
		
		// create object of Access1 class
		Access4 z = new Access4();
		
		// Access4 is in different class and different package as Access1, so
		// it has access to public
		// However, because Access4 extends from Access1, it can access protected by creating
		// its own object (i.e. Access4 rather than Access1)
		System.out.println(z.publicStr);
		System.out.println(z.protectedStr);

	}

}
