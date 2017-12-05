package com.ivm.android.scripts;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.ivm.android.screenHelper.AddAppraisalHelper;
import com.ivm.android.screenHelper.AppraisallistHelper;
import com.ivm.android.screenHelper.UserLoginHelper;
import com.ivm.android.util.DriverTestCase;

public class VerifyviewPhotoandNotes extends DriverTestCase {
	
	// Declare the Objects
	AddAppraisalHelper addappraisalHelper;
	AppraisallistHelper appraisallisthelper;
	UserLoginHelper userloginhelper;
	
	// Initialize the objects
	private void initializeObject(){
		addappraisalHelper = new AddAppraisalHelper(getDriver());
		appraisallisthelper=new AppraisallistHelper(getDriver());
		userloginhelper=new UserLoginHelper(getDriver());
	}	
	@Test(enabled = true)
	public void ReappraiseVehicle() throws InterruptedException
	{
		// Initialize the objects
		initializeObject();		
		
		//user logged in successfully
		login("ON");
	
		//Go to appraisal list screen
		appraisallisthelper.appraisallist();
		Reporter.log("vehicle appraisals list displaying");
		
		//Tap on appraisal vehicle
		appraisallisthelper.clickOnVehicle();
		Reporter.log("Appraisal Vehicle details screen displaying");	
		
		//hit on view button 
		appraisallisthelper.clickOnView();
		Reporter.log("Vehicle information or start appraisal screen displaying");
				
		//hit on Photos button
		appraisallisthelper.ClickOnPhotosButton();
		Reporter.log("Photos screen displaying ");
		
		//click on Notes button
		appraisallisthelper.ClickOnNotes();
		Reporter.log("Notes screen displaying");
		
		//hit back link to back on details screen
		appraisallisthelper.BackToDetails();
		Reporter.log("Back to appraisal details screen");
		
		//hit discard on top right
		appraisallisthelper.closeappraisalVehicle();
		Reporter.log("Discard the appraisal details screen");
		
		// Tap on the Sign out button
		userloginhelper.loggedOut();
		Reporter.log("User taps on the Sign out button");
	}
}
