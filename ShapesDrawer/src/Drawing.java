/*
 * Filename: Drawing.java
 * Author: Patrick Walsh
 * Date: 11/29/2020
 * Purpose: Draws shape to Panel on GUI in Project3.java file
 */


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Drawing extends JPanel {


	private static final long serialVersionUID = 1L;
	private Shape currentShape;
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// draws the current shape on the Graphics object that is passed to it as a parameter.
		// It should also draw the number of shapes that have been created thus far in the upper left corner
		if (currentShape != null) {
			currentShape.draw(g);
			currentShape.setColor(g);
			
			// draw current number of shapes in top left corner of Shape Drawing
			g.setColor(Color.BLACK);
			g.drawString(String.valueOf(currentShape.getNoOfShapes()), 15, 35);
		}

//		System.out.println("paintComponent method working");
	}
	
	@Override
	public Dimension getPreferredSize() {
		// specifies the dimensions of the drawing panel as 200 pixels wide and 200 pixels high.
//		System.out.println("getPreferredSize method working");
		return new Dimension(200,200); // (width, height)
	}
	
	public void drawShape(Shape currentShape) throws OutsideBounds {
		// first checks whether the shape provided will completely fit within the panel.
		// If not, it throws an OutsideBoundsexception.
		// Otherwise, it saves the shape in the corresponding instance variable.
		// It then calls repaint to cause that shape to be drawn.
//		System.out.println("drawShape method working");
		try {
			String outMsg = "Shape Doesn't Fit in Drawing Space";
			if (currentShape.x + currentShape.width > 294 || currentShape.x < 2 || currentShape.y + currentShape.height > 294 || currentShape.y < 5) {
				throw new OutsideBounds(outMsg);
			
			} else {
				this.currentShape = currentShape;
				repaint();
			}
			
		} catch (Exception e2) {
		} 
		
		
	}

	
	
	
	
}
