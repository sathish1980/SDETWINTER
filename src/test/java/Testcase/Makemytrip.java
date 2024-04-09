package Testcase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import BrowserDriver.BrowserLaunch;
import Pages.SearchPage;
import Pages.SearchResultPage;
import Utils.ReadProperty;

public class Makemytrip extends BrowserLaunch{
	int count=0;
	@BeforeSuite
	public void LaunchDriver()
	{
		launchAndMaximize("chrome");
	}
	@BeforeTest
	public void LaunchURL() throws IOException
	{
		//String URL =ReadProperty.GetPropertyData().getProperty("url");
		driver.get("https://www.makemytrip.com/");
		SearchPage sp = new SearchPage(driver);
		//sp.ClickOnAdd();
	}
	@Test(priority=0,dataProvider="validSearchTestData",dataProviderClass=MakeMyTripDataProvider.class)
	public void validSearch(String from, String to,String date) throws InterruptedException, IOException
	{
		/*
			Select From location dropdown
			Select value from location
			Select To location dropdown
			Select value To location
			Select Date
			Click Search
			Validate the search result
		 */

		SearchPage sp = new SearchPage(driver);
		Thread.sleep(5000);
		sp.ClickOnAdd();
		sp.ClickOnFrom();
		sp.SelectValueFromList(from);
		sp.ClickOnTo();
		sp.SelectValueFromList(to);
		sp.SelectDateFromCalender(date);
		sp.ClickOnSearch();
		SearchResultPage srp = new SearchResultPage(driver);
		String actualError = srp.WaitandGetErrorValidation();
		System.out.println(actualError);
		Assert.assertEquals(actualError, srp.expectedError);
		driver.navigate().back();

	}

	

	@Test(priority=1,dataProvider="invalidSearchTestData",dataProviderClass=MakeMyTripDataProvider.class)
	public void SameCityValidation(String from, String to) throws InterruptedException {
		/*
		 * Click back button
		 * click To location
		 * Select same as from location value
		 * validate error message
		 */
		SearchPage sp = new SearchPage(driver);
		//sp.ClickOnBackButton(driver);
		//sp.ClickOnAdd();
		//Thread.sleep(5000);
		sp.ClickOnFrom();
		sp.SelectValueFromList(from);
		sp.ClickOnTo();
		sp.SelectValueFromList(to);
		String actualError =sp.GetSameCityError();
		Assert.assertEquals(actualError, sp.expectedsamecityError);
	}

	@AfterSuite
	public void closeBrowser()
	{
		tearDown();
	}
}
