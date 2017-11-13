package com.ivm.android.screenHelper;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.ivm.android.locators.AddAppraisalObject;
import com.ivm.android.locators.AppraisaldetailsObject;
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
	   String searchtexts=getText(searchText);
		System.out.println(searchtexts);
		
		Assert.assertEquals(searchtexts, "Search Appraisals");

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
public void clickOnVehicle() {
	
	boolean flag = isElementPresent(YMMT);
	Assert.assertTrue(flag, "No vehicle found message showing");
	if(flag!=false)
	{	
		clickOn(YMMT);
				
	}else
	{
		String novehicle=AppraisallistObject.novehicle;
		String testmessage=getText(novehicle);
		boolean flag1=isElementPresent(novehicle);
		Assert.assertTrue(flag1, "No vehicle found message not showing");
		Assert.assertEquals(testmessage,"You do not have any\nappraised vehicles.");
	}
	
}

public void ActionOnGearICON() {
	
	String gearICON=AppraisallistObject.gearICon;
	String printVIEW=AppraisallistObject.printView;
	String reappraise=AppraisallistObject.re_Appraise;
	String EMAILView=AppraisallistObject.emailView;
		
	
	boolean gearflag = isElementPresent(gearICON);
	Assert.assertTrue(gearflag, "Gear icon is not showing");
	
	clickOn(gearICON);
	
	boolean printflag = isElementPresent(printVIEW);
	Assert.assertTrue(printflag, "edit vehicle icon is not showing");
	
	boolean reappraiseflag = isElementPresent(reappraise);
	Assert.assertTrue(reappraiseflag, "edit vehicle icon is not showing");
	
	boolean EMAILflag = isElementPresent(EMAILView);
	Assert.assertTrue(EMAILflag, "edit vehicle icon is not showing");
}

public void clickOnReappraisebutton(String cancel) {
	
	String reappraise=AppraisallistObject.re_Appraise;	
     clickOn(reappraise);
	
	String alerttext=CommonObject.alertpopup_text;
	Assert.assertEquals(getText(alerttext), "Reappraise Vehicle?");
	
	if(cancel.equals("Cancel"))
	{
		String confirm_Cancel=CommonObject.alert_cancel;
		clickOn(confirm_Cancel);
	}else
	{
		String confirm_reappraise=CommonObject.alert_OK;
		clickOn(confirm_reappraise);
		
		String progressbar=CommonObject.progressBar;
		WaitForElementNotPresent(progressbar,3000);	
	}
	
	
	clickOnView();
}





public void completeAppraisal() {
	
	String gearICON=AppraisallistObject.gearICon;
	clickOn(gearICON);	
	
	
	String flagICon=AppraisaldetailsObject.flagICON;
	boolean flag = isElementPresent(flagICon);
	Assert.assertTrue(flag, "edit vehicle icon is not showing");
	clickOn(flagICon);
	
	String appraisalcomplete=AppraisaldetailsObject.appraisalComplete;
	clickOn(appraisalcomplete);
	
	String apraisallist=AppraisallistObject.appraisalTitle;
	String appraisaltitle=getText(apraisallist);
	Assert.assertEquals(appraisaltitle, "APPRAISALS");
	
	boolean flagg = isElementPresent(YMMT);
	Assert.assertTrue(flagg, "No vehicle found message showing");
	
}
public void closeappraisalVehicle() {
	String discardScreen=CommonObject.discardscreen;
	clickOn(discardScreen);
	
}
public void BackToDetails() {
	
	String vehicleinfo=CommonObject.screenTitle;
	String vechicleinformation=getText(vehicleinfo);
	
	String backlink=CommonObject.backArrow;
	clickOn(backlink);
	
	String vehicleinfo1=CommonObject.screenTitle;
	String vechicleinformation1=getText(vehicleinfo1);
	
	Assert.assertEquals(vechicleinformation, vechicleinformation1);
}
public void ClickOnNotes() {
	String notesbutton=AppraisaldetailsObject.notesbutton;
	clickOn(notesbutton);
		
	String notesTitle=CommonObject.screenTitle;
	Assert.assertEquals("NOTES", getText(notesTitle));
	
	String notesButton=AppraisaldetailsObject.addNotes;
	boolean flag = isElementPresent(notesButton);
	if(flag==true)
	{
		System.out.println("vehicle can add Notes");
	}else
	{
		System.out.println("vehicle can view the added Notes");
	}
	
	String backlink=CommonObject.backArrow;
	clickOn(backlink);
}
public void ClickOnPhotosButton() {
	
	String photosbutton=AppraisaldetailsObject.photosbutton;
	clickOn(photosbutton);
	
	String title=CommonObject.screenTitle;
	Assert.assertEquals("VEHICLE PHOTOS", getText(title));
			
	String addphotobuttons=AppraisaldetailsObject.addPhotobutton;
	String selectPhotoLink=AppraisaldetailsObject.selectPhotolink;
	
	boolean flag=isElementPresent(addphotobuttons)&&isElementPresent(selectPhotoLink);
	
	if(flag==true)
	{
		System.out.println("Appraisal vehicle able to add photos in edit mode");
	}else 
	{
		System.out.println("Appraisal vehicle are in view mode");
	}
	
	String backlink=CommonObject.backArrow;
	clickOn(backlink);
	
}
public void clickOnView() {
	
	String editICon=AppraisallistObject.editVehicleIcon;
	boolean flag = isElementPresent(editICon);
	Assert.assertTrue(flag, "edit vehicle icon is not showing");
	
	clickOn(editICon);
	
	String addAppraisal=AddAppraisalObject.checkAddAppraisal;
	boolean flag1=isElementPresent(addAppraisal);
	
	if(flag1==true)
	{
		System.out.println("Appraisal vehicle is editable");
		clickOn(addAppraisal);
	}else
	{
		System.out.println("vehicle are viewable only");
	}
	
}




}

	

	
	

