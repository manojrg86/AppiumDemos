package com.ios.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SafariLauncherTest {

	public static void main(String[] args) throws MalformedURLException, InterruptedException{
		System.out.println("Starting Safari test in iPad");
		AppiumDriver wd=null;		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("appium-version", "1.0");
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("platformVersion", "7.1");
		capabilities.setCapability("deviceName", "iPad");
		capabilities.setCapability("app", "/Users/rshanmu/Library/Developer/Xcode/DerivedData/SafariLauncher-dnvjqmexzysokzdgbibagitqmmwi/Build/Products/Debug-iphoneos/SafariLauncher.app");
		wd = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Thread.sleep(20000);
		Set<String> contextHandles=wd.getContextHandles();
		for (String string : contextHandles) {
			if(string.contains("WEBVIEW")){
				wd.context(string);
				break;
			}
		}
		Set<String> windowHandles =wd.getWindowHandles();
		int count=windowHandles.size();
		int tempCount=0;
		for (String string : windowHandles) {
			wd.switchTo().window(string);
			tempCount++;
			if(tempCount==count){
				break;
			}else{
				wd.close();
			}
		}
		wd.get("http://www.sears.com");
		WebElement searchBox=wd.findElement(By.xpath("//input[@id='keyword']"));
		searchBox.sendKeys("Hammer");
		WebElement searchButton=wd.findElement(By.xpath("//input[@id='goBtn']"));
		searchButton.click();
		Thread.sleep(10000);
		wd.findElement(By.xpath("(//div[contains(@id,'cardProdAddToCart')]//a)[1]")).click();
		Thread.sleep(5000);
		wd.findElement(By.xpath("//a[contains(text(),'Go to Cart')]")).click();
		Thread.sleep(10000);
		wd.findElement(By.xpath("(//a[contains(@class,'remove-item')])[1]")).click();
		Thread.sleep(10000);
		wd.quit();
		System.out.println("Test Completed");

	}

}
