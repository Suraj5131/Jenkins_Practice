package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BaseTest;
import utils.WaitUtils;

public class CartPage {
	WebDriver driver;
	WaitUtils wait;
	protected static final Logger log= LogManager.getLogger(BaseTest.class);
	public CartPage(WebDriver driver) {
		this.driver=driver;
		wait= new WaitUtils(driver);
	}
	public void cartView() {
		
		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
		wait.waitForElementVisible(By.xpath("(//button[@class='btn btn-primary'])[1]"));
		driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[1]")).click();
		log.info("Click on continues shopping");
	}
}
