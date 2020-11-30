/*
 * Filename: OutsideBounds.java
 * Author: Patrick Walsh
 * Date: 11/29/2020
 * Purpose: Creates exception handling that throws a JOptionPane
 */


import javax.swing.JOptionPane;

public class OutsideBounds extends Exception {

	private static final long serialVersionUID = 1L;

	public OutsideBounds(String outMsg) {
		JOptionPane.showMessageDialog(null, outMsg, "Shape Does Not Fit!", JOptionPane.ERROR_MESSAGE);
		Shape.numShapes--;
	}
	
}
