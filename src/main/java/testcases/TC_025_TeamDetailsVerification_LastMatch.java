package testcases;

import java.text.ParseException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.Home_Page_and_Login_Page;
import wrappers.ESPNWrappers;

public class TC_025_TeamDetailsVerification_LastMatch extends ESPNWrappers
{
	@BeforeClass
	public void setValues()
	{
		browserName = "chrome";
		testCaseName = "TC_025_TeamDetailsVerification_LastMatch";
		testDescription = " Verify the Last Match details are displayed both (Team Home/Fixtures & Results page)";
		category = "Regression";
		authors = "Prabhu";
	}

	@Test
	public void Teamdetailsverification() throws InterruptedException 
	{
		new Home_Page_and_Login_Page(driver, test)
		.mouseHoverFootball()
		.clickleaguesandcups()
		.clickEPLLink()
		.clicktablelink()
		.mouseHover_YearDropdown()
		.changeYear_YearDropdown()
		.selectTeam()
		.getLastMatchTeam1Name("//section[@class='club-schedule']//li[2]//span[3]", 0)
		.getLastMatchTeam1Score("(//div[@class='score-container']//span)[3]", 0)
		.getLastMatchTeam2Name("//section[@class='club-schedule']//li[2]//div[3]//span[3]", 1)
		.getLastMatchTeam2Score("(//div[@class='score-container']//span)[4]", 1)
		.clickFixturesandResultsLink()
		.verifyLastMatchTeam1Name("//div[@class='last-match']/div/div/div/div[1]/div[1]/span", 0)
		.verifyLastMatchTeam2Name("//div[@class='last-match']/div/div/div/div[1]/div[2]/span", 1)
		.verifyLastMatchTeam1Score("//div[@class='last-match']/div/div/div/div[2]/div[1]/span", 0)
		.verifyLastMatchTeam2Score("//div[@class='last-match']/div/div/div/div[2]/div[2]/span", 1);
	}
}


