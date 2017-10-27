package com.ivm.android.scripts;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.ivm.android.screenHelper.UserLoginHelper;
import com.ivm.android.util.DriverTestCase;

/**
 * @author IVM MObile 2.0
 *
 */
public class UserLogin extends DriverTestCase{

	// Initialize the objects
	UserLoginHelper userLoginHelper = new UserLoginHelper(getDriver());


	
	// Initialize the variables 
	String validUsername = "gurpreet.kaur@drivedominion.com";
	String validPassword = "360@logica";
	String invalidUsername = "testuser@gmail.com";
	String invalidPassword = "testuser1161";

	/**
	 * This test case for user login into application by using valid credentials
	 * @throws InterruptedException 
	 */
	@Test(enabled = true)
	public void testUserLogin() throws InterruptedException
	{
		// Get orientation of app
		userLoginHelper.appDetails();
		Reporter.log("app context and orientation of app");
		
		// Enter username into Email field
		userLoginHelper.enterUsername(validUsername);
		Reporter.log("User enters username");

		// Enter Passcode into passcode field
		userLoginHelper.enterPasscode(validPassword);
		Reporter.log("User enters Password");

		// Tap on the Sign In button
		userLoginHelper.tapOnSignIn();
		Reporter.log("User taps on Sign In button");

		// Verify user is logged into application
		userLoginHelper.verifyUserLoggedIn();
		Reporter.log("User is logged into application successfully");

		// Tap on the Sign out button
		userLoginHelper.loggedOut();
		Reporter.log("User taps on the Sign out button");

		// Verify user is logged out from application
		userLoginHelper.verifyUserLoggedOut();
		Reporter.log("User is logged out from application successfully");
	}

	/**
	 * This test case for user login into application by using invalid credentials
	 * and verify validation message*/
	 
	@Test(enabled= true)
	public void testUserLoginInvalidCredentials()
	{
		
		// Enter xID into xID field
		userLoginHelper.enterUsername(invalidUsername);
		Reporter.log("User enters username");

		// Enter Passcode into passcode field
		userLoginHelper.enterPasscode(invalidPassword);
		Reporter.log("User enters Password");

		// Tap on the Sign In button
		userLoginHelper.tapOnSignIn();
		Reporter.log("User taps on Sign In button");

		// Verify user is logged into application
		userLoginHelper.verifyValidationMessage();
		Reporter.log("Validation message appears");
	}
}
