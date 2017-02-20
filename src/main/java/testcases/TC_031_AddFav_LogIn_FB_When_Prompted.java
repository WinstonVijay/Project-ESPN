package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.Home_Page_and_Login_Page;
import wrappers.ESPNWrappers;

public class TC_031_AddFav_LogIn_FB_When_Prompted extends ESPNWrappers
{
	@BeforeClass
	public void setValues()
	{
		browserName = "chrome";
		testCaseName = "TC_030_VerifyProfileFav_EmailLogin";
		testDescription = "Verify Profile Favourite using Email Login";
		category = "Smoke";
		authors = "";
	}

	@Test(groups={"ONHOLD"})
	public void AddFavusingFBLoginWhenPrompted()
	{
		
	}
}
