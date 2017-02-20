package testcases;

import java.text.ParseException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.Home_Page_and_Login_Page;
import wrappers.ESPNWrappers;

public class TC_004_LaunchSignUpCreateAccountPage extends ESPNWrappers
{
	@BeforeClass
	public void setValues()
	{
		browserName = "chrome";
		testCaseName = "TC_004_LaunchSignUpCreateAccountPage";
		testDescription = "Launch the Sign Up-Create Account page";
		category = "Regression";
		authors = "Prabhu";
	}

	@Test
	public void Launchsignup() 
	{
		new Home_Page_and_Login_Page(driver, test)
		.loginlink()
		.espn_SignUpButton();
	}
}