package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.Home_Page_and_Login_Page;
import wrappers.ESPNWrappers;

public class TC_035_Facebook_Share extends ESPNWrappers 
{
	@BeforeClass
	public void setValues()
	{
		browserName = "chrome";
		testCaseName = "TC_035_Facebook_Share";
		testDescription= "To share from Player Page using Facebook";
		authors = "Gopi";
		category= "Regression";
	}

	@Test
	public void facebookShare() throws InterruptedException
	{
		new Home_Page_and_Login_Page(driver, test)
		.mouseHoverFootball()
		.clickleaguesandcups()
		.clickEPLLink()
		.clicktablelink()
		.mouseHover_YearDropdown()
		.changeYear_YearDropdown()
		.selectTeam()
		.clickSquadLink()
		.clickPlayer("((//div[@class='squad-data-table'])[2]//tr)[19]//a")
		.clickShareLink()
		.enterMailid("rgopinath100992@gmail.com")
		.enterPassword("Gopinath@1")
		.clickLogin()
		.enterPlayerInformation("Hi.. The below Player performs awesome in recent matches")
		.clickPostToFacebook();
	}
}
