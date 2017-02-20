package testcases;

import java.text.ParseException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.Home_Page_and_Login_Page;
import wrappers.ESPNWrappers;

public class TC_003_LoginInvalidCredentials extends ESPNWrappers
{
	@BeforeClass
	public void setValues()
	{
		browserName = "chrome";
		testCaseName = "TC_003_LoginInvalidCredentials";
		testDescription = "Login with email-using invalid creds";
		category = "Regression";
		authors = "Prabhu";
	}

	@Test
	public void LoginInvalidCredential()
	{
		new Home_Page_and_Login_Page(driver, test)
		.loginlink()
		.espn_username("invaliduser@gmail.com")
		.espn_password("Password@123")
		.espn_LoginButton()
		.errorMessagePass();
	}
}






