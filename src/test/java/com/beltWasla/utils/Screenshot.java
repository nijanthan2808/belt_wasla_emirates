package com.beltWasla.utils;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.beltWasla.runners.TestRunner;


public class Screenshot  {
	public static  WebDriver driver;
	// To get the current class name for screenshot folder
		String thisClassName = getClass().getSimpleName();
		public static int n=001;
		public static String scenarioName ="Test";
		public static String featureName = "Test";
		public void captureScreen() {
			Screenshot.takeScreenshot(TestRunner.dateTime, featureName, scenarioName);
		}
		
	public static  void takeScreenshot(String dateTime, String featureName, String scenarioName) {
	File scrFile;
		try {
			 scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("./target/cucumber-reports/screenshots/" + dateTime +"/"+ featureName + "/"+  n + scenarioName  + ".jpg"), true);
			n++;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
