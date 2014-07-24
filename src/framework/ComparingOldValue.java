package framework;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ComparingOldValue {
	public void comparingOldValue(String viewPort, String functionality,
			String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute,
			WebElement webelement, String testData, String action,
			WebDriver driver, WebDriverWait wait, String oldValue, int j,
			String report, String application,String startTm,String endTm) throws InterruptedException,
			IOException {
		String Status = null;
		try {
			if (!viewPort.contains("Appium")) {
				String Windowid = driver.getWindowHandle();
				driver.switchTo().window(Windowid);
			}
			Thread.sleep(4000);
			String NewValue = webelement.getText();
			System.out.println(NewValue);
			String value = oldValue;
			String TestDatavalue = testData;
			Float ActualNewValue = Float.parseFloat(NewValue);
			Float ActualoldValue = Float.parseFloat(value);
			Float ActualTestData = Float.parseFloat(TestDatavalue);
			System.out.println("Value Entered from the excel is :"
					+ ActualTestData);
			System.out.println("Value captured form the application is :"
					+ ActualoldValue);
			System.out.println((ActualoldValue + ActualTestData));
			System.out.println((ActualoldValue + ActualTestData));
			System.out.println(ActualNewValue);
			if ((ActualoldValue + ActualTestData) == ActualNewValue) {
				System.out.println("Data is changed/added");
				if (report.toUpperCase().equals("TESTSTEP")) {
					Status = "Pass";
					Results r = new Results();
					r.results(testCaseno, testCaseDescription, Status,
							viewPort, application, startTm,endTm);
				}
			}

			else {
				System.out.println("Data is not changed/added");
				if (report.toUpperCase().equals("TESTSTEP")) {
					Status = "Fail";
					Results r = new Results();
					r.results(testCaseno, testCaseDescription, Status,
							viewPort, application, startTm,endTm);
				}
			}
		} catch (Exception e) {
			if (report.toUpperCase().equals("TESTSTEP")) {
				Status = "Fail";
				Results r = new Results();
				r.results(testCaseno, testCaseDescription, Status, viewPort,
						application, startTm,endTm);
			}
		}
	}
}
