package testcases;

import java.text.ParseException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Home_Page_and_Login_Page;
import wrappers.ESPNWrappers;

public class TC_043_VerifyGoals_ConcededGoals_NextMatch_Summary_Page extends ESPNWrappers
{	
	@BeforeClass
	public void setValues()
	{
		browserName = "chrome";
		testCaseName = "TC_043_VerifyGoals_ConcededGoals_NextMatch_Summary_Page";
		testDescription = "Verify total goals and conceded goals of both teams";
		category = "Regression";
		authors = "Vignesh";
	}

	@Test(groups={"ONHOLD"})
	public void Verify_totalgoals_concededgoals_NextMatch_Summary_Page() throws InterruptedException, ParseException
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
		//.clickSummaryLink()
		.getTeamTotalGoals()
		.getTeamGoalsConceded();
	}
}
