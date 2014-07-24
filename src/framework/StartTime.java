package framework;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StartTime {
	
	
	public Date startTime(String viewPort,
			String functionality, String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute,
			WebElement webelement, String testData, String action,
			WebDriver driver, WebDriverWait wait, String oldValue, int j,
			String report, String application,String startTm,String endTm) throws ParseException
	{
		DateFormat start=new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date newdate=new Date();
		String date=start.format(newdate);
		
		Date startDate=start.parse(date);
		
		return startDate;
	}

}
