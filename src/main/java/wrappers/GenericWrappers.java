package wrappers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

import pages.Home_Page_and_Login_Page;
import utils.Reporter;

public class GenericWrappers extends Reporter implements Wrappers {

	public GenericWrappers(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test=test;
	}

	public RemoteWebDriver driver;
	protected static Properties prop;
	public String sUrl,primaryWindowHandle,sHubUrl,sHubPort;
	String currentDte, trimDate;
	String trimmedInput, inputToLCase;
	static String playerDetails, playerPosition, matchesPlayed, goalsScored;
	static String TxtGotToUseLater;
	static String stringtoTrimBIXP,stringtoTrimBIId;
	static String stringtoTrimBEIXP, stringtoTrimBEIId;
	static String finalFetchedStrInput1A, finalFetchedStrInput1AA;
	static String finalFetchedIntInput1A, finalFetchedIntInput1AA;
	static String finalFetchedTiming1A, finalFetchedTiming1AA;
	static String finalFetchedStrInputLong1A, finalFetchedStrInputLong1AA;
	static String finalFetchedGoals1A, finalFetchedGoals1AA;
	static String currentTeam, opponentTeam;
	static String Team1Percentage, Team2Percentage;
	static String TrimmedTeam1Percentage, TrimmedTeam2Percentage;
	static String lastMatchTeam1Name, lastMatchTeam2Name, lastMatchTeam1Score, lastMatchTeam2Score;
	static String matchValue;
	static String teamNameLastMatch, teamScoreLastMatch;
	static int T1Percentage, T2Percentage, TotalPercentage;
	static int parsedCurrentDte, parsedpageDte;
	static int CountofTableContents;
	static int lastMatchTeamAScore, lastMatchTeamBScore;
	static int teamGoalsScored;
	static int adCount;
	static int playersCount;
	SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy");
	Date calDate;

