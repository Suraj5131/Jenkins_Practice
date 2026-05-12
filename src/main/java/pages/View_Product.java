package pages;

import java.util.List;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.LoggerUtil;
import utils.ScreenshotUtil;
public class View_Product {
	WebDriver driver;
	Logger log;
	public View_Product(WebDriver driver, String testName) {
		this.driver=driver;
		log = LoggerUtil.getLogger(testName);
	}
	public void viewProduct() {
		log.info("Started View Product Test");
	    List<WebElement> products = driver.findElements(By.cssSelector("div.card"));
	    for (int i = 0; i < products.size(); i++) {
	        products = driver.findElements(By.cssSelector("div.card"));
	        WebElement product = products.get(i);
	        if (product.getText().contains("ADIDAS ORIGINAL")) {
	            product.findElement(By.xpath(".//button[1]")).click();
	            ScreenshotUtil.takeScreenshot(driver, "ViewProduct", "Teststep1");
	            break;
	        }
	        	    }
	    log.info("View product done");
	    driver.findElement(By.xpath("//a[@routerlink='/dashboard']")).click();
	    log.info("Clicked Continue Shopping");
	    ScreenshotUtil.takeScreenshot(driver, "ViewProduct", "Teststep2");
	    log.info("Continue Shopping Completed");
		
	}
	
}
