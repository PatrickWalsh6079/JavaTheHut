/*
 * Filename: LoginGUITest.java
 * Author: Patrick Walsh
 * Date: 8/31/2021
 * Purpose: Runs 4 tests using JUnit testing framework. 
 * Test 1: Ensures setLogin() method works as expected.
 * Test 2: Ensures getLogin() method works as expected.
 * Test 3: Ensures setPassword() method works as expected.
 * Test 4: Ensures getPassword() method works as expected.
 */

package com.mycompany.gui_login;


import javax.swing.JPasswordField;
import javax.swing.JTextField;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pwalsh
 */
public class LoginGUITest {
    
    // create test object
    LoginGUI testObj = new LoginGUI();
    // give value to login field for testing
    JTextField testingLogin = new JTextField("testUser");
    // give value to password field for testing
    JPasswordField testingPassword = new JPasswordField("testPass");
        
    
    
    // test setLogin method to ensure that it sets the login text to the textLogin field
    @Test
    public void testSetLogin(){
        testObj.setLogin(testingLogin);
        assertEquals("testUser", testingLogin.getText());  // assertEquals(expected value, actual value)
    }
    
    
    
    // test getLogin method to ensure that it retrieves the username 
    // from the textLogin JTextField.
    @Test
    public void testGetLogin(){
        testObj.setLogin(testingLogin);
        String output = testObj.getLogin(); 
        assertEquals("testUser", output);  // assertEquals(expected value, actual value)
    }
    
    
    
    // test setPassword method to ensure that it sets the password text to the textPassword field
    @Test
    public void testSetPassword(){
        testObj.setPassword(testingPassword);
        assertEquals("testPass", String.valueOf(testingPassword.getPassword()));  // assertEquals(expected value, actual value)
    }
    
    
    // test getPassword method to ensure that it retrieves the password 
    // from the textPassword JPasswordField.
    @Test
    public void testGetPassword(){
        String output = testObj.getPassword(); 
        assertEquals("testPass", output);  // assertEquals(expected value, actual value)
    }

    
}
