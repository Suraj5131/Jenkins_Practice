package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    String testName;
    public LoginPage(WebDriver driver, String testName) {
       this.driver = driver;
        this.testName = testName;
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "#userEmail")
    WebElement email;
    @FindBy(css = "input[type='password']")
    WebElement password;
    @FindBy(id = "login")
    WebElement loginbtn;
    public View_Product loginIntosite(String name, String pwd) {
        email.sendKeys(name);
        password.sendKeys(pwd);
        loginbtn.click();
        return new View_Product(driver, testName);
    }
}