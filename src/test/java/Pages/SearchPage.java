package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ElementUtils.WebDriverElement;

public class SearchPage extends WebDriverElement{


	WebDriver driver;
	@FindBy (className="close")
	WebElement closeButton;
	@FindBy (xpath="//*[@for='fromCity']")
	WebElement FromCity;
	@FindBy (xpath="//*[@for='toCity']")
	WebElement ToCity;
	@FindBy (xpath="//*[text()='Search']")
	WebElement Search;
	@FindBy (xpath="//*[@data-cy='sameCityError']")
	WebElement SameCityError;

	public String expectedsamecityError = "From & To airports cannot be the same";
	public SearchPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void ClickOnAdd()
	{
		try
		{
			Thread.sleep(5000);
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("webklipper-publisher-widget-container-notification-frame"));
			List<WebElement> elementexist = driver.findElements(By.className("close"));
			if(elementexist.size()>0)
			{
				//driver.findElement(By.className("close")).click();
				closeButton.click();
			}
			driver.switchTo().defaultContent();
		}catch(Exception e)
		{
			System.out.println(e);
		}

	}

	public void ClickOnFrom()
	{
		//WaitforelementTobeClickable(driver, driver.findElement(By.xpath("//*[@for='fromCity']")));
		//ClickOnButton(driver.findElement(By.xpath("//*[@for='fromCity']")));
		WaitforelementTobeClickable(driver,FromCity);
		ClickOnButton(FromCity);

	}

	public void ClickOnTo()
	{
		//WaitforelementTobeClickable(driver, driver.findElement(By.xpath("//*[@for='toCity']")));
		//ClickOnButton(driver.findElement(By.xpath("//*[@for='toCity']")));
		WaitforelementTobeClickable(driver,ToCity);
		ClickOnButton(ToCity);

	}

	public void SelectValueFromList(String expectedText)
	{
		String alllocElement = "(//*[@id='react-autowhatever-1']//ul)[last()]//li";
		List<WebElement> allLocation = driver.findElements(By.xpath(alllocElement));
		for(int i=1;i<=allLocation.size();i++)
		{
			String actualCode = driver.findElement(By.xpath(alllocElement+"["+i+"]//div[starts-with(@class,'font14')]")).getText();
			if(actualCode.equalsIgnoreCase(expectedText)) {
				ClickOnButton(driver.findElement(By.xpath(alllocElement+"["+i+"]")));
				break;
			}
		}
	}
	public void SelectDateFromCalender(String expectedDate)
	{
		String calenderWeekPath ="(//*[@class='DayPicker-Month'])[2]//*[@class='DayPicker-Week']";
		List<WebElement> totalWeeks = driver.findElements(By.xpath(calenderWeekPath));
		for(int i=1;i<=totalWeeks.size();i++)
		{
			List<WebElement> eachDayinWeek = driver.findElements(By.xpath(calenderWeekPath+"["+i+"]//*[starts-with(@class,'DayPicker-Day')]"));
			for(int j=1;j<=eachDayinWeek.size();j++)
			{
				String className = getAttributeFromElement(driver.findElement(By.xpath(calenderWeekPath+"["+i+"]//*[starts-with(@class,'DayPicker-Day')]["+j+"]")),"class");
				if(!(className.contains("disabled") || className.contains("outside")))
				{
					String actualDate = getTextFromElement(driver.findElement(By.xpath(calenderWeekPath+"["+i+"]//*[starts-with(@class,'DayPicker-Day')]["+j+"]//p[1]")));
					if(actualDate.equalsIgnoreCase(expectedDate))
					{
						ClickOnButton(driver.findElement(By.xpath(calenderWeekPath+"["+i+"]//*[starts-with(@class,'DayPicker-Day')]["+j+"]")));
						break;
					}
				}
			}
		}
	}

	public void ClickOnSearch()
	{
		//ClickOnButton(driver.findElement(By.xpath("//*[text()='Search']")));

		ClickOnButton(Search);

	}

	public String GetSameCityError()
	{
		//return getTextFromElement(driver.findElement(By.xpath("//*[@data-cy='sameCityError']")));
		return getTextFromElement(SameCityError);
	}
}
