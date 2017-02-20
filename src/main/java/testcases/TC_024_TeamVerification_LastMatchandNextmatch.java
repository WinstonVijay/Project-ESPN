package testcases;

import java.text.ParseException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.Home_Page_and_Login_Page;
import wrappers.ESPNWrappers;

public class TC_024_TeamVerification_LastMatchandNextmatch extends ESPNWrappers
{
	@BeforeClass
	public void setValues()
	{
		browserName = "chrome";
		testCaseName = "TC_024_TeamVerification_LastMatchandNextmatch";
		testDescription = " Verify the selected team for both (Last/Next match)";
		category = "Regression";
		authors = "Prabhu";
	}

	@Test
	public void Teamverification() throws InterruptedException 
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
		.verifyTeamPresenceInLastMatch()
		.verifyTeamPresenceInNextMatch();
	}
}


