package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.Home_Page_and_Login_Page;
import wrappers.ESPNWrappers;

public class TC_045_Player_Home_Page_by_Searching_from_HomePage extends ESPNWrappers 
{
	@BeforeClass
	public void setValues()
	{
		browserName = "chrome";
		testCaseName = "TC_045_Player_Home_Page_by_Searching_from_HomePage";
		testDescription= "Launch Player Page from Home Page";
		authors = "Gopi";
		category= "Smoke";
	}

	@Test
	public void launchPlayer() throws InterruptedException
	{
		new Home_Page_and_Login_Page(driver, test)
		.SearchButton_Home()
		.PassInput_Search("Andy King")
		.selectFirstSearchResultPlayer();
	}
}
