package com.beltWasla.steps;

import com.beltWasla.pages.WaslaQohPage;
import com.beltWasla.runners.TestRunner;
import com.beltWasla.setUp.TestContext;
import com.beltWasla.utils.ApplicationLauncher;
import com.beltWasla.utils.Screenshot;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WaslaCreateQOHSteps extends ApplicationLauncher {

	TestContext testContext;
	WaslaQohPage waslaQohPage;

	public WaslaCreateQOHSteps(TestContext context) {
		testContext = context;
		waslaQohPage = testContext.getPageObjectManager().getWaslaQohPage();
	}

	int DEFAULT_WAIT_4_PAGE = 15;

	String thisClassName = getClass().getSimpleName();

	public void captureScreen() {

		Screenshot.takeScreenshot(TestRunner.dateTime, this.thisClassName, scenarioName);

	}

	@Given("^the user has logged into the WASLA application$")
	public void the_user_has_logged_into_the_WASLA_application() throws Throwable {
		try {
			launchApplication();
		} catch (Exception e) {
			captureScreen();
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@When("^the user enter the tag number with or without BSM in the tag number field$")
	public void the_user_enter_the_tag_number_with_or_without_BSM_in_the_tag_number_field() throws Throwable {
		try {
			waslaQohPage.enterTag(propObject.getProperty("TagNumberQOH"));
			Thread.sleep(3000);
			captureScreen();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user enter the tag number without BSM in the tag number field$")
	public void the_user_enter_the_tag_number_without_BSM_in_the_tag_number_field() throws Throwable {
		try {
			waslaQohPage.enterTag(propObject.getProperty("TagNumberNoBSMQOH"));
			Thread.sleep(3000);
			captureScreen();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}
	
	@When("^the user selects valid airline originator from dropdown and submits$")
	public void the_user_selects_valid_airline_originator_from_dropdown_and_submits() throws Throwable {
		try {
			waslaQohPage.clickAirlineDD();
			Thread.sleep(2000);
			waslaQohPage.selectEK();
			Thread.sleep(1000);
			captureScreen();
			waslaQohPage.clickCreate();
			//Thread.sleep(1000);
			captureScreen();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}
	
	@When("^the user select valid carrier code$")
	public void the_user_select_valid_carrier_code() throws Throwable {
		try {
			waslaQohPage.clickAirlineDD();
			Thread.sleep(1000);
			waslaQohPage.selectEK();
			Thread.sleep(1000);
			captureScreen();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user enters multiple tag numbers with BSM and adds it to the list$")
	public void the_user_enters_multiple_tag_numbers_with_BSM_and_adds_it_to_the_list() throws Throwable {
		try {
			waslaQohPage.enterTag(propObject.getProperty("TagNumberQOH"));
			Thread.sleep(3000);
			captureScreen();
			waslaQohPage.enterTag(propObject.getProperty("TagNumberQOH2"));
			Thread.sleep(3000);
			captureScreen();
			waslaQohPage.enterTag(propObject.getProperty("TagNumberQOH3"));
			Thread.sleep(3000);
			captureScreen();
			waslaQohPage.enterTag(propObject.getProperty("TagNumberQOH4"));
			Thread.sleep(3000);
			captureScreen();
			waslaQohPage.enterTag(propObject.getProperty("TagNumberQOH5"));
			Thread.sleep(3000);
			captureScreen();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user enters multiple tag numbers with one or more rejected and adds it to the list$")
	public void the_user_enters_multiple_tag_numbers_with_one_or_more_rejected_and_adds_it_to_the_list()
			throws Throwable {
		try {
			waslaQohPage.enterTag(propObject.getProperty("TagNumberQOH"));
			Thread.sleep(3000);
			captureScreen();
			waslaQohPage.enterTag(propObject.getProperty("TagNumberQOH2"));
			Thread.sleep(3000);
			captureScreen();
			waslaQohPage.enterTag(propObject.getProperty("TagNumberQOH3"));
			Thread.sleep(3000);
			captureScreen();
			waslaQohPage.enterTag(propObject.getProperty("TagNumberQOH4"));
			Thread.sleep(3000);
			captureScreen();
			waslaQohPage.enterTag(propObject.getProperty("TagNumberQOH5"));
			Thread.sleep(3000);
			captureScreen();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the system will create the QOH and show the error message for rejected as QOH creation unsuccessful - due tag (\\d+) - (\\d+) from the below rejected$")
	public void the_system_will_create_the_QOH_and_show_the_error_message_for_rejected_as_QOH_creation_unsuccessful_due_tag_from_the_below_rejected(
			int arg1, int arg2) throws Throwable {
		try {
			// System.out.println("The error message from the QOH is : " +
			// waslaQohPage.getTopErrorMessage());
			Thread.sleep(3000);
			captureScreen();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user enter the tag number which already has a QOH generated$")
	public void the_user_enter_the_tag_number_which_already_has_a_QOH_generated() throws Throwable {
		try {
			waslaQohPage.enterTag(propObject.getProperty("TagNumberQOH"));
			Thread.sleep(3000);
			captureScreen();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the system will throw an error as QOH already exists/created$")
	public void the_system_will_throw_an_error_as_QOH_already_exists_created() throws Throwable {
		try {
			// System.out.println("The error message from the QOH is : " +
			// waslaQohPage.getTopErrorMessage());
			Thread.sleep(3000);
			captureScreen();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}



	@Then("^the sytem will throw an error message as Invalid Airline Originator, Please check and try again$")
	public void the_sytem_will_throw_an_error_message_as_Invalid_Airline_Originator_Please_check_and_try_again()
			throws Throwable {
		try {
			// System.out.println("The error message from the QOH is : " +
			// waslaQohPage.getTopErrorMessage());
			Thread.sleep(3000);
			captureScreen();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}
}
