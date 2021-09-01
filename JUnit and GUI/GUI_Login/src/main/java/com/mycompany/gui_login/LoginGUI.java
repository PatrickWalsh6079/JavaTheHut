/*
 * Filename: LoginGUI.java
 * Author: Patrick Walsh
 * Date: 8/22/2021
 * Purpose: Program creates a login GUI where user can enter username and password.
 * To run JUnit, download from https://sourceforge.net/projects/junit/
 * Place unzipped package somewhere and navigate to location of .jar file.
 * From that location, run following command to ensure JUnit is installed:
 * java -cp junit-4.10.jar org.junit.runner.JUnitCore org.junit.tests.AllTests
 */

package com.mycompany.gui_login;



import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
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
        private static JButton buttonReset;
	private static Font labelFont;
	private static Font textFont;
	private static Font buttonFont;
	private static Font messageFont;
	private static JLabel labelMessage;
        private String logMessage;
        
        // set Log.txt file path
        private static final String LOG_PATH = "C:\\Users\\pwalsh\\Documents\\NetBeansProjects\\GUI_Login\\Log.txt";
	
	
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
		frame.setSize(500, 420); // (width, height)
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
		textLogin = new JTextField("");
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
		buttonLogin.setBounds(150, 200, 180, 45); // (x, y, width, height)
		buttonLogin.setFont(buttonFont);
		buttonLogin.addActionListener(new LoginGUI());
		panel.add(buttonLogin);
                
                // reset button
		buttonReset = new JButton("Reset");
		buttonReset.setBounds(150, 250, 180, 45); // (x, y, width, height)
		buttonReset.setFont(buttonFont);
		buttonReset.addActionListener(new LoginGUI());
		panel.add(buttonReset);
		
		
		// login message
		labelMessage = new JLabel("");
		labelMessage.setBounds(160, 320, 180, 40); // (x, y, width, height)
		labelMessage.setFont(messageFont);
		panel.add(labelMessage);

		
		frame.setVisible(true);
		
	}  // end of method

        
        
        // set login
        public void setLogin(JTextField login){
            LoginGUI.textLogin = login;
        }
        
        
        // set password
        public void setPassword(JPasswordField password){
            LoginGUI.textPassword = password;
        }
        
        
        // get login from textLogin
        public String getLogin(){
            String login = textLogin.getText();
            return login;
        }
        
        
        // get password from textPassword
        public String getPassword(){
            String password = String.valueOf(textPassword.getPassword());
            return password;
        }
        


	// when user enters username and password and clicks login
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// gets values of text boxes for login and password
		String login = getLogin();
		String password = getPassword();
		
		
		// when user clicks login button
		if (e.getSource() == buttonLogin) {
			
			// if username and password are correct
			if (login.equals("JavaTheHut") && password.equals("eatpizza")) {
				labelMessage.setForeground(Color.GREEN);
				labelMessage.setText("Login Accepted!");
                                logMessage = "LOGIN SUCCESS\n";
			// if username and password are wrong
			// displays JOptionPane popup with correct login info
			} else {
				labelMessage.setForeground(Color.RED);
				labelMessage.setText("Incorrect login!");
				JOptionPane.showMessageDialog(null, "The correct login info is:\n\nusername: JavaTheHut\npassword: eatpizza", "Incorrect Login", JOptionPane.ERROR_MESSAGE);
                                logMessage = "LOGIN FAIL\n";
			}
                        
                        // Create a Logger
                        Logger logger = Logger.getLogger("MyLog");  
                        FileHandler fh;  

                        try {
                            // This block configures the logger with handler and formatter  
                            fh = new FileHandler(LOG_PATH, true);  
                            logger.addHandler(fh);
                            SimpleFormatter formatter = new SimpleFormatter();  
                            fh.setFormatter(formatter);  

                            // the following statement is used to log any messages  
                            logger.log(Level.INFO, "**LOGIN ATTEMPT**\nUsername entered: {0}\n", new Object[]{textLogin.getText() + "\n" + logMessage});
                        } catch (IOException | SecurityException ex) {
                            Logger.getLogger(LoginGUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
		} else if (e.getSource() == buttonReset){
                    textLogin.setText("");
                    textPassword.setText("");
                }
		
		
	}  // end of method


	

}