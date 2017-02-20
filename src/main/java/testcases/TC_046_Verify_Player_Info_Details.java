package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.Home_Page_and_Login_Page;
import wrappers.ESPNWrappers;

public class TC_046_Verify_Player_Info_Details extends ESPNWrappers 
{
	@BeforeClass
	public void setValues()
	{
		browserName = "chrome";
		testCaseName = "TC_046_Verify_Player_Info_Details";
		testDescription= "To Get Player Info from Player Page";
		authors = "Gopi";
		category= "Regression";
	}

	@Test
	public void getPlayerInfo() throws InterruptedException
	{
		new Home_Page_and_Login_Page(driver, test)
		.SearchButton_Home()
		.PassInput_Search("Andy King")
		.selectFirstSearchResultPlayer()
		.verifyPlayerName()
		.verifyPlayerPosition();
	}
}
