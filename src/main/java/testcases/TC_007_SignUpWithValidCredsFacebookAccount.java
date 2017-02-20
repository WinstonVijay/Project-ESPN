package testcases;

import java.text.ParseException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.Home_Page_and_Login_Page;
import wrappers.ESPNWrappers;

public class TC_007_SignUpWithValidCredsFacebookAccount extends ESPNWrappers
{
	@BeforeClass
	public void setValues()
	{
		browserName = "chrome";
		testCaseName = "TC_007_SignUpWithValidCredsFacebookAccount";
		testDescription = "TC_007_SignUpWithValidCredsFacebookAccount";
		category = "Regression";
		authors = "";
	}

	@Test (groups={"ONHOLD"})
	public void SignUpUsingFacebookValCreds() 
	{

	}
}