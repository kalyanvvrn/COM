package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TextboxLengthValidation {
	
	public void textboxLengthValidation(String viewPort, String functionality,
			String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute,
			WebElement webelement, String testData, String action,
			WebDriver driver, WebDriverWait wait, String oldValue, int j,
			String report, String application,String startTm,String endTm)
	{
		String Status=null;
		try
		{
		if(!viewPort.contains("Appium"))
		{
			String Windowid = driver.getWindowHandle();
			driver.switchTo().window(Windowid);
		}

	    String[] values=testData.split(",");
	    int length=Integer.parseInt(values[0]);
	    String charachter=values[1];
	    for(int i=0;i<=length;i++)
	    {
	    	webelement.sendKeys(charachter);
	    }
	    String str=webelement.getAttribute("value");
	    
	    
	    
	    if(str.length()==length)
	    {
	    	
	    	if (report.toUpperCase().equals("TESTSTEP")) {
				Status = "Pass";
				Results r = new Results();
				r.results(testCaseno, testCaseDescription, Status, viewPort,
						application, startTm,endTm);
			}
	    	System.out.println("text box is accepting the desired charachter");
	    }
	    else
	    {
	    	System.out.println("Text box is not accepting the desired characheters");
	    }
		}
		catch(Exception e)
		{
			System.out.println("Not able to perform operation on the textbox");
		}
	    
	
		
	
	
	
	}
	

}
