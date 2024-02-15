package com.Accu.nopCommenrce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class BuildYourOwnComputer {
	@Test
	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "F:/Automation/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Initiate Webdriver wait
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		
		//maximize the window size
		driver.manage().window().maximize();
		
		//Navigate to the website
		driver.get("https://demo.nopcommerce.com/");
		
		//Capture the clickable element

		WebElement lnkComputer = driver.findElement(By.xpath("//a[text()='Build your own computer']"));
		
		//Click the link and navigate
		lnkComputer.click();
		
		//Capture header element of the item
		WebElement hItem = driver.findElement(By.xpath("//h1[text()='Build your own computer']"));
		
		//Validate landing to the correct page
		Assert.assertTrue(hItem.isDisplayed(), "Item header displays successfully");
		
		//Capture element processor
		WebElement ddProcessor = driver.findElement(By.xpath("//select[@id='product_attribute_1']"));
		Select selector = new Select(ddProcessor);
		
		//Select value from dropdown list
		selector.selectByVisibleText("2.2 GHz Intel Pentium Dual-Core E2200");
		
		//Capture element processor
		WebElement ddRam = driver.findElement(By.xpath("//select[@id='product_attribute_2']"));
		selector = new Select(ddRam);
		
		//Select value from dropdown list
		selector.selectByVisibleText("2 GB");
		
		//Capture element radio button
		WebElement rbtnHdd400 = driver.findElement(By.id("product_attribute_3_7"));
		
		//Click radio button
		rbtnHdd400.click();
		
		//Capture element radio button
		WebElement rbtnOS = driver.findElement(By.id("product_attribute_4_9"));
				
		//Click radio button
		rbtnOS.click();
		
		//Capture element checkbox
		WebElement chkbxSoftwareMsOfc = driver.findElement(By.id("product_attribute_5_10"));
		
		//Deselect the selected checkbox
		if (chkbxSoftwareMsOfc.isSelected())
			chkbxSoftwareMsOfc.click();
		
		//Capture element checkbox
		WebElement chkbxSoftware = driver.findElement(By.id("product_attribute_5_11"));
		
		//Select chceckbox
		chkbxSoftware.click();
		
		//Wait till calculation finished
		//wait.withTimeout(Duration.ofSeconds(5000));
		
		//Wait till calculation finished
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("price-value-1"), "$1,370.00"));
		
		//Capture the price 
		WebElement lblPrice = driver.findElement(By.id("price-value-1"));
		
		//Capture element add to cart button
		WebElement btnAddToCart = driver.findElement(By.id("add-to-cart-button-1"));
		
		
		//Verify the price value with expected price
		Assert.assertEquals(lblPrice.getText(), "$1,370.00");
		System.out.println("Assert A | Pass | Price is equal to $1,370.00 ");
		
		//Capture element unit quantity 
		WebElement inQuantity = driver.findElement(By.id("product_enteredQuantity_1"));
		
		//Verify the unit quantity value with expected value
		Assert.assertEquals(inQuantity.getAttribute("value"), "1");
		System.out.println("Assert B | Pass | Quantity is equal to 1");
		
		//Click Add to cart button
		btnAddToCart.click();
		
		//Wait till calculation finished
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='bar-notification']//p")));
		
		//Capture element top bar notification
		WebElement pBarNotification = driver.findElement(By.xpath("//div[@id='bar-notification']//p"));
		
		//Verify the success message 
		Assert.assertTrue(pBarNotification.getText().contains("The product has been added"));
		System.out.println("Assert C | Pass | The product has been added successfully");
		
		//Close the test browser instance
		if(driver !=null)
		driver.quit();
		System.out.println("****Test Add to cart Build Your Own Test Passed successfully.****");
	}

}
