package framework;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.android.AndroidDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Selecting_Device {
	@SuppressWarnings({ })
	WebDriver driver = null;
	DesiredCapabilities capabilities = new DesiredCapabilities();

	@SuppressWarnings("deprecation")
	public WebDriver selectdevice(String Driv) {
		// System.out.println("Came1");
		if (Driv.toUpperCase().equals("FIREFOX")) {
			// System.out.println("Came");
			return new FirefoxDriver();
		} else if (Driv.toUpperCase().equals("SAFARI"))
			return new SafariDriver();

		else if (Driv.toUpperCase().equals("ANDROID"))
			return new AndroidDriver();

		else if (Driv.toUpperCase().equals("APPAND"))

			capabilities.setCapability("device", "Android");
		capabilities.setCapability(CapabilityType.VERSION, "4.4");
		capabilities.setCapability(CapabilityType.PLATFORM, "MAC");

		try {
			driver = new RemoteWebDriver(
					new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return driver;

	}
}
