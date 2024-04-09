package ElementUtils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverElement {

	public void EnterText(WebElement element,String TexttoBeEnter)
	{
		if(element.isDisplayed())
		{
			element.clear();
			element.sendKeys(TexttoBeEnter);
		}
	}
	public void ClickOnButton(WebElement element)
	{
		if(element.isDisplayed())
		{
			element.click();
		}
	}

	public String getTextFromElement(WebElement element)
	{
		if(element.isDisplayed())
		{
			return element.getText();
		}
		return null;
	}

	public String getAttributeFromElement(WebElement element,String attributeValue)
	{
		if(element.isDisplayed())
		{
			return element.getAttribute(attributeValue);
		}
		return null;
	}

	public void WaitforelementTobeVisible(WebDriver driver, By element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(element));

	}

	public void WaitforelementTobeClickable(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	public void ClickOnBackButton(WebDriver driver)
	{
		driver.navigate().back();
	}

	public String getScreenshot(WebDriver driver, String fileName) throws IOException
	{
		TakesScreenshot ts =(TakesScreenshot)driver;
		File SourceFile =ts.getScreenshotAs(OutputType.FILE);
		File DestinationFile = new File(System.getProperty("user.dir")+"//Screenshot//"+fileName+".png");
		FileUtils.copyFile(SourceFile,DestinationFile);
		return DestinationFile.toString();
	}
}
