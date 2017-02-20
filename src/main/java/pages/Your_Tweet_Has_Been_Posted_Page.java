package pages;

//Page-Created by Gopinath

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ESPNWrappers;

public class Your_Tweet_Has_Been_Posted_Page extends ESPNWrappers
{

	public Your_Tweet_Has_Been_Posted_Page(RemoteWebDriver driver, ExtentTest test) throws InterruptedException
	{
		this.driver = driver;
		this.test = test;
		Thread.sleep(2500);
		if(!verifyTitle("Your Tweet has been posted!"))
		{
			reportStep("This is not a Your Tweet has been posted! page", "Fail");
		}
	}

	//Close the Your_Tweet_Has_Been_Posted_Page
	public Player_Home_Page clickClose() throws InterruptedException
	{
		clickByIdNoSnap("btn-close");
		switchToLastWindow("Christian Fuchs Player Profile - ESPN FC");
		return new Player_Home_Page(driver, test);
	}
}