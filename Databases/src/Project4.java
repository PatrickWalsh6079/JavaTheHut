/*
 * Filename: Project4.java
 * Author: Patrick Walsh
 * Date: 12/9/2020
 * Purpose: Main program creates GUI where user can enter property info
 * and update a database with that info.
 * 
 */



import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TreeMap;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Project4 implements ActionListener {
	
	
	private static JPanel panel;
	private static JLabel labelTranNum;
	private static JTextField textTranNum;
	private static JLabel labelAddress;
	private static JTextField textAddress;
	private static JLabel labelBedrooms;
	private static JTextField textBedrooms;
	private static JLabel labelSquareFt;
	private static JTextField textSquareFt;
	private static JLabel labelPrice;
	private static JTextField textPrice;
	private static JButton buttonProcess;
	private static JComboBox<String> comboProcess;
	private String[] processChoices = {"Insert", "Delete", "Find"};
	private static JButton buttonStatus;
	private static JComboBox<String> comboStatus;
	private String[] statusChoices = {"FOR_SALE", "UNDER_CONTRACT", "SOLD"};
	private static Font labelFont;

	private TreeMap<Integer, Object> databaseProperties = new TreeMap<Integer, Object>();
	Property<Status> p1;
	

	
	public static void main(String[] args) {

		new Project4();
		

	} // end of main

	
	
	
	public Project4(){
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(450, 400);
		frame.setTitle("Real Estate Database");
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(7, 2, 10, 10)); // (rows, columns, space on sides, space on top and bottom)
		panel.setBorder(new EmptyBorder(15, 15, 15, 15)); // (top, left, bottom, right)
//		panel.setPreferredSize(new Dimension(20,70)); // (width, height)
		
		
		// set font for text
		labelFont = new Font("New Currier", Font.BOLD, 14);
		
		
		// Transaction No.
		labelTranNum = new JLabel("Transaction No:");
		labelTranNum.setHorizontalAlignment(SwingConstants.CENTER); // centers the label
		labelTranNum.setFont(labelFont);
		panel.add(labelTranNum);
		
		textTranNum = new JTextField();
		textTranNum.setFont(labelFont);
		panel.add(textTranNum);
		textTranNum.addActionListener(this);
		
		// Address
		labelAddress = new JLabel("Address:");
		labelAddress.setHorizontalAlignment(SwingConstants.CENTER); // centers the label
		labelAddress.setFont(labelFont);
		panel.add(labelAddress);
		
		textAddress = new JTextField();
		textAddress.setFont(labelFont);
		panel.add(textAddress);
		textAddress.addActionListener(this);
		
		// Bedrooms
		labelBedrooms = new JLabel("Bedrooms:");
		labelBedrooms.setHorizontalAlignment(SwingConstants.CENTER); // centers the label
		labelBedrooms.setFont(labelFont);
		panel.add(labelBedrooms);
		
		textBedrooms = new JTextField();
		textBedrooms.setFont(labelFont);
		panel.add(textBedrooms);
		textBedrooms.addActionListener(this);
		
		// Square Footage
		labelSquareFt = new JLabel("Square Footage:");
		labelSquareFt.setHorizontalAlignment(SwingConstants.CENTER); // centers the label
		labelSquareFt.setFont(labelFont);
		panel.add(labelSquareFt);
		
		textSquareFt = new JTextField();
		textSquareFt.setFont(labelFont);
		panel.add(textSquareFt);
		textSquareFt.addActionListener(this);
		
		// Price
		labelPrice = new JLabel("Price:");
		labelPrice.setHorizontalAlignment(SwingConstants.CENTER); // centers the label
		labelPrice.setFont(labelFont);
		panel.add(labelPrice);
		
		textPrice = new JTextField();
		textPrice.setFont(labelFont);
		panel.add(textPrice);
		textPrice.addActionListener(this);
		
		// Process
		buttonProcess = new JButton("Process");
		buttonProcess.setFont(labelFont);
		panel.add(buttonProcess);
		buttonProcess.addActionListener(this);
		
		comboProcess = new JComboBox<String>(processChoices);
		comboProcess.setFont(labelFont);
		panel.add(comboProcess);
		comboProcess.addActionListener(this);
		
		// Change Status
		buttonStatus = new JButton("Change Status");
		buttonStatus.setFont(labelFont);
		panel.add(buttonStatus);
		buttonStatus.addActionListener(this);
		
		comboStatus = new JComboBox<String>(statusChoices);
		comboStatus.setFont(labelFont);
		panel.add(comboStatus);
		comboStatus.addActionListener(this);
		
		
		
		
		frame.add(panel);
		frame.setVisible(true);
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
		if (e.getSource() == buttonProcess) {
//			System.out.println("Process");
			
			try {
				
				int intTran = Integer.parseInt(textTranNum.getText());
						
				if (comboProcess.getSelectedItem() == "Insert") {

					
					String address = textAddress.getText();
					int intBedrooms = Integer.parseInt(textBedrooms.getText());
					int intSqrFeet = Integer.parseInt(textSquareFt.getText());
					int intPrice = Integer.parseInt(textPrice.getText());

					p1 = new Property<Status>(address, intBedrooms, intSqrFeet, intPrice);
					p1.changeState(Status.FOR_SALE);
					
					// check if record already exists
					if (databaseProperties.containsKey(intTran)) {
						String message = "That record already exists!\nPlease use a different Transaction No";
						JOptionPane.showMessageDialog(null, message, "Duplicate Record!", JOptionPane.ERROR_MESSAGE);
					} else {
						databaseProperties.put(intTran, p1);
						String message = "The following property has been added to the database:\n\n" + databaseProperties.get(intTran);
						JOptionPane.showMessageDialog(null, message, "Record added!", JOptionPane.ERROR_MESSAGE);
						
					}
				} else if (comboProcess.getSelectedItem() == "Delete") {
					// check if record exists or not
					if (databaseProperties.get(intTran) == null) {
						String message = "That record does not exist!\nPlease use a valid Transaction No";
						JOptionPane.showMessageDialog(null, message, "Cannot delete record!", JOptionPane.ERROR_MESSAGE);
					} else {
						String message = "The following property has been deleted from the database:\n\n" + databaseProperties.get(intTran);
						JOptionPane.showMessageDialog(null, message, "Record deleted!", JOptionPane.ERROR_MESSAGE);
						databaseProperties.remove(intTran, p1);
					}
					
				} else if (comboProcess.getSelectedItem() == "Find") {
					// check if record exists or not
					if (databaseProperties.get(intTran) == null) {
						String message = "That record does not exist!\nPlease use a valid Transaction No";
						JOptionPane.showMessageDialog(null, message, "Cannot find record!", JOptionPane.ERROR_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, databaseProperties.get(intTran), "Record found!", JOptionPane.ERROR_MESSAGE);
					}
					
				}
			
		
				
			} // end of try
			catch (Exception eMsg) {
				String message = "Please enter integer values for the following fields:     \n\nTransaction No\nBedrooms\nSquare Footage\nPrice";
				JOptionPane.showMessageDialog(null, message, "Must enter Integers!", JOptionPane.ERROR_MESSAGE);
			}
		
				

				
		} else if (e.getSource() == buttonStatus) {
//				System.out.println("Change Status");
				
			
			try {
				
					int intTran = Integer.parseInt(textTranNum.getText());
					String message = "";
					if (comboStatus.getSelectedItem() == "FOR_SALE") {
						p1.changeState(Status.FOR_SALE);
						message = "Property status was updated to:\n\n" + Status.FOR_SALE;
					} else if (comboStatus.getSelectedItem() == "UNDER_CONTRACT") {
						p1.changeState(Status.UNDER_CONTRACT);
						message = "Property status was updated to:\n\n" + Status.UNDER_CONTRACT;
					} else if (comboStatus.getSelectedItem() == "SOLD") {
						p1.changeState(Status.SOLD);
						message = "Property status was updated to:\n\n" + Status.SOLD;
						
					}
					databaseProperties.replace(intTran, p1);
					JOptionPane.showMessageDialog(null, message, "Status Updated!", JOptionPane.ERROR_MESSAGE);
					
					
			} // end of try
			catch (Exception eMsg) {
				String message = "Please enter an integer value for the Transaction No";
				JOptionPane.showMessageDialog(null, message, "Must enter Integers!", JOptionPane.ERROR_MESSAGE);
			}
			
		} // end of else if
				
			
				
		
	
	
	} // end of actionPerformed

}
