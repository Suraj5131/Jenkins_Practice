package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {
	private static Logger log;
	public static String takeScreenshot(WebDriver driver,String getClass,String testName) {
		log = LoggerUtil.getLogger(testName);
		File mainFolder= new File("Screnshots");
		if(!mainFolder.exists()) {
			mainFolder.mkdir();
		}
		
		File classFolder= new File(mainFolder, getClass);
		if(!classFolder.exists()) {
			classFolder.mkdir();
		}
		
		String fileName=testName+"_"+System.currentTimeMillis()+".png";
		File dest= new File(classFolder,fileName);
		
		TakesScreenshot ts= (TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(src, dest);
            log.info("Screenshot saved at: " + dest.getAbsolutePath());
		}
		catch(IOException  e) {
			e.printStackTrace();
		}
		return dest.getAbsolutePath();
		
	}
	
}
