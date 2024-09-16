package com.ibm.ecommerceapplication.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ibm.ecommerceapplication.utilities.Utilities;

public class ProductCatalougePage extends Utilities {

	public WebDriver driver;

	public ProductCatalougePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this); // Initialize current class driver object
	}

	// Page Factory design pattern
	@FindBy(xpath = "//b[text()='ADIDAS ORIGINAL']/parent::h5/following-sibling::button[2]")
	WebElement addToCartButton;



	public void addToCart(String product) {
		String sample = "demo";
		String xpathTemp = "//b[text()='" + sample + "']/parent::h5/following-sibling::button[2]";
		By productBy = By.xpath(xpathTemp.replace(sample, product));
		
		waitForAnElementToAppear(driver.findElement(productBy));
		driver.findElement(productBy).click();
	}

}
