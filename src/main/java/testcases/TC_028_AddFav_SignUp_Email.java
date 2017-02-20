package testcases;

import java.text.ParseException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.Home_Page_and_Login_Page;
import wrappers.ESPNWrappers;

public class TC_028_AddFav_SignUp_Email extends ESPNWrappers
{
	@BeforeClass
	public void setValues()
	{
		browserName = "chrome";
		testCaseName = "TC_028_AddFav_SignUp_Email";
		testDescription = "TC_028_AddFav_SignUp_Email";
		category = "Regression";
		authors = "";
	}

	@Test(groups={"ONHOLD"})
	public void AddFavusingEmailSignUp()
	{
		
	}
}


