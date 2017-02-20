package testcases;

import java.text.ParseException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.Home_Page_and_Login_Page;
import wrappers.ESPNWrappers;

public class TC_023_TimezoneVerification_LastMatchandNextmatch extends ESPNWrappers
{
	@BeforeClass
	public void setValues()
	{
		browserName = "chrome";
		testCaseName = "TC_023_TimezoneVerification_LastMatchandNextmatch";
		testDescription = " Verify timezone for both (Last/Next match)";
		category = "Regression";
		authors = "Prabhu";
	}

	@Test
	public void timezoneverification() throws InterruptedException 
	{
		new Home_Page_and_Login_Page(driver, test)
		.mouseHoverFootball()
		.clickleaguesandcups()
		.clickEPLLink()
		.clicktablelink()
		.mouseHover_YearDropdown()
		.changeYear_YearDropdown()
		.selectTeam()
		.clickFixturesandResultsLink()
		.verifyLastMatchTiming()
		.verifyNextMatchTiming();
	}
}


