package pages;

//Page-Created by Vigneswaran P

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
		//verifyTextByXpath("(//li[@class='team-name']//a)[3]", text);
		return this;
	}

	//to verify the Team's current year rank
	public Team1_Home_Page verifyCurrentYearRank(int k)
	{
		verifyInput("(//ul[@class='details']/li)[2]", k);
		//verifyTextContainsByXpath("(//ul[@class='details']/li)[2]", text);
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
		switchToLastWindow("Leicester City Squad - ESPN FC");
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
		switchToLastWindow("Leicester City Scores & Fixtures - ESPN FC - ESPN FC");
		return new Team_Fixtures_and_Results_Page(driver,test);
	}

	//to click the Statistics link
	public Team1_Statistics_Page clickStatisticsLink() throws InterruptedException
	{
		clickByLink("Statistics");
		switchToLastWindow("Leicester City Statistics - ESPN FC");
		return new Team1_Statistics_Page(driver,test);
	}

	//to get the Next Match timing
	public Team1_Home_Page getNextMatchTiming(String xPathVal, int i)
	{
		fetchInput(xPathVal, 0);
		return this;
	}

	//to get the Next Match date
	public Team1_Home_Page getNextMatchDate_Month(String xPathVal, int i)
	{
		fetchInput(xPathVal, 0);
		return this;
	}

	//click the search link in home page
	public Team1_Home_Page SearchField_Launch()
	{
		clickById("global-search-trigger");
		return this;
	}

	//Passing input as fetched earlier
	public Team1_Home_Page PassInputFetchedEarlier_Search()
	{
		enterTextFetchedEarlier("//*[@id='global-search']/input[1]");
		return this;
	}

	//select the first search-result
	public Player_Home_Page selectFirstSearchResult() throws InterruptedException
	{
		clickByXpath("//div[@class='search-results']/ul/li[1]/a");
		return new Player_Home_Page(driver,test);
	}


	//to get the Team1-Name from the Next Match 
	public Team1_Home_Page getNextMatchTeam1Name(String xpathVal, int i)
	{
		fetchInput(xpathVal, i);
		return this;
	}

	//to get the Team2-Name from the Next Match
	public Team1_Home_Page getNextMatchTeam2Name(String xpathVal, int i)
	{
		fetchInput(xpathVal, i);
		return this;
	}

	//mouse hover the account in home page
	public Team1_Home_Page mouseHover_MyAccount()
	{
		mouseOverById("global-user-trigger");
		return this;
	}

	//get the favourite-team from my account
	public Team1_Home_Page favouriteTeam_MyAccount(int j)
	{
		verifyInput("//ul[@class='current-favorites-container']/li/a/div[2]", j);
		return this;
	}
}
