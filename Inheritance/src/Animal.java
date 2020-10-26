
public class Animal {
	

	int numLegs;
	boolean hasFur;
	static int numAnimals = 0;
	
	// constructor
	public Animal(int numLegs, boolean hasFur) {
		this.numLegs = numLegs;
		this.hasFur = hasFur;
	}
	
	// default constructor
	public Animal() {
		numLegs = 4;
		hasFur = true;
		numAnimals++;
	}

}
