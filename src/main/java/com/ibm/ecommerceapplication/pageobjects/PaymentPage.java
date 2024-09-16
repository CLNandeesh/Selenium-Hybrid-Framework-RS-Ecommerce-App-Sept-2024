package com.ibm.ecommerceapplication.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ibm.ecommerceapplication.utilities.Utilities;

public class PaymentPage extends Utilities {

	public WebDriver driver;
	public Actions actions;
	
	public PaymentPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this); // Initialize current class driver object
	}

	// Page Factory design pattern
	@FindBy(xpath = "//button[@class='ta-item list-group-item ng-star-inserted']/span")
	List<WebElement> countriesLinks;

	@FindBy(xpath = "//input[@placeholder='Select Country']")
	WebElement countryTextbox;

	@FindBy(xpath = "//a[normalize-space()='Place Order']")
	WebElement placeOrderButton;

	public void selectCountry(String country) {
		waitForAnElementToAppear(countryTextbox);
		countryTextbox.sendKeys(country);
		

		for (WebElement w : countriesLinks) {
			if (w.getText().equalsIgnoreCase(country)) {
				actions = new Actions(driver);
				actions.click(w).build().perform();
				break;
			}
		}
	}

	public OrderFinalPage clickOnPlaceOrder() {
		waitForAnElementToBeClickable(placeOrderButton);
		actions.click(placeOrderButton).build().perform();
		return new OrderFinalPage(driver);
	}

}
