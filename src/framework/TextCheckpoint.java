package framework;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TextCheckpoint {
	public void textCheckpoint(String viewPort, String functionality,
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

			// ((JavascriptExecutor)
			// driver).executeScript("arguments[0].scrollIntoView(true);",
			// Text);
			Thread.sleep(500);
			// System.out.println(Text.getText());
			if (webelement.getText().equals(testData)) {
				System.out.println("Object with the text:"
						+ webelement.getText() + " is displaying correctly");
				if (report.toUpperCase().equals("TESTSTEP")) {
					Status = "Pass";
					Results r = new Results();
					r.results(testCaseno, testCaseDescription, Status,
							viewPort, application);
				}
			} else {
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
