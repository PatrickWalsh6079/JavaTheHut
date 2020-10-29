
public class Computer {
	
	// private instance variables for the Computer's RAM and Processor
	private int ram;
	private double processor;
	
	// constructor that sets the instance variables
	public Computer(int ram, double processor) {
		this.ram = ram;
		this.processor = processor;
	}
	
	// getter methods for private variables
	public int getRam() {
		return ram;
	}
	public double getProcessor() {
		return processor;
	}
	
	// toString() method that displays the Computer RAM and Processor specs
	public String toString() {
		String displaySpecs;
		displaySpecs = "RAM: " + ram + "\nProcessor: " + processor + "\n";
		return displaySpecs;
	}
	
}
