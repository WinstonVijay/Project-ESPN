package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.Home_Page_and_Login_Page;
import wrappers.ESPNWrappers;

public class TC_011_ClickEPL extends ESPNWrappers  
{
	@BeforeClass
	public void setValues()
	{
		browserName = "chrome";
		testCaseName= "TC_011_ClickEPL";
		testDescription= "Click the EPL Link";
		category="Smoke";
		authors= "Gopi";
	}

	@Test
	public void clickEPL() throws InterruptedException
	{
		new Home_Page_and_Login_Page(driver, test).
		mouseHoverFootball().
		clickleaguesandcups().
		clickEPLLink();
	}
}
