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
		if(!verifyTitleContains("Player Profile"))
		{
			reportStep("This is not the targeted Player's Profile page", "FAIL");
		}
	}

	//get goals count
	public Player_Home_Page getGoalsCount(){
		subStringBegEndIndexesXpath("//div[@class='player-record']/ul/li[1]", 0, 2);
		return this;
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

	//To fetch Player Assists
	public Player_Home_Page getPlayerAssists()
	{
		getTextByXpath("(//div[@class='player-record']//li)[3]");
		return this;
	}

	//To get Player Name
	public Player_Home_Page getPlayerName()
	{
		getTextByXpath("//div[@class='player-spec']/h1");
		return this;
	}

	//to click the Facebook Share link
	public Player_Facebook_Share_Page1 clickShareLink() throws InterruptedException
	{
		clickByLink("Share");
		switchToLastWindow("Facebook");
		return new Player_Facebook_Share_Page1(driver,test);
	}

	//To click the Tweet link
	public Player_Twitter_Share_Page clickTweetLink() throws InterruptedException
	{
		clickByLink("Tweet");
		switchToLastWindow("Share a link on Twitter");
		return new Player_Twitter_Share_Page(driver,test);
	}

	//to get the Player's position details
	public Player_Home_Page getPlayerPostionDetails()
	{
		getTextByXpath("//div[@class='player-spec']//dd");
		return this;
	}

	//to get the Player's matches-count
	public Player_Home_Page getPlayerMatchCount()
	{
		getTextByXpath("//div[@class='player-record']//li");
		return this;
	}

	//to get the Player's goal scored-count
	public Player_Home_Page getPlayerGoalsCount()
	{
		getTextByXpath("//div[@class='player-record']//li[2]");
		return this;
	}

	//To get the Player Assists
	public Player_Home_Page getPlayerAssistsCount()
	{
		getTextByXpath("(//div[@class='player-record']//li)[3]");
		return this;
	}

	//To verify Player Name
	public Player_Home_Page verifyPlayerName()
	{
		verifyTextByXpath("//div[@class='player-spec']/h1", "Andy King");
		return this;
	}

	//To verify Player Position
	public Player_Home_Page verifyPlayerPosition()
	{
		verifyTextByXpath("//div[@class='player-spec']/dl/dd", "Midfielder");
		return this;
	}

	//verify the player's position
	public Player_Home_Page verifyPlayerPos(String xPathVal){
		verifyPlayerPosition(xPathVal);
		return this;
	}

	//verify the player-matches played
	public Player_Home_Page verifyPlayerMatchesCount(String xPathVal){
		verifyPlayerMatches(xPathVal);
		return this;
	}

	//verify the player-goals scored
	public Player_Home_Page verifyPlayerGoalsCount(String xPathVal){
		verifyPlayerGoals(xPathVal);
		return this;
	}
}
