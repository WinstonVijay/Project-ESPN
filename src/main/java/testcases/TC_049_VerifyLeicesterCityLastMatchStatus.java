package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.Home_Page_and_Login_Page;
import wrappers.ESPNWrappers;

public class TC_049_VerifyLeicesterCityLastMatchStatus extends ESPNWrappers
{
	@BeforeClass
	public void setValues()
	{
		browserName = "chrome";
		testCaseName = "TC_049_VerifyLeicesterCityLastMatchStatus";
		testDescription= "To verify the status(won/lost) of Leicester City in it's last match";
		authors = "Gopi";
		category= "Regression";
	}

	@Test
	public void verifyLastMatchStat() throws InterruptedException
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
		.clickLastMatch()
		.verifyLeiCityLastMatchStat();
	}
}
