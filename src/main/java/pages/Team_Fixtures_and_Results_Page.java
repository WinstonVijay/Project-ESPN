package pages;

//Page-Created by Vigneshwaran S

import java.text.ParseException;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ESPNWrappers;

public class Team_Fixtures_and_Results_Page extends ESPNWrappers{

	public Team_Fixtures_and_Results_Page(RemoteWebDriver driver,ExtentTest test) throws InterruptedException
	{
		this.driver=driver;
		this.test=test;
		Thread.sleep(2500);
		if(!verifyTitle("Leicester City Scores & Fixtures - ESPN FC - ESPN FC"))
		{
			reportStep("Leicester City Scores & Fixtures - ESPN FC - ESPN FC", "FAIL");
		}
	}

	//Verify the page-content Title as 'Full Season Schedule'
	public Team_Fixtures_and_Results_Page  verifyScheduleTitle(){
		verifyTextByXpath("//div[@class='page-title']/h1", "Full Season Schedule");
		return this;
	}

	//Verify the Last Match-section's title
	public Team_Fixtures_and_Results_Page verifyLastMatchSectionTitle(){
		verifyTextContainsByXpath("//div[@class='last-match']/h3", "Last Match");
		return this;
	}

	//Verify the Next Match-section's title
	public Team_Fixtures_and_Results_Page verifyNextMatchSectionTitle(){
		verifyTextContainsByXpath("//div[@class='next-match']/h3", "Next Match");
		return this;
	}

	//Verify the Last Match-Date
	public Team_Fixtures_and_Results_Page verifyLastMatchDate() throws ParseException {
		toVerifyLastMatchDate("//div[@class='last-match']/h3/span");
		return this;
	}

	//Verify the Next Match-Date
	public Team_Fixtures_and_Results_Page verifyNextMatchDate() throws ParseException{
		toVerifyNextMatchDate("//div[@class='next-match']/h3/span");
		return this;
	}

	//Verify the Last Match-Timing(Time Zone)
	public Team_Fixtures_and_Results_Page verifyLastMatchTiming(){
		verifyTextContainsById("prev-game-date-fmt","IST");
		return this;
	}

	//Verify the Next Match-Timing(Time Zone)
	public Team_Fixtures_and_Results_Page verifyNextMatchTiming(){
		verifyTextContainsById("next-game-date-fmt","IST");
		return this;
	}

	//Verify the Last Match section's Team 1-Name
	public Team_Fixtures_and_Results_Page verifyLastMatchTeam1Name(String xpathValue, int k)
	{
		verifyInput(xpathValue, k);
		return this;
	}

	//Verify the Last Match section's Team 2-Name
	public Team_Fixtures_and_Results_Page verifyLastMatchTeam2Name(String xpathValue, int k)
	{
		verifyInput(xpathValue, k);
		return this;
	}

	//Verify the Last Match section's Team 1-Score
	public Team_Fixtures_and_Results_Page verifyLastMatchTeam1Score(String xpathValue, int k)
	{
		verifyInput(xpathValue, k);
		return this;
	}

	//Verify the Last Match section's Team 2-Score
	public Team_Fixtures_and_Results_Page verifyLastMatchTeam2Score(String xpathValue, int k)
	{
		verifyInput(xpathValue, k);
		return this;
	}

	//Verify the Next Match section-Current team
	public Team_Fixtures_and_Results_Page verifyCurrTeamInNextMatch(String xpathValue, int k)
	{
		verifyInput(xpathValue, k);
		return this;
	}

	//Verify the Next Match section-Timing
	public Team_Fixtures_and_Results_Page verifyTimingNextMatch(String xpathValue, int k)
	{
		verifyInput(xpathValue, k);
		return this;
	}

	//To Click Next Match
	public Team_Next_Match_Summary_Page clickNextMatch() throws InterruptedException
	{
		clickByXpath("//div[@class='next-match']//a");
		return new Team_Next_Match_Summary_Page(driver, test);

	}


	//To Click Last Match
	public Team_Last_Match_Report_Page clickLastMatch() throws InterruptedException
	{
		clickByXpath("//div[@class='last-match']//a");
		return new Team_Last_Match_Report_Page(driver, test);

	}

	//To verify the presence of the Current team in the Last Match section
	public Team_Fixtures_and_Results_Page verifyTeamPresenceInLastMatch()
	{
		verifyTeamPresentLastMatch();
		return this;

	}

	//To verify the presence of the Current team in the Next Match section
	public Team_Fixtures_and_Results_Page verifyTeamPresenceInNextMatch()
	{
		verifyTeamPresentNextMatch();
		return this;
	}

	//Get the Team1 name in Last Match
	public Team_Fixtures_and_Results_Page getTeam1name(String xpathVal, int i)
	{
		fetchInput(xpathVal, i);
		return this;
	}

	//Get the Team1 goal in Last Match
	public Team_Fixtures_and_Results_Page getTeam1goal(String xpathVal, int i)
	{
		fetchInput(xpathVal, i);
		return this;
	}

	//Get the Team2 name in Last Match
	public Team_Fixtures_and_Results_Page getTeam2name(String xpathVal, int i)
	{
		fetchInput(xpathVal, i);
		return this;
	}		

	//Get the Team1 goal in Last Match
	public Team_Fixtures_and_Results_Page getTeam2goal(String xpathVal, int i)
	{
		fetchInput(xpathVal, i);
		return this;
	}

	//To click the Last Match section
	public Team_Last_Match_Report_Page clickLastMatchSection() throws InterruptedException
	{
		clickByXpath("//div[@class='last-match']//a");
		return new Team_Last_Match_Report_Page(driver, test);
	}
	
	//To click the Next Match section
	public Team_Next_Match_Summary_Page clickNextMatchSection() throws InterruptedException
	{
		clickByXpath("//div[@class='next-match']//a");
		return new Team_Next_Match_Summary_Page(driver, test);
	}
}


