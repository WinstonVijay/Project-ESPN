package testcases;

import java.text.ParseException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.Home_Page_and_Login_Page;
import wrappers.ESPNWrappers;

public class TC_001_LaunchFootball_Leagues_Competitions extends ESPNWrappers
{
	@BeforeClass
	public void setValues()
	{
		browserName = "chrome";
		testCaseName = "TC_001_LaunchFootball_Leagues_Competitions";
		testDescription = "Launching the Football Leagues and Competitions page";
		category = "Smoke";
		authors = "Prabhu";
	}

	@Test
	public void LaunchFootballLeaguepage() throws InterruptedException
	{
		new Home_Page_and_Login_Page(driver, test)
		.mouseHoverFootball()
		.clickleaguesandcups();
	}
}


