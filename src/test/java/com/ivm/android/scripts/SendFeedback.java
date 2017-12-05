package com.ivm.android.scripts;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.ivm.android.screenHelper.Feedbackhelper;
import com.ivm.android.screenHelper.UserLoginHelper;
import com.ivm.android.util.DriverTestCase;

/**
 * @author IVM MObile 2.0
 *
 */
public class SendFeedback extends DriverTestCase{

	// Declare the Objects
	Feedbackhelper feedbackhelper;
	UserLoginHelper userloginhelper;
				
		// Initialize the objects
		 private void initializeObject()
			 {
			 feedbackhelper=new Feedbackhelper(getDriver());
				 userloginhelper=new UserLoginHelper(getDriver());
			}
		
	/**
	 * This test case for user send feedback
	 * @throws InterruptedException 
	 */
	@Test(enabled = true)
	public void sendFeedback() throws InterruptedException
	{
		// Initialize the objects
		initializeObject();
				 
		//user logged in successfully
		login("ON");
		Reporter.log("User login Successfully");
		
		//go to feedback screen
		feedbackhelper.Feedbackscreen();
		Reporter.log("feedback screen");
		
		//go to feedback screen
		feedbackhelper.FeedbackText("Test");
		Reporter.log("feedback screen");
		
		//back to Home
		feedbackhelper.backToHome();
		Reporter.log("back To Home screen");
		
		// Tap on the Sign out button
		userloginhelper.loggedOut();
		Reporter.log("User taps on the Sign out button");	
	}
	
}

