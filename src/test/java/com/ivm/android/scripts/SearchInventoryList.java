package com.ivm.android.scripts;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.ivm.android.screenHelper.InventoryListHelper;
import com.ivm.android.screenHelper.UserLoginHelper;
import com.ivm.android.util.DriverTestCase;

public class SearchInventoryList extends DriverTestCase {
	// Declare the Objects
	InventoryListHelper inventorylistHelper;
	UserLoginHelper userloginhelper;
			
	// Initialize the objects
	 private void initializeObject()
		 {
			 inventorylistHelper = new InventoryListHelper(getDriver());
			 userloginhelper=new UserLoginHelper(getDriver());
		}
		
	// Initialize the variable
	String searchvehicle="2014";
		
	@Test(enabled = true)
	public void searchbyVehicleInventory() throws InterruptedException
	{
		// Initialize the objects
		 initializeObject();	
				
		//user logged in successfully
		login("ON");
	
		//Go to appraisal list screen
		inventorylistHelper.inventoryList();
		
		//Tap on Magnification icon
		inventorylistHelper.TapmagnifiICon();
		
		//Search vehicles with vehicle info name
		inventorylistHelper.Searchresults(searchvehicle);
		Reporter.log("search vehicle with VIN and result");
				
		//Tap on Back button 
		inventorylistHelper.backAction();
		Reporter.log("User tap on back action return to Home");
		
		// Tap on the Sign out button
		userloginhelper.loggedOut();
		Reporter.log("User taps on the Sign out button");
	}
}
