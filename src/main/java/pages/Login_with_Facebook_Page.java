package pages;

//Page-Created by Prabhu

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ESPNWrappers;

public class Login_with_Facebook_Page extends ESPNWrappers{
	
	public Login_with_Facebook_Page(RemoteWebDriver driver,ExtentTest test) throws InterruptedException
	{
		this.driver=driver;
		this.test=test;
		Thread.sleep(2500);
		if(!verifyTitle("Facebook"))
		{
			reportStep("This is not facebook login Page", "FAIL");
		}
	}
	

}
