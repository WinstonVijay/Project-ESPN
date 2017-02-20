package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.Home_Page_and_Login_Page;
import wrappers.ESPNWrappers;

public class TC_018_LastMatchDetails_Team1_Home_Page extends ESPNWrappers
{
	@BeforeClass
	public void setValues(){
		browserName = "chrome";
		testCaseName = "TC_018_LastMatchDetails_Team1_Home_Page";
		testDescription = "Check Team1 Last Match Details";
		category = "Regression";
		authors = "Vignesh";
	}

	@Test
	public void checkLastMatch_Team1_Home_Page() throws InterruptedException
	{
		new Home_Page_and_Login_Page(driver, test)
		.mouseHoverFootball()
		.clickleaguesandcups()
		.clickEPLLink()
		.clicktablelink()
		.mouseHover_YearDropdown()
		.changeYear_YearDropdown()
		.selectTeam()
		.getLastMatchTeam1Name("//section[@class='club-schedule']//li[2]//span[3]", 0)
		.getLastMatchTeam1Score("(//div[@class='score-container']//span)[3]", 0)
		.getLastMatchTeam2Name("//section[@class='club-schedule']//li[2]//div[3]//span[3]", 1)
		.getLastMatchTeam2Score("(//div[@class='score-container']//span)[4]", 1);
	}
}
