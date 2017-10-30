package com.ivm.android.screenHelper;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.ivm.android.locators.AppraisallistObject;
import com.ivm.android.locators.CommonObject;
import com.ivm.android.locators.InventorylistObject;
import com.ivm.android.locators.SettingObject;
import com.ivm.android.util.DriverHelper;

import io.appium.java_client.AppiumDriver;

public class InventoryListHelper extends DriverHelper {
	
	String YMMT=InventorylistObject.vehicleInformation;

	public InventoryListHelper(AppiumDriver webdriver) {
		super(webdriver);
		
	}
		
	

	public void TapmagnifiICon() {
		String invneotrytitle=InventorylistObject.inventorytitle;
		boolean flag = isElementPresent(invneotrytitle);
		Assert.assertTrue(flag, "screen title is not present");
		
		String searchICon=AppraisallistObject.search_button;
		clickOn(searchICon);
		
		String searchText=AppraisallistObject.search_text;
		String searchTexts=getText(searchText);
		System.out.println(searchTexts);
		
		Assert.assertEquals(searchTexts, "Search Inventory");
		
	}


	public void Searchresults(String searchdata) {
	
		String Totalresult="";
		String searchText=AppraisallistObject.search_text;
		sendKeys(searchText, searchdata);
		boolean flag = isElementPresent(YMMT);
		
if(flag!=false)
{
	
int sizes = getSize(YMMT);
System.out.println("Sizes:"+sizes);				
				
List<WebElement> vininfo = getDriver().findElements(ByLocator("com.ivm.appraisal:id/vehicle_information"));
List<WebElement> vin = getDriver().findElements(ByLocator("com.ivm.appraisal:id/vin"));
List<WebElement> prices = getDriver().findElements(ByLocator("com.ivm.appraisal:id/price"));
List<WebElement> stockNumber = getDriver().findElements(ByLocator("com.ivm.appraisal:id/stock_number"));
List<WebElement> age = getDriver().findElements(ByLocator("com.ivm.appraisal:id/age"));
List<WebElement> mileage = getDriver().findElements(ByLocator("com.ivm.appraisal:id/mileage"));

				
		for(int i=0;i<sizes;i++)
		{
			   String VINInfo=vininfo.get(i).getText();
			   String VIN=vin.get(i).getText();
			   String price=prices.get(i).getText();
			   String stockNumbers=stockNumber.get(i).getText();
			   String Age=age.get(i).getText();
			   String mileagee=mileage.get(i).getText();
			   
			   System.out.println("VIN Informations are: "+VINInfo+" VIN are:"+VIN+" Vehicle appraisal price: "+price+"Age :"+Age+"mileage :"+mileagee);
			  
			  if(VINInfo.contains(searchdata))
				{
					  Totalresult= VINInfo;
								
					}else if(VIN.contains(searchdata))
					{
						Totalresult= VIN;
											
					}else if(price.contains(searchdata))
					{
						 Totalresult=  price;
						
					}else if(stockNumbers.contains(searchdata))
					{
						 Totalresult=stockNumbers;
						
					}else if(Age.contains(searchdata))
					{
						 Totalresult=mileagee;
						
					}else if(mileage.contains(searchdata))
					{
						 Totalresult=mileagee;
						
					}else{
						 Totalresult="No search existing VIN ,YMMT, price, stock number,age, and mileage";	
					}   
			  }
		}else
		{
			String novehicle=InventorylistObject.novehicle;
			String testmessage=getText(novehicle);
			boolean flag1=isElementPresent(novehicle);
			Assert.assertTrue(flag1, "No vehicle found message not showing");
			Assert.assertEquals(testmessage,"There are no vehicles\nin your inventory.");
			System.out.println(getText(novehicle));
		}
  }


	public void backAction() {
		String backAction=CommonObject.ActionbackArrow;
		clickOn(backAction);
	}


	public void inventoryList() {
	
		String inventoryItem=CommonObject.Home_inventory_item;
		clickOn(inventoryItem);	
	}
}
