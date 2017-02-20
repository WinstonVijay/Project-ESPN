package testcases;

import java.text.ParseException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.Home_Page_and_Login_Page;
import wrappers.ESPNWrappers;

public class TC_005_LoginWithValidCredsFacebookAccount extends ESPNWrappers
{
	@BeforeClass
	public void setValues()
	{
		browserName = "chrome";
		testCaseName = "TC_005_LoginWithValidCredsFacebookAccount";
		testDescription = "TC_005_LoginWithValidCredsFacebookAccount";
		category = "Regression";
		authors = "";
	}

	@Test (groups={"ONHOLD"})
	public void LoginUsingFacebookValCreds() 
	{

	}
}