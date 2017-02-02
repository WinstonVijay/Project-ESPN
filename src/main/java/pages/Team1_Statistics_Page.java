package pages;

//Page-Created by Vigenswaran P

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ESPNWrappers;

public class Team1_Statistics_Page extends ESPNWrappers{
	public Team1_Statistics_Page(RemoteWebDriver driver, ExtentTest test) throws InterruptedException{
		this.driver=driver;
		this.test=test;
		Thread.sleep(2500);
		if(!verifyTitle("Leicester City Statistics - ESPN FC"))
		{
			reportStep("This is not Leicester City Statistics page", "FAIL");
		}
	}

	//to fetch Player1 from the list of Top Scorers
	public Team1_Statistics_Page getTopScorersPlayer1(int i)
	{
		fetchInput("(//td[@headers='player']/a)", i);
		return this;
	}

	//to fetch Player2 from the list of Top Scorers
	public Team1_Statistics_Page getTopScorersPlayer2(int i)
	{
		fetchInput("(//td[@headers='player']/a)[2]", i);
		return this;
	}

	//to fetch Player3 from the list of Top Scorers
	public Team1_Statistics_Page getTopScorersPlayer3(int i)
	{
		fetchInput("(//td[@headers='player']/a)[3]", i);
		return this;
	}

	//to click the Top Assists link
	public Team1_Statistics_Page clickTopAssistsLink()
	{
		clickByLink("Top Assists");
		return this;
	}
	
	//to fetch Player1 from the list of Top Assists
	public Team1_Statistics_Page getTopAssistsPlayer1(int i)
	{
		fetchInput("(//td[@headers='player']/a)", i);
		return this;
	}

	//to fetch Player2 from the list of Top Assists
	public Team1_Statistics_Page getTopAssistsPlayer2(int i)
	{
		fetchInput("(//td[@headers='player']/a)[2]", i);
		return this;
	}

	//to fetch Player3 from the list of Top Assists
	public Team1_Statistics_Page getTopAssistsPlayer3(int i)
	{
		fetchInput("(//td[@headers='player']/a)[3]", i);
		return this;
	}

}






