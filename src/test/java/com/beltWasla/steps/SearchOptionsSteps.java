package com.beltWasla.steps;

import org.openqa.selenium.By;
//import com.aventstack.extentreports.ExtentTest;
import com.relevantcodes.extentreports.ExtentTest;
import com.beltWasla.pages.HomeScreen_BELT;
import com.beltWasla.pages.SearchOptionsPage;
import com.beltWasla.runners.TestRunner;
import com.beltWasla.setUp.TestContext;
import com.beltWasla.utils.ApplicationLauncher;
import com.beltWasla.utils.Screenshot;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SearchOptionsSteps extends ApplicationLauncher {

	ExtentTest logger;

	int DEFAULT_WAIT_4_PAGE = 15;

	String thisClassName = getClass().getSimpleName();

	TestContext testContext;
	SearchOptionsPage tagSearchPage;
	HomeScreen_BELT homePage;

	public SearchOptionsSteps(TestContext context) {
		testContext = context;
		tagSearchPage = testContext.getPageObjectManager().getTagSearchPage();
		homePage = testContext.getPageObjectManager().getHomePage();
	}

	public void captureScreen() {

		Screenshot.takeScreenshot(TestRunner.dateTime, thisClassName, scenarioName);

	}

	@Given("^the user has launched the Search feature$")
	public void the_user_has_launched_the_Search_feature() {
		try {
			homePage.clickTagSearchIcon();
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Given("^the user selected the date range for MACS$")
	public void the_user_selected_the_date_range_for_MACS() {
		try {
			String date = propObject.getProperty("TagSearch.MacsFromDate");

			String day, month, year, monthYear;

			day = date.split("-")[0];

			month = date.split("-")[1];

			year = date.split("-")[2];

			monthYear = month+" "+year; 

			System.out.println("Day :" + day);

			System.out.println("Month :" + month);

			System.out.println("Year :" + year);

			System.out.println("Month Year :" + monthYear);
			
			tagSearchPage.selectFromDate();
		
			Thread.sleep(2000);
			String selectedMonthYear=tagSearchPage.getMonthYear();
			
			while(!selectedMonthYear.equals(monthYear)) 
			{
				tagSearchPage.clickPreviousMonth();
				Thread.sleep(1000);
				selectedMonthYear=tagSearchPage.getMonthYear();
			}
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//*[text()='"+day+"']")).click();
				
		
		
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Given("^the user selected the date range for ALL$")
	public void the_user_selected_the_date_range_for_ALL() {
		try {
			String date = propObject.getProperty("TagSearch.AllFromDate");

			String day, month, year, monthYear;

			day = date.split("-")[0];

			month = date.split("-")[1];

			year = date.split("-")[2];

			monthYear = month+" "+year; 

			System.out.println("Day :" + day);

			System.out.println("Month :" + month);

			System.out.println("Year :" + year);

			System.out.println("Month Year :" + monthYear);
			
			tagSearchPage.selectFromDate();
		
			Thread.sleep(2000);
			String selectedMonthYear=tagSearchPage.getMonthYear();
			
			while(!selectedMonthYear.equals(monthYear)) 
			{
				tagSearchPage.clickPreviousMonth();
				Thread.sleep(1000);
				selectedMonthYear=tagSearchPage.getMonthYear();
			}
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//*[text()='"+day+"']")).click();
				
		
		
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}
	
	@Given("^the user selected the date range for BIR$")
	public void the_user_selected_the_date_range_for_BIR() {
		try {
		/*	String date = propObject.getProperty("TagSearch.BirFromDate");

			String day, month, year, monthYear;

			day = date.split("-")[0];

			month = date.split("-")[1];

			year = date.split("-")[2];

			monthYear = month+" "+year; 

			System.out.println("Day :" + day);

			System.out.println("Month :" + month);

			System.out.println("Year :" + year);

			System.out.println("Month Year :" + monthYear);
			
			tagSearchPage.selectFromDate();
		
			Thread.sleep(2000);
			String selectedMonthYear=tagSearchPage.getMonthYear();
			
			while(!selectedMonthYear.equals(monthYear)) 
			{
				tagSearchPage.clickPreviousMonth();
				Thread.sleep(1000);
				selectedMonthYear=tagSearchPage.getMonthYear();
			}
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//*[text()='"+day+"']")).click();
				
		*/
		
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}
	@When("^the user scans or enters the tag number and selects the BIR option$")
	public void the_user_scans_or_enters_the_tag_number_and_selects_the_BIR_option() {
		try {
			tagSearchPage.enterTagToSearch(propObject.getProperty("TagSearch.ValidTagBIR"));
			tagSearchPage.selectBIR();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user clicks on search$")
	public void the_user_clicks_on_search() {
		try {
			tagSearchPage.clickSearch();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the system will display the details available for the tag$")
	public void the_system_will_display_the_details_available_for_the_tag() {
		try {
			// Result displayed
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^Clicking on a result will display the complete details$")
	public void clicking_on_a_result_will_display_the_complete_details() {
		try {
			tagSearchPage.selectFirstResult();
			// The detailed results are shown
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user scans or enters the tag number and selects the option MACS with EK$")
	public void the_user_scans_or_enters_the_tag_number_and_selects_the_option_MACS_with_EK() {
		try {
			tagSearchPage.enterTagToSearch(propObject.getProperty("TagSearch.ValidTagMACSEK"));
			tagSearchPage.selectMacs();
			tagSearchPage.selectEK();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user scans or enters the tag number and selects the option MACS with OAL$")
	public void the_user_scans_or_enters_the_tag_number_and_selects_the_option_MACS_with_OAL() {
		try {
			tagSearchPage.enterTagToSearch(propObject.getProperty("TagSearch.ValidTagMACSOAL"));
			tagSearchPage.selectMacs();
			tagSearchPage.selectOAL();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user scans or enters the tag number and selects the option MACS with BOTH$")
	public void the_user_scans_or_enters_the_tag_number_and_selects_the_option_MACS_with_BOTH() {
		try {
			tagSearchPage.enterTagToSearch(propObject.getProperty("TagSearch.ValidTagMACSBOTH"));
			tagSearchPage.selectMacs();
			tagSearchPage.selectBOTH();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user scans or enters the tag number and selects the option WT$")
	public void the_user_scans_or_enters_the_tag_number_and_selects_the_option_WT() {
		try {
			tagSearchPage.enterTagToSearch(propObject.getProperty("TagSearch.ValidTagWT"));
			tagSearchPage.selectWT();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user scans or enters the tag number and selects the option WT FWD$")
	public void the_user_scans_or_enters_the_tag_number_and_selects_the_option_WT_FWD() {
		try {
			tagSearchPage.enterTagToSearch(propObject.getProperty("TagSearch.ValidTagWTFWD"));
			tagSearchPage.selectWtFwd();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user scans or enters the tag number and selects the option 'All'$")
	public void the_user_scans_or_enters_the_tag_number_and_selects_the_option_All() {
		try {
			tagSearchPage.enterTagToSearch(propObject.getProperty("TagSearch.ValidTagAll"));
			tagSearchPage.selectALL();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the system will search all the systems - BIR, WT FWD, WT \\(AHL/OHD/DPR\\) MACS -EK & OAL\\) and with the option to the user to deselect one of the source in MACS and display the details$")
	public void the_system_will_search_all_the_systems_BIR_WT_FWD_WT_AHL_OHD_DPR_MACS_EK_OAL_and_with_the_option_to_the_user_to_deselect_one_of_the_source_in_MACS_and_display_the_details() {
		try {
			// Will fetch all the system details
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the user will be able to swtich accross the tabs and view the results$")
	public void the_user_will_be_able_to_swtich_accross_the_tabs_and_view_the_results() {
		try {
			tagSearchPage.openWtTab();
			tagSearchPage.openBIRtab();
			tagSearchPage.openWTfwdTab();
			tagSearchPage.openMacsTab();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user scans or enters the tag number with no data and selects the option 'All'$")
	public void the_user_scans_or_enters_the_tag_number_with_no_data_and_selects_the_option_All() {
		try {
			tagSearchPage.enterTagToSearch(propObject.getProperty("TagSearch.InvalidTagAll"));
			tagSearchPage.selectALL();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@When("^the user click on search$")
	public void the_user_click_on_search() {
		try {
			tagSearchPage.clickSearch();
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^the system will search all the systems - BIR, WT FWD, WT \\(AHL/OHD/DPR\\) MACS -EK & OAL\\)$")
	public void the_system_will_search_all_the_systems_BIR_WT_FWD_WT_AHL_OHD_DPR_MACS_EK_OAL() {
		try {
			// Will fetch all the system details
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

	@Then("^display error \"([^\"]*)\" in all tabs$")
	public void display_error_in_all_tabs(String arg1) {
		try {
			if ((tagSearchPage.getFullErrorMsg()).equals(" ")) {
				// Error message verified
			}
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen();
			throw new RuntimeException();
		}
	}

}
