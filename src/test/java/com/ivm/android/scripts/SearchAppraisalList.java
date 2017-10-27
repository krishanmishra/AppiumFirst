package com.ivm.android.scripts;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.ivm.android.screenHelper.AppraisallistHelper;
import com.ivm.android.screenHelper.UserLoginHelper;
import com.ivm.android.util.DriverTestCase;

public class SearchAppraisalList extends DriverTestCase{
	
	
	// Initialize the objects
	AppraisallistHelper appraisallistHelper = new AppraisallistHelper(getDriver());
	UserLoginHelper userloginhelper=new UserLoginHelper(getDriver());
	String searchvehicle="2014";
	
	
	@Test(enabled = true)
	public void searchbyVehicle() throws InterruptedException
	{
		//user logged in successfully
		login("ON");
	
		//Go to appraisal list screen
		appraisallistHelper.appraisallist();
		
		//Tap on Magnification icon
		appraisallistHelper.TapmagnifiICon();
		
		//Search vehicles with vehicle info name
	    appraisallistHelper. Searchresults(searchvehicle);
		Reporter.log("search vehicle with VIN and result");
				
		//Tap on Back button 
		appraisallistHelper.backAction();
		Reporter.log("User tap on back action return to Home");
		
		// Tap on the Sign out button
		userloginhelper.loggedOut();
		Reporter.log("User taps on the Sign out button");
		
	}
	
	
	
	
	
}
