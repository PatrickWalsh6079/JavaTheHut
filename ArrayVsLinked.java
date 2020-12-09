import java.util.ArrayList;
import java.util.LinkedList;

public class ArrayVsLinked {

	public static void main(String[] args) {
		
		// create LinkedList object
		LinkedList<Integer> linky = new LinkedList<Integer>();
		// add elements to list
		linky.add(9);
		linky.add(8);
		linky.add(7);
		linky.add(6);
		linky.add(5);
		linky.add(4);
		linky.add(3);
		linky.add(2);
		linky.add(1);
		linky.addLast(0); // easy to add element to the end with addLast()

		System.out.println("LinkedList:");
		System.out.println(linky);
		System.out.println("\nLast element in LinkedList:");
		System.out.println(linky.getLast()); // easy yo find the last element in the list
		
		
		System.out.println();
		
		// create ArrayList object
		ArrayList<Integer> arrayee = new ArrayList<Integer>();
		// add elements to list
		arrayee.add(9);
		arrayee.add(8);
		arrayee.add(7);
		arrayee.add(6);
		arrayee.add(5);
		arrayee.add(4);
		arrayee.add(3);
		arrayee.add(2);
		arrayee.add(1);
		arrayee.add(arrayee.size(), 0); // to add an element to the end of the list, must specify add(index, element) 
		
		System.out.println("ArrayList:");
		System.out.println(arrayee);
		System.out.println("\nLast element in ArrayList:");
		System.out.println(arrayee.get(arrayee.size() - 1)); // have to specify get(index) to find the last item in the list
		
		
		
	}

}
