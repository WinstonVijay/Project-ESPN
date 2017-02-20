package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Home_Page_and_Login_Page;
import wrappers.ESPNWrappers;

public class TC_051_Verifying_Score_Players_Details extends ESPNWrappers
{
	@BeforeClass
	public void setValues(){
		browserName = "chrome";
		testCaseName = "TC_051_Verifying_Score_Players_Details";
		testDescription = "Verifying_Score_Players_Details";
		category = "Regression";
		authors = "Vignesh";
	}

	@Test
	public void Launch_LastMatchReportPage() throws InterruptedException
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
		.clickLastMatchSection()
		.verifyScorePlayerDetails("//div[@class='team-info']//a/span[2]", "//div[@class='score-container']//span", "(//div[@class='team-info players']//ul)[1]")
		.verifyScorePlayerDetails("(//div[@class='team-info']//span)[5]", "(//div[@class='score-container']//span)[2]", "(//div[@class='team-info players']//ul)[2]");
	}
}
