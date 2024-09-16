package com.ibm.ecommerceapplication.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ibm.ecommerceapplication.utilities.Utilities;

public class MyCartPage extends Utilities{

	public WebDriver driver;

	public MyCartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this); // Initialize current class driver object
	}

	// Page Factory design pattern
	@FindBy(xpath = "//button[text()='Checkout']")
	WebElement checkoutButton;
	
	public PaymentPage clickOnCheckout()
	{
		waitForAnElementToAppear(checkoutButton);
		Actions actions = new Actions(driver);
		actions.click(checkoutButton).build().perform();
		return new PaymentPage(driver);
	}
	
	
}
