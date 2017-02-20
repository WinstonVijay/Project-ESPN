package testcases;

import java.text.ParseException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.Home_Page_and_Login_Page;
import wrappers.ESPNWrappers;

public class TC_008_SignUpWithInvalidCredsFacebookAccount extends ESPNWrappers
{
	@BeforeClass
	public void setValues()
	{
		browserName = "chrome";
		testCaseName = "TC_008_SignUpWithInvalidCredsFacebookAccount";
		testDescription = "TC_008_SignUpWithInvalidCredsFacebookAccount";
		category = "Regression";
		authors = "";
	}

	@Test (groups={"ONHOLD"})
	public void SignUpUsingFacebookInvalCreds() 
	{

	}
}