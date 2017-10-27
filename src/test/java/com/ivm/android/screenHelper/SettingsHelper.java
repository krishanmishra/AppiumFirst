package com.ivm.android.screenHelper;

import org.testng.Assert;

import com.ivm.android.locators.CommonObject;
import com.ivm.android.locators.DrawerObject;
import com.ivm.android.locators.SettingObject;
import com.ivm.android.util.DriverHelper;

import io.appium.java_client.AppiumDriver;

public class SettingsHelper extends DriverHelper
{

	public SettingsHelper(AppiumDriver webdriver) {
		super(webdriver);
		
	}
	
	public void pagetitle()
	{
		String screenTitle=SettingObject.screen_title;
		boolean flag = isElementPresent(screenTitle);
		Assert.assertTrue(flag, "screen title is not present");
	}
	
	
	
	public void Settingsscreen()
	{
		String drawer_menu=DrawerObject.OpenDrawer;
		clickOn(drawer_menu);
		
		String settings=DrawerObject.settings;
		clickOn(settings);
		
		String screenTitle=SettingObject.screen_title;
		boolean flag = isElementPresent(screenTitle);
		Assert.assertTrue(flag, "Settings screen not present");	
		
	}
	
	public void about(){
		
		String about=SettingObject.about_link;
		clickOn(about);
		
        String screenTitle=SettingObject.screen_title;
		
		boolean flag = isElementPresent(screenTitle);
		Assert.assertTrue(flag, "about screen not present");	
		
		
		String about_id=SettingObject.about_id;
		System.out.println(getText(about_id));
		
		String about_version=SettingObject.about_version;
		System.out.println(getText(about_version));
		
		String back=SettingObject.screen_back;
		clickOn(back);
				
		boolean flag1 = isElementPresent(screenTitle);
		Assert.assertTrue(flag1, "setting screen not present");
		System.out.println(getText(screenTitle));
						
	}
	

public void backToHome()
{
	String back=SettingObject.screen_back;
	clickOn(back);
	
}

public void GoogleAnalytics(String status) {
		
String toggleONOFF=SettingObject.googleAnalytics_toggleONOFF;
String switchstatus=getText(toggleONOFF);
	
//Get status of switch using it's text.
System.out.println(switchstatus);

System.out.println((switchstatus).equals(status));

//If switchStatus1 = Monitored switch OFF, Execute inner code.
if((switchstatus).equals(status)== false)
  {
	toggleButtonSwitchONOFF();
  }
 

}

public void toggleButtonSwitchONOFF()
{
	String toggleONOFF=SettingObject.googleAnalytics_toggleONOFF;
	System.out.println("Doing Monitored switch ON");
	//Tap on switch button "Monitored switch OFF" to make it ON.
   clickOn(toggleONOFF);
   System.out.println("Monitored switch is ON now.");
}

public void permissionAcess()
{
	String allow=CommonObject.permission_allow;
	clickOn(allow);
	
}

public void permissionDeny()
{
	String allow=CommonObject.permission_deny;
	clickOn(allow);
	
}


public void savePhotosOnDevices(String status, String allowacces2) {
	
	String PhototoggleONOFF=SettingObject.SavePhotodevice_toggleONOFF;
	String switchstatus=getText(PhototoggleONOFF);
		
//Get status of switch using it's text.
System.out.println(switchstatus);

//If switchStatus1 = Monitored switch OFF, Execute inner code.
if((switchstatus).equals(status)==false)
{
 System.out.println("Doing Monitored switch ON");
 
 //Tap on switch button "Monitored switch OFF" to make it ON.
clickOn(PhototoggleONOFF);
String allowaccess=CommonObject.permission_allow;
String denyaccess=CommonObject.permission_deny;
String permissionallow=getText(allowaccess);

if(allowacces2.equalsIgnoreCase(permissionallow)==true)
{
clickOn(allowaccess);
}else
{
	clickOn(denyaccess);
	Assert.assertEquals(switchstatus, "OFF");
}

 System.out.println("Monitored switch is ON now.");
}

	
}

public void googleAlert() {
	String googleAnlytics=SettingObject.googleAnalytics_text;
	String googlealertiCon=SettingObject.googleAnalytics_infoIcon;
	boolean flag = isElementPresent(googleAnlytics);
	Assert.assertTrue(flag, "googleAnlytics labels not present");
	
	clickOn(googlealertiCon);
	String alertmessage=CommonObject.alertpopup_text;
	String alert_ok=CommonObject.alert_OK;
	
	System.out.println(getText(alertmessage));
	String alerttmessage=getText(alertmessage);
	String message="IVM uses Google Analytics to track usage of various features in order to provide"
			+ " a better user experience. No personally identifiable information is collected.";
	Assert.assertEquals(alerttmessage, message);
	clickOn(alert_ok);
	
}

public void savePhotosAlert() {
	
	String photodevices=SettingObject.SavePhotodevice_text;
	String savephotoalertiCon=SettingObject.SavePhotodevice_info;
	boolean flag = isElementPresent(photodevices);
	Assert.assertTrue(flag, "save Photos On devices labels not present");
	
	clickOn(savephotoalertiCon);
	String alertmessage=CommonObject.alertpopup_text;
	String alert_ok=CommonObject.alert_OK;
	
	System.out.println(getText(alertmessage));
	String alerttmessage=getText(alertmessage);
	String message="Turning off this setting will stop all photos taken within the app from saving to your device.";
	Assert.assertEquals(alerttmessage, message);
	clickOn(alert_ok);
}
}
