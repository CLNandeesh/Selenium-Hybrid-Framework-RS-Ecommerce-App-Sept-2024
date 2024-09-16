package com.ibm.ecommerceapplication.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ibm.ecommerceapplication.testcomponents.BaseTest;

public class LoginFunctionalityUsing2DObjectArrayDDT extends BaseTest {

	@Test(groups = { "sanity", "regression", "EndToEnd" }, dataProvider = "dataProviderUsing2DObjectArray")
	public void validLoginMessagetest(String email, String password, String message)
			throws InterruptedException, IOException {

		landingPage.loginToApp(email, password);
		String successMessage = landingPage.getErrorMessage();

		Thread.sleep(3000);

		Assert.assertEquals(successMessage, message);
	}

	@DataProvider(name = "dataProviderUsing2DObjectArray")
	public Object[][] getData() {
		return new Object[][] { { "appuismyhero@gmail.com", "Apjkalam!123", "Login Successfully" },
				{ "appuismyhero@gmail.com", "Apjkalam!1234", "Incorrect email or password." } };
	}
}
