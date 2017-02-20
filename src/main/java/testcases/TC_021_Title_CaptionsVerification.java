package testcases;

import java.text.ParseException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.Home_Page_and_Login_Page;
import wrappers.ESPNWrappers;

public class TC_021_Title_CaptionsVerification extends ESPNWrappers
{
	@BeforeClass
	public void setValues()
	{
		browserName = "chrome";
		testCaseName = "TC_021_Title_CaptionsVerification";
		testDescription = " Verify title & captions are displayed(Last/Next match)";
		category = "Regression";
		authors = "Prabhu";
	}

	@Test
	public void TableLink() throws InterruptedException 
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
		.verifyScheduleTitle()
		.verifyLastMatchSectionTitle()
		.verifyNextMatchSectionTitle();
	}
}


