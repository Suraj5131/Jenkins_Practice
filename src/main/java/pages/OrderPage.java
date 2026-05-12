package pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BaseTest;
import utils.WaitUtils;

public class OrderPage {

    WebDriver driver;
    WaitUtils wait;
    protected static final Logger log= LogManager.getLogger(BaseTest.class);
    public OrderPage(WebDriver driver) {
        this.driver = driver;
        wait = new WaitUtils(driver);
    }
    public ViewOrderPage orderProduct() {
        driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
        wait.waitForElementVisible(By.xpath("(//button[@class='btn btn-primary'])[2]"));
        driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[2]")).click();
        wait.waitForElementVisible(By.xpath("(//div[@class='payment__types']/div)[1]"));
        driver.findElement(By.xpath("(//input[@class='input txt'])[1]")).sendKeys("789");
        driver.findElement(By.xpath("(//input[@class='input txt'])[2]")).sendKeys("Suraj Lokhande");
        driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("ind");
        wait.waitForElementVisible(By.cssSelector(".ta-item"));
        List<WebElement> countries = driver.findElements(By.cssSelector(".ta-item"));
        for (WebElement country : countries) {
            if (country.getText().equalsIgnoreCase("India")) {
                country.click();
                break;
            }
        }
        driver.findElement(By.cssSelector(".btnn")).click();
        wait.waitForElementVisible(By.cssSelector(".hero-primary"));
        log.info("Product Placed");
        return new ViewOrderPage(driver);
    }
}