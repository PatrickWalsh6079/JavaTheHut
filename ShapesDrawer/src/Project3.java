/*
 * Filename: Project3.java
 * Author: Patrick Walsh
 * Date: 11/29/2020
 * Purpose: Contains main method, generates GUI for user to create shapes on window.
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class Project3 implements ActionListener {
	
	private static final int WIDTH = 600;
	private static final int HEIGHT = 400;
	
	private Shape currentShape;
	
	private JFrame window;
	private Drawing drawPanel;
	private JPanel choicesPanel;
	private JPanel buttonPanel;
	
	private JLabel labelShape;
	private JLabel labelFill;
	private JLabel labelColor;
	private JLabel labelWidth;
	private JLabel labelHeight;
	private JLabel labelX;
	private JLabel labelY;
	
	private JComboBox<String> comboShape;
	private JComboBox<String> comboFill;
	private JComboBox<String> comboColor;
	
	private String[] shapeChoices = {"Oval", "Rectangle"};
	private String fillChoices[] = {"Solid", "Hollow"};
	private String[] colorChoices = {"Black", "Red", "Orange", "Yellow", "Green", "Blue", "Magenta"};
	private Color[] colors = {Color.BLACK, Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.MAGENTA};
	
	private JTextField textWidth;
	private JTextField textHeight;
	private JTextField textX;
	private JTextField textY;
	
	private JButton drawButton;
	
	
	
	public Project3() {
		// create window frame
		window = new JFrame("Geometric Drawing");
		window.setSize(WIDTH, HEIGHT);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setLocationRelativeTo(null); // makes window start in middle of screen
		window.setLayout(new BorderLayout(5, 5)); // space in between panels on frame (horizontal, vertical)
		
		// create panels for window frame
		drawPanel = new Drawing(); // drawing panel
		choicesPanel = new JPanel(); // shape options panel
		buttonPanel = new JPanel(); // shape options panel
		
		// panel layout and sizes
		choicesPanel.setLayout(new GridLayout(7, 2, 1, 1)); // (rows, columns, space on sides, space on top and bottom)
		choicesPanel.setPreferredSize(new Dimension(280,200)); // (width, height)
		buttonPanel.setPreferredSize(new Dimension(WIDTH, 60)); // (width, height)
		
//		choicesPanel.setBackground(Color.RED);
//		buttonPanel.setBackground(Color.GREEN);
		
		// give panels borders
		drawPanel.setBorder(new EmptyBorder(5, 10, 5, 50)); // (top, left, bottom, right)
		choicesPanel.setBorder(new EmptyBorder(5, 20, 5, 10)); // (top, left, bottom, right)
		drawPanel.setBorder(new TitledBorder("Shape Drawing"));
		
		// add panels to frame window
		window.add(choicesPanel, BorderLayout.WEST);
		window.add(drawPanel, BorderLayout.CENTER);
		window.add(buttonPanel, BorderLayout.SOUTH);
		
		
		
		
		// Shape Type
		labelShape = new JLabel();
		labelShape.setText("Shape Type");
		choicesPanel.add(labelShape);
		
		comboShape = new JComboBox<String>(shapeChoices);
		choicesPanel.add(comboShape);
		comboShape.addActionListener(this);
		
		// Fill Type
		labelFill = new JLabel();
		labelFill.setText("Fill Type");
		choicesPanel.add(labelFill);
		
		comboFill = new JComboBox<String>(fillChoices);
		choicesPanel.add(comboFill);
		comboFill.addActionListener(this);
		
		// Color
		labelColor = new JLabel();
		labelColor.setText("Color");
		choicesPanel.add(labelColor);
		
		comboColor = new JComboBox<String>(colorChoices);
		choicesPanel.add(comboColor);
		comboColor.addActionListener(this);
		
		// Width
		labelWidth = new JLabel();
		labelWidth.setText("Width");
		choicesPanel.add(labelWidth);
		
		textWidth = new JTextField();
		choicesPanel.add(textWidth);
		textWidth.addActionListener(this);

		// Height
		labelHeight = new JLabel();
		labelHeight.setText("Height");
		choicesPanel.add(labelHeight);
		
		textHeight = new JTextField();
		choicesPanel.add(textHeight);
		textHeight.addActionListener(this);
		
		// X coordinates
		labelX = new JLabel();
		labelX.setText("X coordinate");
		choicesPanel.add(labelX);
		
		textX = new JTextField();
		choicesPanel.add(textX);
		textX.addActionListener(this);
		
		// Y coordinates
		labelY = new JLabel();
		labelY.setText("Y coordinate");
		choicesPanel.add(labelY);
		
		textY = new JTextField();
		choicesPanel.add(textY);
		textY.addActionListener(this);
		
		
		
		// Draw button
		drawButton = new JButton();
		drawButton.setText("Draw");
		buttonPanel.add(drawButton, BorderLayout.CENTER);
		drawButton.addActionListener(this);
		
		window.setVisible(true);
		
		
		
	}
	
	

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == drawButton) {
			
			try {
				// check to see if shape is solid or hollow
				// convert to boolean
				boolean isSolid; 
				if ((String.valueOf(comboFill.getSelectedItem()).equals("Solid"))) {
					isSolid = true;
				} else {
					isSolid = false;
				}
				// get int values of x, y, width, and height text boxes
				int x = Integer.parseInt(textX.getText());
				int y = Integer.parseInt(textY.getText());
				int width = Integer.parseInt(textWidth.getText());
				int height = Integer.parseInt(textHeight.getText());
			
			
			
				// check if shape is an Oval or Rectangular object
				if (comboShape.getSelectedItem() == "Oval") {
					// Rectangle(x, y, width, height)
					Shape ovalShape = new Oval(new Rectangle(x, y, width, height), colors[comboColor.getSelectedIndex()], isSolid);
					currentShape = ovalShape;

				} else if (comboShape.getSelectedItem() == "Rectangle") {
					Shape rectShape = new Rectangular(new Rectangle(x, y, width, height), colors[comboColor.getSelectedIndex()], isSolid);
					currentShape = rectShape;

				}
				// draw shape onto panel
				drawPanel.drawShape(currentShape);
				
			} catch (NumberFormatException eMsg) {
				JOptionPane.showMessageDialog(null,"Please enter integer values in the text boxes!\n\ngetMessage(): " + eMsg.getMessage(), "Must enter Integers!", JOptionPane.ERROR_MESSAGE);
			} catch (OutsideBounds e1) {
				e1.printStackTrace();
			} 
			
			
			

		} // end of main if 

		
		
	} // end of actionPerformed()

	
	
	
	
	
	
	public static void main(String[] args) {
		
		new Project3();

	}







}
