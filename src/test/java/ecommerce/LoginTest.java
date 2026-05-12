//package ecommerce;
//
//import java.time.Duration;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import org.testng.annotations.BeforeMethod;
//
//import base.BaseTest;
//import pages.LoginPage;
//import utils.ConfigReader;
//
//public class LoginTest extends BaseTest {
//	@BeforeMethod
//	public void loginPage() {
//		LoginPage loginPage = new LoginPage(driver);
//		// test data (you can later move to excel / data provider)
//		String email = ConfigReader.get("name");
//        String password = ConfigReader.get("pwd");
//        loginPage.loginIntosite(email, password);
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        WebElement productText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='left mt-1'] h3")));
//        Assert.assertTrue(productText.isDisplayed(), "Automation");
//        System.out.println("Login done");
//	}
//	
//	
//}
