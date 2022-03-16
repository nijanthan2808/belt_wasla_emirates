package com.beltWasla.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.beltWasla.runners.TestRunner;
import com.beltWasla.setUp.FileReaderManager;

public class ApplicationLauncher extends TestRunner {
	// To get the current class name for screenshot folder
	String thisClassName = getClass().getSimpleName();

	public void captureScreen() {
		Screenshot.takeScreenshot(TestRunner.dateTime, this.thisClassName, scenarioName);
	}

	//used as part of my project
	public void launchApplication() {
		driver.manage().deleteAllCookies();
		try {
			if (FileReaderManager.getInstance().getMvnPropReader().getEnv().equalsIgnoreCase("")) {
				driver.get(FileReaderManager.getInstance().getConfigReader().getStgApplicationUrl());
			}
			// To run on staging url
			else if (FileReaderManager.getInstance().getMvnPropReader().getEnv().equalsIgnoreCase("stg")
					&& FileReaderManager.getInstance().getConfigReader().getHeadless() == false) {
				System.out.println("inside non headless STG");
				driver.get(FileReaderManager.getInstance().getConfigReader().getStgApplicationUrl());
			}
			// To run on SIT url
			else if (FileReaderManager.getInstance().getMvnPropReader().getEnv().equalsIgnoreCase("sit")
					&& FileReaderManager.getInstance().getConfigReader().getHeadless() == false) {
				System.out.println("inside non headless SIT");
				driver.get(FileReaderManager.getInstance().getConfigReader().getSitApplicationUrl());
			}
			// To run on dev url
			else if (FileReaderManager.getInstance().getMvnPropReader().getEnv().equalsIgnoreCase("dev")
					&& FileReaderManager.getInstance().getConfigReader().getHeadless() == false) {
				System.out.println("inside non headless DEV");
				driver.get(FileReaderManager.getInstance().getConfigReader().getDevApplicationUrl());
			}
			// To run the pack in Jenkins - with staging url and headless browser 
			else if (FileReaderManager.getInstance().getMvnPropReader().getEnv().equalsIgnoreCase("stg")
					&& FileReaderManager.getInstance().getConfigReader().getHeadless() == true) {
				System.out.println("inside  headless STG");
				driver.get(FileReaderManager.getInstance().getConfigReader().getStgApplicationUrl());
				System.out.println("BeltWasla URL: " + driver.getCurrentUrl());
				captureScreen();
				try {
					captureScreen();
					System.out.println("Redirected URL: " + driver.getCurrentUrl());
					WebDriverWait waitWithSec = new WebDriverWait(driver, 20);
					waitWithSec.until(ExpectedConditions.visibilityOfElementLocated(By.name("pf.username")));
					driver.findElement(By.name("pf.username")).sendKeys(propMvn.getProperty("appln.username"));
				} catch (Exception e) {
					System.out.println("could not get/click username");
					e.printStackTrace();
					throw new RuntimeException();
				}
				try {
					driver.findElement(By.name("pf.pass")).sendKeys(propMvn.getProperty("appln.password"));
					captureScreen();
				} catch (Exception e) {
					System.out.println("could not get/click password");
				}

				try {
					driver.findElement(By.xpath("//a[@title='Sign On']")).click();
					UtilThread.sleep(5000);
					System.out.println("After sign on URL: " + driver.getCurrentUrl());
					captureScreen();
				} catch (Exception e) {
					System.out.println("could not get/click sign on");
				}
			}
			// To run the pack in Jenkins - with sit url and headless browser 
			else if (FileReaderManager.getInstance().getMvnPropReader().getEnv().equalsIgnoreCase("sit")
					&& FileReaderManager.getInstance().getConfigReader().getHeadless() == true) {
				System.out.println("inside headless for SIT");
				driver.get(FileReaderManager.getInstance().getConfigReader().getSitApplicationUrl());
				System.out.println("BeltWasla URL: " + driver.getCurrentUrl());
				captureScreen();
				try {
					captureScreen();
					System.out.println("Redirected URL: " + driver.getCurrentUrl());
					driver.findElement(By.name("pf.username")).sendKeys(propMvn.getProperty("appln.username"));
					captureScreen();
				} catch (Exception e) {
					System.out.println("could not get/click username");
				}
				try {

					driver.findElement(By.name("pf.pass")).sendKeys(propMvn.getProperty("appln.password"));
					captureScreen();
				} catch (Exception e) {
					System.out.println("could not get/click password");
				}

				try {

					driver.findElement(By.xpath("//a[@title='Sign On']")).click();
					UtilThread.sleep(5000);
					System.out.println("After sign on URL: " + driver.getCurrentUrl());
					captureScreen();
				} catch (Exception e) {
					System.out.println("could not get/click sign on");
				}

			}
			// To run the pack in Jenkins - with dev url and headless browser 
			else if (FileReaderManager.getInstance().getMvnPropReader().getEnv().equalsIgnoreCase("dev")
					&& FileReaderManager.getInstance().getConfigReader().getHeadless() == true) {
				// Reporter.addStepLog("inside headless for DEV");
				System.out.println("inside headless for DEV");
				driver.get(FileReaderManager.getInstance().getConfigReader().getDevApplicationUrl());
				System.out.println("BeltWasla URL: " + driver.getCurrentUrl());
				captureScreen();
				try {
					captureScreen();
					System.out.println("Redirected URL: " + driver.getCurrentUrl());
					driver.findElement(By.name("pf.username")).sendKeys(propMvn.getProperty("appln.username"));
				} catch (Exception e) {
					System.out.println("could not get/click username");
				}
				try {
					driver.findElement(By.name("pf.pass")).sendKeys(propMvn.getProperty("appln.password"));
					captureScreen();
				} catch (Exception e) {
					System.out.println("could not get/click password");
				}
				try {
					driver.findElement(By.xpath("//a[@title='Sign On']")).click();
					UtilThread.sleep(5000);
					System.out.println("After sign on URL: " + driver.getCurrentUrl());
					captureScreen();
				} catch (Exception e) {
					System.out.println("could not get/click sign on");
				}
			}
		} catch (Exception e) {
			System.out.println("inside  SIT default");
			driver.get(FileReaderManager.getInstance().getConfigReader().getStgApplicationUrl());
		}
		UtilWait.waitLoadAll(driver);
	}
	
