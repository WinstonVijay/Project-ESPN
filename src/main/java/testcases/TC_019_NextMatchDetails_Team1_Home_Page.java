package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.Home_Page_and_Login_Page;
import wrappers.ESPNWrappers;

public class TC_019_NextMatchDetails_Team1_Home_Page extends ESPNWrappers
{
	@BeforeClass
	public void setValues()
	{
		browserName = "chrome";
		testCaseName = "TC_019_NextMatchDetails_Team1_Home_Page";
		testDescription = "Check Team1 Next Match Details";
		category = "Regression";
		authors = "Vignesh";
	}

	@Test
	public void checkNextMatch_Team1_Home_Page() throws InterruptedException
	{
		new Home_Page_and_Login_Page(driver, test)
		.mouseHoverFootball()
		.clickleaguesandcups()
		.clickEPLLink()
		.clicktablelink()
		.mouseHover_YearDropdown()
		.changeYear_YearDropdown()
		.selectTeam()
		.getNextMatchTeam1Name("//section[@class='club-schedule']//li//span[3]", 0)
		.getNextMatchTiming("//span[@class='game-time']/div", 0)
		.getNextMatchTeam2Name("//section[@class='club-schedule']//li//div[3]//span[3]", 0);
	}
}
