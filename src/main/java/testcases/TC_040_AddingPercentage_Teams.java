package testcases;

import java.text.ParseException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.Home_Page_and_Login_Page;
import wrappers.ESPNWrappers;

public class TC_040_AddingPercentage_Teams extends ESPNWrappers
{
	@BeforeClass
	public void setValues()
	{
		browserName = "chrome";
		testCaseName = "TC_040_AddingPercentage_Teams";
		testDescription = "Verify adding the percentage of team's posession equals 100%";
		category = "Regression";
		authors = "Prabhu";
	}

	@Test
	public void AddingPercentage() throws InterruptedException 
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
		.verifyTeamTotalPecentage();
	}
}


