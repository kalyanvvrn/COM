package framework;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Refresh {
	public void refresh(String viewPort, String functionality,
			String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute,
			WebElement webelement, String testData, String action,
			WebDriver driver, WebDriverWait wait, String oldValue, int j,
			String report, String application) throws IOException {
		String Status = null;
		try {
			if (!viewPort.contains("Appium")) {
				String Windowid = driver.getWindowHandle();
				driver.switchTo().window(Windowid);
			}

			webelement.sendKeys(Keys.F5);
		} catch (Exception e) {
			if (report.toUpperCase().equals("TESTSTEP")) {
				Status = "Pass";
				Results r = new Results();
				r.results(testCaseno, testCaseDescription, Status, viewPort,
						application);
			}
		}
	}
}
