package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.Home_Page_and_Login_Page;
import wrappers.ESPNWrappers;

public class TC_016_Launch_Team_Home_Page extends ESPNWrappers 
{
	@BeforeClass
	public void setValues()
	{
		browserName="chrome";
		testCaseName="TC_016_Launch_Team_Home_Page";
		testDescription = "Launch Team Home Page";
		category="Smoke";
		authors="Gopi";
	}

	@Test
	public void luanchTeamHomePage() throws InterruptedException
	{
		new Home_Page_and_Login_Page(driver, test)
		.mouseHoverFootball()
		.clickleaguesandcups()
		.getEPLText("//a[contains(text(),'English Premier League')]", 0)
		.clickEPLLink()
		.EPLtiltleverification("//span[contains(text(),'English Premier League')]", 0)
		.clicktablelink()
		.dropdownleagueverification("English Premier League")
		.mouseHover_YearDropdown()
		.changeYear_YearDropdown()
		.selectTeam();
	}
}
