package com.beltWasla.steps;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import com.relevantcodes.extentreports.ExtentTest;
//import com.aventstack.extentreports.ExtentTest;
import com.beltWasla.pages.BRSLoadBagPage;
import com.beltWasla.pages.HomeScreen_BELT;
import com.beltWasla.runners.TestRunner;
import com.beltWasla.setUp.TestContext;
import com.beltWasla.utils.ApplicationLauncher;
import com.beltWasla.utils.Screenshot;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class BRS_LoadBagSteps extends ApplicationLauncher{

	ExtentTest logger;

	int DEFAULT_WAIT_4_PAGE = 15;
	String thisClassName = getClass().getSimpleName();
	public Actions act = new Actions(driver);
	public void captureScreen() {

		Screenshot.takeScreenshot(TestRunner.dateTime, thisClassName, scenarioName);

	}
	
	TestContext testContext;
	BRSLoadBagPage brsLoadPage;
	HomeScreen_BELT homePage;

	public BRS_LoadBagSteps(TestContext context) {
		
		testContext = context;
		brsLoadPage = testContext.getPageObjectManager().getBrsLoadBagPage();
		homePage = testContext.getPageObjectManager().getHomePage();
	}
	
	@And("^the user has launched the BRS load bag feature$")
	public void the_user_has_launched_the_BRS_load_bag_feature() throws Exception{
		try
		{
			homePage.clickHamburgerBRSLoadBag();
		}
		catch(Exception ex)
		{
			captureScreen();
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@And("^the user has access to BRS load bag feature$")
	public void the_user_has_access_to_BRS_load_bag_feature() throws Exception{
		try
		{
			Assert.assertEquals(homePage.verifyHamburgerBRSLoadBag(), "User has access to BRS Load Bag Feature");
		}
		catch(Exception ex)
		{
			captureScreen();
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@And("^the user role is either 0 or 1$")
	public void the_user_role_is_either_0_or_1() throws Exception{
		try
		{
			//Need to ADD Db validations
			/*
			 * if (Integer.parseInt(DButilities.getUserRole("S948"))==0 ||
			 * Integer.parseInt(DButilities.getUserRole("S948"))==1) {
			 * Assert.assertEquals(true, "User Role for the given user is : " +
			 * DButilities.getUserRole("S944448")); } else{ Assert.assertEquals(false,
			 * "User Role for the given user is : " + DButilities.getUserRole("S944448")); }
			 */
		}
		catch(Exception ex)
		{
			captureScreen();
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@And("^the ULD not registered$")
	public void the_ULD_not_registered() throws Exception{
		try
		{
			//ULD not registered.
		}
		catch(Exception ex)
		{
			captureScreen();
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@When("^the user scans / enters the unregistered ULD number$")
	public void the_user_scans_enters_the_unregistered_ULD_number() throws Exception{
		try
		{
			Thread.sleep(1000);
			brsLoadPage.enterULD(propObject.getProperty("BRSLoadBag.UnregisteredULD"));
			act.sendKeys(Keys.ENTER).build().perform();
		}
		catch(Exception ex)
		{
			captureScreen();
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@Then("^the system will throw an error message as Invalid ULD or ULD not registered$")
	public void the_system_will_throw_an_error_message_as_Invalid_ULD_or_ULD_not_registered() throws Exception{
		try
		{
			Thread.sleep(2000);
			captureScreen();
			Assert.assertEquals(brsLoadPage.getNoULDErrMsg(), propCommon.getProperty("ULDNotRegistered"));
			
			brsLoadPage.clickDismissOption();
		}
		catch(Exception ex)
		{
			captureScreen();
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@And("^the long beep sound will be played$")
	public void the_long_beep_sound_will_be_played() throws Exception{
		try
		{
			//Long beep will be played.
		}
		catch(Exception ex)
		{
			captureScreen();
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@And("^the ULD is in Closed status$")
	public void the_ULD_is_in_Closed_status() throws Exception{
		try
		{
			//ULD is in Closed Status
		}
		catch(Exception ex)
		{
			captureScreen();
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@When("^the user scans / enters the Closed ULD number$")
	public void the_user_scans_enters_the_Closed_ULD_number() throws Exception{
		try
		{
			Thread.sleep(1000);
			brsLoadPage.enterULD(propObject.getProperty("BRSLoadBag.ClosedULD"));
			act.sendKeys(Keys.ENTER).build().perform();
			
		}
		catch(Exception ex)
		{
			captureScreen();
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@Then("^the system will throw an error message as ULD not open for loading$")
	public void the_system_will_throw_an_error_message_as_ULD_not_open_for_loading() throws Exception{
		try
		{
			Thread.sleep(2000);
			captureScreen();
			Assert.assertEquals(brsLoadPage.getNoULDErrMsg(), propCommon.getProperty("ULDNotOpen"));
			
			brsLoadPage.clickDismissOption();
		}
		catch(Exception ex)
		{
			captureScreen();
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@And("^the ULD is in Dispatched status$")
	public void the_ULD_is_in_Dispatched_status() throws Exception{
		try
		{
			//ULD is in Dispatched Status
			
		}
		catch(Exception ex)
		{
			captureScreen();
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@When("^the user scans / enters the Dispatched status ULD number$")
	public void the_user_scans_enters_the_Dispatched_status_ULD_number() throws Exception{
		try
		{
			Thread.sleep(1000);
			brsLoadPage.enterULD(propObject.getProperty("BRSLoadBag.DispatchedULD"));
			act.sendKeys(Keys.ENTER).build().perform();
		}
		catch(Exception ex)
		{
			captureScreen();
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@And("^the ULD is in Dispatched STG status$")
	public void the_ULD_is_in_Dispatched_STG_status() throws Exception{
		try
		{
			//ULD is in Dispatched STG Status
			
		}
		catch(Exception ex)
		{
			captureScreen();
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@When("^the user scans / enters the Dispatched STG status ULD number$")
	public void the_user_scans_enters_the_Dispatched_STG_status_ULD_number() throws Exception{
		try
		{
			Thread.sleep(1000);
			brsLoadPage.enterULD(propObject.getProperty("BRSLoadBag.DispatchedSTGULD"));
			act.sendKeys(Keys.ENTER).build().perform();
		}
		catch(Exception ex)
		{
			captureScreen();
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@And("^the ULD is in Positioned status$")
	public void the_ULD_is_in_Positioned_status() throws Exception{
		try
		{
			//ULD is in Positioned Status
	
		}
		catch(Exception ex)
		{
			captureScreen();
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@When("^the user scans / enters the Positioned status ULD number$")
	public void the_user_scans_enters_the_Positioned_status_ULD_number() throws Exception{
		try
		{
			Thread.sleep(1000);
			brsLoadPage.enterULD(propObject.getProperty("BRSLoadBag.PositionedULD"));
			act.sendKeys(Keys.ENTER).build().perform();
		}
		catch(Exception ex)
		{
			captureScreen();
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@And("^the ULD is in Ramp status$")
	public void the_ULD_is_in_Ramp_status() throws Exception{
		try
		{
			//ULD is in Ramp Status
			
		}
		catch(Exception ex)
		{
			captureScreen();
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@When("^the user scans / enters the Ramp status ULD number$")
	public void the_user_scans_enters_the_Ramp_status_ULD_number() throws Exception{
		try
		{
			Thread.sleep(1000);
			brsLoadPage.enterULD(propObject.getProperty("BRSLoadBag.RampULD"));
			act.sendKeys(Keys.ENTER).build().perform();
		}
		catch(Exception ex)
		{
			captureScreen();
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@And("^ULD is registered for the other leg of the same flight$")
	public void ULD_is_registered_for_the_other_leg_of_the_same_flight() throws Exception{
		try
		{
			//Valid BSM
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@And("^the bag tag has a valid BSM existing in BELT$")
	public void the_bag_tag_has_a_valid_BSM_existing_in_BELT() throws Exception{
		try
		{
			//Valid BSM
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	
	@When("^the user scans or enters a valid ULD number which can be loaded with bags$")
	public void the_user_scans_or_enters_a_valid_ULD_number_which_can_be_loaded_with_bags() throws Exception{
		try
		{
			Thread.sleep(1000);
			brsLoadPage.enterULD(propObject.getProperty("BRSLoadBag.OpenULDLimit1"));
			act.sendKeys(Keys.ENTER).build().perform();
		}
		catch(Exception ex)
		{
			captureScreen();
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@And("^the user is attempting to load the bag which is of a specific cabin class and the ULD is of mixed class and ULD for Y class already exists$")
	public void the_user_is_attempting_to_load_the_bag_which_is_of_a_specific_cabin_class_and_the_ULD_is_of_mixed_class_and_ULD_for_Y_class_already_exists() throws Exception{
		try
		{
			Thread.sleep(1000);
			brsLoadPage.enterULD(propObject.getProperty("BRSLoadBag.OpenULD"));
			act.sendKeys(Keys.ENTER).build().perform();
		}
		catch(Exception ex)
		{
			captureScreen();
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@When("^the user scans/enters the tag which can be loaded in BEST ULD$")
	public void the_user_scans_enters_the_tag_which_can_be_loaded_in_BEST_ULD() throws Exception{
		try
		{
			Thread.sleep(1000);
			brsLoadPage.enterBagTagNo(propObject.getProperty("BRSLoadBag.BagTagSplSegrtnMatch"));
			act.sendKeys(Keys.ENTER).build().perform();
		}
		catch(Exception ex)
		{
			captureScreen();
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@When("^the user scans or enters the Multi BSM bag tag number$")
	public void the_user_scans_or_enters_the_Multi_BSM_bag_tag_number() throws Exception{
		try
		{
			Thread.sleep(1000);
			brsLoadPage.enterBagTagNo(propObject.getProperty("BRSLoadBag.ValidMultiBSMTag"));
			act.sendKeys(Keys.ENTER).build().perform();
		}
		catch(Exception ex)
		{
			captureScreen();
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@And("^the user scans or enters the Multi BSM bag tag number for same flight$")
	public void the_user_scans_or_enters_the_Multi_BSM_bag_tag_number_for_same_flight() throws Exception{
		try
		{
			Thread.sleep(1000);
			brsLoadPage.enterBagTagNo(propObject.getProperty("BRSLoadBag.ValidMultiBSMTag"));
			act.sendKeys(Keys.ENTER).build().perform();
		}
		catch(Exception ex)
		{
			captureScreen();
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@When("^the user scans/enters the tag of different destination than ULD$")
	public void the_user_scans_enters_the_tag_of_different_destination_than_ULD() throws Exception{
		try
		{
			Thread.sleep(1000);
			brsLoadPage.enterBagTagNo(propObject.getProperty("BRSLoadBag.ValidTagWrongDest"));
			act.sendKeys(Keys.ENTER).build().perform();
		}
		catch(Exception ex)
		{
			captureScreen();
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@Then("^the system will throw an error as 'Duplicate Tag' available$")
	public void the_system_will_throw_an_error_as_Duplicate_Tag_available() throws Exception{
		try
		{
			System.out.println(propCommon.getProperty("lastBagLoaded"));
			captureScreen();
			if (brsLoadPage.getNoULDErrMsg().contains(propCommon.getProperty("MultiBSMError"))) {
				System.out.println("Error Msg While Loading Multi BSM for Loader user : "+brsLoadPage.getNoULDErrMsg());
				Assert.assertEquals(true,"Error Msg While Loading Multi BSM for Loader user : "+brsLoadPage.getNoULDErrMsg());
			} else {
				System.out.println("Duplicate Tag Error Message was not found While Loading Multi BSM for Loader user");
				Assert.assertEquals(false,"Duplicate Tag Error Message was not found While Loading Multi BSM for Loader user");
			}
			brsLoadPage.clickDismissOptionBagTag();
		}
		catch(Exception ex)
		{
			captureScreen();
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@And("^the user is attempting to load the bag for a shorter leg on a multi-leg flight for which the ULD is not registered$")
	public void the_user_is_attempting_to_load_the_bag_for_a_shorter_leg_on_a_multi_leg_flight_for_which_the_ULD_is_not_registered() throws Exception{
		try
		{
			Thread.sleep(1000);
			brsLoadPage.enterULD(propObject.getProperty("BRSLoadBag.OpenULD"));
			act.sendKeys(Keys.ENTER).build().perform();
		}
		catch(Exception ex)
		{
			captureScreen();
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	

	@Then("^the system will display an error to the user NO - WRONG ULD DESTINATION$")
	public void the_system_will_display_an_error_to_the_user_NO_WRONG_ULD_DESTINATION() throws Exception{
		try
		{
			System.out.println(propCommon.getProperty("lastBagLoaded"));
			Thread.sleep(2000);
			captureScreen();
			if (brsLoadPage.getNoULDErrMsg().contains(propCommon.getProperty("WrongULDDest"))) {
				System.out.println("Error Msg : "+brsLoadPage.getNoULDErrMsg());
				Assert.assertEquals(true,brsLoadPage.getNoULDErrMsg());
			} else {
				System.out.println("Wrong ULD Destination is not displayed");
				Assert.assertEquals(false,"Wrong ULD Destination is not displayed\"");
			}
			brsLoadPage.clickDismissOptionBagTag();
		}
		catch(Exception ex)
		{
			captureScreen();
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@And("^the user scans or enters the bag tag number$")
	public void the_user_scans_or_enters_the_bag_tag_number() throws Exception{
		try
		{
			Thread.sleep(1000);
			brsLoadPage.enterBagTagNo(propObject.getProperty("BRSLoadBag.ValidTagSingleBSM"));
			act.sendKeys(Keys.ENTER).build().perform();
		}
		catch(Exception ex)
		{
			captureScreen();
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@Then("^the system will throw an error and display WRONG ULD, BEST ULD - ..... IS AVAILABLE Y Class$")
	public void the_system_will_throw_an_error_and_display_WRONG_ULD_BEST_ULD_IS_AVAILABLE_Y_Class() throws Exception{
		try
		{
			Thread.sleep(2000);
			captureScreen();
			if (brsLoadPage.getNoULDErrMsg().contains(propCommon.getProperty("BESTULDClassError"))) {
				System.out.println("Bag loaded Succesfully");
				Assert.assertEquals(true,brsLoadPage.getNoULDErrMsg());
			} else {
				System.out.println("Bag cannot be loaded");
				Assert.assertEquals(false,"Bag cannot be loaded");
			}
			brsLoadPage.clickDismissOptionBagTag();
		}
		catch(Exception ex)
		{
			captureScreen();
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@Then("^the confirmation message is displayed with a beep sound that the bag is loaded successfully e.g. YES - Bag Tag Number - Bag Loaded successfully$")
	public void the_confirmation_message_is_displayed_with_a_beep_sound_that_the_bag_is_loaded_successfully_e_g_YES_Bag_Tag_Number_Bag_Loaded_successfully() throws Exception{
		try
		{
			Thread.sleep(2000);
			captureScreen();
			if (brsLoadPage.getlastBagLogged().contains(propCommon.getProperty("lastBagLoaded"))) {
				System.out.println("Bag loaded Succesfully");
				Assert.assertEquals(true,"Bag loaded Succesfully");
			} else {
				System.out.println("Bag cannot be loaded");
				Assert.assertEquals(false,"Bag cannot be loaded");
			}
		}
		catch(Exception ex)
		{
			captureScreen();
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@And("^the system will also increment the bag count in the ULD$")
	public void the_system_will_also_increment_the_bag_count_in_the_ULD() throws Exception{
		try
		{
			//Need to add
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@And("^the system will display the tag number of the last bag loaded in the screen$")
	public void the_system_will_display_the_tag_number_of_the_last_bag_loaded_in_the_screen() throws Exception{
		try
		{
			System.out.println(propCommon.getProperty("lastBagLoaded"));
			captureScreen();
			if (brsLoadPage.getlastBagLogged().contains(propCommon.getProperty("lastBagLoaded"))) {
				System.out.println("last Bag Loaded"+brsLoadPage.getlastBagLogged());
				Assert.assertEquals(true,"Last Bag Loaded Succesfully");
			} else {
				System.out.println("Last Bag was not Loaded Succesfully");
				Assert.assertEquals(false,"Last Bag was not Loaded Succesfully");
			}
		}
		catch(Exception ex)
		{
			captureScreen();
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@And("^the bag has already loaded on the ULD / flight$")
	public void the_bag_has_already_loaded_on_the_ULD_flight() throws Exception{
		try
		{
		
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@Then("^the system should play a long beep and give an error message as Bag already Loaded$")
	public void the_system_should_play_a_long_beep_and_give_an_error_message_as_Bag_already_Loaded() throws Exception{
		try
		{
			Thread.sleep(2000);
			captureScreen();
			if (brsLoadPage.getNoULDErrMsg().contains(propCommon.getProperty("BagAlreadyLoaded"))) {
				System.out.println("Error Msg : "+brsLoadPage.getNoULDErrMsg());
				Assert.assertEquals(true,brsLoadPage.getNoULDErrMsg());
			} else {
				System.out.println("Error msg as Bag already loaded dint appear");
				Assert.assertEquals(false,"Error msg as Bag already loaded dint appear");
			}
			
			brsLoadPage.clickDismissOptionBagTag();
		}
		catch(Exception ex)
		{
			captureScreen();
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@And("^the user scans or enters the No BSM bag tag number$")
	public void the_user_scans_or_enters_the_No_BSM_bag_tag_number() throws Exception{
		try
		{
			Thread.sleep(1000);
			brsLoadPage.enterBagTagNo(propObject.getProperty("BRSLoadBag.BagTagNoBSM"));
			act.sendKeys(Keys.ENTER).build().perform();
		}
		catch(Exception ex)
		{
			captureScreen();
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@Then("^the system will display NO UNKNOWN TAG/BAG NOT ELIGIBLE FOR LOADING$")
	public void the_system_will_display_NO_UNKNOWN_TAG_BAG_NOT_ELIGIBLE_FOR_LOADING() throws Exception{
		try
		{
			Thread.sleep(3000);
			captureScreen();
			Assert.assertEquals(brsLoadPage.getNoULDErrMsg(), propCommon.getProperty("UnknownTag"));
			brsLoadPage.clickDismissOptionBagTag();
		}
		catch(Exception ex)
		{
			captureScreen();
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	

	@And("^the user scans or enters the Single BSM deleted bag tag number$")
	public void the_user_scans_or_enters_the_Single_BSM_bag_tag_number() throws Exception{
		try
		{
			Thread.sleep(1000);
			brsLoadPage.enterBagTagNo(propObject.getProperty("BRSLoadBag.BagTagDelSingleBSM"));
			act.sendKeys(Keys.ENTER).build().perform();
		}
		catch(Exception ex)
		{
			captureScreen();
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@Then("^the system will display 'NO - DELETED TAG' Press 'dismiss' to continue$")
	public void the_system_will_display_NO_DELETED_TAG_Press_dismiss_to_continue() throws Exception{
		try
		{
			Thread.sleep(1000);
			captureScreen();
			Assert.assertEquals(brsLoadPage.getNoULDErrMsg(), propCommon.getProperty("DeletedTag"));
		
			brsLoadPage.clickDismissOptionBagTag();
		}
		catch(Exception ex)
		{
			captureScreen();
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@And("^ULD is on Open status$")
	public void ULD_is_on_Open_status() throws Exception{
		try
		{
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	@And("^user has entered the ULD number$")
	public void user_has_entered_the_ULD_number() throws Exception{
		try
		{
			Thread.sleep(1000);
			brsLoadPage.enterULD(propObject.getProperty("BRSLoadBag.OpenULDLimit1"));
			act.sendKeys(Keys.ENTER).build().perform();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}
	
	@And("^user has entered the ULD number of specific class$")
	public void user_has_entered_the_ULD_number_of_specific_class() throws Exception{
		try
		{
			Thread.sleep(1000);
			brsLoadPage.enterULD(propObject.getProperty("BRSLoadBag.ClassJULD"));
			act.sendKeys(Keys.ENTER).build().perform();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}
	
	@And("^reconciliation checks of bag and ULD matches$")
	public void reconciliation_checks_of_bag_and_ULD_matches() throws Exception{
		try
		{
		
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@And("^ULD Maximum capacity threshold has been defined$")
	public void ULD_Maximum_capacity_threshold_has_been_defined() throws Exception{
		try
		{
		
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@And("^the user is attempting to load the bag$")
	public void the_user_is_attempting_to_load_the_bag() throws Exception{
		try
		{
		
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@And("^bag is not authorised to load or bag is NATL or standby$")
	public void bag_is_not_authorised_to_load_or_bag_is_NATL_or_standby() throws Exception{
		try
		{
		
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@And("^the tag has been already deleted$")
	public void the_tag_has_been_already_deleted() throws Exception{
		try
		{
		
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@And("^there is no BSM available with the tag$")
	public void there_is_no_BSM_available_with_the_tag() throws Exception{
		try
		{
		
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@When("^the user scans/enters the NATL bag tag$")
	public void the_user_scans_enters_the_NATL_bag_tag() throws Exception{
		try
		{
			Thread.sleep(1000);
			brsLoadPage.enterBagTagNo(propObject.getProperty("BRSLoadBag.BagTagNATL"));
			act.sendKeys(Keys.ENTER).build().perform();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}
	
	@And("^user has entered the ULD number	specific to IB segregation$")
	public void user_has_entered_the_ULD_number_specific_to_IB_segregation() throws Exception{
		try
		{
			Thread.sleep(1000);
			brsLoadPage.enterULD(propObject.getProperty("BRSLoadBag.IBULD"));
			act.sendKeys(Keys.ENTER).build().perform();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}
	
	@And("^user has entered the ULD number	specific to OB segregation$")
	public void user_has_entered_the_ULD_number_specific_to_OB_segregation() throws Exception{
		try
		{
			Thread.sleep(1000);
			brsLoadPage.enterULD(propObject.getProperty("BRSLoadBag.IBULD"));
			act.sendKeys(Keys.ENTER).build().perform();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}
	
	@And("^user has entered the ULD number	specific to special segregation$")
	public void user_has_entered_the_ULD_number_specific_to_special_segregation() throws Exception{
		try
		{
			Thread.sleep(1000);
			brsLoadPage.enterULD(propObject.getProperty("BRSLoadBag.SplSegrtnULD"));
			act.sendKeys(Keys.ENTER).build().perform();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}
	
	@When("^the user scans/enters the tag of special segregation$")
	public void the_user_scans_enters_the_tag_of_special_segregation() throws Exception{
		try
		{
			Thread.sleep(1000);
			brsLoadPage.enterBagTagNo(propObject.getProperty("BRSLoadBag.BagTagSplSegrtnMisMatch"));
			act.sendKeys(Keys.ENTER).build().perform();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}
	
	@And("^user has entered the ULD number with maximum limit specified$")
	public void user_has_entered_the_ULD_number_with_maximum_limit_specified() throws Exception{
		try
		{
			Thread.sleep(1000);
			brsLoadPage.enterULD(propObject.getProperty("BRSLoadBag.IBULD"));
			act.sendKeys(Keys.ENTER).build().perform();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}
	
	@When("^the user scans/enters the tag which is not meant to be loaded onto this ULD or is not part of the inbound segregation$")
	public void the_user_scans_enters_the_tag_which_is_not_meant_to_be_loaded_nto_this_ULD_or_is_not_part_of_the_inbound_segregation() throws Exception{
		try
		{
			Thread.sleep(1000);
			brsLoadPage.enterBagTagNo(propObject.getProperty("BRSLoadBag.BagTagWrongIB"));
			act.sendKeys(Keys.ENTER).build().perform();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}
	
	@Then("^the system will throw error and display NOT AUTHORISED TO LOAD$")
	public void the_system_will_throw_error_and_display_NOT_AUTHORISED_TO_LOAD() throws Exception{
		try
		{
			Thread.sleep(2000);
			captureScreen();
			Assert.assertEquals(brsLoadPage.getNoULDErrMsg(), propCommon.getProperty("NATL"));
			
			brsLoadPage.clickDismissOptionBagTag();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}
	
	@And("^the user is attempting to load the bag on a different flight and date$")
	public void the_user_is_attempting_to_load_the_bag_on_a_different_flight_and_date() throws Exception{
		try
		{
		
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@When("^the user scans/enters the tag from different flight$")
	public void the_user_scans_enters_the_tag_from_different_flight() throws Exception{
		try
		{
			Thread.sleep(1000);
			brsLoadPage.enterBagTagNo(propObject.getProperty("BRSLoadBag.BagTagDifferentFlight"));
			act.sendKeys(Keys.ENTER).build().perform();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}
	
	@Then("^the system will throw an error and display NO - WRONG FLIGHT, Bag Belongs to EKxxxx/13Nov19$")
	public void the_system_will_throw_an_error_and_display_NO_WRONG_FLIGHT_Bag_Belongs_to_EKxxxx_13Nov19() throws Exception{
		try
		{
			Thread.sleep(2000);
			captureScreen();
			if (brsLoadPage.getNoULDErrMsg().contains(propCommon.getProperty("WrongFlight"))) {
				System.out.println("Error Msg : "+brsLoadPage.getNoULDErrMsg());
				Assert.assertEquals(true,brsLoadPage.getNoULDErrMsg());
			} else {
				System.out.println("Error msg as WRONG FLIGHT, Bag belongs to .. dint appear");
				Assert.assertEquals(false,"Error msg as WRONG FLIGHT, Bag belongs to ... dint appear");
			}
			
		}
		catch(Exception ex)
		{
			captureScreen();
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@When("^the user scans/enters the tag which is not meant to be loaded onto this ULD or is not part of the outbound segregation$")
	public void the_user_scans_enters_the_tag_which_is_not_meant_to_be_loaded_nto_this_ULD_or_is_not_part_of_the_outbound_segregation() throws Exception{
		try
		{
			Thread.sleep(1000);
			brsLoadPage.enterBagTagNo(propObject.getProperty("BRSLoadBag.BagTagWrongIB"));
			act.sendKeys(Keys.ENTER).build().perform();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}
	
	@And("^the user will dismiss and proceed$")
	public void the_user_will_dismiss_and_proceed() throws Exception{
		try
		{
			captureScreen();
			brsLoadPage.clickDismissOptionBagTag();
		}
		catch(Exception ex)
		{
			captureScreen();
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@And("^the outbound segregation doesn't match and rest of the checks match with that of the ULD$")
	public void the_outbound_segregation_doesn_match_and_rest_of_the_checks_match_with_that_of_the_ULD() throws Exception{
		try
		{
			//ULD not registered.
		}
		catch(Exception ex)
		{
			captureScreen();
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@And("^the inbound segregation doesn't match and rest of the checks match with that of the ULD$")
	public void the_inbound_segregation_doesn_match_and_rest_of_the_checks_match_with_that_of_the_ULD() throws Exception{
		try
		{
			//ULD not registered.
		}
		catch(Exception ex)
		{
			captureScreen();
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@And("^the user is attempting to load a bag for different class other than the one that is registered on the ULD$")
	public void the_user_is_attempting_to_load_a_bag_for_different_class_other_than_the_one_that_is_registered_on_the_ULD() throws Exception{
		try
		{
		
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@And("^the user is attempting to load the bag which is overshooting the ULD capacity$")
	public void the_user_is_attempting_to_load_the_bag_which_is_overshooting_the_ULD_capacity() throws Exception{
		try
		{
		
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@And("^the bag tag has multiple BSMs created against it$")
	public void the_bag_tag_has_multiple_BSMs_created_against_it() throws Exception{
		try
		{
		
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@And("^the user captures the flight number associated with the ULD$")
	public void the_user_captures_the_flight_number_associated_with_the_ULD() throws Exception{
		try
		{
		
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@And("^all other reconciliation checks of bag and ULD matches  except for the class$")
	public void all_other_reconciliation_checks_of_bag_and_ULD_matches_except_for_the_class() throws Exception{
		try
		{
		
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@And("^system displays the ULD details - Flight Number / Date / STD / ULD No. / Destination / Class/Category / Bay / Bag Count / Staff Number / last successfully loaded bag in the current transaction$")
	public void system_display_the_ULD_details_Flight_Number_Date_STD_ULD_No_Destination_Class_Category_Bay_Bag_Count_Staff_Number_last_successfully_loaded_bag_in_the_current_transaction() throws Exception{
		try
		{
		  //Need to add after id details are fixed by dev team
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@When("^the user scans/enters the tag of different class$")
	public void the_user_scans_enters_the_tag_of_different_class() throws Exception{
		try
		{
			Thread.sleep(1000);
			brsLoadPage.enterBagTagNo(propObject.getProperty("BRSLoadBag.BagTagClassY"));
			act.sendKeys(Keys.ENTER).build().perform();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}
	
	@When("^the user scans/enters the tag$")
	public void the_user_scans_enters_the_tag() throws Exception{
		try
		{
			Thread.sleep(1000);
			brsLoadPage.enterBagTagNo(propObject.getProperty("BRSLoadBag.ValidTagSingleBSM2"));
			act.sendKeys(Keys.ENTER).build().perform();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}
	
	@And("^user has entered the ULD number of specific category$")
	public void user_has_entered_the_ULD_number_of_specific_category() throws Exception{
		try
		{
			Thread.sleep(1000);
			brsLoadPage.enterULD(propObject.getProperty("BRSLoadBag.CategoryTULD"));
			act.sendKeys(Keys.ENTER).build().perform();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}
	
	@Then("^the system will throw an error and display No WRONG ULD CLASS$")
	public void the_system_wil_throw_an_error_and_display_NO_WRONG_ULD_CLASS() throws Exception{
		try
		{
			Thread.sleep(2000);
			captureScreen();
			if (brsLoadPage.getNoULDErrMsg().contains(propCommon.getProperty("WrongULDClass"))) {
				System.out.println("Error Msg : "+brsLoadPage.getNoULDErrMsg());
				Assert.assertEquals(true,brsLoadPage.getNoULDErrMsg());
			} else {
				System.out.println("Error msg as WRONG ULD CLASS dint appear");
				Assert.assertEquals(false,"Error msg as WRONG ULD CLASS dint appear");
			}
			brsLoadPage.clickDismissOptionBagTag();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}
	
	@Then("^the system will throw an error and display NO Wrong ULD type$")
	public void the_system_wil_throw_an_error_and_display_NO_Wrong_ULD_type() throws Exception{
		try
		{
			Thread.sleep(2000);
			captureScreen();
			Assert.assertEquals(brsLoadPage.getNoULDErrMsg().trim(), propCommon.getProperty("WrongULDCategory"));
			
			brsLoadPage.clickDismissOptionBagTag();
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}
	
	@Then("^the system will throw an error ULD Maximum Capacity Reached$")
	public void the_system_wil_throw_and_error_ULD_Maximum_Capacity_Reached() throws Exception{
		try
		{
			Thread.sleep(2000);
			captureScreen();
			if (brsLoadPage.getNoULDErrMsg().contains(propCommon.getProperty("MaxLimitError"))) {
				System.out.println("Error Msg : "+brsLoadPage.getNoULDErrMsg());
				Assert.assertEquals(true,brsLoadPage.getNoULDErrMsg());
			} else {
				System.out.println("Error msg as WARNING : EXCEEDS ULD LIMIT MAX ALLLOWED PCS does not exist");
				Assert.assertEquals(false,"Error msg as 'WARNING : EXCEEDS ULD LIMIT MAX ALLLOWED PCS' does not exist");
			}
			brsLoadPage.clickDismissOptionBagTag();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}
	
	@Then("^the system will throw an error and display NO WRONG ULD$")
	public void the_system_will_throw_an_error_and_display_NO_WRONG_ULD() throws Exception{
		try
		{
			Thread.sleep(2000);
			captureScreen();
			if (brsLoadPage.getNoULDErrMsg().contains(propCommon.getProperty("WrongULDSplSegr"))) {
				System.out.println("Error Msg : "+brsLoadPage.getNoULDErrMsg());
				Assert.assertEquals(true,brsLoadPage.getNoULDErrMsg());
			} else {
				System.out.println("Error msg as 'WRONG ULD' does not exist");
				Assert.assertEquals(false,"Error msg as 'WRONG ULD' dint appear");
			}
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}
	
	@And("^will not allow the user to load the bag on that ULD$")
	public void will_not_allow_the_user_to_load_the_bag_on_that_ULD() throws Exception{
		try
		{
			brsLoadPage.clickDismissOptionBagTag();
		}
		catch(Exception ex)
		{
			captureScreen();
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@When("^the user scans/enters the tag of different category$")
	public void the_user_scans_enters_the_tag_of_different_category() throws Exception{
		try
		{
			Thread.sleep(1000);
			brsLoadPage.enterBagTagNo(propObject.getProperty("BRSLoadBag.BagTagLocal"));
			act.sendKeys(Keys.ENTER).build().perform();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}
	
	@And("^the flight/date is valid$")
	public void the_flight_date_is_valid() throws Exception{
		try
		{
		
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@And("^the user is attempting to load the bag of given category to a different category of ULD$")
	public void the_user_is_attempting_to_load_the_bag_of_given_category_to_a_different_category_of_ULD() throws Exception{
		try
		{
		
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@And("^the inbound or outbound segregation doesn't match and rest of the checks match with that of the ULD$")
	public void the_inbound_or_outbound_segregation_doesnt_match_and_rest_of_the_checks_match_with_that_of_the_ULD() throws Exception{
		try
		{
		
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@And("^Best ULD does not exist$")
	public void Best_ULD_does_not_exist() throws Exception{
		try
		{
		
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	

	@Then("^the system will throw an error and display 'ULD Inbound Segregation rules does not match with Bag'$")
	public void the_system_will_throw_an_error_and_display_ULD_Inbound_Segregation_rules_does_not_match_with_Bag() throws Exception{
		try
		{
			Thread.sleep(3000);
			captureScreen();
			Assert.assertEquals(brsLoadPage.getNoULDErrMsg(), propCommon.getProperty("IBError"));
			
			brsLoadPage.clickDismissOptionBagTag();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}
	
	@Then("^the system will throw an error and display 'ULD outbound Segregation rules does not match with Bag'$")
	public void the_system_will_throw_an_error_and_display_ULD_outbound_Segregation_rules_does_not_match_with_Bag() throws Exception{
		try
		{
			Thread.sleep(3000);
			captureScreen();
			Assert.assertEquals(brsLoadPage.getNoULDErrMsg(), propCommon.getProperty("IBError"));
			
			brsLoadPage.clickDismissOptionBagTag();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}
	
	@Then("^the CloseULD and OffLoad Bag buttons should be Disabled'$")
	public void the_CloseULD_and_OffLoad_Bag_buttons_should_be_Disabled() throws Exception{
		try
		{
			Thread.sleep(3000);
			if (brsLoadPage.verifyCloseULDButton() && brsLoadPage.verifyOffloadBagButton()) {
				Assert.assertEquals(true,"CloseULd and OffLoadBag Buuton is disabled for Loader user");
			} else {
				Assert.assertEquals(false,"CloseULd and OffLoadBag Buuton is not disabled for Loader user");
			
			}
			
			brsLoadPage.clickDismissOptionBagTag();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}
}
