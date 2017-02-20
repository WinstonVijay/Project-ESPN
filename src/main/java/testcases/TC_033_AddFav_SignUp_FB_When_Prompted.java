package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.Home_Page_and_Login_Page;
import wrappers.ESPNWrappers;

public class TC_033_AddFav_SignUp_FB_When_Prompted extends ESPNWrappers
{
	@BeforeClass
	public void setValues()
	{
		browserName = "chrome";
		testCaseName = "TC_033_AddFav_SignUp_FB_When_Prompted";
		testDescription = "TC_033_AddFav_SignUp_FB_When_Prompted";
		category = "Smoke";
		authors = "";
	}

	@Test(groups={"ONHOLD"})
	public void AddFavusingFBSignUpWhenPrompted()
	{
		
	}
}
