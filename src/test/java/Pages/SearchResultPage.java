package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ElementUtils.WebDriverElement;

public class SearchResultPage extends WebDriverElement{

	WebDriver driver;
	@FindBy (className="error-title")
	WebElement errorTitle;


	public String expectedError = "NETWORK PROBLEM";
	public SearchResultPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public String WaitandGetErrorValidation()
	{
		/*WaitforelementTobeVisible(driver,By.className("error-title"));
		String actualError = getTextFromElement(driver.findElement(By.className("error-title")));
		return actualError;*/

		WaitforelementTobeVisible(driver,By.className("error-title"));
		String actualError = getTextFromElement(errorTitle);
		return actualError;
	}

	public String WaitandGetErrorsubttitleValidation()
	{
		WaitforelementTobeVisible(driver,By.className("error-subtitle"));

		String actualError = getTextFromElement(driver.findElement(By.className("error-subtitle")));
		return actualError;
	}
}
