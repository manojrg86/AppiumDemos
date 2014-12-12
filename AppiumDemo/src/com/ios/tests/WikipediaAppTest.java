package com.ios.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class WikipediaAppTest {
	public static void main(String[] args) throws MalformedURLException {
		WebDriver wd=null;
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("appium-version", "1.0");
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("platformVersion", "7.1");
		capabilities.setCapability("deviceName", "iPad");
		capabilities.setCapability("app", "/Users/rshanmu/Library/Developer/Xcode/DerivedData/Wikipedia_Mobile-cijiccheslhbabbbzttvbzhkyqay/Build/Products/Debug-iphoneos/Wikipedia Mobile.app");
		wd = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		wd.findElement(By.name("Cancel")).click();
		((JavascriptExecutor)wd).executeScript("mobile: tap", new HashMap<String, Double>(){{put("tapCount", (double)1); put("touchCount",(double) 1); put("duration",(double) 0.5); put("x", (double)22); put("y", (double)25); }});
		wd.findElement(By.name("S")).click();
		wd.findElement(By.name("e")).click();
		wd.findElement(By.name("a")).click();
		wd.findElement(By.name("r")).click();
		wd.findElement(By.name("s")).click();
		wd.findElement(By.name("Search")).click();
		wd.findElement(By.name("Cancel")).click();
		wd.quit();

	}
}
