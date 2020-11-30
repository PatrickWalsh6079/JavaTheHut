/*
 * Filename: Rectangular.java
 * Author: Patrick Walsh
 * Date: 11/29/2020
 * Purpose: Creates Rectangular subclass that extends Shape class
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Rectangular extends Shape {


	private static final long serialVersionUID = 1L;

	Rectangular(Rectangle rect, Color shapeColor, boolean shapeSolid) {
		super(rect, shapeColor, shapeSolid);
		
	}

	@Override
	void draw(Graphics g) {
		setColor(g);
		int x = super.x;
		int y = super.y;
		int width = super.width;
		int height = super.height;
//		System.out.println("draw() in Rectangular");
		if (getSolid() == true) {
			g.fillRect(x, y, width, height);
		} else {
			g.drawRect(x, y, width, height);
		}
		
	}
	
} // end of Rectangular subclass