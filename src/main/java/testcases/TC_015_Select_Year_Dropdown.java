package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.Home_Page_and_Login_Page;
import wrappers.ESPNWrappers;

public class TC_015_Select_Year_Dropdown extends ESPNWrappers 
{
	@BeforeClass
	public void setValues()
	{
		browserName = "chrome";
		testCaseName = "TC_015_Select_Year_Dropdown";
		testDescription = "Select Year from the Dropdown";
		category="Regression";
		authors = "Gopi";
	}

	@Test
	public void selectYear() throws InterruptedException
	{
		new Home_Page_and_Login_Page(driver, test)
		.mouseHoverFootball()
		.clickleaguesandcups()
		.getEPLText("//a[contains(text(),'English Premier League')]", 0)
		.clickEPLLink()
		.EPLtiltleverification("//span[contains(text(),'English Premier League')]", 0)
		.clicktablelink()
		.dropdownleagueverification("English Premier League")
		.mouseHover_YearDropdown()
		.changeYear_YearDropdown();
	}
}
