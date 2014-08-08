package framework;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.android.AndroidDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.iphone.IPhoneDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Selecting_Device {
	@SuppressWarnings({ })
	WebDriver driver = null;
	DesiredCapabilities capabilities = new DesiredCapabilities();

	@SuppressWarnings("deprecation")
	public WebDriver selectdevice(String Driv) throws Exception {
		String Value=Driv.toUpperCase();
		
		switch(Value)
		{
		//this will return the firefox driver 
		case "FIREFOX": return new FirefoxDriver();
		//this will return safari driver
		case "SAFARI" : return new SafariDriver();
		case "CHROME" : return new ChromeDriver();
		case "IE"     : return new InternetExplorerDriver();
		case "ANDROID": return new AndroidDriver();
		case "IOS"    : return new IPhoneDriver();
		case "APPAND" :  capabilities.setCapability("device", "Android");
		                 capabilities.setCapability(CapabilityType.VERSION, "4.4");
		                 capabilities.setCapability(CapabilityType.PLATFORM, "MAC");

		                 try {
			                driver = new RemoteWebDriver(
					                           new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			              return driver;
		                     } catch (Exception e) {
		                  	System.out.println(e.getMessage());
	                     	}
		                 
		case "APPIOS"  :   capabilities.setCapability(CapabilityType.BROWSER_NAME,"iOS");
		                    capabilities.setCapability(CapabilityType.VERSION, "7.1");
		                    capabilities.setCapability(CapabilityType.PLATFORM, "Mac");
		                    
		                    try {
			                driver = new RemoteWebDriver(
			                            		new URL("http://127.0.0.1:4723/wd/hub/"), capabilities);
		                 	return driver;
	                     	} catch (Exception e) {
	                     		System.out.println(e.getMessage());
			                
		                    }
		                    
		case "APPCHROME":   capabilities.setCapability("device", "Android");
		                      capabilities.setCapability("deviceName", "Android");
		                      capabilities.setCapability(CapabilityType.VERSION, "4.4");
		                      capabilities.setCapability(CapabilityType.PLATFORM, "MAC");
		                      capabilities.setCapability("platformName", "Android");
	                          capabilities.setCapability("app", "chrome");
	                          try {
	  			                driver = new RemoteWebDriver(
	  			                            		new URL("http://127.0.0.1:4723/wd/hub/"), capabilities);
	  		                 	return driver;
	  	                     	} catch (Exception e) {
	  	                     		System.out.println(e.getMessage());
	  			                
	  		                    }
	                          
		case "SELENDROID":  driver=new RemoteWebDriver(DesiredCapabilities.android());
		return driver;
		
		
	     default:return null;
			
		                    	}
	
	
	}
}
