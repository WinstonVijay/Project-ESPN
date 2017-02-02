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
		if(!verifyTitle("Derby County vs. Leicester City - Football Match Summary - January 27, 2017 - ESPN"))
		{
			reportStep("This is not a Southampton vs. Leicester City - Football Match Summary - January 22, 2017 - ESPN", "Fail");

		}
	}

	//To get Team1's Main Players-Count
	public Team_Last_Match_Summary_Page getTeam1MainPlayersCount()
	{
		clickByXpath("//span[contains(text(),'DER')]");
		clickByXpath("//table[@class='table-accordion']/tbody");
		//Yet to add method for counting the members in table
		return this;
	}

	//To get Team1's Substitute Players-Count
	public Team_Last_Match_Summary_Page getTeam1SubstitutePlayersCount()
	{
		clickByXpath("//table[@class='table-accordion']/tbody[2]");
		//Yet to add method for counting the members in table
		return this;
	}

	//To get Team2's Main Players-Count
	public Team_Last_Match_Summary_Page getTeam2MainPlayersCount()
	{
		clickByXpath("(//span[contains(text(),'SOU')])[3]");
		clickByXpath("(//table[@class='table-accordion'])[2]/tbody");
		return this;
	}

	//To get Team2's Substitute Players-Count
	public Team_Last_Match_Summary_Page getTeam2SubstitutePlayersCount()
	{
		clickByXpath("((//table[@class='table-accordion'])[2]/tbody)[2]");
		//Yet to add method for counting the members in table
		return this;

	}

	//To Verify the Teams-posession sum up to 100
	public Team_Last_Match_Summary_Page verifyTeamTotalPecentage()
	{
		String Team1Percentage = getTextByXpath("(//div[@class='possession']//span)[3]");
		String TrimmedTeam1Percentage = Team1Percentage.substring(0, 2);
		int T1Percentage = Integer.parseInt(TrimmedTeam1Percentage);
		String Team2Percentage = getTextByXpath("(//div[@class='possession']//span)[6]");
		String TrimmedTeam2Percentage = Team2Percentage.substring(0, 2);
		int T2Percentage = Integer.parseInt(TrimmedTeam2Percentage);
		int TotalPercentage = T1Percentage + T2Percentage;
		try 
		{
			if(TotalPercentage==100)
			{
				System.out.println("The posession of both the teams sums up to 100");
			}
			else
			{
				System.out.println("The posession of both the teams DOES NOT sum up to 100");
			}
		} 
		catch (NoSuchElementException e) 
		{
			System.out.println("The element TotalPercentage is not found");
		}

		catch (WebDriverException e) 
		{
			System.out.println("The Browser is not found");
		}

		return this;
	}


	//To launching a Player's Home Page
	public Player_Home_Page launchPlayer() throws InterruptedException
	{
		clickByXpath("(//div[@class='accordion-item']//span)[4]/a");
		return new Player_Home_Page(driver, test);

	}	

}

