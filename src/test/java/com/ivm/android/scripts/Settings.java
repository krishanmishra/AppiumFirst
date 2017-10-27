package com.ivm.android.scripts;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.ivm.android.screenHelper.SettingsHelper;
import com.ivm.android.screenHelper.UserLoginHelper;
import com.ivm.android.util.DriverTestCase;

public class Settings extends DriverTestCase {

	// Initialize the objects
	SettingsHelper settingHelper = new SettingsHelper(getDriver());
	UserLoginHelper userloginhelper=new UserLoginHelper(getDriver());
	String Switch_ON = "ON";
	String Switch_OFF = "OFF";
	String allowaccess = "Allow";
	String denyaccess = "Deny";

	@Test(enabled = true)
	public void SettingperissionON() throws InterruptedException 
	{		
		//user logged in successfully
		login("ON");
		//userloginhelper.verifyUserLoggedIn();
						
		//Go to Setting screen
		settingHelper.Settingsscreen();
				
		//verify the page Title
		settingHelper.pagetitle();
		
		//Go to About screen
		settingHelper.about();
		Reporter.log("About screen display");
		
		//verify alert pop up text
		settingHelper.googleAlert();
				
		//verify alert pop up text
		settingHelper.savePhotosAlert();
		
		//ON and Off google Analytics
		settingHelper.GoogleAnalytics(Switch_ON);
		
		//ON and Off Photos On Devices
		settingHelper.savePhotosOnDevices(Switch_ON,allowaccess);
		
								
		//back to Home screen
		settingHelper.backToHome();
		
		// Tap on the Sign out button
		userloginhelper.loggedOut();
		Reporter.log("User taps on the Sign out button");
				
	}
	@Test(enabled = true)
	public void SettingperissionOFF() throws InterruptedException 
	{		
		//user logged in successfully
		login("ON");
		//userloginhelper.verifyUserLoggedIn();
						
		//Go to Setting screen
		settingHelper.Settingsscreen();
				
		//verify the page Title
		settingHelper.pagetitle();
		
		//Go to About screen
		settingHelper.about();
		Reporter.log("About screen display");
		
		//verify alert pop up text
		settingHelper.googleAlert();
						
				//verify alert pop up text
		settingHelper.savePhotosAlert();
		
		//ON and Off google Analytics
		settingHelper.GoogleAnalytics(Switch_OFF);
		
		//ON and Off Photos On Devices
		settingHelper.savePhotosOnDevices(Switch_ON,denyaccess);
				
								
		//back to Home screen
		settingHelper.backToHome();
		
		// Tap on the Sign out button
		userloginhelper.loggedOut();
		Reporter.log("User taps on the Sign out button");
	}
	
}
