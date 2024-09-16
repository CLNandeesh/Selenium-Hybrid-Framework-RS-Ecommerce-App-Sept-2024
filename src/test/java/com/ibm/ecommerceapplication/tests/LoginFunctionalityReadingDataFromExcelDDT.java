package com.ibm.ecommerceapplication.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ibm.ecommerceapplication.testcomponents.BaseTest;
import com.ibm.ecommerceapplication.utilities.DataProviders;
import com.ibm.ecommerceapplication.utilities.ExcelUtility;

public class LoginFunctionalityReadingDataFromExcelDDT extends BaseTest {

	@Test(dataProvider = "LoginData",dataProviderClass = DataProviders.class)
	public void validLoginMessagetest(String email, String password, String message)
			throws InterruptedException, IOException {

		landingPage.loginToApp(email, password);
		String successMessage = landingPage.getErrorMessage();

		Thread.sleep(3000);

		Assert.assertEquals(successMessage, message);
	}

}
	
