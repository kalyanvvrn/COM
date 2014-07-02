package framework;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindElement {

	public WebElement find_Element(String ObjectIdentifierType,
			String ObjectIdentifier, WebDriver driver, WebDriverWait wait,
			String viewPort, String testCaseno, String testCaseDescription,
			String application) throws IOException {
		String Status = null;
		WebElement webelement = null;
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        if (!viewPort.contains("Appium")) {
			String Windowid = driver.getWindowHandle();
			driver.switchTo().window(Windowid);
		}
		// System.out.println();
		if (ObjectIdentifierType.toUpperCase().equals("XPATH")) {
			try {
				webelement = driver.findElement(By.xpath(ObjectIdentifier));
			} catch (Exception e) {

				Status = "Fail";
				Results r = new Results();
				r.results(testCaseno, testCaseDescription, Status, viewPort,
						application);
			}
		} else if (ObjectIdentifierType.toUpperCase().equals("CSS")) {
			try {
				// System.out.println("Came to CSS");
				webelement = driver.findElement(By
						.cssSelector(ObjectIdentifier));
			} catch (Exception e) {
				File scrFile = ((TakesScreenshot) driver)
						.getScreenshotAs(OutputType.FILE);
				// Now you can do whatever you need to do with it, for example
				// copy somewhere
				System.out.println("Came to link image");
				org.apache.commons.io.FileUtils.copyFile(scrFile, new File(
						"/Users/kalyan_v/Desktop/FRAMEWORK/linkimage.png"));
				Status = "Fail";
				Results r = new Results();
				r.results(testCaseno, testCaseDescription, Status, viewPort,
						application);
			}
		} else if (ObjectIdentifierType.toUpperCase().equals("ID")) {
			try {
				webelement = driver.findElement(By.id(ObjectIdentifier));
			} catch (Exception e) {
				Status = "Fail";
				Results r = new Results();
				r.results(testCaseno, testCaseDescription, Status, viewPort,
						application);
			}
		} else if (ObjectIdentifierType.toUpperCase().equals("TAG")) {
			try {
				webelement = driver.findElement(By.tagName(ObjectIdentifier));
			} catch (Exception e) {
				Status = "Fail";
				Results r = new Results();
				r.results(testCaseno, testCaseDescription, Status, viewPort,
						application);
			}
		} else if (ObjectIdentifier.toUpperCase().equals("Class")) {
			try {
				webelement = driver.findElement(By.className(ObjectIdentifier));
			} catch (Exception e) {
				Status = "Fail";
				Results r = new Results();
				r.results(testCaseno, testCaseDescription, Status, viewPort,
						application);
			}
		}

		return webelement;
	}
}
