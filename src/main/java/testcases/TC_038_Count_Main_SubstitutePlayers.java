package testcases;

import java.text.ParseException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.Home_Page_and_Login_Page;
import wrappers.ESPNWrappers;

public class TC_038_Count_Main_SubstitutePlayers extends ESPNWrappers
{
	@BeforeClass
	public void setValues()
	{
		browserName = "chrome";
		testCaseName = "TC_038_Count_Main_SubstitutePlayers";
		testDescription = "Count of main/substitute players on both the teams";
		category = "Regression";
		authors = "Prabhu";
	}

	@Test
	public void Count_MainSubtitute() throws InterruptedException 
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
		.getTeam1MainPlayersCount()
		.getTeam1SubstitutePlayersCount()
		.getTeam2MainPlayersCount()
		.getTeam2SubstitutePlayersCount();
	}
}


