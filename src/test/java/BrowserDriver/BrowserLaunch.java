package BrowserDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class BrowserLaunch {

	public static WebDriver driver;

	// String ReportPath = System.getProperty("user.dir")+"//Reports//MakemyTripAutomation.html";

	public void launchAndMaximize(String browsername)
	{
		if(browsername.equalsIgnoreCase("chrome"))
		{
			driver= new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("edge"))
		{
			driver= new EdgeDriver();
		}
		else
		{
			driver =null;
		}
		driver.manage().window().maximize();
		}

	public void tearDown()
	{
		//report.flush();
		driver.quit();

	}
}
