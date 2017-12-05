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
	// Enter User name
	public void enterUsername(String username)
	{
		String Email_address=LoginObject.Username;
		sendKeys(Email_address,username);
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
		String user_locator=LoginObject.Usernames;
		String dealer_locator=LoginObject.DealerName;
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
		String logoutButton=CommonObject.alert_OK;
			  
		clickOn(drawer_menu);
		clickOn(logout_link);
		boolean flag = isElementPresent(logoutpopup);
 		Assert.assertTrue(flag, "Logout pop up not displaying");
 		
 		String logoutTexxt=getText(logoutpopup);
 		Assert.assertEquals("Logout of IVM?", logoutTexxt);
 			
		clickOn(logoutButton);		
	}	
	//Verify user is logged out
	public void verifyUserLoggedOut()
	{ 
		String Username_locator=LoginObject.Username;
		boolean flag = isElementPresent(Username_locator);
		Assert.assertTrue(flag, "User is not logged out from application");	
	}
	
	// Verify validation message to validate account
	public void validateUser()
	{	
		String loginfailed=LoginObject.login_failed;
		boolean str=isElementPresent(loginfailed);
	
		
		String alertpopuptext=CommonObject.alertpopup_text;
		boolean flag=isElementPresent(alertpopuptext);
								
		String validatemessge="Account Validation Required. Activate your account by clicking the link in the validation email sent to you. For additional help, please contact support at 1–800–647–8425";
		String failed="Login has failed. Please try again.";
							
		if(str == true)
		{
			Assert.assertEquals(getText(loginfailed),failed);
						
		}else if(flag == true)
		{			
			Assert.assertEquals(getText(alertpopuptext),validatemessge);
			String alertOK=CommonObject.alert_OK;
			clickOn(alertOK);
		}else
		{
			String whatsNew=CommonObject.screenTitle;
			String title="WHAT'S NEW";
			Assert.assertEquals(getText(whatsNew),title);
			String checkbox=LoginObject.CheckwhatsNewpopup;
			clickOn(checkbox);				
		}		
	}
	public void tapOnForgotPassword() {
		String fogotPassword=LoginObject.forGotpassword;		
		boolean str=isElementPresent(fogotPassword);		
		Assert.assertTrue(str,"forgot password link not present");		
		clickOn(fogotPassword);		
		String titles=CommonObject.screenTitle;
		String title="FORGOT PASSWORD";
		Assert.assertEquals(getText(titles),title);
		
		String passwordtext="Enter your email address and we'll send a link to reset your password.";
		String fogotpasswordTxt=LoginObject.fogotpasswordTExt;
		Assert.assertEquals(getText(fogotpasswordTxt),passwordtext);		
	}
	public void resetPassword(String resetemail_address) {	
			
		String input_error="Enter a valid email address.";
		String confirmReset="An email has been sent to reset your password.";
		String snackbar=CommonObject.snackbar_text;
		String validation=CommonObject.validation_message;
						
		String emailAddress=LoginObject.email_address;
		String resetButton=LoginObject.resetbutton;
		
		
		sendKeys(emailAddress,resetemail_address);
		clickOn(resetButton);
		
		boolean str=isElementPresent(validation);
		
		if(str == true)
		{
		Assert.assertEquals(getText(validation),input_error );
		}else{
			//String snackmessage=getText(snackbar);
			//JavascriptExecutor js = (JavascriptExecutor)driver;
			//String text = js.executeScript("return document.getElementById('com.ivm.appraisal:id/snackbar_text').innerHTML").toString();
			//System.out.println("WebElement Text is : "+ text);
			
			String text=driver.switchTo().alert().getText();
			Assert.assertEquals(text,confirmReset);
		}			
		String back=CommonObject.backArrow;
		clickOn(back);				
	}
	
	public void LoginScreen() {
				
		String login=LoginObject.Username;
		boolean flag=isElementPresent(login);
		Assert.assertTrue(flag, "Email address field not present");
		
		String pwd=LoginObject.Password;
		boolean flag1=isElementPresent(pwd);
		Assert.assertTrue(flag1, "password field not present");
		
		String forgot=LoginObject.forGotpassword;
		boolean flag2=isElementPresent(forgot);
		Assert.assertTrue(flag2, "forgot password link not present");
	}
	
	
	// Verify validation message for invalid credentials
		public void verifyValidationMessage()
		{
			String snackbar_message=CommonObject.snackbar_text;
			Assert.assertTrue(isElementPresent(snackbar_message), "Validation message does not appear");
			
			String invalidUser="Invalid credentials. Please try again.";
			Assert.assertEquals(getText(snackbar_message),invalidUser);
			
			
		}
}
