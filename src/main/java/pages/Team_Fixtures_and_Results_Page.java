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
	public Team_Fixtures_and_Results_Page  verifyScheduleTitle(String compareValue){
		verifyTextByXpath("//div[@class='page-title']/h1",compareValue);
		return this;
	}
	
	//Verify the Last Match-section's title
	public Team_Fixtures_and_Results_Page verifyLastMatchSectionTitle(String compareValue){
		verifyTextContainsByXpath("//div[@class='last-match']/h3", compareValue);
		return this;
	}

	//Verify the Next Match-section's title
	public Team_Fixtures_and_Results_Page verifyNextMatchSectionTitle(String compareValue){
		verifyTextContainsByXpath("//div[@class='next-match']/h3", compareValue);
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
	public Team_Fixtures_and_Results_Page verifyLastMatchTiming(String compareValue){
		verifyTextContainsById("prev-game-date-fmt",compareValue);
		return this;
	}

	//Verify the Next Match-Timing(Time Zone)
	public Team_Fixtures_and_Results_Page verifyNextMatchTiming(String compareValue){
		verifyTextContainsById("next-game-date-fmt",compareValue);
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
}


