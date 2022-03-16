package com.beltWasla.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchOptionsPage {

	WebDriver driver;

	// Page Constructor
	public SearchOptionsPage(WebDriver driver) {
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
	
	@FindBy(id="tagRefNum")
	WebElement tagSearchField;
	
	@FindBy(id="fromDate")
	public
	WebElement fromDateField;
	
	@FindBy(id="toDate")
	WebElement toDateField;
	
	@FindBy(id="ALL")
	WebElement allOption;
	
	@FindBy(id="BIR")
	WebElement birOption;
	
	@FindBy(id="WT_FWD")
	WebElement wtFwdOption;
	
	@FindBy(id="WT")
	WebElement wtOption;
	
	@FindBy(id="MACS")
	WebElement macsOption;
	
	@FindBy(xpath="//*[@value='EK']")
	WebElement ekRadioButton;
	
	@FindBy(xpath="//*[@value='OAL']")
	WebElement oalRadioButton;
	
	@FindBy(xpath="//*[@value='BOTH']")
	WebElement bothRadioButton;
	
	@FindBy(id="clear")
	WebElement clearButton;
	
	@FindBy(id="Search")
	WebElement searchButton;
	
	@FindBy(id="goBack")
	WebElement goBackButton;
	
	 @FindBy(id="tab-BIR")
	 WebElement birResultTab;
	 
	 @FindBy(xpath="//*[@id='tab-WT FWD']")
	 WebElement wtFwdResultTab;
	 
	 @FindBy(id="tab-WT")
	 WebElement wtResultTab;
	 
	 @FindBy(id="tab-MACS")
	 WebElement macsResultTab;
	 
	 @FindBy(id="title")
	 WebElement errorTitle;

	 @FindBy(id="msg")
	 WebElement errorMsg;

	 @FindBy(id="listItem0")
	 WebElement firstResult;
	 
	 @FindBy(xpath="//*[@class='MuiPickersCalendarHeader-switchHeader']/button[2]")
	 WebElement nextMonth;
	 
	 @FindBy(xpath="//*[@class='MuiPickersCalendarHeader-switchHeader']/div")
	 WebElement monthYearValue; 
	
	@FindBy(xpath="//*[@class='MuiPickersCalendarHeader-switchHeader']/button")
	WebElement previousMonth;
	 	 
	
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
	
	public void enterTagToSearch(String tagNumberToSerach) {
		tagSearchField.sendKeys(tagNumberToSerach);
	}
	
	public void selectFromDate() {
		fromDateField.click();
	}
	
	public void selectToDate() {
		toDateField.click();
	}
	
	public void clickPreviousMonth() {
		previousMonth.click();
	}
	
	public void clickNextMonth() {
		nextMonth.click();
	}
	
	public String getMonthYear() {
		String monthYearVal= monthYearValue.getText();
		return monthYearVal;
	}
	
	public void selectALL() {
		allOption.click();
	}
	
	public void selectBIR() {
		birOption.click();
	}
	
	public void selectWtFwd() {
		wtFwdOption.click();
	}
	
	public void selectWT() {
		wtOption.click();
	}
	
	public void selectMacs() {
		macsOption.click();
	}
	
	public void selectEK() {
		ekRadioButton.click();
	}
	
	public void selectOAL() {
		oalRadioButton.click();
	}
	
	public void selectBOTH() {
		bothRadioButton.click();
	}
	
	public void clickClear() {
		clearButton.click();
	}
	
	public void clickSearch() {
		searchButton.click();
	}
	
	public void clickGoBack() {
		goBackButton.click();
	}
	
	public void openBIRtab() {
		birResultTab.click();
	}
	
	public void openWTfwdTab() {
		wtFwdResultTab.click();
	}
	
	public void openWtTab() {
		wtResultTab.click();
	}
	
	public void openMacsTab() {
		macsResultTab.click();
	}
	
	public void selectFirstResult() {
		firstResult.click();
	}
	
	public String getFullErrorMsg() {
		String fullError = errorTitle.getText() + "... " + errorMsg.getText() ; 
		return fullError;
	}
		
}
