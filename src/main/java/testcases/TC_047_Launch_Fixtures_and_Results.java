package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.Home_Page_and_Login_Page;
import wrappers.ESPNWrappers;

public class TC_047_Launch_Fixtures_and_Results extends ESPNWrappers 
{
	@BeforeClass
	public void setValues()
	{
		browserName = "chrome";
		testCaseName = "TC_047_Launch_Fixtures_and_Results";
		testDescription= "Verify able to click Fix & Results";
		authors = "Gopi";
		category= "Smoke";
	}

	@Test
	public void navToReport() throws InterruptedException
	{
		new Home_Page_and_Login_Page(driver, test)
		.mouseHoverFootball()
		.clickleaguesandcups()
		.clickEPLLink()
		.clicktablelink()
		.mouseHover_YearDropdown()
		.changeYear_YearDropdown()
		.selectTeam()
		.clickFixturesandResultsLink();
	}
}
