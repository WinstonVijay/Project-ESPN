package testcases;

import java.text.ParseException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Home_Page_and_Login_Page;
import wrappers.ESPNWrappers;

public class TC_041_VerifyPlayerDetails_NextMatch_Summary_Page extends ESPNWrappers
{
	@BeforeClass
	public void setValues()
	{
		browserName = "chrome";
		testCaseName = "TC_041_VerifyPlayerDetails_NextMatch_Summary_Page";
		testDescription = "Verify Players_Top scorers and most Assists";
		category = "Regression";
		authors = "Vignesh";
	}

	@Test
	public void Verify_Players_Scorers_Assists() throws InterruptedException, ParseException
	{
		new Home_Page_and_Login_Page(driver, test)
		.mouseHoverFootball()
		.clickleaguesandcups()
		.clickEPLLink()
		.clicktablelink()
		.mouseHover_YearDropdown()
		.changeYear_YearDropdown()
		.selectTeam()
		.clickStatisticsLink()
		.getTopScorersPlayer1(0)
		.getTopScorersPlayer2(0)
		.getTopScorersPlayer3(0)
		.clickTopAssistsLink()
		.getTopAssistsPlayer1(0)
		.getTopAssistsPlayer2(0)
		.getTopAssistsPlayer3(0)
		.switchToTeamHomePage()
		.clickFixturesandResultsLink()
		.clickNextMatchSection()
		.verifyTopScorerPlayer1name(0)
		.verifyTopScorerPlayer2name(0)
		.verifyTopScorerPlayer3name(0)
		.verifyMostAssistsPlayer1name(0)
		.verifyMostAssistsPlayer2name(0)
		.verifyMostAssistsPlayer3name(0);	
	}
}
