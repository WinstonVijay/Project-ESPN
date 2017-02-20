package pages;

//Page-Created by Vigenswaran P

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ESPNWrappers;

public class Player_Facebook_Share_Page2 extends ESPNWrappers{

	public Player_Facebook_Share_Page2(RemoteWebDriver driver,ExtentTest test) throws InterruptedException{
		this.driver=driver;
		this.test=test;
		Thread.sleep(2500);
		if(!verifyTitle("Post to Facebook")){
			reportStep("This is not Post to Facebook page", "FAIL");
		}
	}

	//to enter information about the Player-to be posted on Facebook
	public Player_Facebook_Share_Page2 enterPlayerInformation(String dataAboutPlayer)
	{
		enterByXpath("//div[@class='innerWrap']/textarea", dataAboutPlayer);
		return this;
	}

	//to click 'Post to Facebook' button to share
	public Player_Home_Page clickPostToFacebook() throws InterruptedException{
		clickByXpathNoSnap("//button/span");
		switchToLastWindow("Player Profile");
		return new Player_Home_Page(driver,test);
	}
}
