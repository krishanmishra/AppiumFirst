package com.ivm.android.util;


import java.util.Random;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.ivm.android.util.DriverTestCase;
import com.ivm.android.util.PropertyReader;

public abstract class DriverHelper extends DriverTestCase {

	// Define objects
	public AppiumDriver driver;

	public PropertyReader propertyReader = new PropertyReader();
	public DriverHelper(AppiumDriver webdriver) {
		driver = webdriver;
	}

	// Handle locator type
	public By ByLocator(String locator) {
		By result = null;

		if (locator.startsWith("//")) {
			result = By.xpath(locator);
		} else if(locator.startsWith("//*"))
		{
			result = By.xpath(locator);
		}else if (locator.startsWith("css=")) {
			result = By.cssSelector(locator.replace("css=", ""));
		} else if (locator.contains("id/")) {
			result = By.id(locator);
		} else if (locator.startsWith("link=")) {
			result = By.linkText(locator.replace("link=", ""));
		} else {
			result = By.className(locator);
		}
		return result;
	}

		

	

	// Assert element present
	public Boolean isElementPresent(String locator) 
	{
		Boolean result = false;
		try {
			getDriver().findElement(ByLocator(locator));
			result = true;
		} catch (Exception ex) {
		}
		return result;
	}


	// Handle click action
	public void clickOn(String locator) {
		WebElement el = getDriver().findElement(ByLocator(locator));
		el.click();
		waitForLoad(2000);
	}

	// Handle send keys action
	public void sendKeys(String locator, String text) {
		WebElement el = getDriver().findElement(ByLocator(locator));
		el.clear();
		el.sendKeys(text);
	}

	// Generate a random number
	public int randomNumber(int number)
	{
		Random ran = new Random();
		int i = ran.nextInt(number);
		return i;
	}

	// Hide KeyPad button
	public void hideKeyPad()
	{	
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getDriver().navigate().back();
	}

	// MoveToElement
	public void moveToElement(String locator)
	{
		Actions action = new Actions(getDriver());
		action.moveToElement(getDriver().findElement(ByLocator(locator))).build().perform();
	}

	// Scroll Down the window to specific text
	public void scrollDown(String locator)
	{

		if(isElementPresent(locator)==false)
		{
			scrollDown();
		}
	}

	// Scroll Down the window to specific text
	public void scroll(String key)
	{
		try {
			Thread.sleep(900);
			Runtime.getRuntime().exec(new String[] {propertyReader.readApplicationFile(key), "shell", "input", "keyevent", "20"});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	// Scroll the screen
	public void scrollDown()
	{
		scroll("JavaPath");
	}

	public int getSize(String locator){
		this.waitForElementPresent(locator, 30);
		Assert.assertTrue(isElementPresent(locator), "Element Locator :"+ locator + " Not found");
		int total = getDriver().findElements(ByLocator(locator)).size();
		return total;
	}

	// wait For Load
	public void waitForLoad(int time)
	{
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// scroll down until the element not found
	public void scrollUntilElementFound(String locator)
	{
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		boolean flag = isElementPresent(locator);
		if(flag==false)
		{
			for(int i =1;i<=10;i++)
			{
				scrollDown();
				flag = isElementPresent(locator);
				if(flag==true)
				{
					break;
				}
			}
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	// Return the weblist Elements
	public int listElements(String locator)
	{
		int listSize = driver.findElements(ByLocator(locator)).size();
		return listSize;
	}
	
	// Store text from a locator
		public String getText(String locator) {
			waitForElementPresent(locator, 20);
			Assert.assertTrue(isElementPresent(locator), "Element Locator :"+ locator + " Not found");
			String text = getDriver().findElement(ByLocator(locator)).getText();
			return text;
		}
	
	//wait for element to present
	public void waitForElementPresent(String locator, int time)
	{
		for(int i=1; i<=time; i++)
		{
			if(this.isElementPresent(locator))
				break;
			else
				Assert.fail(locator +" is not found in given time " +time);
		}
	}
	//swipe left and right
	public void swipeRight() {
		 
        Dimension size = driver.manage().window().getSize();
        int startx = (int) (size.width * 0.9);
        int endx = (int) (size.width * 0.20);
        int starty = size.height / 2;
        new TouchAction(driver).press(startx, starty)
                .waitAction(2000)
                .moveTo(endx,starty).release().perform();
    }

    public void swipeLeft() {
 
        Dimension size = driver.manage().window().getSize();
        int startx = (int) (size.width * 0.8);
       int endx = (int) (size.width * 0.20);
        int starty = size.height / 2;
     
        new TouchAction(driver).press(startx, starty)
        .waitAction(2000)
        .moveTo(endx,starty).release().perform();
    }
	public void acceptAlert() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Alert alert = getDriver().switchTo().alert();
		alert.accept();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
