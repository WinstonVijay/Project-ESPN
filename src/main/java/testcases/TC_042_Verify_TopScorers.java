package testcases;

import java.text.ParseException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Home_Page_and_Login_Page;
import wrappers.ESPNWrappers;

public class TC_042_Verify_TopScorers extends ESPNWrappers
{
	@BeforeClass
	public void setValues()
	{
		browserName = "chrome";
		testCaseName = "TC_042_Verify_TopScorers";
		testDescription = "Verify Top scorer's position, matches and goals scored";
		category = "Regression";
		authors = "Vignesh";
	}

	@Test(groups={"ONHOLD"})
	public void Verify_TopScorers() throws InterruptedException, ParseException
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
		.clickNextMatchSection()
		.fetchTopScorerName("(//span[@class='player-name'])[5]")
		.fetchTopScorerDetails("(//span[@class='player-stats'])[5]")
		.launchTeam1()
		.SearchField_Launch()
		.PassInputFetchedEarlier_Search()
		.selectFirstSearchResult()
		.verifyPlayerPos("//div[@class='player-spec']/dl/dd")
		.verifyPlayerMatchesCount("//div[@class='player-record']/ul/li")
		.verifyPlayerGoalsCount("//div[@class='player-record']/ul/li[2]");
	}
}
