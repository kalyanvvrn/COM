package framework;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageCheckpoint {
	
	public void pageCheckpoint(String viewPort, String functionality,
			String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute,
			WebElement webelement, String testData, String action,
			WebDriver driver, WebDriverWait wait, String oldValue, int j,
			String report, String application,String startTm,String endTm) throws IOException
	{
		String Status = null;
		try {
			if (!viewPort.contains("Appium")) {
				String Windowid = driver.getWindowHandle();
				driver.switchTo().window(Windowid);
			}
			
			if (driver.getTitle().equals(testData))
			{
				System.out.println("Page "+testData+" loaded successfully");
				Status = "Pass";
				Results r = new Results();
				r.results(testCaseno, testCaseDescription, Status,
						viewPort, application, startTm,endTm);
			}
			else
			{
				System.out.println("Page "+testData+" not loaded ");
				Status = "Fail";
				Results r = new Results();
				r.results(testCaseno, testCaseDescription, Status,
						viewPort, application, startTm,endTm);
			}
			
		}catch(Exception e)
		{
			
			
				Status = "Fail";
				Results r = new Results();
				r.results(testCaseno, testCaseDescription, Status, viewPort,
						application, startTm,endTm);
				System.out.println("Page "+testData+" not loaded ");
				
		}

	}
}

