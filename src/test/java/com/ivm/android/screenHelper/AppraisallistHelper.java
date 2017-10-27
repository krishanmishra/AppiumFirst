package com.ivm.android.screenHelper;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.ivm.android.locators.AppraisallistObject;
import com.ivm.android.locators.CommonObject;
import com.ivm.android.util.DriverHelper;

import io.appium.java_client.AppiumDriver;

public class AppraisallistHelper extends DriverHelper {

	String vin=AppraisallistObject.appraisalVIN;
	String YMMT=AppraisallistObject.vehicleInformation;
	String price=AppraisallistObject.appraisalprice;
		
	public AppraisallistHelper(AppiumDriver webdriver) {
		super(webdriver);
		
	}
	public void appraisallist() {
					
		String appraisalItem=CommonObject.Home_appraisals_item;
		clickOn(appraisalItem);		
		
	}
public void TapmagnifiICon() {
		
		String appraisaltitle=AppraisallistObject.appraisalTitle;
		boolean flag = isElementPresent(appraisaltitle);
		Assert.assertTrue(flag, "screen title is not present");
		
		String searchICon=AppraisallistObject.search_button;
		clickOn(searchICon);
		
		String searchText=AppraisallistObject.search_text;
		System.out.println(searchText);

	}

public void backAction() {
	
		String backAction=CommonObject.ActionbackArrow;
		clickOn(backAction);
	}
	
public void Searchresults(String vindata)
	{
		String Totalresult="";
		String searchText=AppraisallistObject.search_text;
		sendKeys(searchText, vindata);
		boolean flag = isElementPresent(YMMT);
		
if(flag!=false)
{
	
int sizes = getSize(YMMT);
System.out.println("Sizes:"+sizes);				
				
List<WebElement> vininfo = getDriver().findElements(ByLocator("com.ivm.appraisal:id/appraisal_vehicleInformation"));
List<WebElement> vin = getDriver().findElements(ByLocator("com.ivm.appraisal:id/appraisal_vin"));
List<WebElement> appraisalprice = getDriver().findElements(ByLocator("com.ivm.appraisal:id/appraisal_price"));
				
		for(int i=0;i<sizes;i++)
		{
			   String VINInfo=vininfo.get(i).getText();
			   String VIN=vin.get(i).getText();
			   String AppraisalPrice=appraisalprice.get(i).getText();
			   System.out.println("VIN Informations are: "+VINInfo+" VIN are:"+VIN+" Vehicle appraisal price: "+AppraisalPrice);
			  
			  if(VINInfo.contains(vindata))
				{
					  Totalresult= VINInfo;
								
					}else if(VIN.contains(vindata))
					{
						Totalresult= VIN;
											
					}else if(AppraisalPrice.contains(vindata))
					{
						 Totalresult=  AppraisalPrice;
						
					}else{
						 Totalresult="No search existing VIN ,YMMT, and appraised values";	
					}   
			  }
		}else
		{
			String novehicle=AppraisallistObject.novehicle;
			String testmessage=getText(novehicle);
			boolean flag1=isElementPresent(novehicle);
			Assert.assertTrue(flag1, "No vehicle found message not showing");
			Assert.assertEquals(testmessage,"You do not have any\nappraised vehicles.");
			System.out.println(getText(novehicle));
		}
}


}

	

	
	

