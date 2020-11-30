/*
 * Filename: Oval.java 
 * Author: Patrick Walsh
 * Date: 11/29/2020
 * Purpose: Creates Oval subclass that extends Shape class
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Oval extends Shape {


	private static final long serialVersionUID = 1L;

	Oval(Rectangle rect, Color shapeColor, boolean shapeSolid) {
		super(rect, shapeColor, shapeSolid);
		
	}

	@Override
	void draw(Graphics g) {
		setColor(g);
		int x = super.x;
		int y = super.y;
		int width = super.width;
		int height = super.height;
//		System.out.println("draw() in Oval");
		if (getSolid() == true) {
			g.fillOval(x, y, width, height);
		} else {
			g.drawOval(x, y, width, height);
		}
		
	}
	
} // end of Oval subclass