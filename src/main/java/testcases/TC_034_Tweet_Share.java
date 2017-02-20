package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.Home_Page_and_Login_Page;
import wrappers.ESPNWrappers;

public class TC_034_Tweet_Share extends ESPNWrappers
{
	@BeforeClass
	public void setValues()
	{
		browserName = "chrome";
		testCaseName = "TC_034_Tweet_Share";
		testDescription= "To share from Player Page using Tweet";
		authors = "Gopi";
		category= "Regression";
	}

	@Test //(dataProvider="fetchData")
	public void tweetShare() throws InterruptedException
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
		.clickPlayer("((//div[@class='squad-data-table'])[2]//tr)[4]//a")
		.clickTweetLink()
		.enterInput("6666pllplpopo")
		.enterUserName()
		.enterPassword()
		.clickTweetbutton()
		.clickClose();
	}
}
