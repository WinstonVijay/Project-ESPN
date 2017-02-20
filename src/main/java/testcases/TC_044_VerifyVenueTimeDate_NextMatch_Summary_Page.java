package testcases;

import java.text.ParseException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Home_Page_and_Login_Page;
import wrappers.ESPNWrappers;

public class TC_044_VerifyVenueTimeDate_NextMatch_Summary_Page extends ESPNWrappers
{
	@BeforeClass
	public void setValues()
	{
		browserName = "chrome";
		testCaseName = "TC_044_VerifyVenueTimeDate_NextMatch_Summary_Page";
		testDescription = "Verify Next match Venue,Date & Time";
		category = "Regression";
		authors = "Vignesh";
	}

	@Test
	public void Verify_venuetimedate_NextMatch_Summary_Page() throws InterruptedException, ParseException
	{
		new Home_Page_and_Login_Page(driver, test)
		.mouseHoverFootball()
		.clickleaguesandcups()
		.clickEPLLink()
		.clicktablelink()
		.mouseHover_YearDropdown()
		.changeYear_YearDropdown()
		.selectTeam()
		.getNextMatchTiming("//span[@class='game-time']//div[2]", 0)
		.getNextMatchDate_Month("//span[@class='game-time']//div/div", 0)
		.clickFixturesandResultsLink()
		.clickNextMatchSection()
		//.clickSummaryLink()
		.verifyNextMatchTime(0)
		.verifyNextMatchDate(0)
		.getVenueDetails();
	}
}
