package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {
	private static ThreadLocal<WebDriver> driver= new ThreadLocal<>();
	
	public static WebDriver initDriver() {
		
		String browser=ExcelReader.getData("browser");
		if(browser.equalsIgnoreCase("chrome")) {
			ChromeOptions opt = new ChromeOptions();
			opt.addArguments("--incognito");
			driver.set(new ChromeDriver(opt));
		}
		getDriver().manage().window().maximize();
		return getDriver();
	}
	public static WebDriver getDriver() {
		return driver.get();
		
	}
	public static void quitDriver() {
		getDriver().quit();
		driver.remove();
	}
}