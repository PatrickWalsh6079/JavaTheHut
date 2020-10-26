
public class Main {

	public static void main(String[] args) {
		
		Animal defaultAnimal = new Animal();
		System.out.println("By default, every Animal object has fur = " + defaultAnimal.hasFur);
		System.out.println("By default, every Animal object has " + defaultAnimal.numLegs + " legs.");
		
		System.out.println("\n");
		
		Cat myCat = new Cat("Khaleesi");
		System.out.println(myCat.name);
		System.out.println("Has fur? " + myCat.hasFur);
		System.out.println("Number of legs? " + myCat.numLegs);
		
		System.out.println("\n");
		
		Dog myDog = new Dog("Bella", 3, false);
		System.out.println(myDog.name);
		System.out.println("Has fur? " + myDog.hasFur);
		System.out.println("Number of legs? " + myDog.numLegs);
		
		System.out.println("\n");
		
		// show how many animals were created, minus the defaultAnimal object
		System.out.println("Number of animals: " + (Animal.numAnimals-1));

	} // end of main method

}
