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
			WebDriver driver, WebDriverWait wait, String oldValue, int j,String report,String application,String startTm,String endTm)
			throws InterruptedException, IOException {
        String Status=null;
		try {

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			//Thread.sleep(6000);
			if(!viewPort.contains("Appium"))
			{
				String Windowid = driver.getWindowHandle();
				driver.switchTo().window(Windowid);
			}
		 System.out.println("Came to link");
			webelement.click();
			System.out.println("Came to link1");
			if(report.toUpperCase().equals("TESTSTEP"))
			{
				
			Status="Pass";
			Results r=new Results();
			r.results(testCaseno, testCaseDescription, Status,viewPort,application, startTm,endTm);
			}
			
		} catch (Exception e) {
			
			
			
			if (report.toUpperCase().equals("TESTSTEP")) {
				Status = "Fail";
				Results r = new Results();
				r.results(testCaseno, testCaseDescription, Status,viewPort,application, startTm,endTm);
			}
			
		}
	}
}
