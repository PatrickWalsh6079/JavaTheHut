/*
 * Filename:
 * Author:
 * Date:
 * Purpose: Creates GUI for user to enter vehicle information. Program
 * calculates sales tax and discounts applied depending on user input.
 */


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;



public class Project2 implements ActionListener {

	private static Font labelFont;
	
	// top section of pane elements
	private static JLabel labelMakeModel;
	private static JTextField textMakeModel;
	private static JLabel labelSalesPrice;
	private static JTextField textSalesPrice;
	
	// middle section of pane elements
	private static JRadioButton buttonHybrid;
	private static JRadioButton buttonElectric;
	private static JRadioButton buttonOther;
	private static ButtonGroup radioButtons;
	private static JLabel labelMiles;
	private static JTextField textMiles;
	private static JLabel labelWeight;
	private static JTextField textWeight;
	
	// bottom section of pane elements
	private static JButton buttonCompute;
	private static JButton buttonDisplayReport;
	private static JTextField textSalesTax;
	private static JButton buttonClear;
	
	// initialize class Objects
	Automobile[] carsOther = new Automobile[5];
	Electric[] carsElectric = new Electric[5];
	Hybrid[] carsHybrid = new Hybrid[5];
	
	// initialize count and report variables
	private static int count = 0;
	private static String report;
	
	
	
	
	public static void main(String[] args) {
		
		// bring up GUI
		GUI();
		
//		Automobile[] cars;
//		// create Automobile object
//		Automobile car1 = new Automobile("Fiat", "500c", 14303);
//		System.out.println(car1.toString());
//		
//		System.out.println("");
//		
//		// create Electric object
//		Electric car2 = new Electric("Tesla", "Model S", 78899, 2500);
//		System.out.println(car2.toString());
//		
//		System.out.println("");
//		
//		// create Hybrid object
//		Hybrid car3 = new Hybrid("Toyota", "Prius", 29998, 41);
//		System.out.println(car3.toString());
		

	} // end of main
	
	
	
public static void GUI() {
		
		JFrame frame = new JFrame();
		JPanel panelTop = new JPanel();
		JPanel panelMiddle = new JPanel();
		JPanel panelBottom = new JPanel();
		JPanel panelLeft = new JPanel();
		JPanel panelRight = new JPanel();
		
		
		// set font for text
		labelFont = new Font("New Currier", Font.BOLD, 12);

		// build out frame
		frame.setSize(450, 320); // (width, height)
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Automobile Sales Tax Calculator");
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		// frame layout BorderLayout()
		frame.setLayout(new BorderLayout(10,10)); // space in between panels on frame (horizontal, vertical)
		
		// panel layout GridLayout()
		panelTop.setLayout(new GridLayout(2, 2, 1, 1)); // (rows, columns, space on sides, space on top and bottom)
		panelMiddle.setLayout(new GridLayout(3, 3, 1, 1)); // (rows, columns, space on sides, space on top and bottom)
		panelBottom.setLayout(new GridLayout(2, 2, 5, 5)); // (rows, columns, space on sides, space on top and bottom)
		
		
		// set panel sizes
		panelTop.setPreferredSize(new Dimension(20,70)); // (width, height)
		panelMiddle.setPreferredSize(new Dimension(20,70)); // (width, height)
		panelBottom.setPreferredSize(new Dimension(20,70)); // (width, height)
		panelLeft.setPreferredSize(new Dimension(0,70)); // (width, height)
		panelRight.setPreferredSize(new Dimension(0,70)); // (width, height)
		
		// set borders around panels
		panelTop.setBorder(new EmptyBorder(5, 35, 5, 35)); // (top, left, bottom, right)
		panelMiddle.setBorder(new EmptyBorder(5, 0, 5, 0)); // (top, left, bottom, right)
		panelMiddle.setBorder(BorderFactory.createTitledBorder("Automobile Type"));
		panelBottom.setBorder(new EmptyBorder(5, 35, 5, 35)); // (top, left, bottom, right)
		
		
		
		// Make + Model and Sales Price fields
		labelMakeModel = new JLabel("Make and Model");
		labelMakeModel.setHorizontalAlignment(SwingConstants.CENTER); // centers the label
		labelMakeModel.setFont(labelFont);
		panelTop.add(labelMakeModel);
	
		textMakeModel = new JTextField();
		panelTop.add(textMakeModel);
		
		labelSalesPrice = new JLabel("Sales Price");
		labelSalesPrice.setHorizontalAlignment(SwingConstants.CENTER); // centers the label
		labelSalesPrice.setFont(labelFont);
		panelTop.add(labelSalesPrice);
		
		textSalesPrice = new JTextField();
		panelTop.add(textSalesPrice);

		
		
		
		// Radio buttons
		buttonHybrid = new JRadioButton("Hybrid");
		buttonHybrid.setFont(labelFont);
		panelMiddle.add(buttonHybrid);
		buttonHybrid.addActionListener(new Project2());
	
		
		// Miles per Gallon + Weight in Pounds
		labelMiles = new JLabel("Miles per Gallon");
		labelMiles.setFont(labelFont);
		panelMiddle.add(labelMiles);
		
		textMiles = new JTextField();
		panelMiddle.add(textMiles);
		
		
		buttonElectric = new JRadioButton("Electric");
		buttonElectric.setFont(labelFont);
		panelMiddle.add(buttonElectric);
		buttonElectric.addActionListener(new Project2());
	
		
		labelWeight = new JLabel("Weight in Pounds");
		labelWeight.setFont(labelFont);
		panelMiddle.add(labelWeight);
//	
		textWeight = new JTextField();
		panelMiddle.add(textWeight);
//	
	
	
		buttonOther = new JRadioButton("Other");
		buttonOther.setFont(labelFont);
		buttonOther.setSelected(true);
		panelMiddle.add(buttonOther);
		buttonOther.addActionListener(new Project2());
	
//		// group buttons so that only one is clicked at a time
		radioButtons = new ButtonGroup();
		radioButtons.add(buttonHybrid);
		radioButtons.add(buttonElectric);
		radioButtons.add(buttonOther);
		

		
		
		
		
		// Three buttons and Sales Tax field on bottom of pane
		buttonCompute = new JButton("Compute Sales Tax");
		buttonCompute.setFont(labelFont);
		panelBottom.add(buttonCompute, BorderLayout.CENTER);
		buttonCompute.addActionListener(new Project2());
		
		textSalesTax = new JTextField();
		textSalesTax.setEditable(false);
		panelBottom.add(textSalesTax);
		
		buttonClear = new JButton("Clear Fields");
		buttonClear.setFont(labelFont);
		panelBottom.add(buttonClear);
		buttonClear.addActionListener(new Project2());
		
		buttonDisplayReport = new JButton("Display Report");
		buttonDisplayReport.setFont(labelFont);
		panelBottom.add(buttonDisplayReport);
		buttonDisplayReport.addActionListener(new Project2());
		

		// add panels to frame
		frame.add(panelTop, BorderLayout.NORTH);
		frame.add(panelMiddle, BorderLayout.CENTER);
		frame.add(panelBottom, BorderLayout.SOUTH);
		frame.add(panelLeft, BorderLayout.WEST);
		frame.add(panelRight, BorderLayout.EAST);
		

		frame.setVisible(true); // set to true to see GUI
	
		
	}
	



