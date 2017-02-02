package pages;

//Page-Created by Vigenswaran P

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ESPNWrappers;

public class Player_Home_Page extends ESPNWrappers{
	public Player_Home_Page(RemoteWebDriver driver, ExtentTest test) throws InterruptedException{
		this.driver=driver;
		this.test=test;
		Thread.sleep(2500);
		if(!verifyTitle("Yohan Benalouane Player Profile - ESPN FC"))
		{
			reportStep("This is not Yohan Benalouane Player Profile page", "FAIL");
		}
	}

	//to click the Facebook Share link
	public Player_Facebook_Share_Page1 clickShareLink() throws InterruptedException{
		clickByLink("Share");
		return new Player_Facebook_Share_Page1(driver,test);
	}

	//to click the Tweet link
	public Player_Twitter_Share_Page clickTweetLink() throws InterruptedException
	{
		clickByLink("Tweet");
		return new Player_Twitter_Share_Page(driver,test);
	}

	//to fetch the Player's position
	public Player_Home_Page getPlayerPostion(int i)
	{
		fetchInput("//div[@class='player-spec']//dd", i);
		return this;
	}

	//to fetch the Player's matches-count
	public Player_Home_Page getPlayerMatch(int i)
	{
		fetchInput("//div[@class='player-record']//li", i);
		return this;
	}

	//to fetch the Player's goal scored-count
	public Player_Home_Page getPlayerGoals(int i)
	{
		fetchInput("//div[@class='player-record']//li[2]", i);
		return this;
	}

}
