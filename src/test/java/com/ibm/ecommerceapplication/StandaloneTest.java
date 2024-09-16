package com.ibm.ecommerceapplication;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StandaloneTest {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		String product="ADIDAS ORIGINAL";
		
		driver.get("https://rahulshettyacademy.com/client");

		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("appuismyhero@gmail.com");
		driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("Apjkalam!123");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement addToCart = driver
				.findElement(By.xpath("//b[text()='ADIDAS ORIGINAL']/parent::h5/following-sibling::button[2]"));
		addToCart.click();

		// WebElement message=driver.findElement(By.id("toast-container"));

		// wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));

		// Thread.sleep(5000);
		WebElement message = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		String successMessage = message.getText();
		System.out.println("Success message is: " + successMessage);

		Thread.sleep(3000);

		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();

		driver.findElement(By.xpath("//button[text()='Checkout']")).click();

		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("india");

		List<WebElement> list = driver
				.findElements(By.xpath("//button[@class='ta-item list-group-item ng-star-inserted']/span"));
		Actions actions = new Actions(driver);

		for (WebElement w : list) {
			System.out.println(w.getText());
			if (w.getText().equalsIgnoreCase("India")) {
				actions.click(w).build().perform();
				break;
			}
		}

		Thread.sleep(5000);
		// driver.findElement(By.xpath("//a[normalize-space()='Place Order']")).click();
		actions.click(driver.findElement(By.xpath("//a[normalize-space()='Place Order']"))).build().perform();

		System.out.println("Message is: " + driver.findElement(By.xpath("//h1[@class='hero-primary']")).getText());
		System.out
				.println("Message is: " + driver.findElement(By.xpath("//label[@class='ng-star-inserted']")).getText());

	}

}
