package com.ibm.ecommerceapplication.testcomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.ibm.ecommerceapplication.pageobjects.LandingPage;
import com.ibm.ecommerceapplication.pageobjects.NavigationBarPage;
import com.ibm.ecommerceapplication.pageobjects.OrderFinalPage;
import com.ibm.ecommerceapplication.pageobjects.PaymentPage;
import com.ibm.ecommerceapplication.pageobjects.ProductCatalougePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseTest {

	public WebDriver driver = null;
	public LandingPage landingPage = null;
	public ProductCatalougePage productCatalouge = null;
	public NavigationBarPage navigationBar = null;
	public PaymentPage paymentPage = null;
	public OrderFinalPage orderFinalPage = null;

	public Logger logger;

	public WebDriver initializeDriver() throws IOException {

        //Logging
        logger = LogManager.getLogger(this.getClass());
        
		Properties properties = new Properties();
		FileInputStream fis = new FileInputStream("./\\src\\main\\resources\\config.properties");
		properties.load(fis);
		String browser = properties.getProperty("browser");

		switch (browser) {
		case "chrome":
			driver = new ChromeDriver();
			break;

		case "firefox":
			driver = new FirefoxDriver();
			break;

		case "edge":
			driver = new EdgeDriver();
			break;
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		return driver;

	}

	@BeforeMethod(alwaysRun = true)
	public void launchApplication() throws IOException {
		driver = initializeDriver();
		landingPage = new LandingPage(driver);
		landingPage.goTo();
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";

	}

}
