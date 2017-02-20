package testcases;

import java.text.ParseException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.Home_Page_and_Login_Page;
import wrappers.ESPNWrappers;

public class TC_002_LoginValidCredentials extends ESPNWrappers
{
	@BeforeClass
	public void setValues()
	{
		browserName = "chrome";
		testCaseName = "TC_002_LoginValidCredentials";
		testDescription = "Login with email-using valid creds";
		category = "Smoke";
		authors = "Prabhu";
	}

	@Test
	public void LoginValidCredential()
	{
		new Home_Page_and_Login_Page(driver, test)
		.loginlink()
		.espn_username("testerespn@gmail.com")
		.espn_password("Tester@123!")
		.espn_LoginButton()
		.errorMessageFail();
	}
}


