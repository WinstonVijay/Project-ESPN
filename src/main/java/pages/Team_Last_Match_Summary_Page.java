package pages;

//Page-Created by Gopinath

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ESPNWrappers;

public class Team_Last_Match_Summary_Page extends ESPNWrappers
{

	public Team_Last_Match_Summary_Page(RemoteWebDriver driver, ExtentTest test) throws InterruptedException
	{
		this.driver = driver;
		this.test = test;
		Thread.sleep(2500);
		if(!verifyTitleContains("Leicester City"))
		{
			reportStep("This is not Leicester City's Last Match-Summary page", "Fail");

		}
	}

	//To get Team1's Main Players-Count
	public Team_Last_Match_Summary_Page getTeam1MainPlayersCount()
	{
		verifyCountofMainPlayers("//table[@class='table-accordion']/tbody");
		return this;
	}

	//To get Team1's Substitute Players-Count
	public Team_Last_Match_Summary_Page getTeam1SubstitutePlayersCount()
	{
		verifyCountofSubstitutePlayers("//table[@class='table-accordion']/tbody[2]");
		return this;
	}

	//To get Team2's Main Players-Count
	public Team_Last_Match_Summary_Page getTeam2MainPlayersCount()
	{
		verifyCountofMainPlayers("(//table[@class='table-accordion'])[2]/tbody");
		return this;
	}

	//To get Team2's Substitute Players-Count
	public Team_Last_Match_Summary_Page getTeam2SubstitutePlayersCount()
	{

		verifyCountofSubstitutePlayers("((//table[@class='table-accordion'])[2]/tbody)[2]");
		return this;

	}
	//To Verify the Teams-posession sum up to 100
	public Team_Last_Match_Summary_Page verifyTeamTotalPecentage()
	{
		verifyTotalPercent();
		return this;
	}


	//To launching a Player's Home Page
	public Player_Home_Page launchPlayer() throws InterruptedException
	{
		clickByXpath("(//div[@class='accordion-item']//span)[4]/a");
		return new Player_Home_Page(driver, test);
	}	
}

