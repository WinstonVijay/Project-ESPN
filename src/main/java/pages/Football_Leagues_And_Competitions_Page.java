package pages;

//Page-Created by Vigneshwaran S

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ESPNWrappers;

public class Football_Leagues_And_Competitions_Page extends ESPNWrappers {


public Football_Leagues_And_Competitions_Page(RemoteWebDriver driver, ExtentTest test) throws InterruptedException
{
	this.driver=driver;
	this.test=test;
	Thread.sleep(2500);
	if(!verifyTitle("Football Leagues and Competitions")){
		reportStep("This is not Football Leagues and Competitions Page", "FAIL");
	}
}

//To get the English Premier League-text
public Football_Leagues_And_Competitions_Page getEPLText(String xPathVal, int i){
	fetchInput(xPathVal, i);
	return this;
}


//To click the English Premier League-link
public League_Home_Page clickEPLLink() throws InterruptedException{
	clickByXpath("//div[@class='article-body']//p//a");
	return new League_Home_Page(driver, test);
}
}
