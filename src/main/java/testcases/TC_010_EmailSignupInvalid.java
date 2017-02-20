package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.Home_Page_and_Login_Page;
import wrappers.ESPNWrappers;

public class TC_010_EmailSignupInvalid extends ESPNWrappers
{
	@BeforeClass
	public void setValues()
	{
		browserName = "chrome";
		testCaseName = "TC_010_EmailSignupInvalid";
		testDescription = "Email signup using invalid credentials";
		category = "Smoke";
		authors = "Vignesh";
	}

	@Test
	public void EmailSignupInValid() throws InterruptedException
	{
		new Home_Page_and_Login_Page(driver, test)
		.loginlink()
		.espn_SignUpButton()
		.signUpWithEmail()
		.signup_FirstName("Vignesh")
		.signUp_LastName("Test")
		.signUp_EmailAddress("vigneswaranp01@gmail")
		.signUp_Password("Espn@001")
		.signUp_GenderSelectMale()
		.signUp_DOB("01011990")
		.signUp_SignUpButton()
		.errorMessagePass();
	}
}
