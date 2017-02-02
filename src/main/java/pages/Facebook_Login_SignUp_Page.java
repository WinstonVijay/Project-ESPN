package pages;

//Page-Created by Prabhu

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ESPNWrappers;

public class Facebook_Login_SignUp_Page extends ESPNWrappers {
	
	public Facebook_Login_SignUp_Page(RemoteWebDriver driver,ExtentTest test) throws InterruptedException
	{
		this.driver=driver;
		this.test=test;
		Thread.sleep(2500);
		if(!verifyTitle("Facebook"))
		{
			reportStep("This is not facebook Page", "FAIL");
		}
	}
	
	//input the email in the Facebook-login page
	public Facebook_Login_SignUp_Page facebook_EnterEmail(String data)
	{
		enterById("email", data);
		return this;
	}
	
	//input the password in the Facebook-login page
	public Facebook_Login_SignUp_Page facebook_EnterPassword(String data)
	{
		enterById("pass", data);
		return this;
	}
	
	//click the 'Log In' button
	public Login_with_Facebook_Page facebook_LoginButton() throws InterruptedException
	{
		clickByName("login");
		return new Login_with_Facebook_Page(driver, test);
	}
	

}
