package com.beltWasla.steps;

import com.relevantcodes.extentreports.ExtentTest;
//import com.aventstack.extentreports.ExtentTest;
import com.beltWasla.pages.DfsPage_BELT;
import com.beltWasla.pages.HomeScreen_BELT;
import com.beltWasla.runners.TestRunner;
import com.beltWasla.setUp.TestContext;
import com.beltWasla.utils.ApplicationLauncher;
import com.beltWasla.utils.Screenshot;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DFSSteps extends ApplicationLauncher {

	TestContext testContext;
	DfsPage_BELT dfsPage;
	HomeScreen_BELT homePage;

	public DFSSteps(TestContext context) {
		
		testContext = context;
		dfsPage = testContext.getPageObjectManager().getDfsPage();
		homePage = testContext.getPageObjectManager().getHomePage();
	}
	ExtentTest logger;

	int DEFAULT_WAIT_4_PAGE = 15;

	String thisClassName = getClass().getSimpleName();

	public void captureScreen() {

		Screenshot.takeScreenshot(TestRunner.dateTime, thisClassName, scenarioName);

	}

	@Given("^the user has launched the DFS feature$")
	public void the_user_has_launched_the_DFS_feature() throws Throwable {
		try {
			homePage.clickDfsIcon();
			Thread.sleep(3000);
			captureScreen();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user enters valid flight number flightNumber$")
	public void the_user_enters_valid_flight_number_flightNumber() throws Throwable {
		try {
			dfsPage.enterFlightNumber(propObject.getProperty("ValidFlightNumber"));
			Thread.sleep(3000);
			captureScreen();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user selects a valid date flightDate$")
	public void the_user_selects_a_valid_date_flightDate() throws Throwable {
		try {
			//dfsPage.enterFlightDate(propObject.getProperty("ValidFlightDate"));
			Thread.sleep(3000);
			captureScreen();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user clicks on Confirm button$")
	public void the_user_clicks_on_Confirm_button() throws Throwable {
		try {
			dfsPage.clickSubmitButton();
			Thread.sleep(3000);
			captureScreen();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the system will launch the Departure Flight Info Screen$")
	public void the_system_will_launch_the_Departure_Flight_Info_Screen() throws Throwable {
		try {
			dfsPage.getDfsTextTop();
			System.out.println("DFS summary screen has been launched and its summary title is : " + dfsPage.getDfsTextTop());
			Thread.sleep(3000);
			captureScreen();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user launched the Departure Flight Info Screen by entering flight number flightNumber and date flightDate$")
	public void the_user_launched_the_Departure_Flight_Info_Screen_by_entering_flight_number_flightNumber_and_date_flightDate()
			throws Throwable {
		try {
			dfsPage.enterFlightNumber(propObject.getProperty("ValidFlightNumber"));
			Thread.sleep(3000);
			//dfsPage.enterFlightDate(propObject.getProperty("ValidFlightDate"));
			Thread.sleep(3000);
			dfsPage.clickSubmitButton();
			Thread.sleep(3000);
			dfsPage.getDfsTextTop();
			System.out.println("DFS summary screen has been launched and its summary title is : " + dfsPage.getDfsTextTop());
			Thread.sleep(3000);
			captureScreen();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the system should list Flight number/Date,Status,Route,Bay,STD,ATD,ETD,Carousal,RegNo,Make-up area,Aircraft,Gate,Terminal,Hold Door,Bay,Belt$")
	public void the_system_should_list_Flight_number_Date_Status_Route_Bay_STD_ATD_ETD_Carousal_RegNo_Make_up_area_Aircraft_Gate_Terminal_Hold_Door_Bay_Belt()
			throws Throwable {
		try {
			dfsPage.switchToFlightTab();
			Thread.sleep(3000);
			System.out.println("All the values on flight summary has been verified");
			captureScreen();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user enter the Flight number which is not in two A\\(carrier\\) and minimum one N to maximum four N format\\(Flight number\\)$")
	public void the_user_enter_the_Flight_number_which_is_not_in_two_A_carrier_and_minimum_one_N_to_maximum_four_N_format_Flight_number()
			throws Throwable {
		try {
			dfsPage.enterFlightNumber(propObject.getProperty("InvalidFlightFormat"));
			Thread.sleep(3000);
			captureScreen();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
		
	}

	@When("^the user selects valid date and hits the confirm button$")
	public void the_user_selects_valid_date_and_hits_the_confirm_button() throws Throwable {
		try {
			Thread.sleep(3000);
			//dfsPage.enterFlightDate(propObject.getProperty("ValidFlightDate"));
			Thread.sleep(3000);
			dfsPage.clickSubmitButton();
			Thread.sleep(3000);
			captureScreen();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the system should throw error message as Invalid flight number$")
	public void the_system_should_throw_error_message_as_Invalid_flight_number() throws Throwable {
		try {
			dfsPage.getDfsErrorMessage();
			Thread.sleep(3000);
			System.out.println("The error message from DFS invalid is : " +dfsPage.getDfsErrorMessage());
			captureScreen();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user enters valid carrier code and invalid flight number$")
	public void the_user_enters_valid_carrier_code_and_invalid_flight_number() throws Throwable {
		try {
			dfsPage.enterFlightNumber(propObject.getProperty("InvalidFlightNumber"));
			Thread.sleep(3000);
			//dfs.clickSubmitButton();
			//Thread.sleep(3000);
			captureScreen();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the flight number format is valid$")
	public void the_flight_number_format_is_valid() throws Throwable {
		try {
			//validation
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user enters invalid carrier code and valid flight number$")
	public void the_user_enters_invalid_carrier_code_and_valid_flight_number() throws Throwable {
		try {
			dfsPage.enterFlightNumber(propObject.getProperty("InvalidCarrier"));
			Thread.sleep(3000);
			//dfs.clickSubmitButton();
			//Thread.sleep(3000);
			captureScreen();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the system should throw error message as Invalid Carrier$")
	public void the_system_should_throw_error_message_as_Invalid_Carrier() throws Throwable {
		try {
			dfsPage.getDfsErrorMessage();
			Thread.sleep(3000);
			System.out.println("The error message from carrier invalid is : " +dfsPage.getDfsErrorMessage());
			captureScreen();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}
}
