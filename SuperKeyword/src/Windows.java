
public class Windows extends Computer {
	
	double screenSize;
	
	public Windows(int ram, double processor, double screenSize) {
		super(ram, processor);
		this.screenSize = screenSize;
	}
	
	public String toString() {
		String displaySpecs;
		displaySpecs = "Windows computer:\n" + super.toString() + "Screen size: " + screenSize + " inches\n";
		return displaySpecs;
	}
}
