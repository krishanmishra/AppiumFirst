package com.ivm.android.screenHelper;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import com.ivm.android.locators.AddAppraisalObject;
import com.ivm.android.locators.AppraisallistObject;
import com.ivm.android.locators.CommonObject;
import com.ivm.android.util.DriverHelper;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;

public class AddAppraisalHelper extends DriverHelper{
	
	
	

	public AddAppraisalHelper(AppiumDriver webdriver) {
		super(webdriver);
		
	}


	public void clickAdd() {
	
		String add=AppraisallistObject.addbutton;
		clickOn(add);
		String acceptPermission=CommonObject.permission_allow;
		String denyPermission=CommonObject.permission_deny;
		String skipscanbutton=CommonObject.skipScan;
		clickOn(acceptPermission);
		TouchAction Action = new TouchAction(driver);
		Action.press(driver.findElement(By.id("//android.widget.Button[@text='SKIP SCAN']"))).perform().release();
		//clickOn(skipscanbutton);
		
		
		}

	public void AdddecodeVIN() {
		String addscreentitle=CommonObject.screenTitle;
		String addTitle=getText(addscreentitle);
		Assert.assertEquals("START APPRAISAL", addTitle);
		
		
		String vehicleTitle=AddAppraisalObject.vehicle_title;
		String vehicleTitletext=getText(vehicleTitle);
		Assert.assertEquals("Enter VIN to pull vehicle details.", addTitle);
		
	}

	public void backAction() {
		// TODO Auto-generated method stub
		
	}

	public void AddVINSelectYMMTS() {
		// TODO Auto-generated method stub
		
	}


	public void clickOnVehicle() {
		
		
	}
	
	
	

}