	//created for demo
	public void launchDemoApplication() {
		driver.manage().deleteAllCookies();
		try {
			if (FileReaderManager.getInstance().getMvnPropReader().getEnv().equalsIgnoreCase("")) {
				driver.get(FileReaderManager.getInstance().getConfigReader().getStgApplicationUrl());
			}
			// To run on staging url
			else if (FileReaderManager.getInstance().getMvnPropReader().getEnv().equalsIgnoreCase("stg")
					&& FileReaderManager.getInstance().getConfigReader().getHeadless() == false) {
				System.out.println("inside non headless STG");
				driver.get(FileReaderManager.getInstance().getConfigReader().getStgApplicationUrl());
			}
			// To run on SIT url
			else if (FileReaderManager.getInstance().getMvnPropReader().getEnv().equalsIgnoreCase("sit")
					&& FileReaderManager.getInstance().getConfigReader().getHeadless() == false) {
				System.out.println("inside non headless SIT");
				driver.get(FileReaderManager.getInstance().getConfigReader().getSitApplicationUrl());
			}
			// To run on dev url
			else if (FileReaderManager.getInstance().getMvnPropReader().getEnv().equalsIgnoreCase("dev")
					&& FileReaderManager.getInstance().getConfigReader().getHeadless() == false) {
				System.out.println("inside non headless DEV");
				driver.get(FileReaderManager.getInstance().getConfigReader().getDevApplicationUrl());
			}
		} catch (Exception e) {
			System.out.println("inside  SIT default");
			driver.get(FileReaderManager.getInstance().getConfigReader().getStgApplicationUrl());
		}
		UtilWait.waitLoadAll(driver);
	}


}
