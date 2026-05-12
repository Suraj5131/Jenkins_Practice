package base;

import java.lang.reflect.Method;
import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pages.LoginPage;
import utils.DriverFactory;
import utils.ExcelReader;
import utils.LoggerUtil;

public class BaseTest {

    protected WebDriver driver;
    protected Logger log;
    @BeforeMethod
    public void setup(Method method) {
    	String testName = method.getName();
        log = LoggerUtil.getLogger(testName);
        log.info("Initializing driver");
        driver = DriverFactory.initDriver();
        log.info("Opening URL");
        driver.get(ExcelReader.getData("url"));
        log.info("Logging into application");
        LoginPage loginPage =new LoginPage(driver, testName);
        loginPage.loginIntosite(ExcelReader.getData("name"),ExcelReader.getData("pwd"));
        WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));
        WebElement productText =wait.until( ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='left mt-1'] h3")));
        Assert.assertTrue(productText.isDisplayed(),"Automation");
    }
    @AfterMethod
    public void tearDown(ITestResult result) {
        DriverFactory.quitDriver();
        if (result.getStatus() == ITestResult.SUCCESS) {

            log.info("TEST PASSED : " + result.getName());

        } else if (result.getStatus() == ITestResult.FAILURE) {

            log.error("TEST FAILED : " + result.getName());

            log.error("Reason : " + result.getThrowable());

        } else if (result.getStatus() == ITestResult.SKIP) {

            log.warn("TEST SKIPPED : " + result.getName());
        }
        log.info("Driver Quit");
    }
}