	@Override
	public void actionPerformed(ActionEvent e) {
		

		// get current values of text field boxes
		String inputMakeModel = textMakeModel.getText();
		String[] arrayInputMakeModel = inputMakeModel.trim().split("\\s+");
		String inputPrice = textSalesPrice.getText();
		String inputMiles = textMiles.getText();
		String inputWeight = textWeight.getText();
		
		// when user hits Compute button
		if (e.getSource() == buttonCompute) {
			
			// initialize price, weight, and miles
			int intPrice = 0;
			int intWeight = 0;
			int intMiles = 0;
			
			try {
				// convert values of text field boxes to Object input-readable format
				String make = arrayInputMakeModel[0];
				String model = arrayInputMakeModel[1];
				intPrice = Integer.parseInt(inputPrice);
				
				// if user has already created 5 car objects, start over the count
				if (count > 4) {
					count = 0;
				}
				
				// compute for electric car
				if (buttonElectric.isSelected()) {
					intWeight = Integer.parseInt(inputWeight);
					carsElectric[count] = new Electric(make, model, intPrice, intWeight);
					report = carsElectric[count].toString();
					textSalesTax.setEditable(true);
					textSalesTax.setText("" + String.format("%.2f", carsElectric[count].salesTax(intPrice)));
					textSalesTax.setEditable(false);
					
				}
				// compute for hybrid car
				else if (buttonHybrid.isSelected()) {
					intMiles = Integer.parseInt(inputMiles);
					carsHybrid[count] = new Hybrid(make, model, intPrice, intMiles);
					report = carsHybrid[count].toString();
					textSalesTax.setEditable(true);
					textSalesTax.setText("" + String.format("%.2f", carsHybrid[count].salesTax(intPrice)));
					textSalesTax.setEditable(false);
				}
				// compute for other car
				else {
					carsOther[count] = new Automobile(make, model, intPrice);
					report = carsOther[count].toString();
					textSalesTax.setEditable(true);
					textSalesTax.setText("" + String.format("%.2f", carsOther[count].salesTax(intPrice)));
					textSalesTax.setEditable(false);
				}
				count++;
//				System.out.println("count: " + count);
				
			} catch (IndexOutOfBoundsException ex1) {
//				if Make and Model were not entered
				JOptionPane.showMessageDialog(null, "Please enter vehicle MAKE and MODEL as a String with a space.", "Must enter Make and Model!", JOptionPane.ERROR_MESSAGE);
			
			} catch (NumberFormatException ex2) {
				// if Sales Price is blank or a non-int value
				if (inputPrice.equals("") || intPrice == 0) {
					JOptionPane.showMessageDialog(null, "Please enter an integer for the Sales Price", "Must enter Sales Price!", JOptionPane.ERROR_MESSAGE);
				// if Hybrid is selected and Miles per Gallon is blank or a non-int value
				} else if (buttonHybrid.isSelected() && (inputMiles.equals("") || intMiles == 0)) {
					JOptionPane.showMessageDialog(null, "Please enter an integer for the Miles per Gallon", "Must enter Miles per Gallon!", JOptionPane.ERROR_MESSAGE);
				// if Electric is selected and Weight in Pounds is blank or a non-int value
				} else if (buttonElectric.isSelected() && (inputWeight.equals("") || intWeight == 0)) {
					JOptionPane.showMessageDialog(null, "Please enter an integer for the Weight in Pounds", "Must enter Vehicle Weight!", JOptionPane.ERROR_MESSAGE);
				}
				
			} // end of try, catch block

		} 
		// when user hits Display Report button
		else if (e.getSource() == buttonDisplayReport) {
//			System.out.println("Display report!");
			System.out.println("\n" + report + "\n");
		}
		// when user hits Clear button
		else if (e.getSource() == buttonClear) {
//			System.out.println("Clear!");
			textMakeModel.setText("");
			textSalesPrice.setText("");
			textMiles.setText("");
			textWeight.setText("");
			buttonOther.setSelected(true);
			textSalesTax.setEditable(true);
			textSalesTax.setText("");
			textSalesTax.setEditable(false);
		}
//		else if (e.getSource() == buttonHybrid) {
//			System.out.println("Hybrid!");
//		}
//		else if (e.getSource() == buttonElectric) {
//			System.out.println("Electric!");
//		}
//		else if (e.getSource() == buttonOther) {
//			System.out.println("Other button!");
//		}
		
	
	}


}
