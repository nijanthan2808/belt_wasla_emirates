package com.beltWasla.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RackBagPage {

	WebDriver driver;

	// Page Constructor
	public RackBagPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// All Page Elements With Locators
	
	@FindBy(id = "main-page-title-label")
	WebElement rackBagPageTitle;
	
	@FindBy(id = "hamburgermenuID")
	WebElement mainMenuButton;
	
	@FindBy(id="editLocation")
	WebElement editLocation;
	
	@FindBy(id="locationCode")
	WebElement selectedLocation;
	
	@FindBy(id="mhb-store-rack-num")
	WebElement selectRackField;
	
	@FindBy(id="enter-rack-number")
	WebElement enterRackField;
	
	@FindBy(id="RackList")
	WebElement rackListDropDown;
	
	@FindBy(xpath="//*[@id='RackList']/div")
	WebElement selectRackDropDown;
	
	@FindBy(id="goBack")
	WebElement goBackButton;
	
	@FindBy(id="mhb-store-tag-ohd")
	WebElement enterTagOhdField;
	
	@FindBy(id="mhb-store-submit-btn")
	WebElement submitButton;
	
	@FindBy(id="mhb-store-clear-btn")
	WebElement clearButton;
	
	@FindBy(id="listItem0")
	WebElement ohdResult;
	
	@FindBy(id="listItem1")
	WebElement ohdResult2;
	
	@FindBy(name="Submit")
	WebElement finalSubmit;
	
	@FindBy(xpath="(//p[@id='alert-dialog-slide-description'])[2]")
	WebElement errorResponse;
	
	@FindBy(id="Dismiss")
	WebElement dismissButton;
	
	
	// Home Page Actions as Methods

	public void verifyDfsPageTitle() {
		rackBagPageTitle.getText();
	}

	public void clickMainMenu() {
		mainMenuButton.click();
	}
	
	public void clickEditLocation() {
		editLocation.click();
	}
	
	public String getSelectedLocation() {
		String getSelectedLocationValue = selectedLocation.getText();
		return getSelectedLocationValue;
	}
	
	public void clickselectRack() {
		selectRackField.click();
	}
	
	public void searchRackNumber(String rackNumber) {
		enterRackField.sendKeys(rackNumber);
	}
	
	public boolean verifyRackList() {
		boolean rackListAvailable = rackListDropDown.isDisplayed();
		return rackListAvailable;
	}
	
	public void selectRackDD() {
		selectRackDropDown.click();
	}
	
	public void clickGoBack() {
		goBackButton.click();
	}
	
	public void enterTagOhdNumber(String tagOhdNumber) {
		enterTagOhdField.sendKeys(tagOhdNumber);
	}
	
	public void enterRackNumber(String rackNumber) {
		enterRackField.sendKeys(rackNumber);
	}
	
	public void clickSubmit() {
		submitButton.click();
	}
	
	public void clickClear() {
		clearButton.click();
	}
	
	public void clickOhdResult() {
		ohdResult.click();
	}
	
	public void clickFinalSubmit() {
		finalSubmit.click();
	}
	
	public void clickDismiss() {
		dismissButton.click();
	}
	
	public String getErrorResponse() {
		String errorMsg = errorResponse.getText();
		return errorMsg;
	}
	
	public String getTopErrorMsg() {
		String errorMessage = errorResponse.getText();
		return errorMessage;
	}
	
	public boolean multiOhdExist() {
		boolean multiOhd = ohdResult2.isDisplayed();
		return multiOhd;
	}
	
	public void clickOhdResult2() {
		ohdResult2.click();
	}
	
}
