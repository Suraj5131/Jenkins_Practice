package pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;
import utils.WaitUtils;

public class Add_to_cart {
	WebDriver driver;
	WaitUtils wait;
	protected static final Logger log= LogManager.getLogger(BaseTest.class);
	public Add_to_cart(WebDriver driver) {
		this.driver=driver;
    	PageFactory.initElements(driver, this);
    	 wait = new WaitUtils(driver);  
		
	}
	public void add_to_cart() {
		 List<WebElement> products = driver.findElements(By.cssSelector("div.card"));
		 for (int i = 0; i < products.size(); i++) {
			 products = driver.findElements(By.cssSelector("div.card"));
			 WebElement product = products.get(i);

		        if (product.getText().contains("ADIDAS ORIGINAL")) {

		            product.findElement(By.xpath(".//button[2]")).click();
		            break;
		        }
		       
		 }
		 log.info("Product added into cart");
		 wait.waitForElementVisible(By.cssSelector("#toast-container"));	
		 wait.waitForElementInVisible(By.cssSelector("#toast-container"));
		 log.info("Product added and toast handled");
	}
}
