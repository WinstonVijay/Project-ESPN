package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.Home_Page_and_Login_Page;
import wrappers.ESPNWrappers;

public class TC_009_EmailSignupValid extends ESPNWrappers
{
	@BeforeClass
	public void setValues()
	{
		browserName = "chrome";
		testCaseName = "TC_009_EmailSignupValid";
		testDescription = "Email signup using valid credentials";
		category = "Smoke";
		authors = "Vignesh";
	}

	@Test
	public void EmailSignupValid() throws InterruptedException
	{
		new Home_Page_and_Login_Page(driver, test)
		.loginlink()
		.espn_SignUpButton()
		.signUpWithEmail()
		.signup_FirstName("Vignesh")
		.signUp_LastName("Tester")
		.signUp_EmailAddress("vignesw55ggtr@gmail.com")
		.signUp_Password("Espn@001")
		.signUp_GenderSelectMale()
		.signUp_DOB("01011990")
		.signUp_SignUpButton()
		.errorMessageFail();
	}
}
