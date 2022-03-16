package com.beltWasla.steps;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import com.beltWasla.pages.HomeScreen_BELT;
import com.beltWasla.pages.LocationPage_BELT;
import com.beltWasla.pages.LogBagPage_BELT;
import com.beltWasla.runners.TestRunner;
import com.beltWasla.setUp.TestContext;
import com.beltWasla.utils.ApplicationLauncher;
import com.beltWasla.utils.Screenshot;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LocationSteps extends ApplicationLauncher {

	int DEFAULT_WAIT_4_PAGE = 15;

	String thisClassName = getClass().getSimpleName();
	public Actions act = new Actions(driver);
	TestContext testContext;
	LocationPage_BELT locationPage;
	HomeScreen_BELT homePage;
	LogBagPage_BELT logBagPage;

	public LocationSteps(TestContext context) { 
		 testContext = context;
		 locationPage = testContext.getPageObjectManager().getLocationPage(); 
		 homePage = testContext.getPageObjectManager().getHomePage(); 
		 logBagPage = testContext.getPageObjectManager().getLogBagPage();
	  }

	public void captureScreen() {

		Screenshot.takeScreenshot(TestRunner.dateTime, thisClassName, scenarioName);

	}

	@Given("^the user has logged into the BELT application$")
	public void the_user_has_logged_into_the_BELT_application() throws Throwable {

		try {
			launchApplication();
			captureScreen();
			// login.clickLogin();
		} catch (Exception e) {
			captureScreen();
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Given("^the user has not selected a location yet$")
	public void the_user_has_not_selected_a_location_yet() throws Throwable {
		try {
			System.out.println("Add location lable : " + homePage.getAddLocationLable());
			if (homePage.getAddLocationLable().equals("Add location")) {
				System.out.println("No location has been selected yet...");
			} else {
				System.out.println("Location has been alreay selected...");
				captureScreen();
				throw new RuntimeException();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Unable to verify the location selection status...");
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user is trying to access any feature/function$")
	public void the_user_is_trying_to_access_any_feature_function() throws Throwable {
		try {
			homePage.clickLogBagIcon();
			System.out.println("Opening Logbag feature");
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Given("^the user has already selected a location and saved it$")
	public void the_user_has_already_selected_a_location_and_saved_it() throws Throwable {
		try {

			homePage.clickAddLocationButton();
			locationPage.enterTerminalDropDown(propObject.getProperty("ValidTerminal"));
			act.sendKeys(Keys.ENTER).build().perform();
			locationPage.enterAreaDropDown(propObject.getProperty("ValidArea"));
			act.sendKeys(Keys.ENTER).build().perform();
			locationPage.enterLocationDropDown(propObject.getProperty("ValidLocation"));
			act.sendKeys(Keys.ENTER).build().perform();
			locationPage.clickConfirmButton();
			captureScreen();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the system will prompt the user to select the location$")
	public void the_system_will_prompt_the_user_to_select_the_location() throws Throwable {
		try {
			if (homePage.getAddLocationPromptMessage().equals("Please enter your working location to get started.")) {
				System.out.println("The system prompts the user to select the locationPage...");
			} else {
				System.out.println("The system doesn't prompt the user to select the locationPage...");
			}
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the system won't prompt the user to select the location$")
	public void the_system_won_t_prompt_the_user_to_select_the_location() throws Throwable {
		try {
			if (logBagPage.getLogBagPageTitle().equals("Log bag")) {
				System.out.println("System doesn't prompt to select locationPage...");
			} else {
				System.out.println("System prompts to select locationPage...");
			}
			captureScreen();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Given("^User has navigated to Log location screen$")
	public void user_has_navigated_to_Log_location_screen() throws Throwable {
		try {
			homePage.clickAddLocationButton();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user selects a valid terminal, area and location from the list in any possible way$")
	public void the_user_selects_a_valid_terminal_area_and_location_from_the_list_in_any_possible_way()
			throws Throwable {
		try {
			locationPage.enterTerminalDropDown(propObject.getProperty("ValidTerminal"));
			act.sendKeys(Keys.ENTER).build().perform();
			locationPage.enterAreaDropDown(propObject.getProperty("ValidArea"));
			act.sendKeys(Keys.ENTER).build().perform();
			locationPage.enterLocationDropDown(propObject.getProperty("ValidLocation"));
			act.sendKeys(Keys.ENTER).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user clicks on confirm button$")
	public void the_user_clicks_on_confirm_button() throws Throwable {
		try {
			locationPage.clickConfirmButton();

		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the system will save the selected location data$")
	public void the_system_will_save_the_selected_location_data() throws Throwable {
		System.out.println("The location saved successfully");
	}

	@Then("^the system navigates to the previous screen$")
	public void the_system_navigates_to_the_previous_screen() throws Throwable {
		try {
			System.out.println("Navigated back to - " + homePage.getHomePageTitle() + " page successfully");
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the confirmation message will be displayed as Location update successful$")
	public void the_confirmation_message_will_be_displayed_as_Location_update_successful() throws Throwable {
		try {
			// Toast message capture
			/*
			 * capture toast message
			 */
			if (locationPage.checkSuccessMsg()) {
				System.out.println("Location updated succesfully");
			}
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the selected location is displayed in the location bar on the top in all screens$")
	public void the_selected_location_is_displayed_in_the_location_bar_on_the_top_in_all_screens() throws Throwable {
		try {
			if (homePage.getSelectedLocationData().equals(propObject.getProperty("ValidLocation"))) {
				System.out.println("The location has been saved successfully and its been verified.");
			} else {
				System.out.println("The saved location is mismatched with the given one.");
				captureScreen();
				throw new RuntimeException();
			}
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user has navigated to any screen$")
	public void the_user_has_navigated_to_any_screen() throws Throwable {
		try {
			homePage.clickLogBagIcon();

		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Given("^User has already saved a valid location data successfully$")
	public void user_has_already_saved_a_valid_location_data_successfully() throws Throwable {
		try {

			homePage.clickAddLocationButton();
			locationPage.enterTerminalDropDown(propObject.getProperty("ValidTerminal"));
			act.sendKeys(Keys.ENTER).build().perform();
			locationPage.enterAreaDropDown(propObject.getProperty("ValidArea"));
			act.sendKeys(Keys.ENTER).build().perform();
			locationPage.enterLocationDropDown(propObject.getProperty("ValidLocation"));
			act.sendKeys(Keys.ENTER).build().perform();
			locationPage.clickConfirmButton();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the user will see his saved location at the location bar at the top of the screen$")
	public void the_user_will_see_his_saved_location_at_the_location_bar_at_the_top_of_the_screen() throws Throwable {
		try {
			if (homePage.getSelectedLocationData().equals(propObject.getProperty("ValidLocation"))) {
				System.out.println("The saved location displayed in home screen is : '" + homePage.getSelectedLocationData()
						+ " ' and its been verified.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user clicks the Edit icon in the current location bar$")
	public void the_user_clicks_the_Edit_icon_in_the_current_location_bar() throws Throwable {

		try {
			System.out.println("The saved location before editing is : " + homePage.getSelectedLocationData());
			homePage.editLocationCode();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the user will be navigated to the log location screen$")
	public void the_user_will_be_navigated_to_the_log_location_screen() throws Throwable {
		try {
			System.out.println("Navigated to - '" + locationPage.getLocationPageTitle() + "' screen");
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the user will see his saved terminal, area and location values in relevant drop downs$")
	public void the_user_will_see_his_saved_terminal_area_and_location_values_in_relevant_drop_downs()
			throws Throwable {
		try {
			// verification of current location terminal area
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the user will be able to change the location by selecting from drop down / search by typing / scan the location$")
	public void the_user_will_be_able_to_change_the_location_by_selecting_from_drop_down_search_by_typing_scan_the_location()
			throws Throwable {
		try {
			locationPage.enterTerminalDropDown(propObject.getProperty("NewTerminal"));
			act.sendKeys(Keys.ENTER).build().perform();
			locationPage.enterAreaDropDown(propObject.getProperty("NewArea"));
			act.sendKeys(Keys.ENTER).build().perform();
			locationPage.enterLocationDropDown(propObject.getProperty("NewLocation"));
			act.sendKeys(Keys.ENTER).build().perform();
			locationPage.clickConfirmButton();

		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}

	}

	@Then("^the user should be able to see the recently used locations in the dropdown first$")
	public void the_user_should_be_able_to_see_the_recently_used_locations_in_the_dropdown_first() throws Throwable {
		try {
			if (locationPage.recentLocationsList()) {
				System.out.println("Recently searched locations are available to select");
			}
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^user should be able to select on from it$")
	public void user_should_be_able_to_select_on_from_it() throws Throwable {
		try {
			locationPage.selectFromRecent();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Given("^the user has chooses Search option$")
	public void the_user_has_chooses_Search_option() throws Throwable {
		try {
			locationPage.clickSearchIcon();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user selects any location from the recently used locations shown in the dropdown$")
	public void the_user_selects_any_location_from_the_recently_used_locations_shown_in_the_dropdown()
			throws Throwable {
		try {
			locationPage.selectFromRecent();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}

	}

	@Then("^user system should save that location and take them to the previous screen$")
	public void user_system_should_save_that_location_and_take_them_to_the_previous_screen() throws Throwable {
		try {
			if (locationPage.getLocationPageTitle().equals("Log location")) {
				System.out.println("System doesn't navigate to the previos screen");
				captureScreen();
				throw new RuntimeException();
			} else {
				System.out.println("The system successfully navigated to the previous screen");
			}
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the saved location should be displayed in all the screens$")
	public void the_saved_location_should_be_displayed_in_all_the_screens() throws Throwable {
		try {
			if (homePage.getSelectedLocationData().equals(propObject.getProperty("ValidLocation"))) {
				System.out.println("The saved location displayed in home screen is : '" + homePage.getSelectedLocationData()
						+ " ' and its been verified.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
		try {
			homePage.clickLogBagIcon();
			if (logBagPage.getSelectedLocation().equals(propObject.getProperty("ValidLocation"))) {
				System.out.println("The saved location displayed in home screen is : '" + homePage.getSelectedLocationData()
						+ " ' and its been verified.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Given("^the user has choosen Search option$")
	public void the_user_has_choosen_Search_option() throws Throwable {
		try {
			locationPage.clickSearchIcon();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user starts typing a valid location$")
	public void the_user_starts_typing_a_valid_location() throws Throwable {
		try {
			locationPage.enterSearchLocation(propObject.getProperty("ValidLocation"));
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user selects a valid location from the filtered dropdown$")
	public void the_user_selects_a_valid_location_from_the_filtered_dropdown() throws Throwable {
		try {
			locationPage.selectFromRecent();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^as soon as the user starts typing, system starts retrieving the matching locations and populates the corresponding matching location for the user to choose from$")
	public void as_soon_as_the_user_starts_typing_system_starts_retrieving_the_matching_locations_and_populates_the_corresponding_matching_location_for_the_user_to_choose_from()
			throws Throwable {
		try {
			if ((locationPage.recentLocationsList())) {
				System.out.println("Matching locations with given input filtered and shown...");
			} else {
				System.out.println("Matching locations with given input not shown...");
				captureScreen();
				throw new RuntimeException();
			}
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user starts typing a invalidLocation$")
	public void the_user_starts_typing_a_invalidLocation() throws Throwable {
		try {
			locationPage.enterSearchLocation(propObject.getProperty("InvalidLocation"));
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^message should be displayed as No results found or Invalid input. Please try searching for another location$")
	public void message_should_be_displayed_as_No_results_found_or_Invalid_input_Please_try_searching_for_another_location()
			throws Throwable {
		try {
			System.out.println("System throws error message as : ' " + locationPage.getErrorTitle() + " , "
					+ locationPage.getErrorMsg() + " '");
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^user should be able to rescan or enter the details manually$")
	public void user_should_be_able_to_rescan_or_enter_the_details_manually() throws Throwable {
		try {
			locationPage.clearSearchField();
			locationPage.enterSearchLocation(propObject.getProperty("ValidLocation"));
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}
}
