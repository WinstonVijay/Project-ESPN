package pages;

//Page-Created by Vigenswaran P

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ESPNWrappers;

public class Player_Facebook_Share_Page1 extends ESPNWrappers 
{
	public Player_Facebook_Share_Page1(RemoteWebDriver driver,ExtentTest test) throws InterruptedException
	{
		this.driver=driver;
		this.test=test;
		Thread.sleep(2500);
		if(!verifyTitle("Facebook"))
		{
			reportStep("This is not Facebook page", "FAIL");
		}
	}

	//to enter FB email-id
	public Player_Facebook_Share_Page1 enterMailid(String mailID)
	{
		enterById("email", mailID);
		return this;
	}

	//to enter FB password 
	public Player_Facebook_Share_Page1 enterPassword(String password){
		enterById("pass", password);
		return this;
	}

	//to click 'Login' button 
	public Player_Facebook_Share_Page2 clickLogin() throws InterruptedException{
		clickByName("login");
		return new Player_Facebook_Share_Page2(driver,test);
	}
}
