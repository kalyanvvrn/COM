package framework;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EndTime {
	public String endTime() throws ParseException
	{
		
		String endTm=null;
		DateFormat end=new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date newdate=new Date();
		String date=end.format(newdate);
		Date endTime=end.parse(date);
		endTm=end.format(endTime);
		return endTm;
	}

}
