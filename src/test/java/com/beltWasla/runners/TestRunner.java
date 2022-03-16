package com.beltWasla.runners;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.*;
import org.junit.runner.RunWith;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import com.beltWasla.utils.Screenshot;
import com.beltWasla.enums.EnvironmentType;
import com.beltWasla.setUp.FileReaderManager;

import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(features = { "src/test/java/com/beltWasla/features/Test.feature", // To execute separate test file
		// "./src/test/resources/features", // To execute the whole test pack

}, glue = "com.beltWasla.steps", monochrome = true// ,
// tags = {"@wasla" } // Used to run test files with specified tags
)

//Main test class
public class TestRunner extends Screenshot {

	// instances for loading property files
	public static Properties propConfig = new Properties();
	public static Properties propObject = new Properties();
	public static Properties propDB = new Properties();
	public static Properties propCommon = new Properties();
	public static Properties propMvn = new Properties();

	// instances for property file locations
	public static FileInputStream fisConfig, fisObject, fisComm, fisDB, fisMvn;

	public static Logger logs = Logger.getLogger("devpinoyLogger"); // logger

	public static String dateTime = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
	public static String featureName = null;
	public static EnvironmentType environmentType;

	String thisClassName = getClass().getSimpleName(); // To get the current class name for screenshot folder

	public static Scenario scenario;
	// public static String scenarioName = scenario.getName();

	public void captureScreen() {
		Screenshot.takeScreenshot(TestRunner.dateTime, this.thisClassName, scenarioName);
	}

	@BeforeClass // this block will be executed before running the class
	public static void setup() throws Exception {

		// Any data creation can be done here. DB inserts or other data loads
		try {
			// Commenting out as this cannot be executed from outside organisation

			/*
			 * DButilities.callStoredProcedure(
			 * "./src/test/resources/sqlFiles/Update_EK5441.sql");
			 * DButilities.callStoredProcedure(
			 * "./src/test/resources/sqlFiles/Update_EK9988.sql");
			 * DButilities.executeSQLFile(
			 * "./src/test/resources/sqlFiles/leftLuggageData.sql");
			 * DButilities.executeSQLFile("./src/test/resources/sqlFiles/BDO.sql");
			 * DButilities.executeSQLFile("./src/test/resources/sqlFiles/BRSLoadBag.sql");
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			// To specify paths for all property files
			fisConfig = new FileInputStream("./src/test/resources/properties/config.properties");
			fisObject = new FileInputStream("./src/test/resources/properties/object.properties");
			fisDB = new FileInputStream("./src/test/resources/properties/DB.properties");
			fisComm = new FileInputStream("./src/test/resources/properties/common.properties");
			fisMvn = new FileInputStream("./src/test/resources/properties/mvn.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			// To load all property files before staring the test execution
			propConfig.load(fisConfig);
			propObject.load(fisObject);
			propCommon.load(fisComm);
			propDB.load(fisDB);
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (propConfig.getProperty("environment").equalsIgnoreCase("LOCAL")) {
			if (propConfig.getProperty("browser").equalsIgnoreCase("FIREFOX")) {
				driver = new FirefoxDriver();
			} else if (propConfig.getProperty("browser").equalsIgnoreCase("CHROME")) {

				String osName = System.getProperty("os.name");
				String osType = osName.split(" ")[0];
				if ("Linux".equalsIgnoreCase(osType)) {
					System.setProperty("webdriver.chrome.driver",
							FileReaderManager.getInstance().getConfigReader().getDriverPathLinux());
				} else {
					System.setProperty("webdriver.chrome.driver",
							FileReaderManager.getInstance().getConfigReader().getDriverPath());
				}

				Map<String, Object> preferences = new Hashtable<String, Object>();
				preferences.put("profile.default_content_settings.popups", 0);
				preferences.put("download.prompt_for_download", "false");
				ChromeOptions options = new ChromeOptions();
				options.setHeadless(FileReaderManager.getInstance().getConfigReader().getHeadless());
				options.addArguments("disable-extensions");
				options.addArguments("--disable-dev-shm-usage");
				options.addArguments("--no-sandbox");
				options.addArguments("chrome.switches", "--disable-infobars");
				options.setExperimentalOption("useAutomationExtension", false);
				options.setExperimentalOption("prefs", preferences);
				options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				if (FileReaderManager.getInstance().getConfigReader().getHeadless() == true) {
					System.out.println("started headless browser");
					options.addArguments("window-size=1920,1080");
					options.addArguments("--disable-gpu");
					options.addArguments("--ignore-certificate-errors-spki-list");
					options.addArguments("--ignore-ssl-errors");
				} else {
					System.out.println("started non headless browser");
				}
				driver = new ChromeDriver(options);
			} else if (propConfig.getProperty("browser").equalsIgnoreCase("IE")) {
				driver = new InternetExplorerDriver();
			}
		}

		// To maximise the window if the property is set as true
		if (FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize())
			driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(),
				TimeUnit.SECONDS);

	}

	@AfterClass // this block will be executed after the actual test. Closing all the active web
				// drivers
	public static void clossAllBrowsers() {
		driver.quit();
	}

}