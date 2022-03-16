package com.beltWasla.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DfsPage_BELT {

	WebDriver driver;

	// Page Constructor
	public DfsPage_BELT(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// All Page Elements With Locators
	
	@FindBy(id = "main-page-title-label")
	WebElement dfsPageTitle;
	
	@FindBy(id = "")
	WebElement mainMenuButton;
	
	@FindBy(id = "dfs-flight-number")
	WebElement flightNumberField;
	
	@FindBy(id = "flight-date")
	WebElement flightDateField;
	
	@FindBy(name = "Cancel")
	WebElement cancelButton;

	@FindBy(name = "Submit")
	WebElement submitButton;
	
	@FindBy(id="dfs-summary-textTop")
	WebElement dfsTextTop;
	
	@FindBy(id="dfs-summary-flight-tab")
	WebElement dfsFlightTab;
	
	@FindBy(id="dfs-flight-number-helper-text")
	WebElement dfsErrorMsg;
	
	@FindBy(id="alert-dialog-slide-description")
	WebElement dfsErrorAlert;
	
	// Home Page Actions as Methods

	public void verifyDfsPageTitle() {
		dfsPageTitle.getText();
	}

	public void clickMainMenu() {
		mainMenuButton.click();
	}

	public void enterFlightNumber(String flightNumber) {
		flightNumberField.sendKeys(flightNumber);
	}
	
	public void enterFlightDate(String flightDate) {
		flightDateField.sendKeys(flightDate);
	}	

	public void clickCancelButton() {
		cancelButton.click();
	}

	public void clickSubmitButton() {
		submitButton.click();
	}
	
	public String getDfsTextTop() {
		String getDfsTextTopSummary = dfsTextTop.getText();
		return getDfsTextTopSummary;
	}
	
	public void switchToFlightTab() {
		dfsFlightTab.click();
	}
	
	public String getDfsErrorMessage() {
		String getDfsErrorMsg= dfsErrorMsg.getText();
		return getDfsErrorMsg;
	}
	
	public String getDfsErrorAlert() {
		String getDfsErrorAlt= dfsErrorAlert.getText();
		return getDfsErrorAlt;
	}
	
}
