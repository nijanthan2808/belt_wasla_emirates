package com.beltWasla.steps;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.ExtentTest;
//import com.aventstack.extentreports.ExtentTest;
import com.beltWasla.pages.BRSLoadBagPage;
import com.beltWasla.pages.DisruptionLoadBagPage;
import com.beltWasla.pages.HomeScreen_BELT;
import com.beltWasla.runners.TestRunner;
import com.beltWasla.setUp.TestContext;
import com.beltWasla.utils.Screenshot;
import com.beltWasla.utils.ApplicationLauncher;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DisruptionLoadBagSteps extends ApplicationLauncher{

	public int bagCount = 0;
	
	public Actions act = new Actions(driver);
	
	TestContext testContext;
	DisruptionLoadBagPage disruptionLoadBag;
	HomeScreen_BELT homePage;
	BRSLoadBagPage brsLoadPage;

	public DisruptionLoadBagSteps(TestContext context) {
		
		testContext = context;
		disruptionLoadBag = testContext.getPageObjectManager().getDisruptionPage();
		homePage = testContext.getPageObjectManager().getHomePage();
		brsLoadPage = testContext.getPageObjectManager().getBrsLoadBagPage();
	}
	ExtentTest logger;

	int DEFAULT_WAIT_4_PAGE = 15;

	String thisClassName = getClass().getSimpleName();

	public void captureScreen() {

		Screenshot.takeScreenshot(TestRunner.dateTime, thisClassName, scenarioName);

	}
	
	@And("^the user has launched the Disruption load bag feature$")
	public void the_user_has_launched_the_Disruption_load_bag_feature() throws Exception{
		try
		{
			homePage.clickHamburgerDisruptionLoadBag();
		}
		catch(Exception ex)
		{
			captureScreen();
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@And("^ULD is NOT registered as 'Disruption ULD'$")
	public void ULD_is_NOT_registered_as_Disruption_ULD() throws Exception{
		try
		{
			// Not a Disrupted ULD
		}
		catch(Exception ex)
		{
			captureScreen();
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@And("^Disruption mode is 'ON'$")
	public void Disruption_mode_is_ON() throws Exception{
		try
		{
			Assert.assertEquals(disruptionLoadBag.verifyDisruptionMode(),"Disruption Mode is Enabled : "+disruptionLoadBag.verifyDisruptionMode());
		}
		catch(Exception ex)
		{
			captureScreen();
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@And("^the user is attempting to scan the ULD$")
	public void the_user_is_attempting_to_scan_the_ULD() throws Exception{
		try
		{
			// Not a Disrupted ULD
		}
		catch(Exception ex)
		{
			captureScreen();
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@When("^the user scans or manually enters the unregistered ULD number$")
	public void the_user_scans_or_manually_enters_the_unregistered_ULD_number() throws Exception{
		try
		{
			Thread.sleep(1000);
			brsLoadPage.enterULD(propObject.getProperty("DLB.UnregisteredULD"));
			act.sendKeys(Keys.ENTER).build().perform();
		}
		catch(Exception ex)
		{
			captureScreen();
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@Then("^the system should throw the error message, \"ULD NOT REGISTERED\"$")
	public void the_system_should_throw_the_error_message_ULD_NOT_REGISTERED() throws Exception{
		try
		{
			Thread.sleep(2000);
			captureScreen();
			Assert.assertTrue(brsLoadPage.getNoULDErrMsg().equals(propCommon.getProperty("DisruptionULDNotRegistered")));
			
			brsLoadPage.clickDismissOption();
		}
		catch(Exception ex)
		{
			captureScreen();
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@And("^Disrupted ULD status = Assigned$")
	public void Disrupted_ULD_status_Assigned() throws Exception{
		try
		{
			// Disrupted ULD status check should be implemented from DB
		}
		catch(Exception ex)
		{
			captureScreen();
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@When("^the user scans or manually enters the ULD number which is already assigned$")
	public void the_user_scans_or_manually_enters_the_ULD_number_which_is_already_assigned() throws Exception{
		try
		{
			Thread.sleep(1000);
			brsLoadPage.enterULD(propObject.getProperty("DLB.AssignedULD"));
			act.sendKeys(Keys.ENTER).build().perform();
		}
		catch(Exception ex)
		{
			captureScreen();
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@And("on clicking on 'Dismiss', the ULD details should be cleared from the screen$")
	public void on_clicking_on_Dismiss_the_ULD_details_should_be_cleared_from_the_screen() throws Exception{
		try
		{	
			Thread.sleep(2000);
			captureScreen();
			if (brsLoadPage.getULD().trim().isEmpty()) {
				Assert.assertEquals(true,"The ULD details is cleared from the screen");
			}else {
				Assert.assertEquals(false,"The ULD details is cleared from the screen");
			}
		}
		catch(Exception ex)
		{
			captureScreen();
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@When("^the user scans the ULD or manually enters the ULD number$")
	public void the_user_scans_the_ULD_or_manually_enters_the_ULD_number() throws Exception{
		try
		{
			Thread.sleep(1000);
			brsLoadPage.enterULD(propObject.getProperty("DLB.OpenULD"));
			act.sendKeys(Keys.ENTER).build().perform();
		}
		catch(Exception ex)
		{
			captureScreen();
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@Then("^the system will validate the ULD scanned and display the ULD details$")
	public void  the_system_will_validate_the_ULD_scanned_and_display_the_ULD_details() throws Exception{
		try
		{
			Thread.sleep(2000);
			captureScreen();
			if(disruptionLoadBag.getUldClass()!="" && disruptionLoadBag.getDispUldNo()!="" && disruptionLoadBag.getUldBagCount()!=""
					&& disruptionLoadBag.getUldCategory()!="" && disruptionLoadBag.getULDdestination()!="") {
				Assert.assertEquals(true,"All the ULD details are present in Disruption screen");	
			}else
			{
				Assert.assertEquals(false,"Few ULD details are missing in the Disruption screen");	
			}
			
			System.out.println("ULD Details are : ");
			System.out.println("ULD Class : " + disruptionLoadBag.getUldClass());
			System.out.println("ULD Category : " + disruptionLoadBag.getUldCategory());
			System.out.println("ULD Destination : " + disruptionLoadBag.getULDdestination());
			System.out.println("ULD Bag Count : " + disruptionLoadBag.getUldBagCount());
			System.out.println("ULD No. : " + disruptionLoadBag.getDispUldNo());
			
		}
		catch(Exception ex)
		{
			captureScreen();
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@And("^ULD has already been scanned$")
	public void ULD_has_already_been_scanned() throws Exception{
		try
		{
			Thread.sleep(1000);
			brsLoadPage.enterULD(propObject.getProperty("DLB.OpenULD"));
			act.sendKeys(Keys.ENTER).build().perform();
			Thread.sleep(2000);
			bagCount = Integer.parseInt(disruptionLoadBag.getUldBagCount());
		}
		catch(Exception ex)
		{
			captureScreen();
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@Then("^the following details should be seen on the screen eg - Last Bag tag Scanned, Total No. of Bags loaded etc.$")
	public void the_following_details_should_be_seen_on_the_screen_eg_Last_Bag_tag_Scanned_Total_No_of_Bags_loaded_etc() throws Exception{
		try
		{
			Thread.sleep(2000);
			captureScreen();
			
			//Checking for PAX Details
			if(disruptionLoadBag.getDispLoadPaxVal()!="" && disruptionLoadBag.getDispLoadRouteVal()!="" && disruptionLoadBag.getDispLoadStatusVal()!=""
					&& disruptionLoadBag.getDispLoadFltDateVal()!="" && disruptionLoadBag.getDispLoadFltNoVal()!="") {
				Assert.assertEquals(true,"Pax details are present in Disruption screen");	
			}else
			{
				Assert.assertEquals(false,"Few Pax details are missing in the Disruption screen");	
			}
			
			//Checking for PAX Label Header Details
			if(disruptionLoadBag.getDispLoadPaxLbl()!="" && disruptionLoadBag.getDispLoadRouteLbl()!="" && disruptionLoadBag.getDispLoadStatusLbl()!=""
					&& disruptionLoadBag.getDispLoadFltDateLbl()!="" && disruptionLoadBag.getDispLoadFltNoLbl()!="") {
				Assert.assertEquals(true,"Pax label details are present in Disruption screen");	
			}else
			{
				Assert.assertEquals(false,"Few Pax label details are missing in the Disruption screen");	
			}
			System.out.println("Pax Details are : ");
			System.out.println(disruptionLoadBag.getDispLoadPaxLbl()+ " " + disruptionLoadBag.getDispLoadPaxVal());
			System.out.println(disruptionLoadBag.getDispLoadRouteLbl()+ " " + disruptionLoadBag.getDispLoadRouteVal());
			System.out.println(disruptionLoadBag.getDispLoadStatusLbl()+ " " + disruptionLoadBag.getDispLoadStatusVal());
			System.out.println(disruptionLoadBag.getDispLoadFltDateLbl()+ " " + disruptionLoadBag.getDispLoadFltDateVal());
			System.out.println(disruptionLoadBag.getDispLoadFltNoLbl()+ " " + disruptionLoadBag.getDispLoadFltNoVal());
			
		}
		catch(Exception ex)
		{
			captureScreen();
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@And("^bag belongs to a Flight which is headed to the same destination as the Disrupted ULD.$")
	public void bag_belongs_to_a_Flight_which_is_headed_to_the_same_destination_as_the_Disrupted_ULD() throws Exception{
		try
		{
			//Need to Check in DB after DB implementation
		}
		catch(Exception ex)
		{
			captureScreen();
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@When("^the user scans the tag or manually enters the tag number$")
	public void the_user_scans_the_tag_or_manually_enters_the_tag_number() throws Exception{
		try
		{
			Thread.sleep(1000);
			brsLoadPage.enterBagTagNo(propObject.getProperty("DLB.ValidTagSingleBSM1"));
			act.sendKeys(Keys.ENTER).build().perform();
		}
		catch(Exception ex)
		{
			captureScreen();
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@Then("^System will allow loading of bags to the ULD, with the following message in Green \"YES Bag..Successfully Loaded..\"$")
	public void System_will_allow_loading_of_bags_to_the_ULD_with_the_following_message_in_Green_YES_Bag_Successfully_Loaded() throws Exception{
		try
		{
			Thread.sleep(2000);
			captureScreen();
			if (disruptionLoadBag.getlastBagLogged().contains(propCommon.getProperty("lastBagScanned")) 
					&& bagCount<Integer.parseInt(disruptionLoadBag.getUldBagCount())) {
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
	
	@When("^the user scans the tag or manually enters the valid tag number$")
	public void the_user_scans_the_tag_or_manually_enters_the_valid_tag_number() throws Exception{
		try
		{
			Thread.sleep(1000);
			brsLoadPage.enterBagTagNo(propObject.getProperty("DLB.ValidTagSingleBSM2"));
			act.sendKeys(Keys.ENTER).build().perform();
		}
		catch(Exception ex)
		{
			captureScreen();
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@And("^bag is not already loaded$")
	public void bag_is_not_already_loaded() throws Exception{
		try
		{
		}
		catch(Exception ex)
		{
			captureScreen();
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@When("^the user scans the tag or manually enters the invalid tag number$")
	public void the_user_scans_the_tag_or_manually_enters_the_invalid_tag_number() throws Exception{
		try
		{
			Thread.sleep(1000);
			brsLoadPage.enterBagTagNo(propObject.getProperty("DLB.BagTagNoBSM"));
			act.sendKeys(Keys.ENTER).build().perform();
		}
		catch(Exception ex)
		{
			captureScreen();
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@Then("^system will display red scan \"NO UNKNOWN BAG TAG \" with the option to dismiss$")
	public void system_will_display_red_scan_NO_UNKNOWN_BAG_TAG_with_the_option_to_dismiss() throws Exception{
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
	
	@And("^the destination of ULD and bag does not match$")
	public void the_destination_of_ULD_and_bag_does_not_match() throws Exception{
		try
		{
		}
		catch(Exception ex)
		{
			captureScreen();
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@And("^ULD is in Open status$")
	public void ULD_is_in_Open_status() throws Exception{
		try
		{
		}
		catch(Exception ex)
		{
			captureScreen();
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@And("^the user scans or manually enters the Non-disrupted ULD number$")
	public void the_user_scans_or_manually_enters_the_Non_disrupted_ULD_number() throws Exception{
		try
		{
			Thread.sleep(1000);
			brsLoadPage.enterULD(propObject.getProperty("DLB.NonDisruptedULD"));
			act.sendKeys(Keys.ENTER).build().perform();
		}
		catch(Exception ex)
		{
			captureScreen();
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@And("^ULD is registered as 'Disruption ULD'$")
	public void ULD_is_registered_as_Disruption_ULD() throws Exception{
		try
		{
			// Not a Disrupted ULD
		}
		catch(Exception ex)
		{
			captureScreen();
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@When("^the user scans the tag or manually enters the tag number with different destination as of ULD$")
	public void the_user_scans_the_tag_or_manually_enters_the_tag_number_with_different_destination_as_of_ULD() throws Exception{
		try
		{
			Thread.sleep(1000);
			brsLoadPage.enterBagTagNo(propObject.getProperty("DLB.ValidTagDiffDestination"));
			act.sendKeys(Keys.ENTER).build().perform();
		}
		catch(Exception ex)
		{
			captureScreen();
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@Then("^the system will display message \"ULD destination does not match\"$")
	public void the_system_will_display_message_ULD_destination_does_not_match() throws Exception{
		try
		{
			Thread.sleep(3000);
			captureScreen();
			Assert.assertEquals(brsLoadPage.getNoULDErrMsg(), propCommon.getProperty("WrongULDDest"));
			brsLoadPage.clickDismissOptionBagTag();
		}
		catch(Exception ex)
		{
			captureScreen();
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@And("the system should allow the user to view the disruption feature$")
	public void the_system_should_allow_the_user_to_view_the_disruption_feature() throws Exception{
		try
		{	
			Thread.sleep(1000);
			captureScreen();
			if (brsLoadPage.getULD().trim().isEmpty()) {
				Assert.assertEquals(true,"The Disruption feature is visible");
			}else {
				Assert.assertEquals(false,"The Disruption feature is not visible");
			}
		}
		catch(Exception ex)
		{
			captureScreen();
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@And("^user has entered the Class related ULD number$")
	public void use_has_entered_the_Class_related_ULD_number() throws Exception{
		try
		{
			Thread.sleep(1000);
			brsLoadPage.enterULD(propObject.getProperty("DLB.ClassJULD"));
			act.sendKeys(Keys.ENTER).build().perform();
			Thread.sleep(2000);
			bagCount = Integer.parseInt(disruptionLoadBag.getUldBagCount());
		}
		catch(Exception ex)
		{
			captureScreen();
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@When("^the user scans/enters the tag of same class$")
	public void the_user_scans_enters_the_tag_of_same_class() throws Exception{
		try
		{
			Thread.sleep(1000);
			brsLoadPage.enterBagTagNo(propObject.getProperty("DLB.BagTagClassJ"));
			act.sendKeys(Keys.ENTER).build().perform();
		}
		catch(Exception ex)
		{
			captureScreen();
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@And("^the user is attempting to load a bag of same class other that is registered on the disrupted ULD$")
	public void the_user_is_attempting_to_load_a_bag_of_same_class_other_that_is_registered_on_the_disrupted_ULD() throws Exception{
		try
		{
		}
		catch(Exception ex)
		{
			captureScreen();
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@And("^the user is attempting to load a bag for different class other than the one that is registered on the disrupted ULD$")
	public void the_user_is_attempting_to_load_a_bag_for_different_class_other_than_the_one_that_is_registered_on_the_disrupted_ULD() throws Exception{
		try
		{
		}
		catch(Exception ex)
		{
			captureScreen();
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@When("^the user scans/enters the tag of different class than ULD class$")
	public void the_user_scans_enters_the_tag_of_different_class_than_ULD_class() throws Exception{
		try
		{
			Thread.sleep(1000);
			brsLoadPage.enterBagTagNo(propObject.getProperty("DLB.BagTagClassY").trim());
			Thread.sleep(1000);
			act.sendKeys(Keys.ENTER).build().perform();
			
		}
		catch(Exception ex)
		{
			captureScreen();
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@Then("^the system should validate the baggage class and the ULD class and display error message like \"NO - WRONG ULD CLASS - ULD Class F, Bag Class J\"$")
	public void the_system_should_validate_the_baggage_class_and_the_ULD_class_and_display_error_message_like_NO_WRONG_ULD_CLASS_ULD_Class_F_Bag_Class_J() throws Exception{
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
	
	@And("^all other disruption reconciliation checks of bag and ULD matches except for the Class$")
	public void all_other_disruption_reconciliation_checks_of_bag_and_ULD_matches_except_for_the_Class() throws Exception{
		try
		{
		}
		catch(Exception ex)
		{
			captureScreen();
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@And("^all other disruption reconciliation checks of bag and ULD matches, including Class$")
	public void all_other_disruption_reconciliation_checks_of_bag_and_ULD_matches_including_Class() throws Exception{
		try
		{
		}
		catch(Exception ex)
		{
			captureScreen();
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@When("^the user scans the multi BSM tag number bag$")
	public void the_user_scans_the_multi_BSM_tag_number_bag() throws Exception{
		try
		{
			Thread.sleep(1000);
			brsLoadPage.enterBagTagNo(propObject.getProperty("DLB.ValidMultiBSMTag"));
			act.sendKeys(Keys.ENTER).build().perform();
		}
		catch(Exception ex)
		{
			captureScreen();
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@Then("^System displays a red scan \"NO..DUPLICATE BAGTAG\" with an option to \"Dismiss\"$")
	public void System_displays_a_red_scan_NO_DUPLICATE_BAGTAG_with_an_option_to_Dismiss() throws Exception{
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
	
	@And("^the tag has miultiple BSMs linked for the past x days$")
	public void the_tag_has_miultiple_BSMs_linked_for_the_past_x_days() throws Exception{
		try
		{
		}
		catch(Exception ex)
		{
			captureScreen();
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
}
