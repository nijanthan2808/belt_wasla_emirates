package com.beltWasla.setUp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.beltWasla.enums.DriverType;
import com.beltWasla.enums.EnvironmentType;


public class ConfigFileReader {	
	private Properties properties;
	private final String propertyFilePath= "src//test//resources//properties//config.properties";

	public ConfigFileReader(){
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try { properties.load(reader); }
			catch (IOException e) { e.printStackTrace(); }
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Properties file not found at path : " + propertyFilePath);
		}finally {
			try { if(reader != null) reader.close(); }
			catch (IOException ignore) {}
		}
	}
	
	public String getDriverPath(){
		String driverPath = properties.getProperty("driverPath");
		if(driverPath!= null) return driverPath;
		else throw new RuntimeException("Driver Path not specified in the config.properties file for the Key:driverPath");		
	}
	
	public String getDriverPathLinux(){
		String driverPathLinux = properties.getProperty("driverPathLinux");
		if(driverPathLinux!= null) return driverPathLinux;
		else throw new RuntimeException("Driver Path linux not specified in the Configuration.properties file for the Key:driverPathlinux");		
	}
	
	public long getImplicitlyWait() {		
		String implicitlyWait = properties.getProperty("implicitlyWait");
		if(implicitlyWait != null) {
			try{
				return Long.parseLong(implicitlyWait);
			}catch(NumberFormatException e) {
				throw new RuntimeException("Not able to parse value : " + implicitlyWait + " in to Long");
			}
		}
		return 30;		
	}
	
	public String getSitApplicationUrl() {
		String urlSit = properties.getProperty("urlSit");
		if(urlSit != null) return urlSit;
		else throw new RuntimeException("Application Sit Url not specified in the Configuration.properties file for the Key:urlSit");
	}
	

	public String getStgApplicationUrl() {
		String urlStg = properties.getProperty("urlStg");
		if(urlStg != null) return urlStg;
		else throw new RuntimeException("Application Stg Url not specified in the Configuration.properties file for the Key:urlStg");
	}
	public String getDevApplicationUrl() {
		String urlDev = properties.getProperty("urlDev");
		if(urlDev != null) return urlDev;
		else throw new RuntimeException("Application dev Url not specified in the Configuration.properties file for the Key:urlDev");
	}
	
	
	public DriverType getBrowser() {
		String browserName = properties.getProperty("browser");
		if(browserName == null || browserName.equals("chrome")) return DriverType.CHROME;
		else if(browserName.equalsIgnoreCase("firefox")) return DriverType.FIREFOX;
		else if(browserName.equals("iexplorer")) return DriverType.INTERNETEXPLORER;
		else throw new RuntimeException("Browser Name Key value in config.properties is not matched : " + browserName);
	}
	
	public EnvironmentType getEnvironment() {
		String environmentName = properties.getProperty("environment");
		if(environmentName == null || environmentName.equalsIgnoreCase("local")) return EnvironmentType.LOCAL;
		else if(environmentName.equals("remote")) return EnvironmentType.REMOTE;
		else throw new RuntimeException("Environment Type Key value in config.properties is not matched : " + environmentName);
	}
	
	public Boolean getBrowserWindowSize() {
		String windowSize = properties.getProperty("windowMaximize");
		if(windowSize != null) return Boolean.valueOf(windowSize);
		return true;
	}
	
	public String getTestDataResourcePath(){
		String testDataResourcePath = properties.getProperty("testDataResourcePath");
		if(testDataResourcePath!= null) return testDataResourcePath;
		else throw new RuntimeException("Test Data Resource Path not specified in the config.properties file for the Key:testDataResourcePath");		
	}
	
	public String getReportConfigPath(){
		String reportConfigPath = properties.getProperty("reportConfigPath");
		if(reportConfigPath!= null) return reportConfigPath;
		else throw new RuntimeException("Report Config Path not specified in the config.properties file for the Key:reportConfigPath");		
	}
	
	public String getTestRailRunId(){
		String testRailRunId = properties.getProperty("testRailRunID");
		if(testRailRunId!= null) return testRailRunId;
		else throw new RuntimeException("testRailRunId not specified in the config.properties file for the Key:testRailRunID");		
	}
	
	public String getTestRailUserID(){
		String testRailUseriD = properties.getProperty("testRailUserID");
		if(testRailUseriD!= null) return testRailUseriD;
		else throw new RuntimeException("testRailUserID not specified in the config.properties file for the Key:testRailUserID");		
	}
	
	public String getTestRailUserPWD(){
		String testRailUserPwd = properties.getProperty("testRailUserPWD");
		if(testRailUserPwd!= null) return testRailUserPwd;
		else throw new RuntimeException("testRailUserPwd not specified in the config.properties file for the Key:testRailUserPWD");		
	}
	
	public String getTestRailIntegration(){
		String testRailIntegRation = properties.getProperty("testRailIntegration");
		if(testRailIntegRation!= null) return testRailIntegRation;
		else throw new RuntimeException("testRailIntegration not specified in the config.properties file for the Key:testRailIntegration");		
	}

	public boolean getHeadless() {
		String headless = properties.getProperty("headless");
		if(headless!= null && headless.equalsIgnoreCase("true") ) 
			return true;
		else if(headless!= null && headless.equalsIgnoreCase("false"))
			return false;
		else throw new RuntimeException("headlessBrowser not specified in the config.properties file for the Key:headless") ;		
	}
}
