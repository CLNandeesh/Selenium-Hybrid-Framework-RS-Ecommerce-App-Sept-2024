package com.ibm.ecommerceapplication.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ibm.ecommerceapplication.pageobjects.MyCartPage;
import com.ibm.ecommerceapplication.pageobjects.NavigationBarPage;
import com.ibm.ecommerceapplication.testcomponents.BaseTest;

public class AddProductsToCartTest extends BaseTest {

	@Test(groups={"sanity"})
	public void addSingleProductToCart() throws InterruptedException, IOException {

		productCatalouge = landingPage.loginToApp("appuismyhero@gmail.com", "Apjkalam!123");

		Thread.sleep(3000);

		// Product catalouge page
		productCatalouge.addToCart("ADIDAS ORIGINAL");

		Thread.sleep(3000);

		// NavigationBar page
		navigationBar = new NavigationBarPage(driver);
		MyCartPage myCartPage = navigationBar.clickOnCart();

		Thread.sleep(3000);

		// MyCart Page
		paymentPage = myCartPage.clickOnCheckout();

		Thread.sleep(3000);

		// Payment Page
		paymentPage.selectCountry("India");
		Thread.sleep(3000);
		orderFinalPage = paymentPage.clickOnPlaceOrder();

		Thread.sleep(3000);

		// OrderFinal Page
		Assert.assertEquals(orderFinalPage.getSuccessMessage(), "THANKYOU FOR THE ORDER.");
		Assert.assertNotNull(orderFinalPage.getOrderIdMessage());

		
	}
	
	@Test(groups={"EndToEnd"})
	public void addMultipleElementToCart() throws InterruptedException, IOException {

		productCatalouge = landingPage.loginToApp("appuismyhero@gmail.com", "Apjkalam!123");

		Thread.sleep(3000);

		// Product catalouge page
		productCatalouge.addToCart("ADIDAS ORIGINAL");
		Thread.sleep(3000);
		productCatalouge.addToCart("ZARA COAT 3");

		Thread.sleep(3000);

		// NavigationBar page
		navigationBar = new NavigationBarPage(driver);
		MyCartPage myCartPage = navigationBar.clickOnCart();

		Thread.sleep(3000);

		// MyCart Page
		paymentPage = myCartPage.clickOnCheckout();

		Thread.sleep(3000);

		// Payment Page
		paymentPage.selectCountry("India");
		Thread.sleep(3000);
		orderFinalPage = paymentPage.clickOnPlaceOrder();

		Thread.sleep(3000);

		// OrderFinal Page
		Assert.assertEquals(orderFinalPage.getSuccessMessage(), "THANKYOU FOR THE ORDER.");
		Assert.assertNotNull(orderFinalPage.getOrderIdMessage());

		
	}
}
