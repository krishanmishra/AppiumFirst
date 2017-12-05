package com.ivm.android.screenHelper;

import org.testng.Assert;

import com.ivm.android.locators.CommonObject;
import com.ivm.android.locators.DrawerObject;
import com.ivm.android.locators.SettingObject;
import com.ivm.android.util.DriverHelper;

import io.appium.java_client.AppiumDriver;

public class Feedbackhelper extends DriverHelper{

	public Feedbackhelper(AppiumDriver webdriver) {
		super(webdriver);
		}
	
	public void Feedbackscreen()
	{
		String drawer_menu=DrawerObject.OpenDrawer;
		clickOn(drawer_menu);
		
		String feedback=DrawerObject.send_Feedback;
		clickOn(feedback);
		
		String screenTitle=SettingObject.screen_title;
		boolean flag = isElementPresent(screenTitle);
		Assert.assertTrue(flag, "Feedback screen not present");	
		Assert.assertEquals("FEEDBACK", getText(screenTitle));
		
	}

	public void FeedbackText(String test1) {
	
		String feedbackText=DrawerObject.feedback_text;
		Assert.assertEquals("Add your feedback below.", getText(feedbackText));
		System.out.println("feedback labels are: "+getText(feedbackText));
		
		String inputcount1=DrawerObject.inputCount;
		System.out.println("input count: "+getText(inputcount1));
		
		String Sendbutton=DrawerObject.sendFeedback;
		clickOn(Sendbutton);
		
		String validation_message="Please enter text to send feedback.";
		String accept=CommonObject.alert_OK;
		String aletText=CommonObject.alertpopup_text;
		
		Assert.assertEquals(getText(aletText), validation_message);
		clickOn(accept);
		
		String inputfeedback=DrawerObject.inputFeedback;
		sendKeys(inputfeedback,test1);
		
		String inputcount2=DrawerObject.inputCount;
		System.out.println("input count: "+getText(inputcount2));
		
		clickOn(Sendbutton);
		
	}

	public void backToHome() {
		String back=SettingObject.screen_back;
		clickOn(back);
		
	}
	
	
	
	
	
}
