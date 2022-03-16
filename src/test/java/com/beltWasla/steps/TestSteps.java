package com.beltWasla.steps;

import com.beltWasla.pages.TestPage;
import com.beltWasla.pages.WaslaQohPage;
import com.beltWasla.runners.TestRunner;
import com.beltWasla.setUp.TestContext;
import com.beltWasla.utils.ApplicationLauncher;
import com.beltWasla.utils.Screenshot;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestSteps extends ApplicationLauncher {

	TestContext testContext;
	TestPage testPage;

	public TestSteps(TestContext context) {
		testContext = context;
		testPage = testContext.getPageObjectManager().getTestPage();
	}
	int DEFAULT_WAIT_4_PAGE = 30;

	String thisClassName = getClass().getSimpleName();

	public void captureScreen() {

		Screenshot.takeScreenshot(TestRunner.dateTime, this.thisClassName, scenarioName);

	}
	

	//Implementation of the steps in the test case file - .feature file
	@Given("^the user has launched the application$")
	public void the_user_has_launched_the_application() throws Throwable {
		launchDemoApplication();
		Thread.sleep(30000);
	}

	@Given("^logged into the application$")
	public void logged_into_the_application() throws Throwable {
		testPage.clickSignInLink();
		testPage.enterUsername(propObject.getProperty("userName"));
		testPage.enterPassworde(propObject.getProperty("password"));
		testPage.clickSignInButton();
	}

	@Given("^goto t-shirt section$")
	public void goto_t_shirt_section() throws Throwable {
		testPage.clickTshirts();
	}

	@Given("^add the t-shirt to cart$")
	public void add_the_t_shirt_to_cart() throws Throwable {
		testPage.moveToItem();
		testPage.clickAddToCart();
	}

	@Given("^proceed to checkout and increase the quantity$")
	public void proceed_to_checkout_and_increase_the_quantity() throws Throwable {
	    testPage.clickProceedToCheckout();
	    testPage.increaseQuantityTo2();
	}

	@Given("^proceed to checkout and enter message$")
	public void proceed_to_checkout_and_enter_message() throws Throwable {
		testPage.clickProceedToCheckoutNext();
		testPage.enterMessage(propObject.getProperty("Message"));
	}

	@Given("^proceed to checkout and agree terms$")
	public void proceed_to_checkout_and_agree_terms() throws Throwable {
		testPage.clickProceedToCheckoutNext();
		testPage.clickAgreeTerms();
	}

	@Given("^proceed to checkout and choose payment$")
	public void proceed_to_checkout_and_choose_payment() throws Throwable {
		testPage.clickProceedToCheckoutLast();
		testPage.clickPayByCheck();
	}

	@When("^the user confirms the order$")
	public void the_user_confirms_the_order() throws Throwable {
		testPage.clickConfirmOrder();
	}

	@Then("^the order placed and verified$")
	public void the_order_placed_and_verified() throws Throwable {
		testPage.getConfirmationText().equals(propObject.getProperty("OrderConfirmation"));
	}

	@Then("^user signed out of the application$")
	public void user_signed_out_of_the_application() throws Throwable {
		testPage.clickSignOut();
	}

}