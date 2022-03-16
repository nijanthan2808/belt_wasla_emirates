package com.beltWasla.steps;

import org.junit.Assert;
import org.openqa.selenium.Keys;
//import org.testng.Assert;
import org.openqa.selenium.interactions.Actions;

//import com.aventstack.extentreports.ExtentTest;
import com.relevantcodes.extentreports.ExtentTest;
import com.beltWasla.pages.HomeScreen_BELT;
import com.beltWasla.pages.LeftLuggagePage;
import com.beltWasla.runners.TestRunner;
import com.beltWasla.setUp.TestContext;
import com.beltWasla.utils.ApplicationLauncher;
import com.beltWasla.utils.Screenshot;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LeftLuggageSteps extends ApplicationLauncher {

	ExtentTest logger;

	int DEFAULT_WAIT_4_PAGE = 15;
	String thisClassName = getClass().getSimpleName();
	public Actions act = new Actions(driver);
	public void captureScreen() {

		Screenshot.takeScreenshot(TestRunner.dateTime, thisClassName, scenarioName);

	}

	TestContext testContext;
	LeftLuggagePage leftLuggagePage;
	HomeScreen_BELT homePage;

	public LeftLuggageSteps(TestContext context) {
		
		testContext = context;
		leftLuggagePage = testContext.getPageObjectManager().getLeftLuggagePage();
		homePage = testContext.getPageObjectManager().getHomePage();
	}

	@Given("^user has selected the left luggage location$")
	public void user_has_selected_the_left_luggage_location() {
		try {
			// location selected by default
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Given("^User has access to the Left Luggage Feature$")
	public void user_has_access_to_the_Left_Luggage_Feature() {
		try {
			homePage.clickLLicon();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}

	}

	@Given("^left Luggage record already exists in WASLA Desktop$")
	public void left_Luggage_record_already_exists_in_WASLA_Desktop() {
		try {
			// Left luggage created
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Given("^the user has launched the Deposit feature from the Left Luggage feature page$")
	public void the_user_has_launched_the_Deposit_feature_from_the_Left_Luggage_feature_page() {
		try {
			leftLuggagePage.clickDepositLL();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Given("^the user is attempting to scan or manually enter or select a receipt number from the available list$")
	public void the_user_is_attempting_to_scan_or_manually_enter_or_select_a_receipt_number_from_the_available_list() {
		try {
			Thread.sleep(3000);
			leftLuggagePage.enterReceiptDeposit(propObject.getProperty("LL.ValidDepositReceipt"));
			// leftLuggagePage.enterReceiptDeposit("0");
			// act.sendKeys(Keys.BACK_SPACE).build().perform();
			// leftLuggagePage.enterReceiptDeposit(propObject.getProperty("LL.ValidDepositReceipt"));
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user selects the receipt number$")
	public void the_user_selects_the_receipt_number() {
		try {
			leftLuggagePage.selectDepositReceipt();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the system will display the single receipt number$")
	public void the_system_will_display_the_single_receipt_number() {
		try {
			// Receipt selected and goes to signature screen
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^allow the user to select the receipt for which bag needs to accepted for depositing$")
	public void allow_the_user_to_select_the_receipt_for_which_bag_needs_to_accepted_for_depositing() {
		try {
			// Receipt selected and goes to signature screen
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^system will display the signature screen where the passenger can sign to accept the terms and conditions$")
	public void system_will_display_the_signature_screen_where_the_passenger_can_sign_to_accept_the_terms_and_conditions() {
		try {
			leftLuggagePage.sign();
			Thread.sleep(3000);
			leftLuggagePage.clickAcceptTerms();
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^system will successfully save the signature when Submitting this information$")
	public void system_will_successfully_save_the_signature_when_Submitting_this_information() {
		try {
			leftLuggagePage.clickSubmit();
			// Success message
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the passenger should be able to clear the signature$")
	public void the_passenger_should_be_able_to_clear_the_signature() {
		try {
			if (leftLuggagePage.submitButtonStatus()) {
				leftLuggagePage.clickClear();
				if (leftLuggagePage.submitButtonStatus()) {
					// Sign not cleared
					captureScreen();
					throw new RuntimeException();
				} else {
					// Sign cleared successfully
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Given("^the user is attempting to scan or manually enter a invalid receipt number$")
	public void the_user_is_attempting_to_scan_or_manually_enter_a_invalid_receipt_number() {
		try {
			leftLuggagePage.enterReceiptDeposit(propObject.getProperty("LL.InvalidDepositReceipt"));
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^if there are no receipts found or if the receipts are found but the status is closed$")
	public void if_there_are_no_receipts_found_or_if_the_receipts_are_found_but_the_status_is_closed() {
		try {
			// No receipt found
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the system will display No Open Left Luggage Records found$")
	public void the_system_will_display_No_Open_Left_Luggage_Records_found() {
		try {
			leftLuggagePage.getFullErrorMsg();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Given("^the bag has already been deposited$")
	public void the_bag_has_already_been_deposited() {
		try {
			// Bag deposited
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user has launched the racking feature from the Left Luggage feature page$")
	public void the_user_has_launched_the_racking_feature_from_the_Left_Luggage_feature_page() {
		try {
			Thread.sleep(3000);
			leftLuggagePage.clickRackingLL();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^user scans or enters or selects the rack number from the list$")
	public void user_scans_or_enters_or_selects_the_rack_number_from_the_list() {
		try {
			Thread.sleep(3000);
			leftLuggagePage.clickRackField();
			leftLuggagePage.enterRackNumberSearch(propObject.getProperty("LL.RackNumber"));
			leftLuggagePage.selectFirstRack();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user is scanning or manually entering the left luggage tag number for racking$")
	public void the_user_is_scanning_or_manually_entering_the_left_luggage_tag_number_for_racking() throws Throwable {
		try {
			Thread.sleep(3000);
			leftLuggagePage.enterTagToRack(propObject.getProperty("LL.TagToRack1"));
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user is scanning or manually entering all the left luggage tag number for racking$")
	public void the_user_is_scanning_or_manually_entering_all_the_left_luggage_tag_number_for_racking()
			throws Throwable {
		try {
			Thread.sleep(3000);
			leftLuggagePage.clickRackField();
			leftLuggagePage.enterRackNumberSearch(propObject.getProperty("LL.RackNumber"));
			leftLuggagePage.selectFirstRack();
			Thread.sleep(3000);
			leftLuggagePage.enterTagToRack(propObject.getProperty("LL.TagToRack2"));
			leftLuggagePage.clickRackingSubmit();
			leftLuggagePage.clickRackField();
			leftLuggagePage.enterRackNumberSearch(propObject.getProperty("LL.RackNumber"));
			leftLuggagePage.selectFirstRack();
			Thread.sleep(3000);
			leftLuggagePage.enterTagToRack(propObject.getProperty("LL.TagToRack3"));
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^submit for racking$")
	public void submit_for_racking() {
		try {
			leftLuggagePage.clickRackingSubmit();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^system will display racking status against each bag tag with the below details Racking Done Successfully\\.Total Bags : (\\d+) Bags to Rack : (\\d+)\" along with the count of the bags that are yet to be racked$")
	public void system_will_display_racking_status_against_each_bag_tag_with_the_below_details_Racking_Done_Successfully_Total_Bags_Bags_to_Rack_along_with_the_count_of_the_bags_that_are_yet_to_be_racked(
			int arg1, int arg2) {
		try {
			Thread.sleep(3000);
			Assert.assertEquals(propCommon.getProperty("LL.RackBagSuccessMsg"), leftLuggagePage.getRackBagSuccessMsg());
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^System will display racking status against each bag tag with the below details All Bags racked\\.Total Bags : (\\d+)\\. Bags to Rack : (\\d+)\"$")
	public void system_will_display_racking_status_against_each_bag_tag_with_the_below_details_All_Bags_racked_Total_Bags_Bags_to_Rack(
			int arg1, int arg2) {
		try {
			// Assert.assertEquals(propCommon.getProperty("LL.RackBagSuccessMsg"),
			// leftLuggagePage.getRackBagSuccessMsg());
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user is scanning or manually entering the invalid left luggage tag number$")
	public void the_user_is_scanning_or_manually_entering_the_invalid_left_luggage_tag_number() throws Throwable {
		try {
			Thread.sleep(3000);
			leftLuggagePage.enterTagToRack(propObject.getProperty("LL.InvalidTagToRack"));
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}

	}

	@Then("^the system will throw error message as Invalid storage tag ID - Racking transaction failed$")
	public void the_system_will_throw_error_message_as_Invalid_storage_tag_ID_Racking_transaction_failed() {
		try {
			Thread.sleep(3000);
			Assert.assertEquals(true,propCommon.getProperty("LL.RackBagInvalid").equals(leftLuggagePage.getLLErrorMsg()));
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}

	}

	@Given("^user has access to left luggage Function$")
	public void user_has_access_to_left_luggage_Function() {
		try {
			Thread.sleep(3000);
			Assert.assertTrue(homePage.llIconExist());
			homePage.clickLLicon();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Given("^Left luggage should be deposited & racked$")
	public void left_luggage_should_be_deposited_racked() {
		try {
			// Deposited and racked
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Given("^Collect charges has been initiated in the desktop$")
	public void collect_charges_has_been_initiated_in_the_desktop() {
		try {
			// Collect charges initiated in desktop
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user is attempting to launch collection feature$")
	public void the_user_is_attempting_to_launch_collection_feature() {
		try {
			leftLuggagePage.clickCollectionLL();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the system will display all the receipts which are ready for collection with the indication of the tag has been scanned or not$")
	public void the_system_will_display_all_the_receipts_which_are_ready_for_collection_with_the_indication_of_the_tag_has_been_scanned_or_not() {
		try {
			Thread.sleep(3000);
			leftLuggagePage.enterCollectionReceipt(propObject.getProperty("LL.CollectionReceipt"));
			leftLuggagePage.enterCollectionReceipt("0");
			act.sendKeys(Keys.BACK_SPACE).build().perform();
			// leftLuggagePage.enterCollectionReceipt(propObject.getProperty("LL.CollectionReceipt"));
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the details displayed are - all Receipt number, Total number of bags, Bags Scanned$")
	public void the_details_displayed_are_all_Receipt_number_Total_number_of_bags_Bags_Scanned() {
		try {
			Assert.assertEquals(propObject.getProperty("LL.CollectionReceipt"), leftLuggagePage.getCollectionReciptNumber());
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Given("^user scanned and selected the LL receipt number$")
	public void user_scanned_and_selected_the_LL_receipt_number() {
		try {
			Thread.sleep(3000);
			leftLuggagePage.enterCollectionReceipt(propObject.getProperty("LL.CollectionReceipt"));
			//leftLuggagePage.enterCollectionReceipt("0");
			//act.sendKeys(Keys.BACK_SPACE).build().perform();
			// leftLuggagePage.enterCollectionReceipt("LL.CollectionReceipt");
			leftLuggagePage.selectDepositReceipt();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user scans the tag that belongs to the selected receipt$")
	public void the_user_scans_the_tag_that_belongs_to_the_selected_receipt() {
		try {
			Thread.sleep(3000);
			leftLuggagePage.enterCollectionBagScan(propObject.getProperty("LL.CollectionBagTag1"));
			act.sendKeys(Keys.ENTER).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the system will mark the corresponding LL tag as scanned$")
	public void the_system_will_mark_the_corresponding_LL_tag_as_scanned() {
		try {
			// Backend validation
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user scans the tag that doesnot belongs to the selected receipt$")
	public void the_user_scans_the_tag_that_doesnot_belongs_to_the_selected_receipt() {
		try {
			Thread.sleep(3000);
			leftLuggagePage.enterCollectionBagScan(propObject.getProperty("LL.CollectionInvalidBagTag"));
			leftLuggagePage.enterCollectionBagScan("0");
			act.sendKeys(Keys.BACK_SPACE).build().perform();
			act.sendKeys(Keys.ENTER).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the system will display an error Please enter the storage tag belonging to ref nbr nnnnnn$")
	public void the_system_will_display_an_error_Please_enter_the_storage_tag_belonging_to_ref_nbr_nnnnnn() {
		try {
			Thread.sleep(3000);
			Assert.assertEquals(true,propCommon.getProperty("LL.CollectionBagInvalid").equals(leftLuggagePage.getLLErrorMsg()));
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user scans the tag that already scanned$")
	public void the_user_scans_the_tag_that_already_scanned() {
		try {
			Thread.sleep(3000);
			leftLuggagePage.enterCollectionBagScan(propObject.getProperty("LL.CollectionAlreadyScannedTag"));
			act.sendKeys(Keys.ENTER).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the system will display an error Storage tag is already scanned$")
	public void the_system_will_display_an_error_Storage_tag_is_already_scanned() {
		try {
			Thread.sleep(3000);
			Assert.assertEquals(true,propCommon.getProperty("LL.CollectionBagAlreadyScanned").equals(leftLuggagePage.getLLErrorMsg()));
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Given("^user scanned and selected the LL receipt number for sign$")
	public void user_scanned_and_selected_the_LL_receipt_number_for_sign() {
		try {
			Thread.sleep(3000);
			leftLuggagePage.enterCollectionReceipt(propObject.getProperty("LL.CollectionReceiptSign"));
			leftLuggagePage.selectCollectionReceipt();
			// leftLuggagePage.enterCollectionReceipt(propObject.getProperty("LL.CollectionReceiptSign"));
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Given("^the sign button is disabled$")
	public void the_sign_button_is_disabled() {
		try {
			Assert.assertEquals(false, leftLuggagePage.llCollectSignStatus());
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user scans the bag tag for sign$")
	public void the_user_scans_the_bag_tag_for_sign() {
		try {
			Thread.sleep(3000);
			leftLuggagePage.enterCollectionBagScan(propObject.getProperty("LL.CollectionBagTagSign"));
			act.sendKeys(Keys.ENTER).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the signature capture frame should be enabled$")
	public void the_signature_capture_frame_should_be_enabled() {
		try {
			Thread.sleep(3000);
			Assert.assertEquals(true, leftLuggagePage.llCollectSignStatus());
			// leftLuggagePage.sign();
			// leftLuggagePage.clickClear();
			// Assert.assertEquals(true, leftLuggagePage.llSignPadAvailability());
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user clicks on the signature button for a left luggage$")
	public void the_user_clicks_on_the_signature_button_for_a_left_luggage() {
		try {
			leftLuggagePage.clickSign();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the system will display the signature block where the customer has to sign$")
	public void the_system_will_display_the_signature_block_where_the_customer_has_to_sign() {
		try {
			Thread.sleep(3000);
			leftLuggagePage.sign();
			// Assert.assertEquals(true, leftLuggagePage.llSignPadAvailability());
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the text I accept the terms and conditions stipulated as mentioned in the receipt with the check box$")
	public void the_text_I_accept_the_terms_and_conditions_stipulated_as_mentioned_in_the_receipt_with_the_check_box() {
		try {
			Thread.sleep(300);
			// Terms and condition exist
			leftLuggagePage.clickColTermsCheckBox();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the option to clear the captured signature or submit to save the signature$")
	public void the_option_to_clear_the_captured_signature_or_submit_to_save_the_signature() {
		try {
			Thread.sleep(3000);
			Assert.assertEquals(true, leftLuggagePage.submitButtonStatus());
			leftLuggagePage.clickClear();
			Thread.sleep(3000);
			Assert.assertEquals(false, leftLuggagePage.submitButtonStatus());
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^system will enable the submit button only if the signature has been captured and the terms and condition has been accepted$")
	public void system_will_enable_the_submit_button_only_if_the_signature_has_been_captured_and_the_terms_and_condition_has_been_accepted() {
		try {
			leftLuggagePage.sign();
			Assert.assertEquals(true, leftLuggagePage.submitButtonStatus());
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^on submit the system will display Thank you Signature Saved Successfully in green$")
	public void on_submit_the_system_will_display_Thank_you_Signature_Saved_Successfully_in_green() {
		try {
			// Success message
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the system will auto select the left luggage location as a default$")
	public void the_system_will_auto_select_the_left_luggage_location_as_a_default() {
		try {
			Assert.assertEquals(homePage.getSelectedLocationData(), propObject.getProperty("LL.DefaultLocation"));
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

}
