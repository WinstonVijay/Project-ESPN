package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class SampleReport {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// create the html report (once)
		// before starting the suite
		ExtentReports reports = new ExtentReports("./reports/index.html",false);
		reports.loadConfig(new File("./extent-config.xml"));
		// create a testcase entry
		// before starting the testcase (method)
		ExtentTest test1 = reports.startTest("Merge Lead", "Merge 2 leads in leaftaps");

		test1.assignAuthor("Prashant");
		test1.assignCategory("sanity");

		//Launch the Browser
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		//Syntax to call the class
		//ClassName obj = new ClassName();

		ChromeDriver driver = new ChromeDriver();

		//Load the URL
		//Syntax to call method in a class

		//obj.methodName();
		driver.get("file:///C:/SelTl/home.html");

		// maximize the window
		driver.manage().window().maximize();

		// Take the snap
		File src = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./reports/snap1.jpg");
		FileUtils.copyFile(src, dest);


		// Launch application (wrapper)
		test1.log(LogStatus.PASS, "Launch", "The chrome browser launched successfully"+test1.
				addScreenCapture("./snap1.jpg"));

		// Enter user name (wrapper)
		test1.log(LogStatus.PASS, "User Name", "The username is entered successfully");


		// Enter password (wrapper)
		test1.log(LogStatus.PASS, "Password", "The password entered successfully");

		// end the testcase entry
		// after ending the testcase (method)
		reports.endTest(test1);

		// publish the report
		reports.flush();



	}

}
