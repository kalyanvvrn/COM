package framework;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Link {
	public void link(String viewPort, String functionality,
			String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute,
			WebElement webelement, String testData, String action,
			WebDriver driver, WebDriverWait wait, String oldValue, int j,String report,String application)
			throws InterruptedException, IOException {
String Status=null;
		try {

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Thread.sleep(6000);
			if(!viewPort.contains("Appium"))
			{
				String Windowid = driver.getWindowHandle();
				driver.switchTo().window(Windowid);
			}
		 
			webelement.click();
			if(report.toUpperCase().equals("TESTSTEP"))
			{
			Status="Pass";
			Results r=new Results();
			r.results(testCaseno, testCaseDescription, Status,viewPort,application);
			}
			
		} catch (Exception e) {
			
			
			
			if (report.toUpperCase().equals("TESTSTEP")) {
				Status = "Pass";
				Results r = new Results();
				r.results(testCaseno, testCaseDescription, Status,viewPort,application);
			}
			
		}
	}
}
