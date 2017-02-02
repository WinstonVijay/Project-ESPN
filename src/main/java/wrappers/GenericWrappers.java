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
	String[] FetchedStringInputA =new String[15];
	String[] FetchedStringInputB =new String[15];
	String trimmedInput;
	String inputToLCase;
	static String stringtoTrimBIXP;
	static String stringtoTrimBIId;
	static String stringtoTrimBEIXP;
	static String stringtoTrimBEIId;
	static String finalFetchedStrInput1A;
	static String finalFetchedStrInput1AA;
	static String finalFetchedIntInput1A;
	static String finalFetchedIntInput1AA;
	static String finalFetchedTiming1A;
	static String finalFetchedTiming1AA;
	static String finalFetchedStrInputLong1A;
	static String finalFetchedStrInputLong1AA;
	int parsedCurrentDte, parsedpageDte;
	int CountofTableContents;
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
	 * This method will verify the given text matches in the element text
	 * @param xpath - The locator of the object in xpath
	 * @param text  - The text to be verified
	 * @author Winston
	 */
	public void verifyTextByXpath(String xpath, String text){
		try {
			String sText = driver.findElementByXPath(xpath).getText();
			if (sText.equalsIgnoreCase(text)){
				reportStep("The text: "+sText+" matches with the value :"+text, "PASS");
			}else{
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
				reportStep("The text: "+sText+" contains the value :"+text, "PASS");
			}else{
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
				reportStep("The text: "+sText+" matches with the value :"+text, "PASS");
			}else{
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
				reportStep("The text: "+sText+" contains the value :"+text, "PASS");
			}else{
				reportStep("The text: "+sText+" did not contain the value :"+text, "FAIL");
			}
		}catch (Exception e) {
			reportStep("Unknown exception occured while verifying the title", "FAIL");
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
	 * This method will return the text of the element using xpath as locator
	 * @param xpathVal  The xpath (locator) of the element
	 * @author Winston
	 */
	public String getTextByXpath(String xpathVal){
		String bReturn = "";
		try{
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
			return driver.findElementById(idVal).getText();
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
			reportStep("The window could not be switched to the first window.", "FAIL");
		}
	}

	//to switch to the last-active window
	public void switchToLastWindow() {
		try {
			Set<String> winHandles = driver.getWindowHandles();
			for (String wHandle : winHandles) {
				driver.switchTo().window(wHandle);
			}
		} catch (Exception e) {
			reportStep("The window could not be switched to the last window.", "FAIL");
		}
	}

	//To switch to a specific frame
	public void switchtoframe(String locValue)
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
	public void switchtodefaultcontent(){
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

	//To fetch an Input
	public void fetchInput(String xpathVal,int i)
	{ try{
		FetchedStringInputA[i] = driver.findElement(By.xpath(xpathVal)).getText();
		int FSTIALength = FetchedStringInputA[i].length();
		if (FSTIALength==3){
			trimmedInput = FetchedStringInputA[i].substring(0, 1);
			inputToLCase = FetchedStringInputA[i].substring(1, 3).toLowerCase();
			switch(i){
			case 0:
				finalFetchedStrInput1A=trimmedInput+inputToLCase;
				System.out.println("The fetched String input is "+"'"+finalFetchedStrInput1A+"'");
				reportStep("The String input: "+finalFetchedStrInput1A+" has been fetched", "PASS");
				break;
			case 1:
				finalFetchedStrInput1AA=trimmedInput+inputToLCase;
				System.out.println("The fetched String input is "+"'"+finalFetchedStrInput1AA+"'");
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
					System.out.println("The fetched Integer input is "+"'"+finalFetchedIntInput1A+"'");
					reportStep("The Integer input: "+finalFetchedIntInput1A+ " has been fetched", "PASS");
					break;
				case 1:
					finalFetchedIntInput1AA=driver.findElement(By.xpath(xpathVal)).getText();
					System.out.println("The fetched Integer input is "+"'"+finalFetchedIntInput1AA+"'");
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
						System.out.println("The fetched Timing is "+"'"+finalFetchedTiming1A+"'");
						reportStep("The Timing: "+finalFetchedTiming1A+ " has been fetched", "PASS");
						break;
					case 1:
						finalFetchedTiming1AA=driver.findElement(By.xpath(xpathVal)).getText();
						System.out.println("The fetched Timing is "+"'"+finalFetchedTiming1AA+"'");
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
						System.out.println("The fetched input is "+"'"+finalFetchedStrInputLong1A+"'");
						reportStep("The input: "+finalFetchedStrInputLong1A+ " has been fetched", "PASS");
						break;
					case 1:
						finalFetchedStrInputLong1AA=driver.findElement(By.xpath(xpathVal)).getText();
						System.out.println("The fetched input is "+"'"+finalFetchedStrInputLong1AA+"'");
						reportStep("The input: "+finalFetchedStrInputLong1AA+ " has been fetched", "PASS");
						break;
					default:
						System.out.println(i+"is greater than 1");
						reportStep(i+" is greater than 1", "FAIL");
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
			FetchedStringInputB[k] = driver.findElement(By.xpath(xpathValue)).getText();
			int FSTIBLength = FetchedStringInputB[k].length();

			if(FSTIBLength<=1){
				switch(k){
				case 0:
					if(FetchedStringInputB[k].contains(finalFetchedIntInput1A))
					{
						System.out.println("The input: "+FetchedStringInputB[k]+" is Verified");
						reportStep("The input: "+FetchedStringInputB[k]+" is Verified", "PASS");
						break;
					}
				case 1:
					if(FetchedStringInputB[k].contains(finalFetchedIntInput1AA))
					{
						System.out.println("The input: "+FetchedStringInputB[k]+" is Verified");
						reportStep("The input: "+FetchedStringInputB[k]+" is Verified", "PASS");
						break;
					}
				default:
					System.out.println(k+" is greater than 1");
					reportStep(k+" is greater than 1", "FAIL");
				}	
			}
			else{
				if(FSTIBLength>1 && FetchedStringInputB[k].contains("IST")){
					switch(k){
					case 0:
						if(FetchedStringInputB[k].contains(finalFetchedTiming1A))
						{
							System.out.println("The Timing: "+FetchedStringInputB[k]+" is Verified");
							reportStep("The Timing: "+FetchedStringInputB[k]+" is Verified", "PASS");
							break;
						}
					case 1:
						if(FetchedStringInputB[k].contains(finalFetchedTiming1AA))
						{
							System.out.println("The Timing: "+FetchedStringInputB[k]+" is Verified");
							reportStep("The Timing: "+FetchedStringInputB[k]+" is Verified", "PASS");
							break;
						}
					default:
						System.out.println(k+" is greater than 1");
						reportStep(k+" is greater than 1", "FAIL");
					}
				}else{
					if(FSTIBLength>1 && FetchedStringInputB[k].contains("Premier")){
						switch(k){
						case 0:
							if(FetchedStringInputB[k].contains(finalFetchedStrInputLong1A))
							{
								System.out.println("The input: "+FetchedStringInputB[k]+" is Verified");
								reportStep("The input: "+FetchedStringInputB[k]+" is Verified", "PASS");
								break;
							}
						case 1:
							if(FetchedStringInputB[k].contains(finalFetchedStrInputLong1AA))
							{
								System.out.println("The input: "+FetchedStringInputB[k]+" is Verified");
								reportStep("The input: "+FetchedStringInputB[k]+" is Verified", "PASS");
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
								if(FetchedStringInputB[k].contains(finalFetchedStrInput1A))
								{
									System.out.println("The input: "+FetchedStringInputB[k]+" is Verified");
									reportStep("The input: "+FetchedStringInputB[k]+" is Verified", "PASS");
									break;
								}
							case 1:
								if(FetchedStringInputB[k].contains(finalFetchedStrInput1AA))
								{
									System.out.println("The input: "+FetchedStringInputB[k]+" is Verified");
									reportStep("The input: "+FetchedStringInputB[k]+" is Verified", "PASS");
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
		}catch (Exception e) {
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
				System.out.println("Count of Main Players is verified to be 11");
				reportStep("The count of Main Players is verified", "PASS");
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
				System.out.println("Count of Substitute Players is verified to be greater than or equal to 3");
				reportStep("The count of Substitute Players is verified", "PASS");
			}
		} catch (NoSuchElementException e) {
			reportStep("The element: "+xpathVal+" could not be found", "FAIL");
		} catch (Exception e) {
			reportStep("Unknown exception occured while finding "+xpathVal, "FAIL");
		}
	}



}


