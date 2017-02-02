package pages;

//Page-Created by Vigneshwaran S

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ESPNWrappers;

public class Team_Squad_Page extends ESPNWrappers {
public Team_Squad_Page(RemoteWebDriver driver, ExtentTest test) throws InterruptedException
{
	this.driver=driver;
	this.test=test;
	Thread.sleep(2500);
	if(!verifyTitle("Leicester City Squad - ESPN FC"))
	{
		reportStep("Leicester City Squad - ESPN FC","FAIL");
	}
}
public Player_Home_Page clickPlayer() throws InterruptedException
{
	clickByXpath("(//div[@class='squad-data-table'][2]//tr[2]//td[3]/a)");
	return new Player_Home_Page(driver,test);
}
}
