package com.beltWasla.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WaslaQohPage {

	WebDriver driver;

	// Page Constructor
	public WaslaQohPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// All Page Elements With Locators
	
	@FindBy(id = "main-page-title-label")
	WebElement qohPageTitle;
	
	@FindBy(id = "")
	WebElement mainMenuButton;
	
	@FindBy(id="qoh-airline")
	WebElement airlineField;
	
	@FindBy(id="qoh-tag")
	WebElement tagField;
	
	@FindBy(name = "CREATE QOH")
	WebElement createButton;
	
	@FindBy(name = "REMOVE ALL")
	WebElement removeAllButton;
	
	@FindBy(id="qoh-tag-helper-text")
	WebElement tagFieldError;

	@FindBy(id="alert-dialog-slide-description")
	WebElement qohTopErrorAlert;
	
	@FindBy(id="Dismiss")
	WebElement dismissButtonAlert;
	
	@FindBy(id="editLocation")
	WebElement editLocation;
	
	@FindBy(id="locationCode")
	WebElement selectedLocation;
	
	@FindBy(id="ek-snackbar-content")
	WebElement successMessageFrame;
	
	@FindBy(id="client-snackbar-icon")
	WebElement successMessage;
	
	@FindBy(id="panel1d-header")
	WebElement multiBSMDD;
	
	@FindBy(name="Submit")
	WebElement submitButton;
	
	@FindBy(xpath = "//input[@name='radio-button'][1]")
	WebElement selectBSMDD;
	
	@FindBy(id = "qoh-airline-ek")
	WebElement airlineDropdown;
	
	@FindBy(id = "EK")
	WebElement airlineEK;
	
	@FindBy(id = "FZ")
	WebElement airlineFZ;
	
	// Home Page Actions as Methods

	public void verifyDfsPageTitle() {
		qohPageTitle.getText();
	}

	public void clickMainMenu() {
		mainMenuButton.click();
	}
	
	public void clickSubmit() {
		submitButton.click();
	}

	public void clickMultiBSMDD() {
		multiBSMDD.click();
	}
	
	public void selectBSMDD() {
		selectBSMDD.click();
	}
	
	public void enterAirline(String airlineCode) {
		airlineField.sendKeys(airlineCode);
	}
	
	public void enterTag(String tagNumber) {
		tagField.sendKeys(tagNumber);
	}
	
	public void clickCreate() {
		createButton.click();
	}
	
	public void clickRemove() {
		removeAllButton.click();
	}
	
	public String getTagFieldErrorMessage() {
		String getTagFieldErrorMsg = tagFieldError.getText();
		return getTagFieldErrorMsg;
	}
	
	public String getTopErrorMessage() {
		String getTopErrorMsg = qohTopErrorAlert.getText();
		return getTopErrorMsg;
	}
	
	public void clickDismiss() {
		dismissButtonAlert.click();
	}
	
	public void clickEditLocation() {
		editLocation.click();
	}
	
	public String getSelectedLocation() {
		String getSelectedLocationValue = selectedLocation.getText();
		return getSelectedLocationValue;
	}
	
	public boolean checkSuccessMsg() {
		boolean checkSuccessMsg = successMessage.isDisplayed();
		return checkSuccessMsg;
	}
	
	public String gettoastMessage() {
		String gettoastMessage = successMessage.getText();
		return gettoastMessage;
	}
	
	public void clickAirlineDD() {
		airlineDropdown.click();
	}
	
	public void selectEK() {
		airlineEK.click();
	}
	
	public void selectFZ() {
		airlineFZ.click();
	}
	
}
