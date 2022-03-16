package com.beltWasla.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LocationPage_BELT {

	WebDriver driver;

	// Page Constructor
	public LocationPage_BELT(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// All Page Elements With Locators

	@FindBy(id = "main-page-title-label")
	WebElement locationPageTitle;

	@FindBy(id = "")
	WebElement mainMenuButton;

	@FindBy(id = "search-location-icon")
	WebElement searchIcon;

	@FindBy(id = "search-location")
	WebElement enterSearchLocation;

	@FindBy(id = "locationList")
	WebElement searchedLocationList;

	@FindBy(xpath = "//*[@id='locationList']/div")
	WebElement selectSearchedLocation;

	@FindBy(id = "terminal")
	WebElement selectTerminal;

	@FindBy(id = "area")
	WebElement selectArea;

	@FindBy(id = "code")
	WebElement selectLocation;

	@FindBy(id = "terminal-select-value")
	WebElement enterTerminal;

	@FindBy(id = "area-select-value")
	WebElement enterArea;

	@FindBy(id = "code-select-value")
	WebElement enterLocation;

	@FindBy(id = "locationList")
	WebElement recentList;

	@FindBy(xpath = "//*[@id='locationList']/div")
	WebElement recentLocations;
	
	@FindBy(id="title")
	WebElement errorTitle;

	@FindBy(id="msg")
	WebElement errorMsg;

	@FindBy(id = "clear")
	WebElement clearButton;

	@FindBy(id = "confirm")
	WebElement confirmButton;
	
	@FindBy(id = "client-snackbar-icon")
	WebElement toastMessage;
	
	
	// Home Page Actions as Methods

	public String getLocationPageTitle() {
		String locTitle = locationPageTitle.getText();
		return locTitle;
	}

	public void clickMainMenu() {
		mainMenuButton.click();
	}

	public void clickSearchIcon() {
		searchIcon.click();
	}

	public void enterSearchLocation(String searchLocation) {
		enterSearchLocation.sendKeys(searchLocation);
	}

	public void selectSearchedLocation() {
		selectSearchedLocation.click();
	}

	public void selectAreaFromDropDown() {
		selectArea.click();
	}

	public void selectLocationFromDropDown() {
		selectArea.click();
	}

	public void selectTerminalFromDropDown() {
		selectTerminal.click();
	}

	public void enterTerminalDropDown(String terminalPredictive) {
		enterTerminal.sendKeys(terminalPredictive);
	}

	public void enterAreaDropDown(String areaPredictive) {
		enterArea.sendKeys(areaPredictive);
	}

	public void enterLocationDropDown(String locationPredictive) {
		enterLocation.sendKeys(locationPredictive);
	}

	public boolean recentLocationsList() {
		boolean recentPresent = recentList.isDisplayed();
		return recentPresent;
	}

	public void selectFromRecent() {
		recentLocations.click();
	}
	
	public String getErrorTitle() {
		String errTitle = errorTitle.getText();
		return errTitle;
	}

	public String getErrorMsg() {
		String errMsg = errorMsg.getText();
		return errMsg;
	}
	
	public void clearSearchField() {
		enterSearchLocation.clear();
	}
	
	public void clickClearButton() {
		clearButton.click();
	}

	public void clickConfirmButton() {
		confirmButton.click();
	}
	
	public boolean checkSuccessMsg() {
		boolean locSuccessMsg = toastMessage.isDisplayed();
		return locSuccessMsg;
	}


}
