package com.beltWasla.steps;

//import com.aventstack.extentreports.ExtentTest;
import com.relevantcodes.extentreports.ExtentTest;
import com.beltWasla.pages.LogBagPage_BELT;
//import com.relevantcodes.extentreports.ExtentTest;
import com.beltWasla.runners.TestRunner;
import com.beltWasla.setUp.TestContext;
import com.beltWasla.utils.ApplicationLauncher;
import com.beltWasla.utils.Screenshot;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OHDSteps extends ApplicationLauncher {

	
	ExtentTest logger;

	int DEFAULT_WAIT_4_PAGE = 15;
	
	TestContext testContext;
	LogBagPage_BELT ohdPage;

	public OHDSteps(TestContext context) { 
		 testContext = context;
		 ohdPage = testContext.getPageObjectManager().getLogBagPage(); 
	  }

	String thisClassName = getClass().getSimpleName();

	public void captureScreen() {

		Screenshot.takeScreenshot(TestRunner.dateTime, thisClassName, scenarioName);

	}

	@Given("^the OHD is created and not on Closed status$")
	public void the_OHD_is_created_and_not_on_Closed_status() throws Throwable {
		try {
			System.out.println("The OHD is not in closed status");
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the loader scans a OHD reference number$")
	public void the_loader_scans_a_OHD_reference_number() throws Throwable {
		try {
			ohdPage.enterTagNumber(propObject.getProperty("ValidOHD"));
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the OHD is LOGGED successfully$")
	public void the_OHD_is_LOGGED_successfully() throws Throwable {
		try {
			System.out.println("OHD logged successfully");
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the message will be displayed as the OHD is logged successfully\\.DXBEK(\\d+) OHD logged Successfully$")
	public void the_message_will_be_displayed_as_the_OHD_is_logged_successfully_DXBEK_OHD_logged_Successfully(int arg1)
			throws Throwable {
		try {
			// verify message
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the loader scans a invalidOHD reference number$")
	public void the_loader_scans_a_invalidOHD_reference_number() throws Throwable {
		try {
			ohdPage.enterTagNumber(propObject.getProperty("InvalidOHD"));
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the Invalid OHD reference number error message is displayed until the user scans/enters a valid OHD number$")
	public void the_Invalid_OHD_reference_number_error_message_is_displayed_until_the_user_scans_enters_a_valid_OHD_number()
			throws Throwable {
		try {
			ohdPage.getBagTagOHDerror();
			Thread.sleep(3000);
			System.out.println("The error message from invalid OHD is : " + ohdPage.getBagTagOHDerror());
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Given("^the OHD exist in the system with closed status$")
	public void the_OHD_exist_in_the_system_with_closed_status() throws Throwable {
		try {
			System.out.println("The OHD is in closed status");
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user scans or enters manually the OHD reference number$")
	public void the_user_scans_or_enters_manually_the_OHD_reference_number() throws Throwable {
		try {
			ohdPage.enterTagNumber(propObject.getProperty("ClosedOHD"));
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^System validates the status and identifies the status of OHD is closed$")
	public void system_validates_the_status_and_identifies_the_status_of_OHD_is_closed() throws Throwable {
		try {
			System.out.println("The system validates the OHD status");
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^an error with OHD is closed response will be shown to the loader$")
	public void an_error_with_OHD_is_closed_response_will_be_shown_to_the_loader() throws Throwable {
		try {
			ohdPage.getBSMerrorMsg();
			Thread.sleep(3000);
			System.out.println("The error message from closed OHD is : " + ohdPage.getBSMerrorMsg());
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}
}
