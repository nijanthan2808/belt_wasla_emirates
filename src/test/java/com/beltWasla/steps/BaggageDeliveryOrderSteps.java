package com.beltWasla.steps;

import org.junit.Assert;
import org.openqa.selenium.Keys;
//import org.testng.Assert;
import org.openqa.selenium.interactions.Actions;

import com.beltWasla.pages.BaggageDeliveryOptionPage;
import com.beltWasla.pages.HomeScreen_BELT;
import com.beltWasla.pages.LocationPage_BELT;
//import com.relevantcodes.extentreports.ExtentTest;
import com.beltWasla.runners.TestRunner;
import com.beltWasla.setUp.TestContext;
import com.beltWasla.utils.ApplicationLauncher;
import com.beltWasla.utils.Screenshot;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BaggageDeliveryOrderSteps extends ApplicationLauncher {

	TestContext testContext;
	BaggageDeliveryOptionPage bdoPage;
	HomeScreen_BELT homePage;
	LocationPage_BELT locationPage;
	public Actions act = new Actions(driver);

	public BaggageDeliveryOrderSteps(TestContext context) {
		testContext = context;
		bdoPage = testContext.getPageObjectManager().getBdoPage();
		homePage = testContext.getPageObjectManager().getHomePage();
		locationPage = testContext.getPageObjectManager().getLocationPage();
	}

	int DEFAULT_WAIT_4_PAGE = 15;

	String thisClassName = getClass().getSimpleName();

	public void captureScreen() {

		Screenshot.takeScreenshot(TestRunner.dateTime, this.thisClassName, scenarioName);

	}

	@Given("^the user hasn't selected a location yet$")
	public void the_user_hasn_t_selected_a_location_yet() {
		try {
			// homePage.getAddLocationLable().equals("Add location");

			Assert.assertEquals(true, propCommon.getProperty("Home.AddLocationLable").equals(homePage.getAddLocationLable()));
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Given("^the user has access to Baggage Delivery Order feature and icon is available in the home screen$")
	public void the_user_has_access_to_Baggage_Delivery_Order_feature_and_icon_is_available_in_the_home_screen() {
		try {

			Assert.assertTrue(homePage.bdoIconExist());
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user launches the BDO app$")
	public void the_user_launches_the_BDO_app()  {
		try {

			homePage.clickBdoIcon();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user clicks on th icon and opens the feature$")
	public void the_user_clicks_on_th_icon_and_opens_the_feature() {
		try {

			homePage.clickBdoIcon();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the user will be prompted to select the location first$")
	public void the_user_will_be_prompted_to_select_the_location_first() {
		try {

			Assert.assertTrue(homePage.locationPromptAvailable());
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the user will not be prompted to select the location$")
	public void the_user_will_not_be_prompted_to_select_the_location() {
		try {

			Assert.assertEquals(true, propCommon.getProperty("BDO.PageTitle").equals(bdoPage.verifyBdoPageTitle()));
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the feature will be launched$")
	public void the_feature_will_be_launched() {
		try {

			Assert.assertEquals(true, propCommon.getProperty("BDO.PageTitle").equals(bdoPage.verifyBdoPageTitle()));
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Given("^User has access to the BDO Feature$")
	public void User_has_access_to_the_BDO_Feature() {
		try {

			Assert.assertTrue(homePage.bdoIconExist());
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user launches the BDO feature$")
	public void the_user_launches_the_BDO_feature() {
		try {

			homePage.clickBdoIcon();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the system will successfully open the BDO page$")
	public void the_system_will_successfully_open_the_BDO_page() {
		try {

			Assert.assertEquals(true, propCommon.getProperty("BDO.PageTitle").equals(bdoPage.verifyBdoPageTitle()));
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^with the option for the user, based on given access, to launch Log bag for BDO, Vendor Delivery and Pax Collection$")
	public void with_the_option_for_the_user_based_on_given_access_to_launch_Log_bag_for_BDO_Vendor_Delivery_and_Pax_Collection() {
		try {

			Assert.assertTrue(bdoPage.bdoLogBagAvailablity());

			Assert.assertTrue(bdoPage.bdoVendorDelAvailablity());

			Assert.assertTrue(bdoPage.bdoPaxCollAvailablity());
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Given("^user has selected a location outside BDO$")
	public void user_has_selected_a_location_outside_BDO() {
		try {

			homePage.clickAddLocationButton();

			locationPage.clickSearchIcon();

			locationPage.enterSearchLocation(propObject.getProperty("BDO.LocationOutside"));

			locationPage.selectSearchedLocation();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Given("^the location selected is not one of the following -BPA IN, BPA OUT, LFT LUGG IN, LFT LUGG OUT$")
	public void the_location_selected_is_not_one_of_the_following_BPA_IN_BPA_OUT_LFT_LUGG_IN_LFT_LUGG_OUT() {
		try {

			Assert.assertEquals(true, propObject.getProperty("BDO.LocationOutside").equals(homePage.getSelectedLocationData()));
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Given("^the user navigated to Log bag option$")
	public void the_user_navigated_to_Log_bag_option() {
		try {
			Thread.sleep(2000);
			bdoPage.openLogBagBDO();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user scans or enters the BDO Tag/ Bag Tag / OHD / AHL ref number and submits the transaction$")
	public void the_user_scans_or_enters_the_BDO_Tag_Bag_Tag_OHD_AHL_ref_number_and_submits_the_transaction() {
		try {

			bdoPage.enterTagBdoLog(propObject.getProperty("BDO.ValidBagTagNumber1"));
			bdoPage.logBagClickSubmit();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the system will validate the selected location is one of the following BPA IN, BPA OUT, LFT-LUGG IN, LFT-LUGG OUT$")
	public void the_system_will_validate_the_selected_location_is_one_of_the_following_BPA_IN_BPA_OUT_LFT_LUGG_IN_LFT_LUGG_OUT() {
		try {
			// backend validation
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^if not, then system will display a error message$")
	public void if_not_then_system_will_display_a_error_message() {
		try {
			Thread.sleep(1000);
			Assert.assertEquals(true, propCommon.getProperty("BDO.LocationError").equals(bdoPage.getErrorMEssage()));
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Given("^user has selected any BDO location$")
	public void user_has_selected_any_BDO_location() {
		try {

			homePage.clickAddLocationButton();

			locationPage.clickSearchIcon();

			locationPage.enterSearchLocation(propObject.getProperty("BDO.LocationInside"));

			locationPage.selectSearchedLocation();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user scans or enters empty tag number$")
	public void the_user_scans_or_enters_empty_tag_number() {
		try {
			bdoPage.enterTagBdoLog("");
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the submit button will be disabled$")
	public void the_submit_button_will_be_disabled() {
		try {
			Assert.assertEquals(false, bdoPage.logBagSubmitButtonEnabled());
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Given("^user has selected location BPA IN$")
	public void user_has_selected_location_BPA_IN() {
		try {
			homePage.clickAddLocationButton();
			locationPage.clickSearchIcon();
			Thread.sleep(2000);
			locationPage.enterSearchLocation(propObject.getProperty("BDO.BPAIN"));
			locationPage.selectSearchedLocation();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Given("^BDo created at EK store$")
	public void bdo_created_at_EK_store() {
		try {
			//
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Given("^the user is attempting to log a bag$")
	public void the_user_is_attempting_to_log_a_bag() {
		try {
			homePage.clickBdoIcon();
			bdoPage.openLogBagBDO();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Given("^BPA IN is not done$")
	public void bpa_IN_is_not_done() {
		try {
			//
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Given("^user selects Is damaged optional$")
	public void user_selects_Is_damaged_optional() {
		try {
			Thread.sleep(2000);
			bdoPage.selectDamagedOption();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Given("^option to enter remarks is enabled and mandated$")
	public void option_to_enter_remarks_is_enabled_and_mandated() {
		try {
			bdoPage.enterDamagedRemarks(propObject.getProperty("BDO.DamageRemarks"));
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^user enters valid tag number for log bag$")
	public void user_enters_valid_tag_number_for_log_bag() {
		try {
			bdoPage.enterTagBdoLog(propObject.getProperty("BDO.ValidBagTagNumber1"));
			} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^user clicks on log bag SUBMIT$")
	public void user_clicks_on_log_bag_SUBMIT() {
		try {
			Thread.sleep(2000);
			bdoPage.logBagClickSubmit();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^system returns successful message Bag Logged successfully along with the count of total bags and scanned bags$")
	public void system_returns_successful_message_Bag_Logged_successfully_along_with_the_count_of_total_bags_and_scanned_bags() {
		try {
			//Thread.sleep(10000);
			// success message
			 System.out.println(" Error : " + bdoPage.getSuccessToastMsg());
			 Assert.assertEquals(true, bdoPage.getSuccessToastMsg().contains(propCommon.getProperty("BDO.SucessMsgBPAIN")));
			
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Given("^BDo created at LL store$")
	public void bdo_created_at_LL_store() {
		try {
			//
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^user enters valid tag number created at LL store for log bag$")
	public void user_enters_valid_tag_number_created_at_LL_store_for_log_bag() {
		try {
			bdoPage.enterTagBdoLog(propObject.getProperty("BDO.ValidBagTagLL"));
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^system returns error message that BPA IN cannot be done for BDO created at Left Luggage\\.$")
	public void system_returns_error_message_that_BPA_IN_cannot_be_done_for_BDO_created_at_Left_Luggage() {
		try {
			Thread.sleep(5000);
			System.out.println("Error Message : " + bdoPage.getErrorMEssage());
			Assert.assertEquals(true, propCommon.getProperty("BDO.BpaInErrorBdoLL").equals(bdoPage.getErrorMEssage()));
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user is logs a bag that already logged in BPA IN$")
	public void the_user_is_logs_a_bag_that_already_logged_in_BPA_IN() {
		try {
			Thread.sleep(5000);
			bdoPage.enterTagBdoLog(propObject.getProperty("BDO.BpaInDone"));
			bdoPage.logBagClickSubmit();
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the system will display Bag already logged under BPA IN$")
	public void the_system_will_display_Bag_already_logged_under_BPA_IN() {
		try {
			Thread.sleep(5000);
			System.out.println("Error Message : " + bdoPage.getErrorMEssage() );
			Assert.assertEquals(true,propCommon.getProperty("BDO.BpaInAlreadyDoneError").equals(bdoPage.getErrorMEssage()));
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user scans or enters the BDO Tag number that is invalid$")
	public void the_user_scans_or_enters_the_BDO_Tag_number_that_is_invalid() {
		try {
		//	Thread.sleep(5000);
			bdoPage.enterTagBdoLog(propObject.getProperty("BDO.InvalidBagTagNumber"));
		//	Thread.sleep(5000);
			bdoPage.logBagClickSubmit();
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the system will display NO BDO found for given input data - BDO tag number$")
	public void the_system_will_display_NO_BDO_found_for_given_input_data_BDO_tag_number() {
		try {
			//Thread.sleep(50000);
			Assert.assertEquals(true, propCommon.getProperty("BDO.InvalidBdoTagError").equals(bdoPage.getErrorMEssage()));
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Given("^user has selected location Left Luggage OUT$")
	public void user_has_selected_location_Left_Luggage_OUT() {
		try {
			homePage.clickAddLocationButton();
			locationPage.clickSearchIcon();
			Thread.sleep(2000);
			locationPage.enterSearchLocation(propObject.getProperty("BDO.LLOUT"));
			locationPage.selectSearchedLocation();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Given("^user has launched the PAX Collection$")
	public void user_has_launched_the_PAX_Collection() {
		try {
			homePage.clickBdoIcon();
			bdoPage.openPaxCollection();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user scans or enters the BDO Reference in Passive$")
	public void the_user_scans_or_enters_the_BDO_Reference_in_Passive() {
		try {
			bdoPage.enterBdoRefNumber("BDO.PassiveBDO");
			act.sendKeys(Keys.ENTER).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^system should not display the BDO details and display message No Record found for the BDO Ref number$")
	public void system_should_not_display_the_BDO_details_and_display_message_No_Record_found_for_the_BDO_Ref_number() {
		try {
			Assert.assertEquals(true, propCommon.getProperty("BDO.PassiveBDODeliveryError").equals(bdoPage.getErrorMEssage()));
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Given("^the BDO is active and Left luggae out done for all the bags$")
	public void the_BDO_is_active_and_Left_luggae_out_done_for_all_the_bags() {
		try {
			//
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Given("^the user scans or enters the BDO Reference and selects bags$")
	public void the_user_scans_or_enters_the_BDO_Reference_and_selects_bags() {
		try {
			Thread.sleep(2000);
			bdoPage.enterBdoRefNumber(propObject.getProperty("BDO.ValidBdoRefNumber"));
			act.sendKeys(Keys.ENTER).build().perform();
			Thread.sleep(2000);
			bdoPage.selectAllBags();
			bdoPage.clickStepNext();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Given("^user entered required details of the Pax/Other and clicks next$")
	public void user_entered_required_details_of_the_Pax_Other_and_clicks_next() {
		try {
			bdoPage.enterBdoDeliveryName(propObject.getProperty("BDO.ValidName"));
			Thread.sleep(2000);
			bdoPage.enterBdoDeliveryPhone(propObject.getProperty("BDO.ValidPhone"));
			Thread.sleep(2000);
			bdoPage.clickBdoDeliveryIdType();
			bdoPage.selectUaeIdType();
			bdoPage.enterBdoIdNumberField(propObject.getProperty("BDO.ValidIdNumber"));
			bdoPage.clickStepNext();
			
			//Thread.sleep(10000);
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user clicks on Terms and Conditions in signature capture screen$")
	public void the_user_clicks_on_Terms_and_Conditions_in_signature_capture_screen() {
		try {
			bdoPage.clickTerms();
			
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the user will be shown the terms and conditions In English and Arabic with agree button$")
	public void the_user_will_be_shown_the_terms_and_conditions_In_English_and_Arabic_with_agree_button() {
		try {
			System.out.println("Term 1 : " + bdoPage.getTermsAndCondition1());
			System.out.println("Term 2 : " + bdoPage.getTermsAndCondition2());
			Assert.assertEquals(true, propCommon.getProperty("BDO.Term1").equals(bdoPage.getTermsAndCondition1()));
			Assert.assertEquals(true, propCommon.getProperty("BDO.Term2").equals(bdoPage.getTermsAndCondition2()));
			bdoPage.clickAgree();
			Assert.assertEquals(true, bdoPage.checkboxSelectStatus());
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user signs and clicks on clear button$")
	public void the_user_signs_and_clicks_on_clear_button() {
		try {
			bdoPage.clickTermsCheckBox();
			Thread.sleep(10000);
			Assert.assertEquals(false, bdoPage.deliverySubmitButtonEnabled());
			bdoPage.captureSign();
			Thread.sleep(10000);
			Assert.assertEquals(true, bdoPage.deliverySubmitButtonEnabled());
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^clicking on it should clear off the signature on the panel$")
	public void clicking_on_it_should_clear_off_the_signature_on_the_panel() {
		try {
			bdoPage.clickClear();
			Assert.assertEquals(false, bdoPage.deliverySubmitButtonEnabled());
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user launches the Pax collection screen$")
	public void the_user_launches_the_Pax_collection_screen() {
		try {
			bdoPage.openPaxCollection();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the system will default to Left Luggage OUT as collection location$")
	public void the_system_will_default_to_Left_Luggage_OUT_as_collection_location() {
		try {
			Assert.assertEquals(true, propCommon.getProperty("BDO.PaxColDefaultLocation").equals(bdoPage.getSelectedLocation()));
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Given("^the BDO is active and Left luggae out not done for any of the bags$")
	public void the_BDO_is_active_and_Left_luggae_out_not_done_for_any_of_the_bags() {
		try {
			//
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^user signs and accepts terms and clicks next$")
	public void user_signs_and_accepts_terms_and_clicks_next() {
		try {
			bdoPage.clickTermsCheckBox();
			bdoPage.captureSign();
			bdoPage.deliveryClickSubmit();
			
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^system will display an error BDO delivery failed for List BDO tag nbrs$")
	public void system_will_display_an_error_BDO_delivery_failed_for_List_BDO_tag_nbrs() {
		try {
			Thread.sleep(10000);
			System.out.println("Error Message : " + bdoPage.getErrorMEssage());
			Assert.assertEquals(true, bdoPage.getErrorMEssage().contains(propCommon.getProperty("BDO.DeliveryFailedError")));
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^user didnot enter required fields and clicks next$")
	public void user_didnot_enter_required_fields_and_clicks_next() {
		try {
			bdoPage.clickStepNext();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the system will validate and throw errors for manatory fields$")
	public void the_system_will_validate_and_throw_errors_for_manatory_fields() {
		try {
			Assert.assertEquals(true, propCommon.getProperty("BDO.NameError").equals(bdoPage.getNameErrorHelper()));
			Assert.assertEquals(true, propCommon.getProperty("BDO.PhoneError").equals(bdoPage.getPhoneErrorHelper()));
			Assert.assertEquals(true, propCommon.getProperty("BDO.IdNumberError").equals(bdoPage.getIdNumberErrorHelper()));
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user scans or enters the BDO Reference that is already delivered$")
	public void the_user_scans_or_enters_the_BDO_Reference_that_is_already_delivered() {
		try {
			bdoPage.enterBdoRefNumber(propObject.getProperty("BDO.AlreadyDeliveredBDO"));
			act.sendKeys(Keys.ENTER).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^system will display bag details as delivery status as Y$")
	public void system_will_display_bag_details_as_delivery_status_as_Y() {
		try {
			Assert.assertEquals(true, bdoPage.getBagDeliveryStatus().equals(propCommon.getProperty("BDO.DeliveredBagStatus")));
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Given("^user has selected location BPA OUT$")
	public void user_has_selected_location_BPA_OUT() {
		try {
			homePage.clickAddLocationButton();
			locationPage.clickSearchIcon();
			Thread.sleep(2000);
			locationPage.enterSearchLocation(propObject.getProperty("BDO.BPAOUT"));
			locationPage.selectSearchedLocation();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Given("^bag has already been scanned at BPA IN area$")
	public void bag_has_already_been_scanned_at_BPA_IN_area() {
		try {
			//
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Given("^user has launched BDO log bag$")
	public void user_has_launched_BDO_log_bag() {
		try {
			Thread.sleep(3000);
			bdoPage.openLogBagBDO();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user scans or enters the BDO Bag Tag number in BPA OUT area$")
	public void the_user_scans_or_enters_the_BDO_Bag_Tag_number_in_BPA_OUT_area() {
		try {
			bdoPage.enterTagBdoLog(propObject.getProperty("BDO.ValidTagBpaOut"));
			bdoPage.logBagClickSubmit();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^BPA out is not already done$")
	public void bpa_out_is_not_already_done() {
		try {
			//
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the system will display success message BDO logged successfully$")
	public void the_system_will_display_success_message_BDO_logged_successfully() {
		try {
			//
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Given("^the bag is Passive$")
	public void the_bag_is_Passive() {
		try {
			//
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user scans or enters the BDO bag tag in passive status$")
	public void the_user_scans_or_enters_the_BDO_bag_tag_in_passive_status() {
		try {
			bdoPage.enterTagBdoLog(propObject.getProperty("BDO.PassiveBagBPAOUT"));
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the system will display Operation not allowed BDO not active$")
	public void the_system_will_display_Operation_not_allowed_BDO_not_active() {
		try {
			Thread.sleep(5000);
			System.out.println("Error Message : " + bdoPage.getErrorMEssage());
			Assert.assertEquals(true, propCommon.getProperty("BDO.PassiveBdoError").equals(bdoPage.getErrorMEssage()));
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user scans or enters the BDO Bag Tag that is pending for approval$")
	public void the_user_scans_or_enters_the_BDO_Bag_Tag_that_is_pending_for_approval() {
		try {
			bdoPage.enterTagBdoLog(propObject.getProperty("BDO.BdoPendingApprovalEK"));
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the system will display Operation cannot be performed for not approved urgent BDO$")
	public void the_system_will_display_Operation_cannot_be_performed_for_not_approved_urgent_BDO() {
		try {
			Thread.sleep(5000);
			System.out.println("Error Message : " + bdoPage.getErrorMEssage());;
			Assert.assertEquals(true, propCommon.getProperty("BDO.UrgentBdoError").equals(bdoPage.getErrorMEssage()));
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user scans or enters the BDO Bag Tag created at Left Luggage and submits$")
	public void the_user_scans_or_enters_the_BDO_Bag_Tag_created_at_Left_Luggage_and_submits() {
		try {
			bdoPage.enterTagBdoLog(propObject.getProperty("BDO.CreatedAtLL"));
			bdoPage.logBagClickSubmit();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^system returns error message that BPA OUT cannot be done for BDO created at Left Luggage$")
	public void system_returns_error_message_that_BPA_OUT_cannot_be_done_for_BDO_created_at_Left_Luggage() {
		try {
			Thread.sleep(5000);
			System.out.println("Error Message : " + bdoPage.getErrorMEssage() );
			Assert.assertEquals(true, propCommon.getProperty("BDO.CreatedAtLLError").equals(bdoPage.getErrorMEssage()));
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user scans or enters the BDO Bag Tag that already logged under BPA OUT and submits$")
	public void the_user_scans_or_enters_the_BDO_Bag_Tag_that_already_logged_under_BPA_OUT_and_submits() {
		try {
			bdoPage.enterTagBdoLog(propObject.getProperty("BDO.BpaOutAlreadyDone"));
			bdoPage.logBagClickSubmit();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^system returns error message Bag already logged under BPA OUT$")
	public void system_returns_error_message_Bag_already_logged_under_BPA_OUT() {
		try {
			Thread.sleep(5000);
			System.out.println("Error Message : " + bdoPage.getErrorMEssage() );
			Assert.assertEquals(true, propCommon.getProperty("BDO.BpaOutDoneError").equals(bdoPage.getErrorMEssage()));
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Given("^user has selected location Left Luggage IN$")
	public void user_has_selected_location_Left_Luggage_IN() {
		try {
			homePage.clickAddLocationButton();
			locationPage.clickSearchIcon();
			Thread.sleep(2000);
			locationPage.enterSearchLocation(propObject.getProperty("BDO.LLIN"));
			locationPage.selectSearchedLocation();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Given("^the user scans or enters the BDO Bag Tag for Damage mandate$")
	public void the_user_scans_or_enters_the_BDO_Bag_Tag_for_Damage_mandate() {
		try {
			bdoPage.enterTagBdoLog(propObject.getProperty("BDO.DamageTag"));
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^user selects Is damaged checkbox$")
	public void user_selects_Is_damaged_checkbox() {
		try {
			bdoPage.selectDamagedOption();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^clicks on submit without entering comments$")
	public void clicks_on_submit_without_entering_comments() {
		try {
			bdoPage.logBagClickSubmit();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^system will thow error message as Enter the damage remarks$")
	public void system_will_thow_error_message_as_Enter_the_damage_remarks() {
		try {
			System.out.println("Error Message : " + bdoPage.getErrorMEssage());
			Assert.assertEquals(true, propCommon.getProperty("BDO.DamageMandateError").equals(bdoPage.getErrorMEssage()));
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Given("^Left Luggage IN is not done$")
	public void left_Luggage_IN_is_not_done() {
		try {
			// Bag created at LL store and LL IN is not done yet
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user scans or enters the BDO Bag Tag number created at LL$")
	public void the_user_scans_or_enters_the_BDO_Bag_Tag_number_created_at_LL() {
		try {
			Thread.sleep(3000);
			bdoPage.enterTagBdoLog(propObject.getProperty("BDO.ValidBagLL1"));
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^system returns successful message Bag Logged successfully along with the count of total bags and scanned bags at LL IN$")
	public void system_returns_successful_message_Bag_Logged_successfullyalong_with_the_count_of_total_bags_and_scanned_bags_at_LL_IN() {
		try {
			// Success message
			System.out.println("Success messsage : " + bdoPage.getSuccessToastMsg());
			 Assert.assertEquals(true, bdoPage.getSuccessToastMsg().contains(propCommon.getProperty("BDO.SucessMsgLLIN")));
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user scans or enters the BDO Bag Tag number created at LL and Left Luggage IN is already done$")
	public void the_user_scans_or_enters_the_BDO_Bag_Tag_number_created_at_LL_and_Left_Luggage_IN_is_already_done() {
		try {
			bdoPage.enterTagBdoLog(propObject.getProperty("BDO.AlreadyLoggedAtLLIN"));
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the system will display Bag already logged under Left Luggage in$")
	public void the_system_will_display_Bag_already_logged_under_Left_Luggage_in() {
		try {
			Thread.sleep(5000);
			System.out.println("Error Message : " + bdoPage.getErrorMEssage() );
			Assert.assertEquals(true, propCommon.getProperty("BDO.LLInAlreadyDoneError").equals(bdoPage.getErrorMEssage()));
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user scans or enters the BDO Bag Tag number created at EK store and custom scan is not yet done$")
	public void the_user_scans_or_enters_the_BDO_Bag_Tag_number_created_at_EK_store_and_custom_scan_is_not_yet_done() {
		try {
			bdoPage.enterTagBdoLog(propObject.getProperty("BDO.EKCreatedCusScanNotDone"));
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^system will display error as Left Luggage IN allowed only after Custom Scan$")
	public void system_will_display_error_as_Left_Luggage_IN_allowed_only_after_Custom_Scan() {
		try {
			Thread.sleep(5000);
			System.out.println("Error Message : " + bdoPage.getErrorMEssage() );
			Assert.assertEquals(true, propCommon.getProperty("BDO.CustScanNotDoneError").equals(bdoPage.getErrorMEssage()));
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Given("^Left Luggage out is not already done$")
	public void left_Luggage_out_is_not_already_done() {
		try {
			// LL out not done
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user scans or enters the BDO Bag Tag that Left Luggage IN already done$")
	public void the_user_scans_or_enters_the_BDO_Bag_Tag_that_Left_Luggage_IN_already_done() {
		try {
			bdoPage.enterTagBdoLog(propObject.getProperty("BDO.ValidTagLLOut"));
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user scans or enters the BDO Bag Tag created at LL and LL IN not done$")
	public void the_user_scans_or_enters_the_BDO_Bag_Tag_created_at_LL_and_LL_IN_not_done() {
		try {
			bdoPage.enterTagBdoLog(propObject.getProperty("BDO.CreatedAtLLPassive"));
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user scans or enters the BDO Bag Tag that Left Luggage out is already done$")
	public void the_user_scans_or_enters_the_BDO_Bag_Tag_that_Left_Luggage_out_is_already_done() {
		try {
			bdoPage.enterTagBdoLog(propObject.getProperty("BDO.LLOutAlreadyDone"));
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the system will throw error as Bag already logged under Left Luggage OUT$")
	public void the_system_will_throw_error_as_Bag_already_logged_under_Left_Luggage_OUT() {
		try {
			Thread.sleep(5000);
			System.out.println("Error Message : " + bdoPage.getErrorMEssage() );
			Assert.assertEquals(true, propCommon.getProperty("BDO.LLOutDoneError").equals(bdoPage.getErrorMEssage()));
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Given("^user launches Vendor delivery$")
	public void user_launches_Vendor_delivery() {
		try {
			bdoPage.openVendorDelivery();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Given("^the user scans or enters the BDO Reference number for partial delivery$")
	public void the_user_scans_or_enters_the_BDO_Reference_number_for_partial_delivery() {
		try {
			bdoPage.enterBdoRefNumber(propObject.getProperty("BDO.RefPartialVenDel"));
			act.sendKeys(Keys.ENTER).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user selects bags to be delivered and submits$")
	public void the_user_selects_bags_to_be_delivered_and_submits() {
		try {
			bdoPage.selectFirstBag();
			bdoPage.clickStepNext();
			
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^system will mark only the successfully delivered bags as Y$")
	public void system_will_mark_only_the_successfully_delivered_bags_as_Y() {
		try {
			Assert.assertEquals(true, bdoPage.getBagDeliveryStatus().equals("Y"));
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Given("^the user scans or enters the BDO Reference number for full delivery$")
	public void the_user_scans_or_enters_the_BDO_Reference_number_for_full_delivery() {
		try {
			bdoPage.enterBdoRefNumber(propObject.getProperty("BDO.RefFullVenDel"));
			act.sendKeys(Keys.ENTER).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user selects all bags to deliver and submits$")
	public void the_user_selects_all_bags_to_deliver_and_submits() {
		try {
			Thread.sleep(2000);
			bdoPage.selectAllBags();
			bdoPage.clickStepNext();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^system will mark all the selected and successfully delivered bags as Y$")
	public void system_will_mark_all_the_selected_and_successfully_delivered_bags_as_Y() {
		try {
			Assert.assertEquals(true, bdoPage.getBagDeliveryStatus().equals("Y"));
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

}
