package com.ibm.ecommerceapplication.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ibm.ecommerceapplication.utilities.Utilities;

public class OrderFinalPage extends Utilities {

	public WebDriver driver;

	public OrderFinalPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this); // Initialize current class driver object
	}

	// Page Factory design patter
	@FindBy(xpath = "//h1[@class='hero-primary']")
	WebElement successMessageText;
	
	@FindBy(xpath = "//label[@class='ng-star-inserted']")
	WebElement orderIdText;
	
	public String getSuccessMessage()
	{
		waitForAnElementToAppear(successMessageText);
		return successMessageText.getText();	
	}
	
	public String getOrderIdMessage()
	{
		waitForAnElementToAppear(orderIdText);
		return orderIdText.getText();	
	}
	
}
