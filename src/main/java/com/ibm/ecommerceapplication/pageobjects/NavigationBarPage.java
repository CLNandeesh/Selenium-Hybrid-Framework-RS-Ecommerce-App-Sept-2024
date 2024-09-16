package com.ibm.ecommerceapplication.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ibm.ecommerceapplication.utilities.Utilities;

public class NavigationBarPage extends Utilities {
	
	public WebDriver driver;

	public NavigationBarPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this); // Initialize current class driver object
	}

	// Page Factory design pattern
	@FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
	WebElement cartButton;
	
	public MyCartPage clickOnCart()
	{
		waitForAnElementToAppear(cartButton);
		cartButton.click();
		return new MyCartPage(driver);
	}

}
