package pages;

//Page-Created by Prabhu

import java.util.List;

//Page-Created by Prabhu

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

//Page-Created by Prabhu

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ESPNWrappers;

public class Home_Page_and_Login_Page extends ESPNWrappers{

	public Home_Page_and_Login_Page(RemoteWebDriver driver, ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		if(!verifyTitle("ESPN: The Worldwide Leader in Sports"))
		{
			reportStep("This is not Home Page", "FAIL");
		}
	}


	//Mouse hover into the football
	public Home_Page_and_Login_Page mouseHoverFootball()
	{
		mouseOverByXpath("//li[@class='sports menu-soccer']");
		return this;
	}

	//click the leagues and cups link under football 
	public Football_Leagues_And_Competitions_Page clickleaguesandcups() throws InterruptedException
	{
		clickByLink("Leagues & Cups");
		return new Football_Leagues_And_Competitions_Page(driver,test);
	}

	//Click the login link 
	public Home_Page_and_Login_Page loginlink()
	{
		clickByXpath("//li[@class='user']/a");
		switchToFrame("disneyid-iframe");
		return this;
	}

	//Pass the user name in ESPN account 
	public Home_Page_and_Login_Page espn_username(String data)
	{
		enterByXpath("//div[@class='field field-username-email']/label/span/input", data);
		return this;
	}

	//Pass the password in ESPN account
	public Home_Page_and_Login_Page espn_password(String data)
	{
		enterByXpath("//div[@class='field field-password']/label/span/input", data);
		return this;
	}

	//Click the login button in ESPN account
	public Home_Page_and_Login_Page espn_LoginButton()
	{
		clickByXpath("//div[@class='btn-group touch-print-btn-group-wrapper']/button[2]");
		switchToDefaultcontent();
		return this;
	}

	//To check whether the error message pops up while logged in, if so PASS
	public Home_Page_and_Login_Page errorMessagePass()
	{
		errorMessagePASS();
		return this;
	}

	//To check whether the error message pops up while logged in, if so FAIL
	public Home_Page_and_Login_Page errorMessageFail()
	{
		errorMessageFAIL();
		return this;
	}

	//click login with facebook button 
	public Facebook_Login_SignUp_Page espn_LogInWithFacebook() throws InterruptedException
	{
		clickByLink("Log In with Facebook");
		switchToLastWindow("Facebook");
		return new Facebook_Login_SignUp_Page(driver, test);
	}

	//Click the Sign up button in ESPN account
	public Home_Page_and_Login_Page espn_SignUpButton()
	{
		clickByXpath("//div[@class='btn-group btn-group-create-account ng-scope']/a");
		return this;
	}

	//Click the "Sign up with email" button in create account 
	public Home_Page_and_Login_Page signUpWithEmail()
	{
		clickByXpath("//div[@class='btn-group']/a[1]");
		return this;
	}

	//Click the "Sign up with face book" button in create account 
	public Facebook_Login_SignUp_Page signUpWithFacebook() throws InterruptedException
	{
		clickByXpath("//div[@class='btn-group']/a[2]");
		switchToLastWindow("Facebook");
		return new Facebook_Login_SignUp_Page(driver, test);
	}

	//Pass the first name in create account  
	public Home_Page_and_Login_Page signup_FirstName(String data)
	{
		enterByXpath("//form[@name='vm.create']/section[1]/div[1]/div[1]/label/span[2]/input", data);
		return this;
	}

	//Pass the last name in create account 
	public Home_Page_and_Login_Page signUp_LastName(String data)
	{
		enterByXpath("//form[@name='vm.create']/section[1]/div[1]/div[2]/label/span[2]/input", data);
		return this;
	}

	//Pass the email address in create account 
	public Home_Page_and_Login_Page signUp_EmailAddress(String data)
	{
		enterByXpath("//form[@name='vm.create']/section[1]/div[2]/div[1]/label/span[2]/input", data);
		return this;
	}

	//Pass the password in create account 
	public Home_Page_and_Login_Page signUp_Password(String data)
	{
		enterByXpath("//form[@name='vm.create']/section[1]/div[3]/div[1]/label/span[2]/input", data);
		return this;
	}

	//select 'Male' as the Gender
	public Home_Page_and_Login_Page signUp_GenderSelectMale()
	{
		clickByXpath("//form[@name='vm.create']/section[2]/div[1]/div/div/label[1]/span");
		return this;
	}

	//Pass the "DOB" in this (dd/mm/yyyy) format
	public Home_Page_and_Login_Page signUp_DOB(String data)
	{
		enterByXpath("//form[@name='vm.create']/section[2]/div[2]/div/span[2]/label/input[1]", data);
		return this;
	}

	//Click the "Sign up" button in create account
	public Home_Page_and_Login_Page signUp_SignUpButton()
	{
		clickByXpath("//form[@name='vm.create']/section[4]/div/button");
		switchToDefaultcontent();
		return this;
	}

	//click the search link in home page
	public Home_Page_and_Login_Page SearchButton_Home()
	{
		clickById("global-search-trigger");
		return this;
	}

	//Passing input as default value "Chelsea" into the search field
	public Home_Page_and_Login_Page PassInput_Search(String data)
	{
		enterByClass("search-box", data);
		return this;
	}

	//gettext of first search result
	public Home_Page_and_Login_Page gettextFirstSearchResult(int i)
	{
		fetchInput("//div[@class='search-results']/ul/li[1]/a", i);
		return this;
	}

	//select the first search-result to select a team
	public Team1_Home_Page selectFirstSearchResultTeam() throws InterruptedException
	{
		Thread.sleep(1500);
		clickByXpath("//div[@class='search-results']/ul/li[1]/a");
		return new Team1_Home_Page(driver,test);
	}

	//select the first search-result to select a player
	public Player_Home_Page selectFirstSearchResultPlayer() throws InterruptedException
	{
		Thread.sleep(1500);
		clickByXpath("//div[@class='search-results']/ul/li[1]/a");
		return new Player_Home_Page(driver,test);
	}

	//mouse hover the account in home page
	public Home_Page_and_Login_Page mouseHover_MyAccount()
	{
		mouseOverById("global-user-trigger");
		return this;
	}

	//get the favourite-team from my account
	public Home_Page_and_Login_Page favouriteTeam_MyAccount(int j)
	{
		verifyInput("//ul[@class='current-favorites-container']/li/a/div[2]", j);
		return this;
	}

	//verifying Ads on the Home page
	public Home_Page_and_Login_Page verifyingAds()
	{
		verifyAdsOnHomePage();
		return this;
	}
}
