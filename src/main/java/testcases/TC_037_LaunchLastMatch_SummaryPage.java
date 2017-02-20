package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.Home_Page_and_Login_Page;
import wrappers.ESPNWrappers;

public class TC_037_LaunchLastMatch_SummaryPage extends ESPNWrappers
{
	@BeforeClass
	public void setValues()
	{
		browserName = "chrome";
		testCaseName = "TC_037_LaunchLastMatch_SummaryPage";
		testDescription = "Able to click and Launch Summary";
		category = "Smoke";
		authors = "Vignesh";
	}

	@Test
	public void LaunchLastMatchReport_SummaryPage() throws InterruptedException
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
		.clickSummary();
	}
}
