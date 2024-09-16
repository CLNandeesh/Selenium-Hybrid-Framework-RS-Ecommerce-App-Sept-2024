package com.ibm.ecommerceapplication.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilities {

	public WebDriver driver;
	public WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
	public Utilities(WebDriver driver) {
		this.driver=driver;
	}
	
	public void waitForAnElementToAppear(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForAnElementToAppear(By by) {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}
	
	public void waitForAnElementToBeClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
}
