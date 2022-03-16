package com.beltWasla.setUp;

import java.io.File;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;

import com.beltWasla.enums.DriverType;
import com.beltWasla.enums.EnvironmentType;

public class WebDriverManager {
	private WebDriver driver;
	private static DriverType driverType;
	private static EnvironmentType environmentType;
	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
	public static File outputFile;
	public static String timeStamp;
	
	public WebDriverManager() {
		driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
		environmentType = FileReaderManager.getInstance().getConfigReader().getEnvironment();
	}
	
	public WebDriver getDriver() {
		if(driver == null) driver = createDriver();
		return driver;
	}
	
	private WebDriver createDriver() {
		   switch (environmentType) {	    
	        case LOCAL : driver = createLocalDriver();
	        	break;
	        case REMOTE : driver = createRemoteDriver();
	        	break;
		   }
		   return driver;
	}
	
	private WebDriver createRemoteDriver() {
		
	/*	ChromeOptions options = new ChromeOptions();
		options.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
		options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true); 
		driver = new RemoteWebDriver(new URL("http://10.x.x.x:4444/wd/hub"), options);
		*/
		throw new RuntimeException("RemoteWebDriver is not yet implemented");
	}
	
	private WebDriver createLocalDriver() {
        switch (driverType) {	    
        case FIREFOX : driver = new FirefoxDriver();
	    	break;
        case CHROME : 
        	System.setProperty(CHROME_DRIVER_PROPERTY, FileReaderManager.getInstance().getConfigReader().getDriverPath());
        	//---------------------------------------------------
        //	timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
			//System.out.println("timeStamp: "+timeStamp);
			outputFile = new File(System.getProperty("user.dir")+"/src/test/resources/downloads/");
			String path= outputFile.toString();
	     //   System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
	        Map<String, Object> preferences = new Hashtable<String, Object>();
	        preferences.put("profile.default_content_settings.popups", 0);
	        preferences.put("download.prompt_for_download", "false");
	        preferences.put("download.default_directory", path);
	        ChromeOptions options = new ChromeOptions();
	        //options.setHeadless(true);
	        options.addArguments("disable-extensions");
			options.addArguments("chrome.switches","--disable-infobars");
			options.setExperimentalOption("useAutomationExtension", false);
	        options.setExperimentalOption("prefs", preferences);
	        options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true); 
	        driver = new ChromeDriver(options);
    		break;
        case INTERNETEXPLORER : driver = new InternetExplorerDriver();
    		break;
        }
        
        if(FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize())
        	driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
		return driver;
	}	
	
	public void quitDriver() {
		driver.close();
		driver.quit();		
	}

}
