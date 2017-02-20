package pages;

//Page-Created by Gopinath

import java.text.ParseException;

import org.openqa.selenium.By;

//Page-Created by Gopinath

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ESPNWrappers;

public class Team_Next_Match_Summary_Page extends ESPNWrappers 
{

	static String Team;
	static String LaunchTeam;

	public Team_Next_Match_Summary_Page(RemoteWebDriver driver, ExtentTest test) throws InterruptedException
	{
		this.driver= driver;
		this.test = test;
		Thread.sleep(2500);
		if(!verifyTitleContains("Leicester City"))
		{
			reportStep("This is not the Next Match page of Team-Leicester City", "Fail");
		}
	}

	//To fetch the Team1's Top-Scorer details
	public Team_Next_Match_Summary_Page fetchTopScorerDetails(String xPathVal)
	{
		getPlayerInfo(xPathVal);
		return this;
	}

	//to verify Next Match Time
	public Team_Next_Match_Summary_Page verifyNextMatchTime(int k) throws InterruptedException
	{
		Thread.sleep(3000);
		verifyInput("(//div[@class='game-status']//span)[3]", k);
		//toVerifyNextMatchDate("(//li[@class='subdued']//span)[3]");
		return this;
	}

	//To launch the Team1's(Leicester) Home Page 
	public Team1_Home_Page launchTeam1() throws InterruptedException
	{
		LaunchTeam = driver.findElement(By.xpath("//div[@class='team-header']//a")).getText();
		if(LaunchTeam.contains("Leicester"))
		{
			driver.findElement(By.xpath("//div[@class='team-header']//a")).click();
		}
		else
		{
			driver.findElement(By.xpath("(//div[@class='team-header']/a)[2]")).click();
		}
		return new Team1_Home_Page(driver, test);
	}

	//To fetch a text-to be used later
	public Team_Next_Match_Summary_Page fetchTopScorerName(String xpathVal)
	{
		getTextToUseLater(xpathVal);
		return this;
	}

	//To verify the TopScorer Player1 name 
	public Team_Next_Match_Summary_Page verifyTopScorerPlayer1name(int k)
	{
		Team = driver.findElement(By.xpath("(//span[@class='team-name'])[1]")).getText();
		if(Team.contains("Leicester City")){
			verifyInput("(//span[@class='player-name'])[1]", k);
		}else{
			verifyInput("(//span[@class='player-name'])[4]", k);
		}
		return this;
	}

	//To verify the TopScorer Player2 name 
	public Team_Next_Match_Summary_Page verifyTopScorerPlayer2name(int k)
	{
		Team = driver.findElement(By.xpath("(//span[@class='team-name'])[1]")).getText();
		if(Team.contains("Leicester City")){
			verifyInput("(//span[@class='player-name'])[2]", k);
		}else{
			verifyInput("(//span[@class='player-name'])[5]", k);
		}
		return this;
	}

	//To verify the TopScorer Player3 name 
	public Team_Next_Match_Summary_Page verifyTopScorerPlayer3name(int k)
	{
		Team = driver.findElement(By.xpath("(//span[@class='team-name'])[1]")).getText();
		if(Team.contains("Leicester City")){
			verifyInput("(//span[@class='player-name'])[3]", k);
		}else{
			verifyInput("(//span[@class='player-name'])[6]", k);
		}
		return this;
	}

	//To verify the Most Assists Player1 name 
	public Team_Next_Match_Summary_Page verifyMostAssistsPlayer1name(int k)
	{
		Team = driver.findElement(By.xpath("(//span[@class='team-name'])[1]")).getText();
		if(Team.contains("Leicester City")){
			verifyInput("(//span[@class='player-name'])[7]", k);
		}else{
			verifyInput("(//span[@class='player-name'])[10]", k);
		}
		return this;
	}

	//To verify the Most Assists Player2 name 
	public Team_Next_Match_Summary_Page verifyMostAssistsPlayer2name(int k)
	{
		Team = driver.findElement(By.xpath("(//span[@class='team-name'])[1]")).getText();
		if(Team.contains("Leicester City")){
			verifyInput("(//span[@class='player-name'])[8]", k);
		}else{
			verifyInput("(//span[@class='player-name'])[11]", k);
		}
		return this;
	}

	//To verify the Most Assists Player3 name 
	public Team_Next_Match_Summary_Page verifyMostAssistsPlayer3name(int k)
	{
		Team = driver.findElement(By.xpath("(//span[@class='team-name'])[1]")).getText();
		if(Team.contains("Leicester City")){
			verifyInput("(//span[@class='player-name'])[9]", k);
		}else{
			verifyInput("(//span[@class='player-name'])[12]", k);
		}
		return this;
	}

	//To verify Next Match Venue
	public Team_Next_Match_Summary_Page getVenueDetails()
	{
		getTextByXpath("//li[@class='venue']/div");
		return this;  
	}

	/*//To verify next match Timing
	public Team_Next_Match_Summary_Page getNextMatchTime(int k)
	{
		verifyInput("(//li[@class='subdued']//span)[2]", k);
		return this;(//div[@class='game-status']//span)[3]
	}
*/
	//to verify Next Match Date
	public Team_Next_Match_Summary_Page verifyNextMatchDate(int k) throws ParseException
	{	
		verifyInput("//div[@class='game-status']//span/span", k);
		//toVerifyNextMatchDate("(//li[@class='subdued']//span)[3]");
		return this;
	}

	//To verify Team Total Goals in Next Match Summary Page
	public Team_Next_Match_Summary_Page getTeamTotalGoals()
	{
		getTeamGoalsScoredCount();
		return this;
	}

	//To verify Team Goals Conceded in Next Match Summary Page
	public Team_Next_Match_Summary_Page getTeamGoalsConceded()
	{
		getTeamGoalsConcededCount();
		return this;
	}

}
