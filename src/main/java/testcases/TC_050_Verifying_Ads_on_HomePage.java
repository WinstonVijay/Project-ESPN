package testcases;

import java.text.ParseException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.Home_Page_and_Login_Page;
import wrappers.ESPNWrappers;

public class TC_050_Verifying_Ads_on_HomePage extends ESPNWrappers
{
	@BeforeClass
	public void setValues()
	{
		browserName = "chrome";
		testCaseName = "TC_050_Verifying_Ads_on_HomePage";
		testDescription = "Verify the total count of advertisements in the Home page";
		category = "Regression";
		authors = "Prabhu";
	}

	@Test
	public void adsVerification()
	{
		new Home_Page_and_Login_Page(driver, test)
		.verifyingAds();
	}
}


