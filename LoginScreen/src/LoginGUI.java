/*
 * Filename: LoginGUI.java
 * Author: Patrick Walsh
 * Date: 11/12/2020
 * Purpose: Program creates a login GUI where user can enter username and password
 */



import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



public class LoginGUI implements ActionListener {
	
	// elements of GUI
	private static JLabel labelLogin;
	private static JTextField textLogin;
	private static JLabel labelPassword;
	private static JPasswordField textPassword;
	private static JButton buttonLogin;
	private static Font labelFont;
	private static Font textFont;
	private static Font buttonFont;
	private static Font messageFont;
	private static JLabel labelMessage;
	
	
	public static void main(String[] args) {
		
		GUI();
		
	} // end of main
	
	
	
	
	
	public static void GUI() {
		
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		
		labelFont = new Font("Times New Roman", Font.BOLD, 32);
		textFont = new Font("Times New Roman", Font.PLAIN, 20);
		buttonFont = new Font("Times New Roman", Font.BOLD, 28);
		messageFont = new Font("Constantia", Font.PLAIN, 22);
		
		// create frame and add panel to it
		frame.setSize(500, 400); // (width, height)
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("USER LOGIN");
		frame.setLocationRelativeTo(null); // makes GUI open in the middle of the screen
		frame.setResizable(false);
		frame.add(panel);
		panel.setLayout(null);
		panel.setBorder(BorderFactory.createEtchedBorder());
		
		// login label
		labelLogin = new JLabel("Login: ");
		labelLogin.setBounds(70, 50, 120, 50); // (x, y, width, height)
		labelLogin.setFont(labelFont);
		panel.add(labelLogin);
		
		// login text box
		textLogin = new JTextField();
		textLogin.setBounds(240, 55, 180, 35); // (x, y, width, height)
		textLogin.setFont(textFont);
		textLogin.addActionListener(new LoginGUI());
		panel.add(textLogin);	

        
		// password label
		labelPassword = new JLabel("Password: ");
		labelPassword.setBounds(70, 120, 170, 50); // (x, y, width, height)
		labelPassword.setFont(labelFont);
		panel.add(labelPassword);
		

		// password text box
		textPassword = new JPasswordField();
		textPassword.setBounds(240, 125, 180, 35); // (x, y, width, height)
		textPassword.setFont(textFont);
		textPassword.addActionListener(new LoginGUI());
		panel.add(textPassword);
		
		
		// login button
		buttonLogin = new JButton("Login");
		buttonLogin.setBounds(150, 220, 180, 45); // (x, y, width, height)
		buttonLogin.setFont(buttonFont);
		buttonLogin.addActionListener(new LoginGUI());
		panel.add(buttonLogin);
		
		
		// login message
		labelMessage = new JLabel("");
		labelMessage.setBounds(160, 280, 180, 40); // (x, y, width, height)
		labelMessage.setFont(messageFont);
		panel.add(labelMessage);

		
		frame.setVisible(true);
		
	}




	// when user enters username and password and clicks login
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// gets values of text boxes for login and password
		String login = textLogin.getText();
		String password = String.valueOf(textPassword.getPassword());
		
		
		// when user clicks login button
		if (e.getSource() == buttonLogin) {
			
			// if username and password are correct
			if (login.equals("JavaTheHut") && password.equals("eatpizza")) {
				labelMessage.setForeground(Color.GREEN);
				labelMessage.setText("Login Accepted!");
			// if username and password are wrong
			// displays JOptionPane popup with correct login info
			} else {
				labelMessage.setForeground(Color.RED);
				labelMessage.setText("Incorrect login!");
				JOptionPane.showMessageDialog(null, "The correct login info is:\n\nusername: JavaTheHut\npassword: eatpizza", "Incorrect Login", JOptionPane.ERROR_MESSAGE);
			}
		} // end of if
		
		
	}
	

}
