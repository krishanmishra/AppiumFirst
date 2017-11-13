package com.ivm.android.scripts;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.ivm.android.screenHelper.AddAppraisalHelper;
import com.ivm.android.screenHelper.AppraisallistHelper;
import com.ivm.android.screenHelper.UserLoginHelper;
import com.ivm.android.util.DriverTestCase;

public class VerifyReappraiseAppraisalDetailsPage extends DriverTestCase {
	
	// Initialize the objects
    AddAppraisalHelper addappraisalHelper = new AddAppraisalHelper(getDriver());
    AppraisallistHelper appraisallisthelper=new AppraisallistHelper(getDriver());
	UserLoginHelper userloginhelper=new UserLoginHelper(getDriver());
	
	String cancel="Cancel";
	String OK="OK";
			
	
	@Test(enabled = true)
	public void ReappraiseVehicle() throws InterruptedException
	{
		//user logged in successfully
		login("ON");
	
		//Go to appraisal list screen
		appraisallisthelper.appraisallist();
		Reporter.log("appraisal list display");
		
		//Tap on appraisal vehicle
		appraisallisthelper.clickOnVehicle();
		Reporter.log("click on appraisal vehicle");	
		
		//click on reappraise icon
		appraisallisthelper.ActionOnGearICON();
		Reporter.log("Icon should trigger a warning to the user");
				
	  //click and verify after tap on Reappraise
		appraisallisthelper.clickOnReappraisebutton(OK);
		Reporter.log("Reappraise vehicle and confirm that fields are editable");
		
		//hit and check the complete button
		appraisallisthelper.completeAppraisal();
		Reporter.log("Saved appraisal vehicle details screen");
		
		// Tap on the Sign out button
		userloginhelper.loggedOut();
		Reporter.log("User taps on the Sign out button");
		
	}
	
	
	
	
	
	

}
