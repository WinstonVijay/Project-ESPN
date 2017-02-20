package pages;

//Page-Created by Gopinath

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ESPNWrappers;

public class Team_Last_Match_Report_Page extends ESPNWrappers 
{
	String text;
	public Team_Last_Match_Report_Page(RemoteWebDriver driver, ExtentTest test) throws InterruptedException
	{
		this.driver = driver;
		this.test = test;
		Thread.sleep(2500);
		if(!verifyTitleContains("Leicester City"))
		{
			reportStep("This is not Leicester City's Last Match-Report page", "Fail");
		}
	}

	//To verify the Team1-Name in Last Match
	public Team_Last_Match_Report_Page verifyTeam1Name(int k)
	{
		verifyInput("(//a[@class='team-name']/span)[2]" , k);
		return this;
	}

	//To verify the Team2-Name in Last Match
	public Team_Last_Match_Report_Page verifyTeam2Name(int k)
	{
		verifyInput("(//a[@class='team-name']/span)[5]" , k);
		return this;
	}

	//To verify the Team1-Score in Last Match
	public Team_Last_Match_Report_Page verifyTeam1goal(int k)
	{
		verifyInput("//div[@class='score-container']/span" , k);
		return this;
	}

	//To verify the Team2-Score in Last Match
	public Team_Last_Match_Report_Page verifyTeam2goal(int k)
	{
		verifyInput("(//div[@class='score-container']/span)[2]" , k);
		return this;
	}

	//To click the Summary link
	public Team_Last_Match_Summary_Page clickSummary() throws InterruptedException
	{
		clickByXpath("//span[contains(text(),'Summary')]");
		return new Team_Last_Match_Summary_Page(driver, test);
	}
	
	//Verify the Home Team-status(won/lost)
	public Team_Last_Match_Report_Page verifyLeiCityLastMatchStat()
	{
		verifyLeiCityLastMatchStatus();
		return this;
	}
	
	//verify the score and the player-details match
	public Team_Last_Match_Report_Page verifyScorePlayerDetails(String xPathValTeamName, String xPathValScore, String xPathValPlayers)
	{
		scoreAndPlayerDetailsVerify(xPathValTeamName, xPathValScore, xPathValPlayers);
		return this;
	}
	
}

