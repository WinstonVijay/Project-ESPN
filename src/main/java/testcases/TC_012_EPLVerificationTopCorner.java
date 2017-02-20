package testcases;

import java.text.ParseException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.Home_Page_and_Login_Page;
import wrappers.ESPNWrappers;

public class TC_012_EPLVerificationTopCorner extends ESPNWrappers
{
	@BeforeClass
	public void setValues()
	{
		browserName = "chrome";
		testCaseName = "TC_012_EPLVerificationTopCorner";
		testDescription = "view the EPL title displayed in the left top corner of the page";
		category = "Regression";
		authors = "Prabhu";
	}

	@Test
	public void EPLTitleverification() throws InterruptedException
	{
		new Home_Page_and_Login_Page(driver, test)
		.mouseHoverFootball()
		.clickleaguesandcups()
		.getEPLText("//div[@class='article-body']//p//a", 0)
		.clickEPLLink()
		.EPLtiltleverification("//span[contains(text(),'English Premier League')]", 0);
	}
}


