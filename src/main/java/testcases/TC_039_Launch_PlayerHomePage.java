package testcases;

import java.text.ParseException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.Home_Page_and_Login_Page;
import wrappers.ESPNWrappers;

public class TC_039_Launch_PlayerHomePage extends ESPNWrappers
{
	@BeforeClass
	public void setValues()
	{
		browserName = "chrome";
		testCaseName = "TC_039_Launch_PlayerHomePage";
		testDescription = "Verify launching the Player's Home page";
		category = "Smoke";
		authors = "Prabhu";
	}

	@Test
	public void PlayerHomePage() throws InterruptedException 
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
		.clickSummary()
		.launchPlayer();
	}
}


