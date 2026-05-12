package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.WaitUtils;

public class ViewOrderPage{
	 WebDriver driver;
	 WaitUtils wait;
	 
	    public ViewOrderPage(WebDriver driver) {
	        this.driver = driver;
	        wait= new WaitUtils(driver);
	    }
	    public void goToOrdersPage() {
        wait.waitForElementVisible(By.xpath("(//button[@class='btn btn-custom'])[2]"));
		driver.findElement(By.xpath("(//button[@class='btn btn-custom'])[2]")).click();
		 wait.waitForElementVisible(By.xpath("(//button[@class='btn btn-primary'])[1]"));
		 driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[1]")).click();
		 wait.waitForElementClickable(By.cssSelector(".btn.-teal']"));
		 driver.findElement(By.cssSelector(".btn.-teal")).click();
		 wait.waitForElementVisible(By.xpath("//button[@class='btn btn-primary col-md-2 offset-md-4']"));
		 driver.findElement(By.xpath("//button[@class='btn btn-primary col-md-2 offset-md-4']"));
	    }
}
