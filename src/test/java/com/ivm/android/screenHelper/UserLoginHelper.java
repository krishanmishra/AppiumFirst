package com.ivm.android.screenHelper;



import org.testng.Assert;

import com.ivm.android.locators.CommonObject;
import com.ivm.android.locators.DrawerObject;
import com.ivm.android.locators.LoginObject;
import com.ivm.android.util.DriverHelper;
import io.appium.java_client.AppiumDriver;


public class UserLoginHelper extends DriverHelper{

	public UserLoginHelper(AppiumDriver driver) 
	{
		super(driver);	
		
	}
	
	

	public void appDetails()
	{
		
		//views -Native,Hybrid and webview
		//System.out.println(driver.getContext());
		//System.out.println(driver.getOrientation());
   }
	

	// Enter User name
	public void enterUsername(String username)
	{
		String Username_locator=LoginObject.Username;
		sendKeys(Username_locator,username);
	}

	// Enter Pass code
	public void enterPasscode(String passowrd)
	{
		String passowrd_locator=LoginObject.Password;
		sendKeys(passowrd_locator,passowrd);
	}

	// Tap on the SignIn button
	public void tapOnSignIn()
	{
		String login_locator=LoginObject.login_button;
		clickOn(login_locator);
     }

	//Verify user is logged
	public void verifyUserLoggedIn()
	{
		String checknewpopup=LoginObject.CheckwhatsNewpopup;
		String user_locator=LoginObject.Usernames;
		String dealer_locator=LoginObject.DealerName;
		clickOn(checknewpopup);
		boolean flag = isElementPresent(user_locator);
		boolean flag1 = isElementPresent(dealer_locator);
		Assert.assertTrue(flag, "User name is not displaying on Home screen");
		Assert.assertTrue(flag1, "Dealer is not displaying on Home screen");
	}

	public void loggedOut() throws InterruptedException 
	{
		String drawer_menu=DrawerObject.OpenDrawer;
		String logout_link=DrawerObject.logout;
		String logoutpopup=CommonObject.alertpopup_text;
		String logoutButton=LoginObject.Logout_button;
			  
		clickOn(drawer_menu);
		clickOn(logout_link);
		boolean flag = isElementPresent(logoutpopup);
 		Assert.assertTrue(flag, "Logout pop up not displaying");
 		String logoutTexxt=getText(logoutpopup);
 		Assert.assertEquals("Logout of IVM?", logoutTexxt);
		System.out.println(getText(logoutpopup));
		clickOn(logoutButton);
}
		
	

	//Verify user is logged out
	public void verifyUserLoggedOut()
	{ 
		String Username_locator=LoginObject.Username;
		boolean flag = isElementPresent(Username_locator);
		Assert.assertTrue(flag, "User is not logged out from application");	
	}
	
	// Verify validation message for invalid credentials
	public void verifyValidationMessage()
	{
		String snackbar_message=CommonObject.snackbar_text;
		Assert.assertTrue(isElementPresent(snackbar_message), "Validation message does not appear");
		
	}
}
