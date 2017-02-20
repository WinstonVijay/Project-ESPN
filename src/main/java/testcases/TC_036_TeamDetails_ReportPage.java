package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.Home_Page_and_Login_Page;
import wrappers.ESPNWrappers;

public class TC_036_TeamDetails_ReportPage extends ESPNWrappers
{
	@BeforeClass
	public void setValues()
	{
		browserName = "chrome";
		testCaseName = "TC_036_TeamDetails_ReportPage";
		testDescription = "Verify Team Details in Report Page";
		category = "Regression";
		authors = "Vignesh";
	}

	@Test
	public void TeamDetails_Report_Page() throws InterruptedException
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
		.getTeam1name("//div[@class='last-match']/div/div/div/div[1]/div[1]/span", 2)
		.getTeam1goal("//div[@class='last-match']/div/div/div/div[2]/div[1]/span", 0)
		.getTeam2name("//div[@class='last-match']/div/div/div/div[1]/div[2]/span", 3)
		.getTeam2goal("//div[@class='last-match']/div/div/div/div[2]/div[2]/span", 1)
		.clickLastMatchSection()
		.verifyTeam1Name(2)
		.verifyTeam1goal(0)
		.verifyTeam2Name(3)
		.verifyTeam2goal(1);
	}
}