	public GenericWrappers() {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File("./src/main/resources/config.properties")));
			sHubUrl = prop.getProperty("HUB");
			sHubPort = prop.getProperty("PORT");
			sUrl = prop.getProperty("URL");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will launch the browser in local machine and maximise the browser and set the
	 * wait for 30 seconds and load the url
	 * @author Winston
	 * @param url - The url with http or https
	 * 
	 */
	public void invokeApp(String browser) {
		invokeApp(browser,false);
	}

	/**
	 * This method will launch the browser in grid node (if remote) and maximise the browser and set the
	 * wait for 30 seconds and load the url 
	 * @author Winston
	 * @param url - The url with http or https
	 * 
	 */
	public void invokeApp(String browser, boolean bRemote) {
		try {

			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setBrowserName(browser);
			dc.setPlatform(Platform.WINDOWS);

			// this is for grid run
			if(bRemote)
				driver = new RemoteWebDriver(new URL("http://"+sHubUrl+":"+sHubPort+"/wd/hub"), dc);
			else{ // this is for local run
				if(browser.equalsIgnoreCase("chrome")){
					System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
					driver = new ChromeDriver();
				}else{
					System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
					driver = new FirefoxDriver();
				}
			}

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(sUrl);

			primaryWindowHandle = driver.getWindowHandle();		
			reportStep("The browser:" + browser + " launched successfully", "PASS");

		} catch (Exception e) {
			e.printStackTrace();
			reportStep("The browser:" + browser + " could not be launched", "FAIL");
		}
	}

	//To check whether the error message pops up while logged in, if so PASS
	public void errorMessagePASS() {
		try {
			switchToFrame("disneyid-iframe");
			System.out.println("SUCCESS! - Log-In Failed as expected");
			reportStep("Log-In Failed as expected", "PASS");
		}catch (Exception e) {
			reportStep("Unknown exception occured while fetching data", "FAIL");
		}
	}

	//To check whether the error message pops up while logged in, if so FAIL
	public void errorMessageFAIL() {
		try {
			switchToFrame("disneyid-iframe");
			System.out.println("FAIL - Log In Failed due to technical difficulties");
			reportStep("Log-In Failed due to technical difficulties", "FAIL");
		}
		catch (NoSuchElementException e) {
			reportStep("Log-In successfull", "FAIL");
		}catch (Exception e) {
			reportStep("Unknown exception occured while fetching data", "FAIL");
		}
	}

	//To verify the presence of the Current Team in the Last Match section
	public boolean verifyTeamPresentLastMatch()
	{
		String Team1Name = driver.findElement(By.xpath("//div[@class='last-match']/div/div/div/div/div[1]")).getText();
		System.out.println(Team1Name);
		String Team2Name = driver.findElement(By.xpath("//div[@class='last-match']/div/div/div/div/div[1]")).getText();
		System.out.println(Team2Name);
		boolean bReturn = false;
		try {
			if(Team1Name.contains("Leicester City")){
				System.out.println("In the Last_Match-section, the Team1 is identified to be 'Leicester City'");
				reportStep("In the Last_Match-section, the Team1 is identified to be 'Leicester City'", "PASS");
				bReturn = true;
			}else{
				if(Team2Name.contains("Leicester City")){
					System.out.println("In the Last_Match-section, the Team2 is identified to be 'Leicester City'");
					reportStep("In the Last_Match-section, the Team2 is identified to be 'Leicester City'", "PASS");
					bReturn = true;
				}
			}
		}catch (Exception e) {
			reportStep("Unknown exception occured while verifying the title", "FAIL");
		}
		return bReturn;
	}

	//To verify the presence of the Current Team in the Next Match section
	public boolean verifyTeamPresentNextMatch()
	{
		String Team1Name = driver.findElement(By.xpath("//div[@class='next-match']/div/div/div/div/div[1]")).getText();
		String Team2Name = driver.findElement(By.xpath("//div[@class='next-match']/div/div/div/div/div[2]")).getText();
		boolean bReturn = false;
		try {
			if(Team1Name.contains("Leicester City")){
				System.out.println("In the Next_Match-section, the Team1 is identified to be 'Leicester City'");
				reportStep("In the Next_Match-section, the Team1 is identified to be 'Leicester City'", "PASS");
				bReturn = true;
			}else{
				if(Team2Name.contains("Leicester City")){
					System.out.println("In the Next_Match-section, the Team2 is identified to be 'Leicester City'");
					reportStep("In the Next_Match-section, the Team2 is identified to be 'Leicester City'", "PASS");
					bReturn = true;
				}
			}
		}catch (Exception e) {
			reportStep("Unknown exception occured while verifying the title", "FAIL");
		}
		return bReturn;
	}

	//To verify the last match-status of Leicester City
	public void verifyLeiCityLastMatchStatus()
	{
		lastMatchTeam1Name = driver.findElement(By.xpath("(//a[@class='team-name'])[1]")).getText();
		lastMatchTeam1Score = driver.findElement(By.xpath("//span[@class='score icon-font-after']")).getText();
		lastMatchTeamAScore = Integer.parseInt(lastMatchTeam1Score);
		lastMatchTeam2Name = driver.findElement(By.xpath("(//a[@class='team-name'])[2]")).getText();
		lastMatchTeam2Score = driver.findElement(By.xpath("//span[@class='score icon-font-before']")).getText();
		lastMatchTeamBScore = Integer.parseInt(lastMatchTeam2Score);

		try {
			if(lastMatchTeamAScore>lastMatchTeamBScore)
			{
				if(lastMatchTeam1Name.contains("Leicester City"))
				{
					System.out.println("Leicester City won it's last match with "+"'"+lastMatchTeam2Name+"'"+" by "+lastMatchTeam1Score+" goals");
					reportStep("Leicester City won it's last match", "PASS");
				}else{
					System.out.println("Leicester City lost it's last match with "+"'"+lastMatchTeam1Name+"'"+" by "+(lastMatchTeamAScore-lastMatchTeamBScore)+" goals");
					reportStep("Leicester City lost it's last match", "PASS");
				}
			}else{
				if(lastMatchTeamAScore==lastMatchTeamBScore)
				{
					System.out.println("Leicester City's last match was a draw with both the teams scoring "+lastMatchTeamAScore+" goals each");
					reportStep("Leicester City's last match was a draw", "PASS");
				}
			}
		} catch (NoSuchElementException e) {
			reportStep("The stated element could not be located", "FAIL");
		} catch (Exception e) {
			reportStep("Unknown exception occured while locating the stated element", "FAIL");
		}
	}

	//Verify Ads count
	public void verifyAdsOnHomePage()
	{
		adCount=0;
		try {
			List<WebElement> totalFrames = driver.findElements(By.tagName("iframe"));
			for(WebElement frame : totalFrames)
			{
				matchValue = frame.getAttribute("title");
				if(matchValue.equalsIgnoreCase("3rd party ad content"))
				{
					adCount++;
				}
			}
			if(adCount==7)
			{
				System.out.println("The total no. of Ads in the Home and Login page is verified to be 7");
				reportStep("The total no. of Ads in the Home and Login page is verified to be 7", "PASS");
			}
		} catch (NoSuchElementException e) {
			reportStep("The stated element could not be located", "FAIL");
		} catch (Exception e) {
			reportStep("Unknown exception occured while locating the stated element", "FAIL");
		}
	}

	//To verify the score and the details displayed are unique-Last Match report page
	public void scoreAndPlayerDetailsVerify(String xPathValTeamName, String xPathValScore, String xPathValPlayers)
	{
		try {
			teamNameLastMatch = driver.findElement(By.xpath(xPathValTeamName)).getText();
			teamScoreLastMatch = driver.findElement(By.xpath(xPathValScore)).getText();
			teamGoalsScored = Integer.parseInt(teamScoreLastMatch);
			if(teamGoalsScored>=1)
			{
				WebElement scoredPlayers = driver.findElement(By.xpath(xPathValPlayers));
				List<WebElement> playersList = scoredPlayers.findElements(By.tagName("li"));
				playersCount = playersList.size();
				if(teamGoalsScored == playersCount)
				{
					System.out.println("The team: "+teamNameLastMatch+"'s Score and Player details match");
					reportStep("The team: "+teamNameLastMatch+"'s Score and Player details match", "PASS");
				}else
				{
					System.out.println("The team: "+teamNameLastMatch+"'s Score and Player details DO NOT match");
					reportStep("The team: "+teamNameLastMatch+"'s Score and Player details DO NOT match", "FAIL");
				}
			}else{
				System.out.println("The team: "+teamNameLastMatch+" scored no goals");
				reportStep("The team: "+teamNameLastMatch+" scored no goals", "PASS");
			}
		} catch (NoSuchElementException e) {
			reportStep("The stated element could not be located", "FAIL");
		} catch (Exception e) {
			reportStep("Unknown exception occured while locating the stated element", "FAIL");
		}
	}

	/**
	 * This method will enter the value to the text field using id attribute to locate
	 * 
	 * @param idValue - id of the webelement
	 * @param data - The data to be sent to the webelement
	 * @author Winston
	 * @throws IOException 
	 * @throws COSVisitorException 
	 */

	public void enterById(String idValue, String data) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(idValue)));
			driver.findElement(By.id(idValue)).clear();
			driver.findElement(By.id(idValue)).sendKeys(data);	
			reportStep("The data: "+data+" entered successfully in field :"+idValue, "PASS");
		} catch (NoSuchElementException e) {
			reportStep("The data: "+data+" could not be entered in the field :"+idValue, "FAIL");
		} catch (Exception e) {
			reportStep("Unknown exception occured while entering "+data+" in the field :"+idValue, "FAIL");
		}
	}

	/**
	 * This method will enter the value to the text field using name attribute to locate
	 * 
	 * @param nameValue - name of the webelement
	 * @param data - The data to be sent to the webelement
	 * @author Winston
	 * @throws IOException 
	 * @throws COSVisitorException 
	 */
	public void enterByName(String nameValue, String data) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.name(nameValue)));
			driver.findElement(By.name(nameValue)).clear();
			driver.findElement(By.name(nameValue)).sendKeys(data);	
			reportStep("The data: "+data+" entered successfully in field :"+nameValue, "PASS");

		} catch (NoSuchElementException e) {
			reportStep("The data: "+data+" could not be entered in the field :"+nameValue, "FAIL");
		} catch (Exception e) {
			reportStep("Unknown exception occured while entering "+data+" in the field :"+nameValue, "FAIL");
		}

	}

	/**
	 * This method will enter the value to the text field using name attribute to locate
	 * 
	 * @param classValue - Class Value of the webelement
	 * @param data - The data to be sent to the webelement
	 * @author Winston
	 * @throws IOException 
	 * @throws COSVisitorException 
	 */
	public void enterByClass(String classValue, String data) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.className(classValue)));
			driver.findElement(By.className(classValue)).clear();
			driver.findElement(By.className(classValue)).sendKeys(data);	
			reportStep("The data: "+data+" entered successfully in field :"+classValue, "PASS");

		} catch (NoSuchElementException e) {
			reportStep("The data: "+data+" could not be entered in the field :"+classValue, "FAIL");
		} catch (Exception e) {
			reportStep("Unknown exception occured while entering "+data+" in the field :"+classValue, "FAIL");
		}

	}

	/**
	 * This method will enter the value to the text field using name attribute to locate
	 * 
	 * @param xpathValue - xpathValue of the webelement
	 * @param data - The data to be sent to the webelement
	 * @author Winston
	 * @throws IOException 
	 * @throws COSVisitorException 
	 */
	public void enterByXpath(String xpathValue, String data) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathValue)));
			driver.findElement(By.xpath(xpathValue)).clear();
			driver.findElement(By.xpath(xpathValue)).sendKeys(data);	
			reportStep("The data: "+data+" entered successfully in field :"+xpathValue, "PASS");

		} catch (NoSuchElementException e) {
			reportStep("The data: "+data+" could not be entered in the field :"+xpathValue, "FAIL");
		} catch (Exception e) {
			reportStep("Unknown exception occured while entering "+data+" in the field :"+xpathValue, "FAIL");
		}
	}

	/**
	 * This method will verify the title of the browser 
	 * @param title - The expected title of the browser
	 * @author Winston
	 */
	public boolean verifyTitle(String title){
		boolean bReturn = false;
		try{
			if (driver.getTitle().equalsIgnoreCase(title)){
				reportStep("The title of the page matches with the value :"+title, "PASS");
				bReturn = true;
			}else
				reportStep("The title of the page:"+driver.getTitle()+" did not match with the value :"+title, "SUCCESS");

		}catch (Exception e) {
			reportStep("Unknown exception occured while verifying the title", "FAIL");
		}
		return bReturn;
	}

	/**
	 * This method will verify the title of the browser whether it just contains the input
	 * @param title - The expected title of the browser
	 * @author Winston
	 */
	public boolean verifyTitleContains(String title){
		boolean bReturn = false;
		try{
			if (driver.getTitle().contains(title)){
				reportStep("The title of the page matches with the value :"+title, "PASS");
				bReturn = true;
			}else
				reportStep("The title of the page:"+driver.getTitle()+" did not match with the value :"+title, "SUCCESS");

		}catch (Exception e) {
			reportStep("Unknown exception occured while verifying the title", "FAIL");
		}
		return bReturn;
	}

	/**
	 * This method will verify the given text matches in the element text
	 * @param xpath - The locator of the object in xpath
	 * @param text  - The text to be verified
	 * @author Winston
	 */
	public void verifyTextByXpath(String xpath, String text){
		try {
			String sText = driver.findElementByXPath(xpath).getText();
			if (sText.equalsIgnoreCase(text)){
				System.out.println("The text: "+sText+" matches with the value :"+text);
				reportStep("The text: "+sText+" matches with the value :"+text, "PASS");
			}else{
				System.out.println("The text: "+sText+" did not match with the value :"+text);
				reportStep("The text: "+sText+" did not match with the value :"+text, "FAIL");
			}
		}catch (Exception e) {
			reportStep("Unknown exception occured while verifying the title", "FAIL");
		}
	}

	/**
	 * This method will verify the given text is available in the element text
	 * @param xpath - The locator of the object in xpath
	 * @param text  - The text to be verified
	 * @author Winston
	 */
	public void verifyTextContainsByXpath(String xpath, String text){
		try{
			String sText = driver.findElementByXPath(xpath).getText();
			if (sText.contains(text)){
				System.out.println("The text: "+sText+" matches with the value :"+text);
				reportStep("The text: "+sText+" contains the value :"+text, "PASS");
			}else{
				System.out.println("The text: "+sText+" did not match with the value :"+text);
				reportStep("The text: "+sText+" did not contain the value :"+text, "FAIL");
			}
		}catch (Exception e) {
			reportStep("Unknown exception occured while verifying the title", "FAIL");
		}
	}

	/**
	 * This method will verify the given text is available in the element text
	 * @param id - The locator of the object in id
	 * @param text  - The text to be verified
	 * @author Winston
	 */
	public void verifyTextById(String id, String text) {
		try{
			String sText = driver.findElementById(id).getText();
			if (sText.equalsIgnoreCase(text)){
				System.out.println("The text: "+sText+" matches with the value :"+text);
				reportStep("The text: "+sText+" matches with the value :"+text, "PASS");
			}else{
				System.out.println("The text: "+sText+" did not match with the value :"+text);
				reportStep("The text: "+sText+" did not match with the value :"+text, "FAIL");
			}
		}catch (Exception e) {
			reportStep("Unknown exception occured while verifying the title", "FAIL");
		}
	}

	/**
	 * This method will verify the given text is available in the element text
	 * @param id - The locator of the object in id
	 * @param text  - The text to be verified
	 * @author Winston
	 */
	public void verifyTextContainsById(String id, String text) {
		try{
			String sText = driver.findElementById(id).getText();
			if (sText.contains(text)){
				System.out.println("The text: "+sText+" matches with the value :"+text);
				reportStep("The text: "+sText+" contains the value :"+text, "PASS");
			}else{
				System.out.println("The text: "+sText+" did not match with the value :"+text);
				reportStep("The text: "+sText+" did not contain the value :"+text, "FAIL");
			}
		}catch (Exception e) {
			reportStep("Unknown exception occured while verifying the title", "FAIL");
		}
	}

	//To verify the total percentage of 2 teams
	public void verifyTotalPercent(){
		Team1Percentage = getTextByXpath("(//div[@class='possession']//span)[3]");
		TrimmedTeam1Percentage = Team1Percentage.substring(0, 2);
		T1Percentage = Integer.parseInt(TrimmedTeam1Percentage);
		Team2Percentage = getTextByXpath("(//div[@class='possession']//span)[6]");
		TrimmedTeam2Percentage = Team2Percentage.substring(0, 2);
		T2Percentage = Integer.parseInt(TrimmedTeam2Percentage);
		TotalPercentage = T1Percentage + T2Percentage;
		try 
		{
			if(TotalPercentage==100)
			{
				System.out.println("The posession of both the teams sums up to 100");
				reportStep("The posession of both the teams sums up to 100", "PASS");
			}
			else
			{
				System.out.println("The posession of both the teams DOES NOT sum up to 100");
				reportStep("The posession of both the teams does NOT sums up to 100", "FAIL");
			}
		}catch (NoSuchElementException e) {
			reportStep("The element could not be found", "FAIL");
		} catch (Exception e) {
			reportStep("Unknown exception occured while finding the element", "FAIL");
		}
	}

	//get Team's total goals scored
	public void getTeamGoalsScoredCount(){
		String TeamName =subStringBegEndIndexesXpath("//li[@class='stat-box']//span", 0, 4);
		try {
			if(TeamName.contains("LEI"))
			{
				String Team1TotalGoalCount = driver.findElement(By.xpath("(//li[@class='stat-box']//span)[5]")).getText();
				System.out.println("Team1-Leicester's Goals Count: " +Team1TotalGoalCount );
				reportStep("Team1-Leicester's Goals Count is verified to be: "+Team1TotalGoalCount, "PASS");
			}	
			else
			{
				String Team2TotalGoalCount = driver.findElement(By.xpath("(//li[@class='stat-box']//span)[8]")).getText();
				System.out.println("Team2-Leicester's Goals Count: " + Team2TotalGoalCount );
				reportStep("Team2-Leicester's Goals Count is verified to be: "+Team2TotalGoalCount, "PASS");
			}
		}catch (NoSuchElementException e) {
			reportStep("The element could not be found", "FAIL");
		} catch (Exception e) {
			reportStep("Unknown exception occured while finding the element", "FAIL");
		}
	}

	//get Team's total goals conceded
	public void getTeamGoalsConcededCount(){
		String TeamName =subStringBegEndIndexesXpath("(//li[@class='stat-box']//span)[11]", 0, 4);
		try {
			if(TeamName.contains("LEI"))
			{
				String Team1GoalsConcededCount = driver.findElement(By.xpath("(//li[@class='stat-box']//span)[15]")).getText();
				System.out.println("Team1-Leicester's Goals Conceded Count: " +Team1GoalsConcededCount);
				reportStep("Team1-Leicester's Goals Conceded Count is verified to be: "+Team1GoalsConcededCount, "PASS");
			}	
			else
			{
				String Team2GoalsConcededCount = driver.findElement(By.xpath("(//li[@class='stat-box']//span)[18]")).getText();
				System.out.println("Team2-Leicester's Goals Conceded Count: " + Team2GoalsConcededCount);
				reportStep("Team2-Leicester's Goals Conceded Count is verified to be: "+Team2GoalsConcededCount, "PASS");
			}
		}catch (NoSuchElementException e) {
			reportStep("The element could not be found", "FAIL");
		} catch (Exception e) {
			reportStep("Unknown exception occured while finding the element", "FAIL");
		}	
	}

	/**
	 * This method will close all the browsers
	 * @author Winston
	 */
	public void quitBrowser() {
		try {
			driver.quit();
		} catch (Exception e) {
			reportStep("The browser:"+driver.getCapabilities().getBrowserName()+" could not be closed.", "FAIL");
		}

	}

	/**
	 * This method will click the element using id as locator
	 * @param id  The id (locator) of the element to be clicked
	 * @author Winston
	 */
	public void clickById(String id) {
		try{
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id(id))));
			driver.findElement(By.id(id)).click();
			reportStep("The element with id: "+id+" is clicked.", "PASS");
		} catch (Exception e) {
			reportStep("The element with id: "+id+" could not be clicked.", "FAIL");
		}
	}

	//to click by id, without taking a snap
	public void clickByIdNoSnap(String id) {
		try{
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id(id))));
			driver.findElement(By.id(id)).click();
		} catch (Exception e) {
			System.out.println("Unknown exception!");
		}
	}

	/**
	 * This method will click the element using id as locator
	 * @param classVal  The Class value (locator) of the element to be clicked
	 * @author Winston
	 */
	public void clickByClassName(String classVal) {
		try{
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.className(classVal))));
			driver.findElement(By.className(classVal)).click();
			reportStep("The element with class Name: "+classVal+" is clicked.", "PASS");
		} catch (Exception e) {
			reportStep("The element with class Name: "+classVal+" could not be clicked.", "FAIL");
		}
	}
	/**
	 * This method will click the element using name as locator
	 * @param name  The name (locator) of the element to be clicked
	 * @author Winston
	 */
	public void clickByName(String name) {
		try{
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name(name))));
			driver.findElement(By.name(name)).click();
			reportStep("The element with name: "+name+" is clicked.", "PASS");
		} catch (Exception e) {
			reportStep("The element with name: "+name+" could not be clicked.", "FAIL");
		}
	}

	/**
	 * This method will click the element using link name as locator
	 * @param linkVal  The link value (locator) of the element to be clicked
	 * @author Winston
	 */
	public void clickByLink(String linkVal) {
		try{
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText(linkVal))));
			driver.findElement(By.linkText(linkVal)).click();
			reportStep("The element with link name: "+linkVal+" is clicked.", "PASS");
		} catch (Exception e) {
			reportStep("The element with link name: "+linkVal+" could not be clicked.", "FAIL");
		}
	}

	/**
	 * This method will click the element using partial-link name as locator
	 * @param partLinkVal  The partial-link value (locator) of the element to be clicked
	 * @author Winston
	 */
	public void clickByPartialLink(String partLinkVal) {
		try{
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText(partLinkVal))));
			driver.findElement(By.linkText(partLinkVal)).click();
			reportStep("The element with link name: "+partLinkVal+" is clicked.", "PASS");
		} catch (Exception e) {
			reportStep("The element with link name: "+partLinkVal+" could not be clicked.", "FAIL");
		}
	}

	/**
	 * This method will click the element using link name as locator, but without taking a Snap
	 * @param linkVal  The link value (locator) of the element to be clicked
	 * @author Winston
	 */
	public void clickByLinkNoSnap(String linkVal) {
		try{
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText(linkVal))));
			driver.findElement(By.linkText(linkVal)).click();
		} catch (Exception e) {
			reportStep("The element with link name: "+linkVal+" could not be clicked.", "FAIL");
		}
	}

	/**
	 * This method will click the element using xpath as locator
	 * @param xpathVal  The xpath (locator) of the element to be clicked
	 * @author Winston
	 */
	public void clickByXpath(String xpathVal) {
		try{
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(xpathVal))));
			driver.findElement(By.xpath(xpathVal)).click();
			reportStep("The element : "+xpathVal+" is clicked.", "PASS");
		} catch (Exception e) {
			reportStep("The element with xpath: "+xpathVal+" could not be clicked.", "FAIL");
		}
	}

	/**
	 * This method will click the element using xpath as locator, but without taking a Snap
	 * @param xpathVal  The xpath (locator) of the element to be clicked
	 * @author Winston
	 */
	public void clickByXpathNoSnap(String xpathVal) {
		try{
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(xpathVal))));
			driver.findElement(By.xpath(xpathVal)).click();
		} catch (Exception e) {
			reportStep("The element with xpath: "+xpathVal+" could not be clicked.", "FAIL");
		}
	}

	/**
	 * This method will mouse over on the element using id as locator
	 * @param idVal  The id (locator) of the element to be moused over
	 * @author Winston
	 */
	public void mouseOverById(String idVal) {
		try{
			new Actions(driver).moveToElement(driver.findElement(By.id(idVal))).build().perform();
			reportStep("The mouse over by xpath : "+idVal+" is performed.", "PASS");
		} catch (Exception e) {
			reportStep("The mouse over by xpath : "+idVal+" could not be performed.", "FAIL");
		}
	}

	/**
	 * This method will mouse over on the element using xpath as locator
	 * @param xpathVal  The xpath (locator) of the element to be moused over
	 * @author Winston
	 */
	public void mouseOverByXpath(String xpathVal) {
		try{
			new Actions(driver).moveToElement(driver.findElement(By.xpath(xpathVal))).build().perform();
			reportStep("The mouse over by xpath : "+xpathVal+" is performed.", "PASS");
		} catch (Exception e) {
			reportStep("The mouse over by xpath : "+xpathVal+" could not be performed.", "FAIL");
		}
	}

	/**
	 * This method will get the text of the element, to be use later at a different step, using xpath as locator
	 * @param xpathVal  The xpath (locator) of the element
	 * @author Winston
	 */
	public String getTextToUseLater(String xpathVal){
		//String bReturn = "";
		try{
			TxtGotToUseLater = driver.findElement(By.xpath(xpathVal)).getText();
			System.out.println(TxtGotToUseLater);
		} catch (Exception e) {
			reportStep("The element with xpath: "+xpathVal+" could not be found.", "FAIL");
		}
		return TxtGotToUseLater; 
	}

	/**
	 * This method will enter the text fetched earlier using the method:, using xpath as locator
	 * @param xpathVal  The xpath (locator) of the element
	 * @author Winston
	 */
	public void enterTextFetchedEarlier(String xpathVal){
		try{
			driver.findElement(By.xpath(xpathVal)).clear();
			driver.findElement(By.xpath(xpathVal)).sendKeys(TxtGotToUseLater);	
			reportStep("The data: "+TxtGotToUseLater+" entered successfully in field :"+xpathVal, "PASS");
		} catch (NoSuchElementException e) {
			reportStep("The data: "+TxtGotToUseLater+" could not be entered in the field :"+xpathVal, "FAIL");
		} catch (Exception e) {
			reportStep("Unknown exception occured while entering "+TxtGotToUseLater+" in the field :"+xpathVal, "FAIL");
		}
	}

	/**
	 * This method will return the text of the element using xpath as locator
	 * @param xpathVal  The xpath (locator) of the element
	 * @author Winston
	 */
	public String getTextByXpath(String xpathVal){
		String bReturn = "";
		try{
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathVal)));
			System.out.println(driver.findElement(By.xpath(xpathVal)).getText());
			return driver.findElement(By.xpath(xpathVal)).getText();
		} catch (Exception e) {
			reportStep("The element with xpath: "+xpathVal+" could not be found.", "FAIL");
		}
		return bReturn; 
	}

	/**
	 * This method will return the text of the element using id as locator
	 * @param xpathVal  The id (locator) of the element
	 * @author Winston
	 */
	public String getTextById(String idVal) {
		String bReturn = "";
		try{
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(idVal)));
			System.out.println(driver.findElement(By.id(idVal)).getText());
			return driver.findElement(By.id(idVal)).getText();
		} catch (Exception e) {
			reportStep("The element with id: "+idVal+" could not be found.", "FAIL");
		}
		return bReturn; 
	}

	//to switch to the parent window
	public void switchToParentWindow() {
		try {
			Set<String> winHandles = driver.getWindowHandles();
			for (String wHandle : winHandles) {
				driver.switchTo().window(wHandle);
				break;
			}
		} catch (Exception e) {
			reportStep("The window could not be switched to the first window", "FAIL");
		}
	}

	//to switch to the last-active window
	public void switchToLastWindow(String windowTitle) {
		try {
			Set<String> winHandles1 = driver.getWindowHandles();
			for (String wHandle : winHandles1) 
			{
				driver.switchTo().window(wHandle);
				if(driver.getTitle().contains(windowTitle))
				{
					System.out.println("Switched to the target window with title: "+windowTitle);
					break;
				}
			}
		} catch (Exception e) {
			reportStep("The window could not be switched to the last window", "FAIL");
		}
	}


	//To switch to a specific frame
	public void switchToFrame(String locValue)
	{
		try {
			WebElement frame= driver.findElement(By.id(locValue));
			driver.switchTo().frame(frame);
			System.out.println("Frame-switch SUCCESSFUL");
			reportStep("Frame-switch SUCCESSFUL", "PASS");
		} catch (Exception e) {
			reportStep("Unknown exception occured while finding "+locValue, "FAIL");
		}
	}

	//To switch to the default frame
	public void switchToDefaultcontent(){
		try {
			driver.switchTo().defaultContent();
			System.out.println("Frame-switch SUCCESSFUL");
			reportStep("Default Frame-switch SUCCESSFUL", "PASS");
		} catch (Exception e) {
			reportStep("Unknown exception occured", "FAIL");
		}
	}

	//To take a snap
	public long takeSnap(){
		long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L; 
		try {
			FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE) , new File("./reports/images/"+number+".jpg"));
		} catch (WebDriverException e) {
			reportStep("The browser has been closed.", "FAIL");
		} catch (IOException e) {
			reportStep("The snapshot could not be taken", "WARN");
		}
		return number;
	}

	//To substring a String by providing the Begin index alone-using xPath as locator
	public String subStringBegIndexXpath(String xpathVal, int begIndex){
		try {
			stringtoTrimBIXP=getTextByXpath(xpathVal);
			System.out.println(stringtoTrimBIXP.substring(begIndex));
			reportStep("String has been successfully trimmed", "PASS");
		} catch (NoSuchElementException e) {
			reportStep("The element: "+xpathVal+" could not be found", "FAIL");
		} catch (Exception e) {
			reportStep("Unknown exception occured while finding "+xpathVal, "FAIL");
		}
		return stringtoTrimBIXP.substring(begIndex);
	}

	//To substring a String by providing the Begin index alone-using Id as locator
	public String subStringBegIndexId(String idVal, int begIndex){
		try {
			stringtoTrimBIId=getTextById(idVal);
			System.out.println(stringtoTrimBIId.substring(begIndex));
			reportStep("String has been successfully trimmed", "PASS");
		} catch (NoSuchElementException e) {
			reportStep("The element: "+idVal+" could not be found", "FAIL");
		} catch (Exception e) {
			reportStep("Unknown exception occured while finding "+idVal, "FAIL");
		}
		return stringtoTrimBIId.substring(begIndex);
	}

	//To substring a String by providing BOTH the Begin & End indexes-using xPath as locator
	public String subStringBegEndIndexesXpath(String xpathVal, int begIndex, int endIndex){
		try {
			stringtoTrimBEIXP=getTextByXpath(xpathVal);
			System.out.println(stringtoTrimBEIXP.substring(begIndex, endIndex));
			reportStep("String has been successfully trimmed", "PASS");
		} catch (NoSuchElementException e) {
			reportStep("The element: "+xpathVal+" could not be found", "FAIL");
		} catch (Exception e) {
			reportStep("Unknown exception occured while finding "+xpathVal, "FAIL");
		}
		return stringtoTrimBEIXP.substring(begIndex, endIndex);
	}

	//To substring a String by providing BOTH the Begin & End indexes-using Id as locator
	public String subStringBegEndIndexesId(String idVal, int begIndex, int endIndex){
		try {
			stringtoTrimBEIId=getTextById(idVal);
			System.out.println(stringtoTrimBEIId.substring(begIndex, endIndex));
			reportStep("String has been successfully trimmed", "PASS");
		} catch (NoSuchElementException e) {
			reportStep("The element: "+idVal+" could not be found", "FAIL");
		} catch (Exception e) {
			reportStep("Unknown exception occured while finding "+idVal, "FAIL");
		}
		return stringtoTrimBEIId.substring(begIndex, endIndex);
	}

	//get player info
	public void getPlayerInfo(String xPathVal){
		try {
			playerDetails = driver.findElement(By.xpath(xPathVal)).getText();
			if(playerDetails.length()==28){
				playerPosition = playerDetails.substring(0, 7); 
				System.out.println(playerPosition);
				matchesPlayed = playerDetails.substring(17, 19);
				System.out.println(matchesPlayed);
				goalsScored = playerDetails.substring(27);
				System.out.println(goalsScored);
				reportStep("Player details fetched successfully", "PASS");
			}else{
				if(playerDetails.length()==31){
					playerPosition = playerDetails.substring(0, 10); 
					System.out.println(playerPosition);
					matchesPlayed = playerDetails.substring(20, 22);
					System.out.println(matchesPlayed);
					goalsScored = playerDetails.substring(30);
					System.out.println(goalsScored);
					reportStep("Player details fetched successfully", "PASS");
				}
			}
		} catch (NoSuchElementException e) {
			reportStep("The element: "+xPathVal+" could not be found", "FAIL");
		} catch (Exception e) {
			reportStep("Unknown exception occured while finding "+xPathVal, "FAIL");
		}
	}

	//verify player position
	public void verifyPlayerPosition(String xPathVal){
		try {
			String aa = driver.findElement(By.xpath(xPathVal)).getText();
			if(aa.contains(playerPosition)){
				System.out.println("Player-Position verified");
				reportStep("Player-Position verified", "PASS");
			}
		} catch (NoSuchElementException e) {
			reportStep("The element: "+xPathVal+" could not be found", "FAIL");
		} catch (Exception e) {
			reportStep("Unknown exception occured while finding "+xPathVal, "FAIL");
		}
	}

	//verify player's matches played count 
	public void verifyPlayerMatches(String xPathVal){
		try {
			String aa = driver.findElement(By.xpath(xPathVal)).getText();
			int aaLength = aa.length();
			if(aaLength <= 7)
			{
				String trimmedAa1 = aa.substring(0, 1);
				if(trimmedAa1.contains(matchesPlayed))
				{
					System.out.println("Player-Matches verified");
					reportStep("Player-Matches verified", "PASS");
				}
			}
			else
			{
				if(aaLength >7)
				{
					String trimmedAa2 = aa.substring(0, 2);
					if(trimmedAa2.contains(matchesPlayed))
					{
						System.out.println("Player-Matches verified");
						reportStep("Player-Matches verified", "PASS");
					}	
				}
			}
		} catch (NoSuchElementException e) {
			reportStep("The element: "+xPathVal+" could not be found", "FAIL");
		} catch (Exception e) {
			reportStep("Unknown exception occured while finding "+xPathVal, "FAIL");
		}	
	}


	//verify player's goals scored count 
	public void verifyPlayerGoals(String xPathVal){
		try {
			String aa = driver.findElement(By.xpath(xPathVal)).getText();
			int aaLength = aa.length();
			if(aaLength == 7)
			{
				if(aa.substring(0, 1).contains(goalsScored))
				{
					System.out.println("Player-Goals verified");
					reportStep("Player-Goals verified", "PASS");
				}
			}
			else
			{
				if(aaLength == 8)
				{
					if(aa.substring(0, 2).contains(goalsScored))
					{
						System.out.println("Player-Goals verified");
						reportStep("Player-Goals verified", "PASS");
					}
				}
			}
		} catch (NoSuchElementException e) {
			reportStep("The element: "+xPathVal+" could not be found", "FAIL");
		} catch (Exception e) {
			reportStep("Unknown exception occured while finding "+xPathVal, "FAIL");
		}	
	}


	//To fetch an Input 
	public void fetchInput(String xpathVal,int i)
	{ try{
		String aabbcc = driver.findElement(By.xpath(xpathVal)).getText();
		int FSTIALength = aabbcc.length();
		if (FSTIALength==3){
			trimmedInput = aabbcc.substring(0, 1);
			inputToLCase = aabbcc.substring(1, 3).toLowerCase();
			switch(i){
			case 0:
				finalFetchedStrInput1A=trimmedInput+inputToLCase;
				System.out.println("The fetched String input-finalFetchedStrInput1A is "+"'"+finalFetchedStrInput1A+"'");
				reportStep("The String input: "+finalFetchedStrInput1A+" has been fetched", "PASS");
				break;
			case 1:
				finalFetchedStrInput1AA=trimmedInput+inputToLCase;
				System.out.println("The fetched String input-finalFetchedStrInput1AA is "+"'"+finalFetchedStrInput1AA+"'");
				reportStep("The input: "+finalFetchedStrInput1AA+ " has been fetched", "PASS");
				break;
			default:
				System.out.println(i+"is greater than 1");
				reportStep(i+" is greater than 1", "FAIL");
			}
		}else{
			if (FSTIALength==1){
				switch(i){
				case 0:
					finalFetchedIntInput1A=driver.findElement(By.xpath(xpathVal)).getText();
					System.out.println("The fetched Integer input-finalFetchedIntInput1A is "+"'"+finalFetchedIntInput1A+"'");
					reportStep("The Integer input: "+finalFetchedIntInput1A+ " has been fetched", "PASS");
					break;
				case 1:
					finalFetchedIntInput1AA=driver.findElement(By.xpath(xpathVal)).getText();
					System.out.println("The fetched Integer input-finalFetchedIntInput1AA is "+"'"+finalFetchedIntInput1AA+"'");
					reportStep("The Integer input: "+finalFetchedIntInput1AA+ " has been fetched", "PASS");
					break;
				default:
					System.out.println(i+"is greater than 1");
					reportStep(i+" is greater than 1", "FAIL");
				}
			}else{
				if (FSTIALength==7){
					switch(i){
					case 0:
						finalFetchedTiming1A=driver.findElement(By.xpath(xpathVal)).getText();
						System.out.println("The fetched Timing-finalFetchedTiming1A is "+"'"+finalFetchedTiming1A+"'");
						reportStep("The Timing: "+finalFetchedTiming1A+ " has been fetched", "PASS");
						break;
					case 1:
						finalFetchedTiming1AA=driver.findElement(By.xpath(xpathVal)).getText();
						System.out.println("The fetched Timing-finalFetchedTiming1AA is "+"'"+finalFetchedTiming1AA+"'");
						reportStep("The Timing: "+finalFetchedTiming1AA+ " has been fetched", "PASS");
						break;
					default:
						System.out.println(i+"is greater than 1");
						reportStep(i+" is greater than 1", "FAIL");
					}
				}else{
					switch(i){
					case 0:
						finalFetchedStrInputLong1A=driver.findElement(By.xpath(xpathVal)).getText();
						System.out.println("The fetched input-finalFetchedStrInputLong1A is "+"'"+finalFetchedStrInputLong1A+"'");
						reportStep("The input: "+finalFetchedStrInputLong1A+ " has been fetched", "PASS");
						break;
					case 1:
						finalFetchedStrInputLong1AA=driver.findElement(By.xpath(xpathVal)).getText();
						System.out.println("The fetched input-finalFetchedStrInputLong1AA is "+"'"+finalFetchedStrInputLong1AA+"'");
						reportStep("The input: "+finalFetchedStrInputLong1AA+ " has been fetched", "PASS");
						break;
					case 2:
						currentTeam =driver.findElement(By.xpath(xpathVal)).getText();
						System.out.println("The fetched input-finalFetchedStrInputLong1AA(Current Team) is "+"'"+currentTeam+"'");
						reportStep("The input: "+finalFetchedStrInputLong1AA+ " has been fetched", "PASS");
						break;
					case 3:
						opponentTeam =driver.findElement(By.xpath(xpathVal)).getText();
						System.out.println("The fetched input-finalFetchedStrInputLong1AA(Opponent Team) is "+"'"+opponentTeam+"'");
						reportStep("The input: "+finalFetchedStrInputLong1AA+ " has been fetched", "PASS");
						break;
					default:
						System.out.println(i+"is greater than 2");
						reportStep(i+" is greater than 2", "FAIL");
					}	
				}
			}
		}
	}
	catch(NoSuchElementException e)
	{
		System.out.println("Unable to fetch the target");
		reportStep("Element not fetched", "FAIL");
	}
	}

	//To verify the fetched Input
	public void verifyInput(String xpathValue, int k)
	{
		try{
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(xpathValue))));
			String ddeeff = driver.findElement(By.xpath(xpathValue)).getText();
			int FSTIBLength = ddeeff.length();

			if(FSTIBLength==4 && (ddeeff.contains("/"))){
				switch(k){
				case 0:
					if(ddeeff.contains(finalFetchedStrInputLong1A))
					{
						System.out.println("The input: "+ddeeff+" is Verified");
						reportStep("The input: "+ddeeff+" is Verified", "PASS");
						break;
					}
				case 1:
					if(ddeeff.contains(finalFetchedStrInputLong1AA))
					{
						System.out.println("The input: "+ddeeff+" is Verified");
						reportStep("The input: "+ddeeff+" is Verified", "PASS");
						break;
					}
				default:
					System.out.println(k+" is greater than 1");
					reportStep(k+" is greater than 1", "FAIL");
				}
			}else{
				if(FSTIBLength<=1){
					switch(k){
					case 0:
						if(ddeeff.contains(finalFetchedIntInput1A))
						{
							System.out.println("The input: "+ddeeff+" is Verified");
							reportStep("The input: "+ddeeff+" is Verified", "PASS");
							break;
						}
					case 1:
						if(ddeeff.contains(finalFetchedIntInput1AA))
						{
							System.out.println("The input: "+ddeeff+" is Verified");
							reportStep("The input: "+ddeeff+" is Verified", "PASS");
							break;
						}
					default:
						System.out.println(k+" is greater than 1");
						reportStep(k+" is greater than 1", "FAIL");
					}	
				}else{
					if(FSTIBLength>1 && ddeeff.contains("IST")){
						switch(k){
						case 0:
							if(ddeeff.contains(finalFetchedTiming1A))
							{
								System.out.println("The Timing: "+ddeeff+" is Verified");
								reportStep("The Timing: "+ddeeff+" is Verified", "PASS");
								break;
							}
						case 1:
							if(ddeeff.contains(finalFetchedTiming1AA))
							{
								System.out.println("The Timing: "+ddeeff+" is Verified");
								reportStep("The Timing: "+ddeeff+" is Verified", "PASS");
								break;
							}
						default:
							System.out.println(k+" is greater than 1");
							reportStep(k+" is greater than 1", "FAIL");
						}
					}else{
						if(FSTIBLength>1 && (ddeeff.contains("Premier"))){
							switch(k){
							case 0:
								if(ddeeff.contains(finalFetchedStrInputLong1A))
								{
									System.out.println("The input: "+ddeeff+" is Verified");
									reportStep("The input: "+ddeeff+" is Verified", "PASS");
									break;
								}
							case 1:
								if(ddeeff.contains(finalFetchedStrInputLong1AA))
								{
									System.out.println("The input: "+ddeeff+" is Verified");
									reportStep("The input: "+ddeeff+" is Verified", "PASS");
									break;
								}
							default:
								System.out.println(k+" is greater than 1");
								reportStep(k+" is greater than 1", "FAIL");
							}
						}else{
							if(FSTIBLength>1){
								switch(k){
								case 0:
									if(ddeeff.contains(finalFetchedStrInput1A))
									{
										System.out.println("The input: "+ddeeff+" is Verified");
										reportStep("The input: "+ddeeff+" is Verified", "PASS");
										break;
									}
								case 1:
									if(ddeeff.contains(finalFetchedStrInput1AA))
									{
										System.out.println("The input: "+ddeeff+" is Verified");
										reportStep("The input: "+ddeeff+" is Verified", "PASS");
										break;
									}
								case 2:
									if(ddeeff.contains(currentTeam))
									{
										System.out.println("The input: "+ddeeff+" is Verified");
										reportStep("The input: "+ddeeff+" is Verified", "PASS");
										break;
									}
								case 3:
									if(ddeeff.contains(opponentTeam))
									{
										System.out.println("The input: "+ddeeff+" is Verified");
										reportStep("The input: "+ddeeff+" is Verified", "PASS");
										break;
									}

								default:
									System.out.println(k+" is greater than 1");
									reportStep(k+" is greater than 1", "FAIL");
								}
							}
						}
					}
				}
			}
		}
		catch (Exception e) {
			System.out.println("The verification failed");
			reportStep("The input: is Not Verified :", "FAIL");
		}
	}

	//To fetch the Current-Calendar date
	public Date toFetchCalendarDate() throws ParseException{
		try {
			Date currentDate = new Date();
			String formattedCurrentDate=sdf.format(currentDate);
			calDate = sdf.parse(formattedCurrentDate);
		} catch (Exception e) {
			System.out.println("Unable to fetch the Calendar Date");
			reportStep("Unknown exception occured while fetching the Calendar date", "FAIL");
		}
		return calDate;
	}

	//To verify the last match date
	public void toVerifyLastMatchDate(String xpathVal) throws ParseException{
		try {
			String dateToBeVerified=driver.findElement(By.xpath(xpathVal)).getText();
			String dateToBeVerified1=dateToBeVerified.substring(2);
			Date lastMatchDate=sdf.parse(dateToBeVerified1);
			System.out.println("Fetched Date: "+lastMatchDate);
			if(lastMatchDate.before(toFetchCalendarDate())){
				System.out.println("The fetched date is verified to be earlier than the current date");
				reportStep("The fetched date is verified to be earlier than the current date", "PASS");
			}
		} catch (NoSuchElementException e) {
			reportStep("The element: "+xpathVal+" could not be found", "FAIL");
		} catch (Exception e) {
			reportStep("Unknown exception occured while finding "+xpathVal, "FAIL");
		}
	}

	//To verify the next match date
	public void toVerifyNextMatchDate(String xpathVal) throws ParseException{
		try {
			String dateToBeVerified=driver.findElement(By.xpath(xpathVal)).getText();
			String dateToBeVerified1=dateToBeVerified.substring(2);
			Date nextMatchDate=sdf.parse(dateToBeVerified1);
			System.out.println("Fetched Date: "+nextMatchDate);
			if(nextMatchDate.after(toFetchCalendarDate())){
				System.out.println("The fetched date is verified to be in the future");
				reportStep("The fetched date is verified to be in the future", "PASS");
			}
		} catch (NoSuchElementException e) {
			reportStep("The element: "+xpathVal+" could not be found", "FAIL");
		} catch (Exception e) {
			reportStep("Unknown exception occured while finding "+xpathVal, "FAIL");
		}
	}

	//To verify the count of Main players in a team
	public void verifyCountofMainPlayers(String xpathVal){
		try {
			WebElement tableToFetch = driver.findElement(By.xpath(xpathVal));
			List<WebElement> tableContents = tableToFetch.findElements(By.tagName("tr"));
			CountofTableContents = tableContents.size();
			if(CountofTableContents==11){
				System.out.println("Hence the count of Main Players is verified to be 11");
				reportStep("Count of Main Players is verified", "PASS");
			}
		} catch (NoSuchElementException e) {
			reportStep("The element: "+xpathVal+" could not be found", "FAIL");
		} catch (Exception e) {
			reportStep("Unknown exception occured while finding "+xpathVal, "FAIL");
		}
	}

	//To verify the count of Substitute players in a team
	public void verifyCountofSubstitutePlayers(String xpathVal){
		try {
			WebElement tableToFetch = driver.findElement(By.xpath(xpathVal));
			List<WebElement> tableContents = tableToFetch.findElements(By.tagName("tr"));
			CountofTableContents = tableContents.size();
			if(CountofTableContents>=3){
				System.out.println("Hence the count of Substitute Players is verified to be greater than or equal to 3");
				reportStep("Count of Substitute Players is verified", "PASS");
			}
		} catch (NoSuchElementException e) {
			reportStep("The element: "+xpathVal+" could not be found", "FAIL");
		} catch (Exception e) {
			reportStep("Unknown exception occured while finding "+xpathVal, "FAIL");
		}
	}
}


