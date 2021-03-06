package framework;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DataCheckpointNegetive {
	public void dataCheckpointNegetive(String viewPort, String functionality,
			String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute,
			WebElement webelement, String testData, String action,
			WebDriver driver, WebDriverWait wait, String oldValue, int j,
			String report, String application) throws IOException {
		String Status = null;
		try {

			// Thread.sleep(5000);
			if (!viewPort.contains("Appium")) {
				String Windowid = driver.getWindowHandle();
				driver.switchTo().window(Windowid);
			}

			if (!webelement.getText().equals(testData)) {
				System.out.println(testCaseDescription
						+ " Displaying correctly as " + webelement.getText());

				if (report.toUpperCase().equals("TESTSTEP")) {
					Status = "Pass";
					Results r = new Results();
					r.results(testCaseno, testCaseDescription, Status,
							viewPort, application);
				}
			} else {
				System.out.println(testCaseDescription
						+ " Displaying incorrectly as " + webelement.getText());

				if (report.toUpperCase().equals("TESTSTEP")) {
					Status = "Fail";
					Results r = new Results();
					r.results(testCaseno, testCaseDescription, Status,
							viewPort, application);
				}
			}
		} catch (Exception e) {
			if (report.toUpperCase().equals("TESTSTEP")) {
				Status = "Fail";
				Results r = new Results();
				r.results(testCaseno, testCaseDescription, Status, viewPort,
						application);
			}
		}
	}
}
