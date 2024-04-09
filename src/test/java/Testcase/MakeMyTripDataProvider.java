package Testcase;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import Utils.ExcelRead;

public class MakeMyTripDataProvider {
	
	String[][] validData = {{"MAA","PNQ","15"},{"PNQ","MAA","25"}};
	String[][] invalidData = {{"MAA","MAA"},{"PNQ","PNQ"},{"BLR","BLR"}};

	@DataProvider
	public String[][] validSearchTestData() throws IOException
	{
		return validData;
	}

	@DataProvider
	public String[][] invalidSearchTestData() throws IOException
	{
		return invalidData;
	}


}
