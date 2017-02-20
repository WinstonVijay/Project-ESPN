package testcases;

import java.text.ParseException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.Home_Page_and_Login_Page;
import wrappers.ESPNWrappers;

public class TC_006_LoginWithInvalidCredsFacebookAccount extends ESPNWrappers
{
	@BeforeClass
	public void setValues()
	{
		browserName = "chrome";
		testCaseName = "TC_006_LoginWithInvalidCredsFacebookAccount";
		testDescription = "TC_006_LoginWithInvalidCredsFacebookAccount";
		category = "Regression";
		authors = "";
	}

	@Test (groups={"ONHOLD"})
	public void LoginUsingFacebookInvalCreds() 
	{

	}
}