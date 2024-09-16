package com.ibm.ecommerceapplication.tests;

import java.io.IOException;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ibm.ecommerceapplication.testcomponents.BaseTest;

public class LoginFunctionalityUsing2DHashMapDDT extends BaseTest{
	@Test(groups = { "sanity", "regression", "EndToEnd" }, dataProvider = "dataProviderUsingHashMap")
	public void validLoginMessagetest(HashMap<String,String> map)
			throws InterruptedException, IOException {

		landingPage.loginToApp(map.get("email"), map.get("password"));
		String successMessage = landingPage.getErrorMessage();

		Thread.sleep(3000);

		Assert.assertEquals(successMessage, map.get("message"));
	}

	@DataProvider(name = "dataProviderUsingHashMap")
	public Object[][] getData() {
		
		HashMap<String,String> map1=new HashMap<>();
		map1.put("email","appuismyhero@gmail.com");
		map1.put("password","Apjkalam!123");
		map1.put("message","Login Successfully");
		
		HashMap<String,String> map2=new HashMap<>();
		map2.put("email","appuismyhero@gmail.com");
		map2.put("password","Apjkalam!1234");
		map2.put("message","Incorrect email or password.");
		
		return new Object[][] { {map1},{map2} };
	}
}
