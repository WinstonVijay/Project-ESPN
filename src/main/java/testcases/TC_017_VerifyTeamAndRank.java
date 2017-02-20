package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.Home_Page_and_Login_Page;
import wrappers.ESPNWrappers;

public class TC_017_VerifyTeamAndRank extends ESPNWrappers
{
	@BeforeClass
	public void setValues(){
		browserName = "chrome";
		testCaseName = "TC_017_VerifyTeamAndRank";
		testDescription = "Verify Team Name and its current year";
		category = "Regression";
		authors = "Vignesh";
	}

	@Test
	public void verifyTeam() throws InterruptedException
	{
		new Home_Page_and_Login_Page(driver, test)
		.mouseHoverFootball()
		.clickleaguesandcups()
		.clickEPLLink()
		.clicktablelink()
		.getposition_LeicesterCity(0)
		.mouseHover_YearDropdown()
		.changeYear_YearDropdown()
		.firstteam_gettext(2)
		.selectTeam()
		.verifyTeamTitle(2)
		.verifyCurrentYearRank(0);
	}
}
