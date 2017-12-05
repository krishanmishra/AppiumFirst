package com.ivm.android.scripts;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.ivm.android.screenHelper.UserLoginHelper;
import com.ivm.android.util.DriverTestCase;

/**
 * @author IVM MObile 2.0
 *
 */
public class VerifyForgotPassword extends DriverTestCase{

	// Initialize the objects
	UserLoginHelper userLoginHelper = new UserLoginHelper(getDriver());
	
	// Initialize the variables 
	String Resetemail_address = "test1234@gmail.com";
    String invalid_address = "test1234gmail.com";
	/**
	 * This test case for user reset password by using blank credentials
	 * @throws InterruptedException 
	 */
	@Test(enabled = true)
	public void BlankValuePassword() throws InterruptedException
	{
		// Tap on forgot passowrd
		userLoginHelper.tapOnForgotPassword();
		Reporter.log("User taps on forgot passowrd link");
		
		// Entered email and reset the password
		userLoginHelper.resetPassword("");
		Reporter.log("Reset the password");
		
		//Confirm the screen
		userLoginHelper.LoginScreen();
		Reporter.log("User login Screen");
				
	}
	/**
	 * This test case for reset password by using invalid credentials
	 * @throws InterruptedException 
	 */
	@Test(enabled = true)
	public void Invalidaddress() throws InterruptedException
	{
		// Tap on forgot passowrd
		userLoginHelper.tapOnForgotPassword();
		Reporter.log("User taps on forgot passowrd link");
		
		// Entered email and reset the password
		userLoginHelper.resetPassword(invalid_address);
		Reporter.log("Reset the password");
		
		//Confirm the screen
		userLoginHelper.LoginScreen();
		Reporter.log("User login Screen");				
	}
	/**
	 * This test case for reset password by using valid credentials
	 * @throws InterruptedException 
	 */
	@Test(enabled = true)
	public void validaddress() throws InterruptedException
	{	

		// Tap on forgot passowrd
		userLoginHelper.tapOnForgotPassword();
		Reporter.log("User taps on forgot passowrd link");
		
		// Entered valid email and reset the password
		userLoginHelper.resetPassword(Resetemail_address);
		Reporter.log("Reset the password");
		
		//Confirm the screen
		userLoginHelper.LoginScreen();
		Reporter.log("User login Screen");
		
		
	}
}

