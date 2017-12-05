package com.ivm.android.scripts;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.ivm.android.screenHelper.UserLoginHelper;
import com.ivm.android.util.DriverTestCase;

/**
 * @author IVM MObile 2.0
 *
 */
public class ValidateNewUserAccount extends DriverTestCase{

	// Initialize the objects
	UserLoginHelper userLoginHelper = new UserLoginHelper(getDriver());


	
	// Initialize the variables 
	String NewUsername = "test1234@gmail.com";
	String NewPassword = "360@logica";
	
	/**
	 * This test case for user login into application by using valid credentials
	 * @throws InterruptedException 
	 */
	@Test(enabled = true)
	public void validateAccount() throws InterruptedException
	{
		
		// Enter username into Email field
		userLoginHelper.enterUsername(NewUsername);
		Reporter.log("User enters username");

		// Enter Passcode into passcode field
		userLoginHelper.enterPasscode(NewPassword);
		Reporter.log("User enters Password");

		// Tap on the Sign In button
		userLoginHelper.tapOnSignIn();
		Reporter.log("User taps on Sign In button");

		// Account Validation Required. Activate your account by clicking the link in the validation email sent to you.
		//For additional help, please contact support at 1-800-647-8425."
		userLoginHelper.validateUser();
		Reporter.log("Validation message appears");
		
	}
}
