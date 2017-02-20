package testcases;

import java.text.ParseException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.Home_Page_and_Login_Page;
import wrappers.ESPNWrappers;

public class TC_026_AddFav_LogIn_Email extends ESPNWrappers
{
	@BeforeClass
	public void setValues()
	{
		browserName = "chrome";
		testCaseName = "TC_026_AddFav_LogIn_Email";
		testDescription = "Log in(using Email)-Add favorite-verify the team on the Profile section";
		category = "Regression";
		authors = "Prabhu";
	}

	@Test(groups={"ONHOLD"})
	public void AddFavusingEmailLogin() 
	{
		
	}
}


