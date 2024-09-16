package com.ibm.ecommerceapplication.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.ibm.ecommerceapplication.testcomponents.*;

import com.ibm.ecommerceapplication.testcomponents.BaseTest;

public class LoginFunctionalityTest extends BaseTest {

	@Test(groups = { "regression" }, retryAnalyzer = Retry.class)
	public void invalidLoginMessagetest() throws InterruptedException, IOException {

		logger.info("invalidLoginMessagetest STARTED");

		landingPage.loginToApp("appuismyhero@gmail.com", "Apjkalam!1234");
		logger.info("Entered Email and Password");

		String errorMessage = landingPage.getErrorMessage();
		logger.info(errorMessage);
		
		Thread.sleep(3000);

		Assert.assertEquals(errorMessage, "Incorrect email or password.");

		logger.info("invalidLoginMessagetest ENDED");
	}

	@Test(groups = { "sanity", "regression", "EndToEnd" })
	public void validLoginMessagetest() throws InterruptedException, IOException {

		logger.info("invalidLoginMessagetest STARTED");

		landingPage.loginToApp("appuismyhero@gmail.com", "Apjkalam!123");
		logger.info("Entered Email and Password");
		String successMessage = landingPage.getErrorMessage();
		logger.info(successMessage);

		Thread.sleep(3000);

		Assert.assertEquals(successMessage, "Login Successfully");
		logger.info("invalidLoginMessagetest ENDED");
	}

}
