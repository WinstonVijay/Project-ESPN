package pages;

//Page-Created by Gopinath

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ESPNWrappers;

public class Team_Next_Match_Summary_Page extends ESPNWrappers 
{

	public Team_Next_Match_Summary_Page(RemoteWebDriver driver, ExtentTest test) throws InterruptedException
	{
		this.driver= driver;
		this.test = test;
		Thread.sleep(2500);
		if(!verifyTitle("Burnley vs. Leicester City - Football Match Summary - January 31, 2017 - ESPN"))
		{
			reportStep("This is not a Burnley vs. Leicester City - Football Match Summary - January 31, 2017 - ESPN page", "Fail");
		}
	}


	//To verify the TopScorer Player1 name 
	public Team_Next_Match_Summary_Page verifyTopScorerPlayer1name(int k)
	{
		verifyInput("(//div[@class='player-detail'])[4]//span[1]", k);
		return this;
	}

	//To verify the TopScorer Player2 name 
	public Team_Next_Match_Summary_Page verifyTopScorerPlayer2name(int k)
	{
		verifyInput("(//div[@class='player-detail'])[5]//span[1]", k);
		return this;
	}

	//To verify the TopScorer Player3 name 
	public Team_Next_Match_Summary_Page verifyTopScorerPlayer3name(int k)
	{
		verifyInput("(//div[@class='player-detail'])[6]//span[1]", k);
		return this;
	}

	//To verify the Most Assists Player1 name 
	public Team_Next_Match_Summary_Page verifyMostAssistsPlayer1name(int k)
	{
		verifyInput("(//div[@class='player-detail'])[10]//span[1]", k);
		return this;
	}

	//To verify the Most Assists Player2 name 
	public Team_Next_Match_Summary_Page verifyMostAssistsPlayer2name(int k)
	{
		verifyInput("(//div[@class='player-detail'])[11]//span[1]", k);
		return this;
	}

	//To verify the Most Assists Player3 name 
	public Team_Next_Match_Summary_Page verifyMostAssistsPlayer3name(int k)
	{
		verifyInput("(//div[@class='player-detail'])[12]//span[1]", k);
		return this;
	}

	/*//To verify the TopScorer Player1 details 
	public Team_Next_Match_Summary_Page getPlayer1TopScorerDetails(int i)
	{
		verifyInput("(//div[@class='player-detail'])[4]//span[2]", i);
		return this;
	}

	//To verify the TopScorer Player2 details 
	public Team_Next_Match_Summary_Page getPlayer2TopScorerDetails(int i)
	{
		verifyInput("(//div[@class='player-detail'])[5]//span[2]", i);
		return this;
	}

	//To verify the TopScorer Player3 details 
	public Team_Next_Match_Summary_Page getPlayer3TopScorerDetails(int i)
	{
		verifyInput("(//div[@class='player-detail'])[6]//span[2]", i);
		return this;
	}

	//To verify the Most Assists Player1 details 
	public Team_Next_Match_Summary_Page getPlayer1MostAssistDetails(int i)
	{
		verifyInput("(//div[@class='player-detail'])[10]//span[2]", i);
		return this;
	}

	//To verify the Most Assists Player2 details 
	public Team_Next_Match_Summary_Page getPlayer2MostAssistDetails(int i)
	{
		verifyInput("(//div[@class='player-detail'])[11]//span[2]", i);
		return this;
	}

	//To verify the Most Assists Player3 details 
	public Team_Next_Match_Summary_Page getPlayer3MostAssistDetails(int i)
	{
		verifyInput("(//div[@class='player-detail'])[12]//span[2]", i);
		return this;
	}*/

	//To verify Next Match Venue
	public Team_Next_Match_Summary_Page getVenueDetails()
	{
		getTextByXpath("//li[@class='venue']/div");
		return this;  
	}

	//To verify next match Timing
	public Team_Next_Match_Summary_Page getNextMatchTime(int k)
	{
		verifyInput("(//li[@class='subdued']//span)[2]", k);
		return this;
	}

	//to verify Next Match Date
	public Team_Next_Match_Summary_Page getNextMatchDate()
	{
		getTextByXpath("(//li[@class='subdued']//span)[3]");
		return this;
	}

	//To verify Team1 Total Goals in Next Match Summary Page
	public Team_Next_Match_Summary_Page getTeam1TotalGoals()
	{
		getTextByXpath("(//span[@class='chartValue'])[2]");
		return this;
	}

	//To verify Team1 Goals Conceded in Next Match Summary Page
	public Team_Next_Match_Summary_Page getTeam1GoalsConceded()
	{
		getTextByXpath("(//span[@class='chartValue'])[4]");
		return this;
	}

	//To verify Team2 Total Goals in Next Match Summary Page
	public Team_Next_Match_Summary_Page getTeam2TotalGoals()
	{
		getTextByXpath("(//span[@class='chartValue'])[1]");
		return this;

	}

	//To verify Team2 Goals Conceded in Next Match Summary Page
	public Team_Next_Match_Summary_Page getTeam2GoalsConceded()
	{
		getTextByXpath("(//span[@class='chartValue'])[3]");
		return this;
	}

}
