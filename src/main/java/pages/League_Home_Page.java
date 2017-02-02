package pages;

import java.util.concurrent.TimeUnit;

//Page-Created by Prabhu

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ESPNWrappers;

public class League_Home_Page extends ESPNWrappers {

	public League_Home_Page(RemoteWebDriver driver, ExtentTest test) throws InterruptedException
	{
		this.driver=driver;
		this.test=test;
		Thread.sleep(2500);
		if(!verifyTitle("English Premier League News, Stats, Scores - ESPN"))
		{
			reportStep("This is not league home page", "FAIL");
		}
	}
	
	//verify the title as "English Premier League" in the left top corner of the page
	public League_Home_Page EPLtiltleverification(String xPathVal, int k)
	{
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		verifyInput(xPathVal, k);
		return this;
	}
	
	//click the table link
	public League_Table_Page clicktablelink() throws InterruptedException
	{
		clickByName("&lpos=subnav+subnav_soccer_table");
		return new League_Table_Page(driver, test);
	}



}
