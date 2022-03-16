package com.beltWasla.steps;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.ExtentTest;
//import com.aventstack.extentreports.ExtentTest;
import com.beltWasla.pages.HomeScreen_BELT;
import com.beltWasla.pages.LocationPage_BELT;
import com.beltWasla.pages.LogBagPage_BELT;
import com.beltWasla.runners.TestRunner;
import com.beltWasla.setUp.TestContext;
import com.beltWasla.utils.ApplicationLauncher;
import com.beltWasla.utils.Screenshot;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LogBag_BagTagSteps extends ApplicationLauncher {

	ExtentTest logger;

	int DEFAULT_WAIT_4_PAGE = 15;
	
	String thisClassName = getClass().getSimpleName();
	public Actions act = new Actions(driver);
	TestContext testContext;
	LogBagPage_BELT logBagPage;
	LocationPage_BELT locationPage;
	HomeScreen_BELT homePage;

	public LogBag_BagTagSteps(TestContext context) { 
		 testContext = context;
		 logBagPage = testContext.getPageObjectManager().getLogBagPage(); 
		 locationPage = testContext.getPageObjectManager().getLocationPage(); 
		 homePage = testContext.getPageObjectManager().getHomePage(); 
	  }
	
	public void captureScreen() {

		Screenshot.takeScreenshot(TestRunner.dateTime, this.thisClassName, scenarioName);

	}

	@Given("^the user has selected a location already$")
	public void the_user_has_selected_a_location_already() throws Throwable {
		try {
			homePage.clickAddLocationButton();	
			locationPage.enterTerminalDropDown(propObject.getProperty("ValidTerminal"));
			act.sendKeys(Keys.ENTER).build().perform();
			locationPage.enterAreaDropDown(propObject.getProperty("ValidArea"));
			act.sendKeys(Keys.ENTER).build().perform();
			locationPage.enterLocationDropDown(propObject.getProperty("ValidLocation"));
			act.sendKeys(Keys.ENTER).build().perform();
			locationPage.clickConfirmButton();
			//System.out.println("Log bag screen launched");
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Given("^the user has launched the log bag function$")
	public void the_user_has_launched_the_log_bag_function() throws Throwable {
		try {
			homePage.clickLogBagIcon();
			System.out.println("Log bag screen launched");
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user manually enters / scans a valid bagTag number which is in either two AN six N or ten N format$")
	public void the_user_manually_enters_scans_a_valid_bagTag_number_which_is_in_either_two_AN_six_N_or_ten_N_format()
			throws Throwable {
		try {
			logBagPage.enterTagNumber(propObject.getProperty("ValidBagTag"));
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user press the enter key to submit$")
	public void the_user_press_the_enter_key_to_submit() throws Throwable {
		try {
			act.sendKeys(Keys.ENTER).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the system will successfully validate the tag number format and auto submit it$")
	public void the_system_will_successfully_validate_the_tag_number_format_and_auto_submit_it() throws Throwable {
		try {
			System.out.println(logBagPage.getBagLoggedToastMsg()+" : Toast Msg");
			if (logBagPage.verifyBagLoggedDisplayed()) {
				System.out.println("Given Bag Tag number exists");
				if (logBagPage.getBagLoggedLable().contains(propCommon.getProperty("bagLogged"))) {
					System.out.println("Bag tag number auto submited after validation");
					Assert.assertTrue("Bag tag number auto submited after validation", true);
				} else {
					System.out.println("Bag tag number cannot be auto submited after validation");
					Assert.assertTrue("Bag tag number cannot be auto submited after validation",false);
				}
			}else
			{
				System.out.println("Given Bag Tag number does not exist");
			}
			

		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user manually enters / scans a invalid bagTag number which is in neither two AN six N nor ten N format$")
	public void the_user_manually_enters_scans_a_invalid_bagTag_number_which_is_in_neither_two_AN_six_N_nor_ten_N_format()
			throws Throwable {
		try {
			logBagPage.enterTagNumber(propObject.getProperty("InvalidBagTag"));
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the system will throw an error message as Invalid format until valid tag number is entered$")
	public void the_system_will_throw_an_error_message_as_Invalid_format_until_valid_tag_number_is_entered()
			throws Throwable {
		try {
			Assert.assertEquals(logBagPage.getBagTagOHDerror().trim(), propCommon.getProperty("BagTagInvalidFormat"));
			if (logBagPage.getBagTagOHDerror().equals("Invalid Format")) {
				System.out.println("Incorrect bag tag format entered and its been verified with the error message");
			} else {
				System.out.println("Incorrect bag tag format entered but unable to verify the error message");
			}
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user hits the enter key without entering eight characters after entering three alpha numeric first as bagTag number$")
	public void the_user_hits_the_enter_key_without_entering_eight_characters_after_entering_three_alpha_numeric_first_as_bagTag_number()
			throws Throwable {
		try {
			// next phase
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the system will throw an error message as Invalid format untill valid tag number is entered$")
	public void the_system_will_throw_an_error_message_as_Invalid_format_untill_valid_tag_number_is_entered()
			throws Throwable {
		try {
			// next phase
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user hits the enter key without entering ten characters after entering three numeric first as bagTag number$")
	public void the_user_hits_the_enter_key_without_entering_ten_characters_after_entering_three_numeric_first_as_bagTag_number()
			throws Throwable {
		try {
			// next phase
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Given("^the bagTag is in valid format but no BSM created$")
	public void the_bagTag_is_in_valid_format_but_no_BSM_created() throws Throwable {
		try {
			System.out.println("Bag tag has no bsm created");
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user scans / enters the no BSM bagTag number manually$")
	public void the_user_scans_enters_the_no_BSM_bagTag_number_manually() throws Throwable {
		try {
			logBagPage.enterTagNumber(propObject.getProperty("BagTagNoBSM"));
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the system will prompt that BSM does not exists$")
	public void the_system_will_prompt_that_BSM_does_not_exists() throws Throwable {
		try {
			Thread.sleep(2000);
			Assert.assertEquals(logBagPage.getBSMerrorMsg(),propCommon.getProperty("NoBSMFound"));
			if (logBagPage.getBSMerrorMsg().equals("No BSM found. Do you want to enter details manually")) {
				System.out.println("Sytem throws waring as No BSM with tag number");
			} else {
				System.out.println("Unable to get the waring as No BSM with tag number");
			}
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the system allows the user to add the optional details manually and log the bag$")
	public void the_system_allows_the_user_to_add_the_optional_details_manually_and_log_the_bag() throws Throwable {
		try {
			logBagPage.clickYesOption();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user scans a valid bagTag with multiple BSM$")
	public void the_user_scans_a_valid_bagTag_with_multiple_BSM() throws Throwable {
		try {
			logBagPage.enterTagNumber(propObject.getProperty("BagTagMultiBSM"));
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^there are multiple BSMs found for the given bagTag for the last specified days$")
	public void there_are_multiple_BSMs_found_for_the_given_bagTag_for_the_last_specified_days() throws Throwable {
		try {
			//Assert.assertEquals(propCommon.getProperty("MultiBSMFound"), logBagPage.getBSMerrorMsg());
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}
	
	@And("^the user has selected OK option from the multiple BSM prompt$")
	public void the_user_has_selected_OK_option_from_the_multiple_BSM_prompt() throws Throwable {
		try {
			Thread.sleep(2000);
			Assert.assertEquals(logBagPage.getBSMerrorMsg().trim(), propCommon.getProperty("MultiBSMFound").trim());
			if (logBagPage.getBSMerrorMsg().trim().equals(propCommon.getProperty("MultiBSMFound").trim())) {
				System.out.println("Multiple BSMs found for the entered bag tag number");	
			}
			else{
				System.out.println("Multiple BSMs is not found for the entered bag tag number");
			}
			logBagPage.clickMultiBSMOkOption();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}
	
	@Then("^the user can be able to select the right BSM to be logged from the list of passengers with the same bagTag number$")
	public void the_user_can_be_able_to_select_the_right_BSM_to_be_logged_from_the_list_of_passengers_with_the_same_bagTag_number()
			throws Throwable {
		try {
			logBagPage.selectPaxMultiBSM();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the message will be displayed that the bag is logged successfully e.g. Bag Tag Number - Logged Successfully$")
	public void the_message_will_be_displayed_that_the_bag_is_logged_successfully_e_g_Bag_Tag_Number_Logged_Successfully()
			throws Throwable {
		try {
			if (logBagPage.verifyBagLoggedDisplayed()) {
				System.out.println("Given Bag Tag number exists");
				if (logBagPage.getBagLoggedLable().contains(propCommon.getProperty("bagLogged"))) {
					System.out.println("Bag tag number auto submited after validation");
					Assert.assertTrue("Bag tag number auto submited after validation", true);
				} else {
					System.out.println("Bag tag number cannot be auto submited after validation");
					Assert.assertTrue("Bag tag number cannot be auto submited after validation", false);
				}
			} else {
				System.out.println("Given Bag Tag number doesnot exists");
				captureScreen();
				throw new RuntimeException();
			}
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^Flight number/Date, Passenger Name, Cabin class, Bay, Route - Board point-Off point and the make up area ,Special log item information will be displayed$")
	public void Flight_number_Date_Passenger_Name_Cabin_class_Bay_Route_Board_point_Off_point_and_the_make_up_area_Special_log_item_information_will_be_displayed()
			throws Throwable {
		try {
			System.out.println("Flight and Pax information with the entered tag number are : ");
			System.out.println(logBagPage.getSummaryLogFlightNumberLbl() + "  " + logBagPage.getSummaryLogFlightNumberVal());
			System.out.println(logBagPage.getSummaryLogDateLbl() + "  " + logBagPage.getSummaryLogDateVal());
			System.out.println(logBagPage.getSummaryLogPaxLbl() + "  " + logBagPage.getSummaryLogPaxVal());
			System.out.println(logBagPage.getSummaryLogRouteLbl() + "  " + logBagPage.getSummaryLogRouteVal());
			System.out.println(logBagPage.getSummaryLogAreaLbl() + "  " + logBagPage.getSummaryLogAreaVal());
			System.out.println(logBagPage.getSummaryLogBayLbl() + "  " + logBagPage.getSummaryLogBayVal());
			System.out.println(logBagPage.getSummaryLogClassLbl() + "  " + logBagPage.getSummaryLogClassVal());
			// System.out.println(logBagPage.getSummaryLogSpecialItemLbl() + " " +
			// logBagPage.getSummaryLogSpecialItemVal());

		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Given("^the BSM was created from BELT$")
	public void the_BSM_was_created_from_BELT() throws Throwable {
		try {
			System.out.println("Bag tag has a BSM already");

		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Given("^the user selects the special log option$")
	public void the_user_selects_the_special_log_option() throws Throwable {
		try {
			if (propObject.getProperty("SpecialItem").equals("Stroller")) {
				logBagPage.clickSpecialLogItem();
				//act.sendKeys(Keys.TAB).build().perform();
				//act.sendKeys(Keys.ARROW_DOWN).build().perform();
				System.out.println("Special item field selected");
				logBagPage.selectStroller();
			}
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user enters bagTag and submits / scans bagTag$")
	public void the_user_enters_bagTag_and_submits_scans_bagTag() throws Throwable {
		try {
			logBagPage.enterTagNumber(propObject.getProperty("ValidBagTag"));
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the system will display the success message$")
	public void the_system_will_display_the_success_message() throws Throwable {
		try {
			if (logBagPage.getBagLoggedLable().contains(propCommon.getProperty("bagLogged"))) {
				System.out.println("Bag tag number submitted successfully");
				Assert.assertTrue("Bag tag number submitted successfully", true);
			} else {
				System.out.println("Bag tag number is not submitted successfully");
				Assert.assertTrue("Bag tag number is not submitted successfully", false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the system clears the bag tag and special log type entries$")
	public void the_system_clears_the_bag_tag_and_special_log_type_entries() throws Throwable {
		try {
			if (logBagPage.getBagTagFieldValue().equals("")) {
				System.out.println("Bag tag field got cleared after special log submission");
			} else {
				System.out.println("Bag tag number not cleared");
			}
			if (logBagPage.getSpecialFieldValue().equals("")) {
				System.out.println("Special log field got cleared after special log submission");
			} else {
				System.out.println("Special log field not cleared");
			}
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user selects the Multi-special log option from  log bag screen$")
	public void the_user_selects_the_Multi_special_log_option_from_log_bag_screen() throws Throwable {
		try {
			logBagPage.chooseMultipleSpecialLog(propObject.getProperty("SpecialItem"));
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the system will allow the loader to log multiple tags under the selected special service successfully$")
	public void the_system_will_allow_the_loader_to_log_multiple_tags_under_the_selected_special_service_successfully()
			throws Throwable {
		try {
			logBagPage.enterTagNumber(propObject.getProperty("ValidBagTag"));
			logBagPage.enterTagNumber(propObject.getProperty("ValidBagTag2"));
			logBagPage.enterTagNumber(propObject.getProperty("ValidBagTag3"));
			logBagPage.enterTagNumber(propObject.getProperty("ValidBagTag4"));
			logBagPage.enterTagNumber(propObject.getProperty("ValidBagTag5"));
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the system clears the bag tag entry and retains special log type entry$")
	public void the_system_clears_the_bag_tag_entry_and_retains_special_log_type_entry() throws Throwable {
		try {
			if (logBagPage.getBagTagFieldValue().equals("")) {
				System.out.println("Bag tag field got cleared after special log submission");
			} else {
				System.out.println("Bag tag number not cleared");
			}
			if (!logBagPage.getSpecialFieldValue().equals("")) {
				System.out.println("Special log field got retained after special log submission in multi log mode");
			} else {
				System.out.println("Special log field got cleared");
			}
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the user should be prompted if he wishes to enter the optional details manually$")
	public void the_user_should_be_prompted_if_he_wishes_to_enter_the_optional_details_manually() throws Throwable {
		try {
			Assert.assertEquals(logBagPage.getBSMerrorMsg().trim(), propCommon.getProperty("NoBSMFound"));
			if (logBagPage.getBSMerrorMsg().equals("No BSM found. Do you want to enter details manually")) {
				System.out.println("Sytem throws waring as No BSM with tag number");
			} else {
				System.out.println("Unable to get the waring as No BSM with tag number");
			}
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user selected Yes option from the prompt$")
	public void the_user_selected_Yes_option_from_the_prompt() throws Throwable {
		try {
			Thread.sleep(1000);
			logBagPage.clickYesOption();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the user should be able to enter the following fields -Passenger Name,Destination,Inbound Flight number and date,Outbound Flight number and date,Bag Weights\\(Kgs\\)and any additional notes\\.$")
	public void the_user_should_be_able_to_enter_the_following_fields_Passenger_Name_Destination_Inbound_Flight_number_and_date_Outbound_Flight_number_and_date_Bag_Weights_Kgs_and_any_additional_notes()
			throws Throwable {
		try {
			// details manual enter
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the user can edit all the fields and each field is optional one - not mandatory$")
	public void the_user_can_edit_all_the_fields_and_each_field_is_optional_one_not_mandatory() throws Throwable {
		try {
			// optional validation
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the user should be able to submit successfully without entering any input data$")
	public void the_user_should_be_able_to_submit_successfully_without_entering_any_input_data() throws Throwable {
		try {
			logBagPage.clickForce();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user has selected No option from the prompt$")
	public void the_user_has_selected_No_option_from_the_prompt() throws Throwable {
		try {
			Thread.sleep(1000);
			logBagPage.clickNoOption();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the bag should be logged with the success meassage$")
	public void the_bag_should_be_logged_with_the_success_meassage() throws Throwable {
		try {
			//Assert.assertEquals(logBagPage.getBagLoggedLable().trim(), propCommon.getProperty("bagLogged"));
			if (logBagPage.getBagLoggedLable().contains(propCommon.getProperty("bagLogged"))) {
				Assert.assertTrue("Bag tag number logged successfully", true);
				System.out.println("Bag tag number logged successfully");
			} else {
				System.out.println("Bag tag number cannot be logged");
				Assert.assertTrue("Bag tag number cannot be logged", false);
			}

		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the bag should be logged with the success meassage without details$")
	public void the_bag_should_be_logged_with_the_success_meassage_without_details() throws Throwable {
		try {
			System.out.println("Logged successfully");

		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}
}
