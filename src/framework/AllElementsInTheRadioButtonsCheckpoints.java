package framework;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllElementsInTheRadioButtonsCheckpoints {
	public void allElementsInTheRadioButtonsCheckpoints(String viewPort,
			String functionality, String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute,
			WebElement webelement, String testData, String action,
			WebDriver driver, WebDriverWait wait, String oldValue, int j,
			String report, String application,String startTm,String endTm) throws IOException {
		String Status = null;
		try {

			if (!viewPort.contains("Appium")) {
				String Windowid = driver.getWindowHandle();
				driver.switchTo().window(Windowid);
			}

			List<WebElement> List = webelement
					.findElements(By.tagName("input"));
			String[] Values = testData.split(",");
			int i = 0;
			for (WebElement Radioitem : List) {
				if (Radioitem.getText().equals(Values[i])) {
					i = i + 1;
				}
			}
			if (i == List.size()) {
				System.out.println("All radio Butotns are there");
				if (report.toUpperCase().equals("TESTSTEP")) {
					Status = "Pass";
					Results r = new Results();
					r.results(testCaseno, testCaseDescription, Status,
							viewPort, application, startTm,endTm);
				}
			} else {
				System.out.println("All Radio buttons are not there");
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
