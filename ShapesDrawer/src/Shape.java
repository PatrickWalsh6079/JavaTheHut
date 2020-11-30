/*
 * Filename: Shape.java
 * Author: Patrick Walsh
 * Date: 11/29/2020
 * Purpose: Creates abstract Shape class
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

abstract class Shape extends Rectangle {

	private static final long serialVersionUID = 1L;
	private Color shapeColor;
	private boolean shapeSolid;
	public static int numShapes;
	
	Shape (Rectangle rect, Color shapeColor, boolean shapeSolid) {
		super(rect);
		this.shapeColor = shapeColor;
		this.shapeSolid = shapeSolid;
		numShapes++;
	}
	
	public void setColor(Graphics g) {
//		System.out.println("sets the color for the next draw operation to the color of the current shape");
		g.setColor(shapeColor);
	}
	
	public boolean getSolid() {
		return shapeSolid;
	}
	
	public int getNoOfShapes() {
		return numShapes;
	}
	
	abstract void draw(Graphics g);
	
} // end of abstract Shape class


