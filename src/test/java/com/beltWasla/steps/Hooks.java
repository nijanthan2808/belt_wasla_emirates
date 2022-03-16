package com.beltWasla.steps;

import java.io.IOException;
import com.beltWasla.runners.TestRunner;
import com.beltWasla.setUp.TestContext;
import com.beltWasla.utils.ApplicationLauncher;
import com.beltWasla.utils.Screenshot;
import com.beltWasla.utils.TestRailConnect;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends ApplicationLauncher {

	TestContext testContext;

	public Hooks(TestContext context) {
		testContext = context;
	}

	String thisClassName = getClass().getSimpleName();

	public void captureScreen() {
		Screenshot.takeScreenshot(TestRunner.dateTime, this.thisClassName, scenarioName);
	}

	//@Before
	public void beforeScenario(Scenario scenario) {
		System.out.println("Came till here inside before");
		scenarioName = scenario.getName();
		System.out.println("Scenario Name : " + scenarioName);
		// Reporter.addStepLog("Scenario Name : " + scenarioName);
		featureName = scenario.getId().split(";")[0].replace("-", " ");
		System.out.println("Feature Name : " + featureName);
		// Reporter.addStepLog("Feature Name : " + featureName);
		// return scenarioName;
	}

	// commenting out to ignore testratil update as part of demo
	// @After(order = 1) //To update theresults in test rail
	public void afterScenario(Scenario scenario) throws IOException {
		System.out.println("scenario name: " + scenario.getName());
		String scenarioName = scenario.getName();
		String testCaseIDs = null;
		String[] arrtestCaseIDs = null;
		String testCaseID = null;
		String testCase = null;
		try {
			String[] testScenarioSplittedArr = scenarioName.split("-");
			// testCaseIDs=testScenarioSplittedArr[0].trim().substring(1);
			testCaseIDs = testScenarioSplittedArr[0].trim();
			arrtestCaseIDs = testCaseIDs.split(",");

			System.out.println("filtered testCaseID: " + testCaseID);
			for (String testid : arrtestCaseIDs) {
				try {
					testCaseID = testid.substring(1);
					Integer.parseInt(testCaseID);
				} catch (RuntimeException e) {
					testCaseID = null;
					break;
				}
			}

			String status = scenario.getStatus();
			System.out.println("scenario status: " + status);
			// String id=scenario.getId();
			System.out.println("scenario id: " + testCaseID);
		} catch (Exception e) {
			System.out.println("testCaseID is missing");
		}

		if (scenario.getStatus().equalsIgnoreCase("failed")) {
			// String screenshotName = scenario.getName().replaceAll(" ", "_");
			try {
				captureScreen();
				// Reporter.addScreenCaptureFromPath(destinationPath.toString());
				if (testCaseID == null) {
					// Reporter.addScenarioLog("testCaseID is null, so test Rail not updated");
				} else {
					for (String test : arrtestCaseIDs) {
						testCase = test.substring(1);
						TestRailConnect.update(testCase, "Failed");
					}
				}

			} catch (IOException e) {
			}
		} else if (scenario.getStatus().equalsIgnoreCase("passed")) {
			try {
				captureScreen();
				if (testCaseID == null) {
					System.out.println("testCaseID is null, so test Rail not updated");
				} else {
					// TestRailConnect.update(testCaseID, "Passed",
					// testContext.getWebDriverManager().getDriver());
					for (String test : arrtestCaseIDs) {
						testCase = test.substring(1);
						TestRailConnect.update(testCase, "Passed");
					}
				}
			} catch (IOException e) {
			}
		}
	}

	@After(order = 0) // To delete all created data and close browsers
	public void AfterSteps() {
		// DButilities.executeSQLFile(System.getProperty("user.dir")+"/src/test/resources/sqlFiles/AllDelete.sql");
		// testContext.getWebDriverManager().quitDriver();
	}

}
