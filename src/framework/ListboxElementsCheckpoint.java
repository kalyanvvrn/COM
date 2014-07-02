package framework;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ListboxElementsCheckpoint {
	public void listboxElementsCheckpoint(String viewPort,
			String functionality, String driverExecute, String testCaseno,
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
			Thread.sleep(2000);

			// WebElement ListElement=driver.findElement(By.tagName("select"));

			String[] Parts = testData.split(",");

			Select Select = new Select(webelement);
			List<WebElement> List = Select.getOptions();

			int counter = 0;
			for (int i = 0; i < List.size(); i++) {
				if (List.get(i).getText().equals(Parts[i])) {
					System.out.println("list Item " + i + " "
							+ List.get(i).getText());
					counter = counter + 1;
				}
			}

			if (counter == List.size()) {
				System.out
						.println("All the list items are displaying correctly");
				if (report.toUpperCase().equals("TESTSTEP")) {
					Status = "Pass";
					Results r = new Results();
					r.results(testCaseno, testCaseDescription, Status,
							viewPort, application);
				}

			} else {
				System.out
						.println("All the list items are not displaying correctly");
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
