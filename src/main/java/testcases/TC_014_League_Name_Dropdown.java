package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.Home_Page_and_Login_Page;
import wrappers.ESPNWrappers;

public class TC_014_League_Name_Dropdown extends ESPNWrappers {

	@BeforeClass
	public void setValues()
	{
		browserName = "chrome";
		testCaseName= "TC_014_League_Name_Dropdown";
		testDescription= "League name verification in drop down";
		category="Regression";
		authors= "Gopi";
	}

	@Test
	public void leagueNameVerify() throws InterruptedException
	{
		new Home_Page_and_Login_Page(driver, test)
		.mouseHoverFootball()
		.clickleaguesandcups()
		.getEPLText("//a[contains(text(),'English Premier League')]", 0)
		.clickEPLLink()
		.EPLtiltleverification("//span[contains(text(),'English Premier League')]", 0)
		.clicktablelink()
		.dropdownleagueverification("English Premier League");
	}
}
