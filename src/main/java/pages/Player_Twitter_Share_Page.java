package pages;

//Page-Created by Gopinath

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ESPNWrappers;

public class Player_Twitter_Share_Page extends ESPNWrappers {

	public Player_Twitter_Share_Page(RemoteWebDriver driver, ExtentTest test) throws InterruptedException
	{
		this.driver = driver;
		this.test = test;
		Thread.sleep(2500);
		if(!verifyTitle("Share a link on Twitter"))
		{
			reportStep("This is not the Twitter-Share page", "FAIL");
		}

	}

	//to enter username
	public Player_Twitter_Share_Page enterUserName()
	{
		enterById("username_or_email", "gopinath.rathinam@gsr-inc.com");
		return this;
	}

	//to enter password
	public Player_Twitter_Share_Page enterPassword()
	{
		enterById("password", "Gopinath@1");
		return this;
	}

	//to click the 'Log in and Tweet' button
	public Your_Tweet_Has_Been_Posted_Page clickTweetbutton() throws InterruptedException
	{
		clickByXpath("(//fieldset[@class='submit']//input)[2]");
		switchToLastWindow();
		return new Your_Tweet_Has_Been_Posted_Page(driver,test) ;
	}


}



