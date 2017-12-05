package com.ivm.android.scripts;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.ivm.android.screenHelper.AddAppraisalHelper;
import com.ivm.android.screenHelper.AppraisallistHelper;
import com.ivm.android.screenHelper.UserLoginHelper;
import com.ivm.android.util.DriverTestCase;

public class Add_Appraisal extends DriverTestCase {
	
	
	// Initialize the objects
	    AddAppraisalHelper addappraisalHelper = new AddAppraisalHelper(getDriver());
	    AppraisallistHelper appraisallisthelper=new AppraisallistHelper(getDriver());
		UserLoginHelper userloginhelper=new UserLoginHelper(getDriver());
		String AddvehiclewithVIN="";
		String AddvehiclewithoutVIN="";
		
		@Test(enabled = true)
		public void addappraisalwithVIN() throws InterruptedException
		{
			//user logged in successfully
			login("ON");
		
			//Go to appraisal list screen
			appraisallisthelper.appraisallist();
			
			//Tap on add button icon
			addappraisalHelper.clickAdd();
			
			//Search vehicles with vehicle info name
			addappraisalHelper.AdddecodeVIN();
			Reporter.log("search vehicle with VIN and result");
					
			//Tap on Back button 
			addappraisalHelper.backAction();
			Reporter.log("User tap on back action return to Home");
			
			// Tap on the Sign out button
			userloginhelper.loggedOut();
			Reporter.log("User taps on the Sign out button");
			
		}
		
		@Test(enabled = true)
		public void addappraisalwithoutVIN() throws InterruptedException
		{
			//user logged in successfully
			login("ON");
		
			//Go to appraisal list screen
			appraisallisthelper.appraisallist();
			
			//Tap on Magnification icon
			addappraisalHelper.clickAdd();
			
			//Add vehicle with selecting YMMTS
			addappraisalHelper.AddVINSelectYMMTS();
			Reporter.log("search vehicle with VIN and result");
					
			//Tap on Back button 
			addappraisalHelper.backAction();
			Reporter.log("User tap on back action return to Home");
			
			// Tap on the Sign out button
			userloginhelper.loggedOut();
			Reporter.log("User taps on the Sign out button");
			
		}
	
	
	
	
	
	
}
