package com.beltWasla.steps;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import com.beltWasla.pages.BeltQohPage;
import com.beltWasla.pages.HomeScreen_BELT;
import com.beltWasla.pages.LocationPage_BELT;
import com.beltWasla.runners.TestRunner;
import com.beltWasla.setUp.TestContext;
import com.beltWasla.utils.ApplicationLauncher;
import com.beltWasla.utils.Screenshot;
import com.relevantcodes.extentreports.ExtentTest;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BeltCreateQOHSteps extends ApplicationLauncher{

	ExtentTest logger;

	int DEFAULT_WAIT_4_PAGE = 15;
	String thisClassName = getClass().getSimpleName();
	public Actions act = new Actions(driver);
	public void captureScreen() {

		Screenshot.takeScreenshot(TestRunner.dateTime, thisClassName, scenarioName);

	}
	
	TestContext testContext;
	BeltQohPage beltQohPage;
	HomeScreen_BELT homePage;
	LocationPage_BELT locationPage;

	public BeltCreateQOHSteps(TestContext context) {
		
		testContext = context;
		beltQohPage = testContext.getPageObjectManager().getBeltQohPage();
		homePage = testContext.getPageObjectManager().getHomePage();
		locationPage = testContext.getPageObjectManager().getLocationPage();
	}
	
	
	
	@Given("^the user has launched the Create QOH screen$")
	public void the_user_has_launched_the_Create_QOH_screen() throws Throwable {
		try {
			homePage.clickQOH();
			Thread.sleep(1000);
			captureScreen();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user enter the tag number in the tag number field$")
	public void the_user_enter_the_tag_number_in_the_tag_number_field() throws Throwable {
		try {
			beltQohPage.enterTag(propObject.getProperty("TagNumberQOH"));
			Thread.sleep(1000);
			captureScreen();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user enters valid airline originator and submits$")
	public void the_user_enters_valid_airline_originator_and_submits() throws Throwable {
		try {
			beltQohPage.enterAirline(propObject.getProperty("AirlineOriginator"));
			Thread.sleep(1000);
			captureScreen();
			beltQohPage.clickCreate();
			//Thread.sleep(1000);
			captureScreen();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the entered tag number will be added to the list$")
	public void the_entered_tag_number_will_be_added_to_the_list() throws Throwable {
		// auto add
	}

	@Then("^after submitting it will show created successfully message$")
	public void after_submitting_it_will_show_created_successfully_message() throws Throwable {
		try {
			//WebDriverWait wait = new WebDriverWait(driver,5);
			//wait.until(ExpectedConditions.presenceOfElementLocated(beltQohPage.successMessage));
			captureScreen();
			if (beltQohPage.checkSuccessMsg()) {
				Assert.assertEquals(true,propCommon.getProperty("QOHCreatedMsg").equals(beltQohPage.gettoastMessage().trim()));
				System.out.println(beltQohPage.gettoastMessage());
			}else{
				System.out.println("Not present");
				Assert.assertEquals(false,propCommon.getProperty("QOHCreatedMsg").equals(beltQohPage.gettoastMessage().trim()));
			}
			System.out.println("QOH created successfully and verified");
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user enters multiple tag numbers and adds it to the list$")
	public void the_user_enters_multiple_tag_numbers_and_adds_it_to_the_list() throws Throwable {
		try {
			beltQohPage.enterTag(propObject.getProperty("TagNumberQOH"));
			Thread.sleep(1000);
			captureScreen();
			beltQohPage.enterTag(propObject.getProperty("TagNumberQOH2"));
			Thread.sleep(1000);
			captureScreen();
			beltQohPage.enterTag(propObject.getProperty("TagNumberQOH3"));
			Thread.sleep(1000);
			captureScreen();
			beltQohPage.enterTag(propObject.getProperty("TagNumberQOH4"));
			Thread.sleep(1000);
			captureScreen();
			beltQohPage.enterTag(propObject.getProperty("TagNumberQOH5"));
			Thread.sleep(1000);
			captureScreen();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user enter valid carrier code$")
	public void the_user_enter_valid_carrier_code() throws Throwable {
		try {
			beltQohPage.enterAirline(propObject.getProperty("AirlineOriginator"));
			Thread.sleep(1000);
			captureScreen();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user submits the added tags$")
	public void the_user_submits_the_added_tags() throws Throwable {
		try {
			beltQohPage.clickCreate();
			Thread.sleep(1000);
			captureScreen();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the system will create the QOH for all entered tag numbers agianst mentioned airline originator code$")
	public void the_system_will_create_the_QOH_for_all_entered_tag_numbers_agianst_mentioned_airline_originator_code()
			throws Throwable {
		try {
			Thread.sleep(2000);
			captureScreen();
			if (beltQohPage.gettoastMessage().contains(propCommon.getProperty("QOHCreatedMsg"))) {
				Assert.assertEquals(true,beltQohPage.gettoastMessage().contains(propCommon.getProperty("QOHCreatedMsg")));
				System.out.println(beltQohPage.gettoastMessage());
			}else{
				System.out.println("Not present");
				Assert.assertEquals(false,beltQohPage.gettoastMessage().contains(propCommon.getProperty("QOHCreatedMsg")));
			}
			Thread.sleep(1000);

		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user changes the location$")
	public void the_user_changes_the_location() throws Throwable {
		try {
			beltQohPage.clickEditLocation();
			Thread.sleep(1000);
			captureScreen();
			locationPage.enterTerminalDropDown(propObject.getProperty("NewTerminal"));
			act.sendKeys(Keys.ENTER).build().perform();
			Thread.sleep(1000);
			captureScreen();
			locationPage.enterAreaDropDown(propObject.getProperty("NewArea"));
			act.sendKeys(Keys.ENTER).build().perform();
			Thread.sleep(1000);
			captureScreen();
			locationPage.enterLocationDropDown(propObject.getProperty("NewLocation"));
			act.sendKeys(Keys.ENTER).build().perform();
			Thread.sleep(1000);
			captureScreen();
			locationPage.clickConfirmButton();
			Thread.sleep(1000);
			captureScreen();

		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user created QOH for a tag$")
	public void the_user_created_QOH_for_a_tag() throws Throwable {
		try {
			beltQohPage.enterTag(propObject.getProperty("TagNumberQOH"));
			beltQohPage.enterAirline(propObject.getProperty("AirlineOriginator"));
			beltQohPage.clickCreate();
			Thread.sleep(1000);
			captureScreen();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the newly chaged location should reflect in the created QOH$")
	public void the_newly_chaged_location_should_reflect_in_the_created_QOH() throws Throwable {
		try {
			if (beltQohPage.getSelectedLocation().equals(propObject.getProperty("NewLocation"))) {
				System.out.println("Location change saved successfully");
				Assert.assertEquals(true,beltQohPage.getSelectedLocation().equals(propObject.getProperty("NewLocation")));
			}
			else{
				Assert.assertEquals(false,beltQohPage.getSelectedLocation().equals(propObject.getProperty("NewLocation")));
			}
			Thread.sleep(2000);
			captureScreen();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user enters invalid airline originator code$")
	public void the_user_enters_invalid_airline_originator_code() throws Throwable {
		try {
			beltQohPage.enterAirline(propObject.getProperty("InvalidAirline"));
			Thread.sleep(1000);
			captureScreen();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user enters valid tag number$")
	public void the_user_enters_valid_tag_number() throws Throwable {
		try {
			beltQohPage.enterTag(propObject.getProperty("TagNumberQOH"));
			Thread.sleep(1000);
			captureScreen();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the system throws an error message as Airline Originator is not valid\\. Please check and try again$")
	public void the_system_throws_an_error_message_as_Airline_Originator_is_not_valid_Please_check_and_try_again()
			throws Throwable {
		try {
			//error message validation
			//System.out.println("The  error message is : " + beltQohPage.getTopErrorMessage());
			captureScreen();
			Assert.assertEquals(true,beltQohPage.getTopErrorMessage().equals(propCommon.getProperty("InvalidArlineOrg")));
			
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user enters same tag number mare than once and adds it to the list$")
	public void the_user_enters_same_tag_number_mare_than_once_and_adds_it_to_the_list() throws Throwable {
		try {
			beltQohPage.enterTag(propObject.getProperty("TagNumberQOH"));
			Thread.sleep(1000);
			captureScreen();
			beltQohPage.enterTag(propObject.getProperty("TagNumberQOH"));
			Thread.sleep(3000);
			captureScreen();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the sytem will throw an error message as Tag is already added in the list$")
	public void the_sytem_will_throw_an_error_message_as_Tag_is_already_added_in_the_list() throws Throwable {
		try {
			System.out.println("The  error message is : " + beltQohPage.getTopErrorMessage());
			captureScreen();
			Assert.assertEquals(true,beltQohPage.getTopErrorMessage().equals(propCommon.getProperty("TagAlreadyAdded")));
			Thread.sleep(1000);
			
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user enters ten tag numbers$")
	public void the_user_enters_ten_tag_numbers() throws Throwable {
		try {
			beltQohPage.enterTag(propObject.getProperty("TagNumberQOH"));
			Thread.sleep(1000);
			captureScreen();
			beltQohPage.enterTag(propObject.getProperty("TagNumberQOH2"));
			Thread.sleep(1000);
			captureScreen();
			beltQohPage.enterTag(propObject.getProperty("TagNumberQOH3"));
			Thread.sleep(1000);
			captureScreen();
			beltQohPage.enterTag(propObject.getProperty("TagNumberQOH4"));
			Thread.sleep(1000);
			captureScreen();
			beltQohPage.enterTag(propObject.getProperty("TagNumberQOH5"));
			Thread.sleep(1000);
			captureScreen();
			beltQohPage.enterTag(propObject.getProperty("TagNumberQOH6"));
			Thread.sleep(1000);
			captureScreen();
			beltQohPage.enterTag(propObject.getProperty("TagNumberQOH7"));
			Thread.sleep(1000);
			captureScreen();
			beltQohPage.enterTag(propObject.getProperty("TagNumberQOH8"));
			Thread.sleep(1000);
			captureScreen();
			beltQohPage.enterTag(propObject.getProperty("TagNumberQOH9"));
			Thread.sleep(1000);
			captureScreen();
			beltQohPage.enterTag(propObject.getProperty("TagNumberQOH10"));
			Thread.sleep(1000);
			captureScreen();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user trying to add the eleventh tag number to the list$")
	public void the_user_trying_to_add_the_eleventh_tag_number_to_the_list() throws Throwable {
		try {
			beltQohPage.enterTag(propObject.getProperty("TagNumberQOH11"));
			Thread.sleep(3000);
			captureScreen();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the sytem will throw an error message as Limit exceeded - max ten tags allowed for creation$")
	public void the_sytem_will_throw_an_error_message_as_Limit_exceeded_max_ten_tags_allowed_for_creation()
			throws Throwable {
		try {
			captureScreen();
			Assert.assertEquals(true,propCommon.getProperty("LimitExceeded10").equals(beltQohPage.getTopErrorMessage()));
			System.out.println("The  error message is : " + beltQohPage.getTopErrorMessage());
			Thread.sleep(1000);
			
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}
	
	@And("^the tag number has multiple valid BSM$")
	public void the_tag_number_has_multiple_valid_BSM() throws Throwable {
		// auto add
	}
	
	@When("^the user enter the multi BSM tag number in the tag number field$")
	public void the_user_enter_the_multi_BSM_tag_number_in_the_tag_number_field() throws Throwable {
		try {
			beltQohPage.enterTag(propObject.getProperty("TagNumberMultiQOH"));
			Thread.sleep(1000);
			captureScreen();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}
	
	@Then("^the system will prompt the user to select the right BSM and creates the QOH$")
	public void the_system_will_prompt_the_user_to_select_the_right_BSM_and_creates_the_QOH() throws Throwable {
		try {
			beltQohPage.clickMultiBSMDD();
			beltQohPage.selectBSMDD();
			Thread.sleep(1000);
			beltQohPage.clickSubmit();
			Thread.sleep(1000);
			captureScreen();
			if (beltQohPage.checkSuccessMsg()) {
				Assert.assertEquals(true,propCommon.getProperty("QOHCreatedMsg").equals(beltQohPage.gettoastMessage()));
				System.out.println(beltQohPage.gettoastMessage());
			}else{
				System.out.println("Not present");
				Assert.assertEquals(false,propCommon.getProperty("QOHCreatedMsg").equals(beltQohPage.gettoastMessage()));
			}
			System.out.println("QOH created successfully and verified");
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}
}
