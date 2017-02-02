package pages;

import java.util.concurrent.TimeUnit;

//Page-Created by Vigenswaran P

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ESPNWrappers;

public class Team1_Home_Page extends ESPNWrappers{
	public Team1_Home_Page(RemoteWebDriver driver, ExtentTest test) throws InterruptedException{
		this.driver=driver;
		this.test=test;
		Thread.sleep(2500);
		if(!verifyTitle("Leicester City News and Scores - ESPN"))
		{
			reportStep("This is not Leicester City  News and Scores page", "FAIL");
		}
	}


	//to verify the Team title
	public Team1_Home_Page verifyTeamTitle(int k)
	{
		verifyInput("(//li[@class='team-name']//a)[3]", k);
		return this;
	}

	//to verify the Team's current year rank
	public Team1_Home_Page verifyCurrentYearRank(int k)
	{
		verifyInput("(//ul[@class='details']/li)[2]", k);
		return this;
	}

	//to get the Team1-Name from the Last Match 
	public Team1_Home_Page getLastMatchTeam1Name(String xpathVal, int i)
	{
		fetchInput(xpathVal, i);
		return this;
	}

	//to get the Team1-Score from the Last Match
	public Team1_Home_Page getLastMatchTeam1Score(String xpathVal, int i)
	{
		fetchInput(xpathVal, i);
		return this;
	}

	//to get the Team2-Name from the Last Match
	public Team1_Home_Page getLastMatchTeam2Name(String xpathVal, int i)
	{
		fetchInput(xpathVal, i);
		return this;
	}

	//to get the Team2-Name from the Last Match
	public Team1_Home_Page getLastMatchTeam2Score(String xpathVal, int i)
	{
		fetchInput(xpathVal, i);
		return this;
	}

	//to click the Squad link
	public Team_Squad_Page clickSquadLink() throws InterruptedException
	{
		clickByLink("Squad");
		switchToLastWindow();
		return new Team_Squad_Page(driver,test);
	}

	//to click the Add Favourite link
	public Team1_Home_Page clickAddFavouriteLink()
	{
		clickByXpath("(//button[@class='button-alt sm'])[2]/span[1]");
		return this;
	}

	//to click the Fixtures & Results link
	public Team_Fixtures_and_Results_Page clickFixturesandResultsLink() throws InterruptedException
	{
		clickByLink("Fixtures & Results");
		switchToLastWindow();
		return new Team_Fixtures_and_Results_Page(driver,test);
	}

	//to click the Statistics link
	public Team1_Statistics_Page clickStatisticsLink() throws InterruptedException
	{
		clickByLink("Statistics");
		switchToLastWindow();
		return new Team1_Statistics_Page(driver,test);
	}

	//to get the Next Match timing
	public Team1_Home_Page getNextMatchTiming(String xPathVal, int i)
	{
		fetchInput(xPathVal, 0);
		return this;
	}

}
