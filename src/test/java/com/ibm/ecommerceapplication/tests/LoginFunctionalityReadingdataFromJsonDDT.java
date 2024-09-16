package com.ibm.ecommerceapplication.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ibm.ecommerceapplication.testcomponents.BaseTest;
import com.ibm.ecommerceapplication.utilities.DataReader;


public class LoginFunctionalityReadingdataFromJsonDDT extends BaseTest {

	@Test(groups = { "sanity", "regression", "EndToEnd" }, dataProvider = "dataProviderUsingJson")
	public void validLoginMessagetest(HashMap<String, String> map) throws InterruptedException, IOException {

		landingPage.loginToApp(map.get("email"), map.get("password"));
		String successMessage = landingPage.getErrorMessage();

		Thread.sleep(3000);

		Assert.assertEquals(successMessage, map.get("message"));
	}

	@DataProvider(name = "dataProviderUsingJson")
	public Object[][] getData() throws IOException {
		DataReader dataReader = new DataReader();
		List<HashMap<String, String>> data = dataReader.getJsonDataToMap();
		return new Object[][] { { data.get(0) }, { data.get(1) } };
	}
}
