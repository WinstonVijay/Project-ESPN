package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.Home_Page_and_Login_Page;
import wrappers.ESPNWrappers;

public class TC_030_AddFav_LogIn_Email_When_Prompted extends ESPNWrappers
{
	@BeforeClass
	public void setValues()
	{
		browserName = "chrome";
		testCaseName = "TC_030_AddFav_LogIn_Email_When_Prompted";
		testDescription = "Verify Profile Favourite using Email Login";
		category = "Smoke";
		authors = "Vignesh";
	}

	@Test(groups={"ONHOLD"})
	public void AddFavusingEmailWhenPrompted() throws InterruptedException
	{
		new Home_Page_and_Login_Page(driver, test)
		//	.loginlink()
		//	.espn_username("vigneswaranp01@gmail.com")
		//	.espn_password("Espn@001")
		//	.espn_LoginButton()
		.SearchButton_Home()
		.PassInput_Search("Leicester City")
		.gettextFirstSearchResult(0)
		.selectFirstSearchResultTeam()
		.clickAddFavouriteLink()
		.mouseHover_MyAccount()
		.favouriteTeam_MyAccount(0);
	}
}
