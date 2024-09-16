package com.ibm.ecommerceapplication.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ibm.ecommerceapplication.utilities.Utilities;

public class LandingPage extends Utilities{

	public WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this); // Initialize current class driver object
	}

	// Page Factory design pattern
	@FindBy(xpath = "//input[@id='userEmail']")
	WebElement emailTextbox;

	@FindBy(xpath = "//input[@id='userPassword']")
	WebElement passwordTextbox;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorText;

	@FindBy(xpath="//input[@value='Login']")
	WebElement signinButton;

	public ProductCatalougePage loginToApp(String email,String password)
	{
		waitForAnElementToAppear(emailTextbox);
		emailTextbox.sendKeys(email);
		passwordTextbox.sendKeys(password);
		signinButton.click();
		return new ProductCatalougePage(driver);
	}
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public String getErrorMessage()
	{
		waitForAnElementToAppear(errorText);
		return errorText.getText();
	}

}
