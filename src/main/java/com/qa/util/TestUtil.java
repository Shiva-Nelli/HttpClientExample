package com.qa.util;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import com.qa.factory.DriverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtil {

	private static WebDriver driver= DriverFactory.getDriver();
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long WAIT = 20;

	static JavascriptExecutor js;

	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}


	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}

	public static  void explicitWaitElementToBeClickable(WebElement element)
	{
		WebDriverWait clickableWait = new WebDriverWait(driver, Duration.ofSeconds(WAIT));
		clickableWait.until(ExpectedConditions.elementToBeClickable(element));

	}

	public static  void explicitWaitVisibiblityOf(WebElement element)
	{
		WebDriverWait clickableWait = new WebDriverWait(driver, Duration.ofSeconds(WAIT));
		clickableWait.until(ExpectedConditions.visibilityOf(element));

	}


	public static void javaScriptClick(WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public static void javaScriptScroll(WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	public static String gerRandomString(int n)
	{
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
				+ "0123456789"
				+ "abcdefghijklmnopqrstuvxyz";
		StringBuilder sb = new StringBuilder(n);
		for (int i = 0; i < n; i++) {
			int index = (int)(AlphaNumericString.length() * Math.random());
			sb.append(AlphaNumericString.charAt(index));
		}

		return sb.toString();
	}



}
