package pages;

//Page-Created by Prabhu

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ESPNWrappers;

public class League_Table_Page extends ESPNWrappers{

	public League_Table_Page(RemoteWebDriver driver,ExtentTest test) throws InterruptedException
	{
		this.driver=driver;
		this.test=test;
		Thread.sleep(2500);
		if(!verifyTitle("English Premier League Table"))
		{
			reportStep("This is not English Premier League Table page", "FAIL");
		}
	}

	//Verify the league-drop down's content as EPL
	public League_Table_Page dropdownleagueverification(String text)
	{
		verifyTextByXpath("//div[@class='filters']/div[1]/button", text);
		return this;
	}

	//Mouser hover the league-Year drop down
	public League_Table_Page mousehover_yeardropdown()
	{
		mouseOverByXpath("//div[@class='filters']/div[2]/button");
		return this;
	}

	//select & change the year as "2015-2016" in the league year drop-down
	public League_Table_Page changeyear_yeardropdown()
	{
		clickByLink("2015-16");
		return this;
	}

	//Launch the top team in the table displayed
	public Team1_Home_Page clickTeam() throws InterruptedException
	{
		clickByXpath("//table[@class='standings has-team-logos']/tbody/tr[1]/td[1]/a[2]/span/span");
		return new Team1_Home_Page(driver, test);
	}

	//get text of first team in the displayed table
	public League_Table_Page firstteam_gettext(String xPathVal, int i)
	{
		fetchInput(xPathVal, i);
		//getTextByXpath("//table[@class='standings has-team-logos']/tbody/tr[1]/td[1]/a[2]/span/span");
		return this;
	}

	//get the position of the target team-Leicester City in the current year of 2016-2017
	public League_Table_Page getposition_LeicesterCity()
	{
		//getTextByXpath("//tbody/tr[15]/td[1]/span");
		return this;
	}

}
