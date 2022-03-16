package com.beltWasla.steps;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.ExtentTest;
//import com.aventstack.extentreports.ExtentTest;
import com.beltWasla.pages.HomeScreen_BELT;
import com.beltWasla.pages.LocationPage_BELT;
import com.beltWasla.pages.LogBagPage_BELT;
import com.beltWasla.pages.RackBagPage;
import com.beltWasla.runners.TestRunner;
import com.beltWasla.setUp.TestContext;
import com.beltWasla.utils.ApplicationLauncher;
import com.beltWasla.utils.Screenshot;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RackBagSteps extends ApplicationLauncher {

	ExtentTest logger;

	int DEFAULT_WAIT_4_PAGE = 15;
	public Actions act = new Actions(driver);
	String thisClassName = getClass().getSimpleName();
	
	TestContext testContext;
	RackBagPage rackBagPage;
	HomeScreen_BELT homePage;
	LocationPage_BELT locationPage;
	LogBagPage_BELT logBagPage;

	public RackBagSteps(TestContext context) { 
		 testContext = context;
		 rackBagPage = testContext.getPageObjectManager().getRackBagPage(); 
		 homePage = testContext.getPageObjectManager().getHomePage(); 
		 locationPage = testContext.getPageObjectManager().getLocationPage(); 
		 logBagPage = testContext.getPageObjectManager().getLogBagPage(); 
	  }
	
	public void captureScreen() {

		Screenshot.takeScreenshot(TestRunner.dateTime, thisClassName, scenarioName);

	}

	@Given("^the user has launched the Rack feature$")
	public void the_user_has_launched_the_Rack_feature() {
		try {
			//Thread.sleep(2000);
			//homePage.clickHamburgerMenu();
			Thread.sleep(2000);
			homePage.clickHamburgerRack();
			Thread.sleep(3000);
			} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}

	}

	@Given("^the store IN is already done$")
	public void the_store_IN_is_already_done() {
		try {
			homePage.clickAddLocationButton();
			locationPage.clickSearchIcon();
			Thread.sleep(2000);
			locationPage.enterSearchLocation(propObject.getProperty("RackBag.StoreIn"));
			locationPage.selectSearchedLocation();
			homePage.clickLogBagIcon();
			logBagPage.enterTagNumber(propObject.getProperty("RackBag.ValidOhdNumber"));
			act.sendKeys(Keys.ENTER).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Given("^the user has selected a location to rack$")
	public void the_user_has_selected_a_location_to_rack() {
		try {
			homePage.clickAddLocationButton();
			locationPage.clickSearchIcon();
			Thread.sleep(3000);
			locationPage.enterSearchLocation(propObject.getProperty("RackBag.StoreRackLocation"));
			locationPage.selectSearchedLocation();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Given("^the user has entered or scanned the valid tag ref number$")
	public void the_user_has_entered_or_scanned_the_valid_tag_ref_number() {
		try {
			rackBagPage.enterTagOhdNumber(propObject.getProperty("RackBag.ValidTagNumber"));
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Given("^the user has entered or scanned the valid OHD ref number$")
	public void the_user_has_entered_or_scanned_the_valid_OHD_ref_number() {
		try {
			Thread.sleep(3000);
			rackBagPage.enterTagOhdNumber(propObject.getProperty("RackBag.ValidOhdNumber"));
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user scans, selects the rack from the list or enters the rack number manually where the bag needs to be racked$")
	public void the_user_scans_selects_the_rack_from_the_list_or_enters_the_rack_number_manually_where_the_bag_needs_to_be_racked() {
		try {
			Thread.sleep(3000);
			rackBagPage.clickselectRack();
			rackBagPage.selectRackDD();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the scanned rack number belongs to the location selected$")
	public void the_scanned_rack_number_belongs_to_the_location_selected() {
		try {
			// rack numbers displayed as per location
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^then submits for available bags to racking$")
	public void then_submits_for_available_bags_to_racking() {
		try {
			rackBagPage.clickSubmit();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the system will show the OHD details and clicking on it will show full details$")
	public void the_system_will_show_the_OHD_details_and_clicking_on_it_will_show_full_details() {
		try {
			rackBagPage.clickOhdResult();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the user will click on Submit to rack$")
	public void the_user_will_click_on_Submit_to_rack() {
		try {
			rackBagPage.clickFinalSubmit();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the system will display Racking done successfully response$")
	public void the_system_will_display_Racking_done_successfully_response() {
		try {
			// Toast response
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user scans or enters the rack number manually which is invalid to the location$")
	public void the_user_scans_or_enters_the_rack_number_manually_which_is_invalid_to_the_location() {
		rackBagPage.enterRackNumber(propObject.getProperty("RackBag.WrongRackNumber"));
	}

	@Given("^the user has entered or scanned the valid tag/OHD ref number$")
	public void the_user_has_entered_or_scanned_the_valid_tag_OHD_ref_number() {
		try {
			Thread.sleep(2000);
			rackBagPage.enterTagOhdNumber(propObject.getProperty("RackBag.ValidOhdNumber"));
			rackBagPage.clickSubmit();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the scanned rack number does not belong to the location selected$")
	public void the_scanned_rack_number_does_not_belong_to_the_location_selected() {
		try {
			// Scanned rack is invalid for selected location
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^when the user submits for racking, the System will display Invalid Rack number response$")
	public void when_the_user_submits_for_racking_the_System_will_display_Invalid_Rack_number_response() {
		try {
			if (rackBagPage.getErrorResponse().equals("")) {
				System.out.println("Error message captured and verified. Error : " + rackBagPage.getErrorResponse());
			} else {
				System.out.println("Error message captured not matching. Error : " + rackBagPage.getErrorResponse());
			}
			// rackBagPage.enterRackNumber(propObject.getProperty("RackBag.RackNumber"));
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user scans or enters the tag/OHD number and searches$")
	public void the_user_scans_or_enters_the_tag_OHD_number_and_searches() {
		try {
			Thread.sleep(3000);
			rackBagPage.enterTagOhdNumber(propObject.getProperty("RackBag.TagWithNoOHD"));
			rackBagPage.clickSubmit();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^No OHD is found for the tag$")
	public void no_OHD_is_found_for_the_tag() {
		try {
			// No OHD available for given tag
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the system will search and if no data found then will display error to the user No OHD exists for the tag number\\. Cannot rack the bag without OHD$")
	public void the_system_will_search_and_if_no_data_found_then_will_display_error_to_the_user_No_OHD_exists_for_the_tag_number_Cannot_rack_the_bag_without_OHD() {
		try {
			Thread.sleep(2000);
			Assert.assertEquals(true, rackBagPage.getErrorResponse().equals(propCommon.getProperty("RackBag.NoOhdError")));
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the bag is not logged in corresponding storage IN$")
	public void the_bag_is_not_logged_in_corresponding_storage_IN() {
		try {
			// Bag not logged under store IN
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user scans or enters the tag/OHD number without store IN and searches$")
	public void the_user_scans_or_enters_the_tag_OHD_number_without_store_IN_and_searches() {
		try {
			Thread.sleep(3000);
			rackBagPage.enterTagOhdNumber(propObject.getProperty("RackBag.OHDWithoutStoreIN"));
			rackBagPage.clickSubmit();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the system will throw a message that Racking allowed only after storage$")
	public void the_system_will_throw_a_message_that_Racking_allowed_only_after_storage() {
		try {
			System.out.println("Error response : "+rackBagPage.getTopErrorMsg());
		//	Assert.assertTrue( rackBagPage.getErrorResponse().equals(propCommon.getProperty("RackBag.StoreInError")));
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the bag is logged in the main store$")
	public void the_bag_is_logged_in_the_main_store() {
		try {
			homePage.clickAddLocationButton();
			locationPage.clickSearchIcon();
			Thread.sleep(2000);
			locationPage.enterSearchLocation(propObject.getProperty("RackBag.MainStoreIn"));
			locationPage.selectSearchedLocation();
			//Thread.sleep(10000);
			homePage.clickLogBagIcon();
			logBagPage.enterTagNumber(propObject.getProperty("RackBag.ValidTagNumber"));
			act.sendKeys(Keys.ENTER).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^there are multiple OHDs mapped to the tag$")
	public void there_are_multiple_OHDs_mapped_to_the_tag() {
		try {
			// Multiple OHD available
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the system will display both the OHD and allow user to select the right one$")
	public void the_system_will_display_both_the_OHD_and_allow_user_to_select_the_right_one() {
		try {
			if (rackBagPage.multiOhdExist()) {
				System.out.println("Multiple OHDs available");
			}else {
				System.out.println("Multipke OHD not available");
				captureScreen();
				throw new RuntimeException();
			}
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^on selection of the right OHD system will display Racking done successfully response$")
	public void on_selection_of_the_right_OHD_system_will_display_Racking_done_successfully_response() {
		try {
			rackBagPage.clickOhdResult();
			rackBagPage.clickFinalSubmit();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}
	
	@When("^OHD is logged main store$")
	public void ohd_is_logged_main_store() {
		try {
			homePage.clickAddLocationButton();
			locationPage.clickSearchIcon();
			Thread.sleep(2000);
			locationPage.enterSearchLocation("MSTR-IN");
			locationPage.selectSearchedLocation();
			//homePage.clickHamburgerMenu();
			homePage.clickHamburgerLogBag();
			logBagPage.enterTagNumber(propObject.getProperty("RackBag.ValidOhdNumber"));
			act.sendKeys(Keys.ENTER).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^user is attempting to rack the bag in the left luggage$")
	public void user_is_attempting_to_rack_the_bag_in_the_left_luggage() {
		try {
			homePage.clickAddLocationButton();
			locationPage.clickSearchIcon();
			locationPage.enterSearchLocation("LEFTLUGG");
			locationPage.selectSearchedLocation();
			//homePage.clickHamburgerMenu();
			homePage.clickHamburgerRack();
			rackBagPage.clickselectRack();
			rackBagPage.selectRackDD();
			rackBagPage.enterTagOhdNumber(propObject.getProperty("RackBag.ValidOhdNumber"));
			rackBagPage.clickSubmit();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the system will throw a message that Racking Location Should be Inside the Store : ABC$")
	public void the_system_will_throw_a_message_that_Racking_Location_Should_be_Inside_the_Store_ABC() {
		try {
			Assert.assertEquals(true, rackBagPage.getErrorResponse().equals(propCommon.getProperty("RackBag.DiffStoreError"))); 
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^ABC can be any location - Customs, Main Store, etc$")
	public void abc_can_be_any_location_Customs_Main_Store_etc() {
		try {
			//
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the OHD is on close status$")
	public void the_OHD_is_on_close_status() {
		try {
			//OHD is already closed
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the bag is being logged in the right location$")
	public void the_bag_is_being_logged_in_the_right_location() {
		try {
			//
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}
	
	@Then("^the system will throw a message  OHD not found$")
	public void the_system_will_throw_a_message_OHD_not_found() throws Throwable {
	   try {
		 //  Assert.assertEquals(true, rackBagPage.getErrorResponse().equals(propCommon.getProperty("RackBag.InvalidOhdError"))) ;
	   }catch(Exception e) {
		   e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
	   }
	}

	@Given("^the location IN the selected storage area is selected$")
	public void the_location_IN_the_selected_storage_area_is_selected() throws Throwable {
		try {
			homePage.clickAddLocationButton();
			locationPage.clickSearchIcon();
			Thread.sleep(3000);
			locationPage.enterSearchLocation("LFTLG-IN");
			locationPage.selectSearchedLocation();
			//homePage.clickHamburgerMenu();
			homePage.clickHamburgerRack();
			rackBagPage.clickselectRack();
			rackBagPage.selectRackDD();
			rackBagPage.enterTagOhdNumber(propObject.getProperty("RackBag.ValidOhdNumber"));
			act.sendKeys(Keys.ENTER).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Given("^Storage OUT action is done$")
	public void storage_OUT_action_is_done() throws Throwable {
		try {
			homePage.clickAddLocationButton();
			locationPage.clickSearchIcon();
			locationPage.enterSearchLocation("LFTLG-OT");
			locationPage.selectSearchedLocation();
			homePage.clickHamburgerMenu();
			homePage.clickHamburgerRack();
			rackBagPage.clickselectRack();
			rackBagPage.selectRackDD();
			rackBagPage.enterTagOhdNumber(propObject.getProperty("RackBag.ValidOhdNumber"));
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user scans or enters the Tag/OHD number in log bag$")
	public void the_user_scans_or_enters_the_Tag_OHD_number_in_log_bag() throws Throwable {
		try {
			homePage.clickHamburgerMenu();
			homePage.clickHamburgerLogBag();
			logBagPage.enterTagNumber(propObject.getProperty("RackBag.ValidOhdNumber"));
			act.sendKeys(Keys.ENTER).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^all the other pre-defined negative conditions are not met$")
	public void all_the_other_pre_defined_negative_conditions_are_not_met() throws Throwable {
		try {
			// No negative scenario
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
		
	}

	@Then("^the System will allow user to log the bag/OHD outside the storage area display xxxxxxxxx - successfully Logged\\. Where xxx is a valid Tag or OHD$")
	public void the_System_will_allow_user_to_log_the_bag_OHD_outside_the_storage_area_display_xxxxxxxxx_successfully_Logged_Where_xxx_is_a_valid_Tag_or_OHD() throws Throwable {
		try {
			// Success message
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}
	
	@When("^the user scans or enters the tag/OHD number with multiple OHD and searches$")
	public void the_user_scans_or_enters_the_tag_OHD_number_with_multiple_OHD_and_searches() throws Throwable {
		try {
			rackBagPage.enterTagOhdNumber(propObject.getProperty("RackBag.ValidMultiOhd"));
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	
}
