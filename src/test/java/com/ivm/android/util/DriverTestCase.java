package com.ivm.android.util;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.ivm.android.locators.LoginObject;
import com.ivm.android.screenHelper.UserLoginHelper;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;



public abstract class DriverTestCase {

	//Declaration of variables
	private static AppiumDriver driver ;
	private static AppiumDriverLocalService service;
	PropertyReader propertyReader = new PropertyReader();

  //  public String username= propertyReader.readApplicationFile("Username");
	//public String password= propertyReader.readApplicationFile("Password");
//	public String offUsername= propertyReader.readApplicationFile("OFF_Username");
//	public String offPassword= propertyReader.readApplicationFile("OFF_password");
	
	 @BeforeClass
	public static void setUp() throws MalformedURLException
	{
		 service = AppiumDriverLocalService.buildDefaultService();
	        service.start();

	        if (service == null || !service.isRunning())
	        {
	            throw new AppiumServerHasNotBeenStartedLocallyException(
	                    "An appium server node is not started!");
	        }
	        
	        
	        
//	        File f=new File("src/test/java");
//			File fs=new File(f,"ApiDemos-debug.apk");    
		DesiredCapabilities capabilities = new DesiredCapabilities();
		//capabilities.setCapability("appium-version", "1.0");
		//capabilities.setCapability("platformName", "Android");
		//capabilities.setCapability("platformVersion", "5.0.1");
		//capabilities.setCapability("deviceName", "baf8e4a4");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "krishanemulator");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		//cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.ivm.appraisal" );
		capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.ivm.appraisal.areas.LauncherActivity" );
		capabilities.setCapability("fullReset", false);
		capabilities.setCapability("unicodeKeyboard", true);
		capabilities.setCapability("resetKeyboard", true);
		//capabilities.setCapability("app", propertyReader.getPath()+"/app/app-theLab.apk");

		try{
		
			
			driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities) 
			// driver = new AppiumDriver<>(service.getUrl(), capabilities);
			  {

				public MobileElement scrollToExact(String arg0) 
				{
					// TODO Auto-generated method stub
					return null;
				}

				public MobileElement scrollTo(String arg0) 
				{
					// TODO Auto-generated method stub
					return null;
				}
			};	

   }		
	 catch (Exception ex)
		{
			driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities)
			
			
			{

				public MobileElement scrollToExact(String arg0) {
					// TODO Auto-generated method stub
					return null;
				}

				public MobileElement scrollTo(String arg0) {
					// TODO Auto-generated method stub
					return null;
				}
			};	

		}

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	public AppiumDriver getDriver()
	{
		return driver;
	}

	
//Handle child windows
	public String switchPreviewWindow() {
		Set<String> windows = getDriver().getWindowHandles();
		Iterator<String> iter = windows.iterator();
		String parent = iter.next();
		getDriver().switchTo().window(iter.next());
		return parent;
	}
	// login to the application
		public void  login(String userType) throws InterruptedException
		{

			UserLoginHelper loginHelper = new UserLoginHelper(this.getDriver());

			String userName = propertyReader.readApplicationFile(userType + "_Username");
			
			String password = propertyReader.readApplicationFile(userType + "_Password");
			
			loginHelper.enterUsername(userName);
			loginHelper.enterPasscode(password);
			loginHelper.tapOnSignIn();
			WebElement el = getDriver().findElement(By.className("android.widget.ImageButton"));
			el.click();
			
			
		  }
	
	
	
	
	
		/**
	     * finishing.
	     */
	    @AfterClass
	    public static void afterClass() {
	        if (driver != null) {
	            driver.quit();
	        }
	        if (service != null) {
	            service.stop();
	        }
	    }
}
