
public class Dog extends Animal {
	// inherits properties of Animal class
	String name;
	
	// 3 different constructors:
	// can define just name,
	// can define name and numLegs,
	// or can define name, numLegs, and hasFur
	public Dog(String name) {
		this.name = name;
	}
	public Dog(String name, int numLegs) {
		this.name = name;
		this.numLegs = numLegs;
	}
	public Dog(String name, int numLegs, boolean hasFur) {
		this.name = name;
		this.numLegs = numLegs;
		this.hasFur = hasFur;
	}
	
}
