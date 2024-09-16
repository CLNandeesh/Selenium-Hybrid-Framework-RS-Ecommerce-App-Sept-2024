package com.ibm.ecommerceapplication.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.ibm.ecommerceapplication.testcomponents.*;

import com.ibm.ecommerceapplication.testcomponents.BaseTest;

public class LoginFunctionalityTest extends BaseTest{

	@Test(groups={"regression"},retryAnalyzer=Retry.class)
	public void invalidLoginMessagetest() throws InterruptedException, IOException {

		landingPage.loginToApp("appuismyhero@gmail.com", "Apjkalam!123");
		String errorMessage = landingPage.getErrorMessage();

		Thread.sleep(3000);

		Assert.assertEquals(errorMessage, "Incorrect email or password.");
	}
	
	@Test(groups={"sanity","regression","EndToEnd"})
	public void validLoginMessagetest() throws InterruptedException, IOException {

		landingPage.loginToApp("appuismyhero@gmail.com", "Apjkalam!123");
		String successMessage = landingPage.getErrorMessage();

		Thread.sleep(3000);

		Assert.assertEquals(successMessage, "Login Successfully");
	}
	
}
