package package1;

public class Access1 {
	
	// access modifiers:
	// default, public, private, and protected
	
	
	// default access
	// accessible within the same package
	String defaultStr = "I am default";
	
	
	// public access
	// accessible in all packages
	public String publicStr = "I am public";
	
	
	//private access
	// accessible only in the same class (file)
	private String privateStr = "I am private";
	
	
	// protected access
	// accessible within the same package, or in another class with "extends" keyword
	protected String protectedStr = "I am protected";
	
	
}
