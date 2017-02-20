package testcases;

import java.text.ParseException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.Home_Page_and_Login_Page;
import wrappers.ESPNWrappers;

public class TC_027_AddFav_LogIn_FB extends ESPNWrappers
{
	@BeforeClass
	public void setValues()
	{
		browserName = "chrome";
		testCaseName = "TC_027_AddFav_LogIn_FB";
		testDescription = "TC_027_AddFav_LogIn_FB";
		category = "Regression";
		authors = "Prabhu";
	}

	@Test(groups={"ONHOLD"})
	public void AddFavusingFBLogin()
	{
		
	}
}


