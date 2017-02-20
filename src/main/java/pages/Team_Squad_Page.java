package pages;

//Page-Created by Vigneshwaran S

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ESPNWrappers;

public class Team_Squad_Page extends ESPNWrappers {
	public Team_Squad_Page(RemoteWebDriver driver, ExtentTest test) throws InterruptedException
	{
		this.driver=driver;
		this.test=test;
		Thread.sleep(2500);
		if(!verifyTitle("Leicester City Squad - ESPN FC"))
		{
			reportStep("Leicester City Squad - ESPN FC","FAIL");
		}
	}

	//To click the Player
	public Player_Home_Page clickPlayer(String XpathVal) throws InterruptedException
	{
		clickByXpath(XpathVal);
		return new Player_Home_Page(driver,test);
	}
}
