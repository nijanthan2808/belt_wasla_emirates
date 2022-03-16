package com.beltWasla.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogBagPage_BELT {

	WebDriver driver;

	// Page Constructor
	public LogBagPage_BELT(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// All Page Elements With Locators

	@FindBy(id = "main-page-title-label")
	WebElement logBagPageTitle;

	@FindBy(id = "")
	WebElement mainMenuButton;

	@FindBy(id = "locationCode")
	WebElement selectedLocation;

	@FindBy(id = "selectLocation")
	WebElement locationEdit;

	@FindBy(id = "logBag-home-tag-ohd")
	WebElement tagNumberField;

	@FindBy(xpath = "//label[@id='specialLogItemClass']")
	WebElement specialLogField;
	
	@FindBy(xpath = "//div[@id='specialLogItemClass']")
	WebElement ddspecialLogField;
	
	@FindBy(id = "multi-scan-check-box")
	WebElement multipleSepcialLogOption;

	@FindBy(id = "multi-scan-On-Off")
	WebElement multipleSepcialLogStatus;

	@FindBy(id = "spl-item-listStroller")
	WebElement specialItemStroller;

	@FindBy(id = "spl-item-listWheelchair")
	WebElement specialItemWheelChair;

	@FindBy(id = "spl-item-listKennel / Pet Container")
	WebElement specialItemKennelPet;

	@FindBy(id = "spl-item-listFire Arm (s)")
	WebElement specialItemFireArm;

	@FindBy(id = "spl-item-listAudio/Video Devices")
	WebElement specialItemAudioVideo;

	@FindBy(id = "spl-item-listComputer")
	WebElement specialItemComputer;

	@FindBy(id = "spl-item-listElectrical Appliances")
	WebElement specialItemElectrical;

	@FindBy(id = "spl-item-listSporting Equipment/s")
	WebElement specialItemSporting;

	@FindBy(id = "spl-item-listMusic Instruments")
	WebElement specialItemMusical;

	@FindBy(id = "spl-item-listOSR")
	WebElement specialItemOSR;

	@FindBy(id = "spl-item-listNewspaper")
	WebElement specialItemNewsPaper;

	@FindBy(id = "spl-item-listZam Zam")
	WebElement specialItemZamZam;

	@FindBy(id = "specialLogItemClass")
	WebElement selectedSpecialLogItem;

	@FindBy(id = "log-summary-item-label")
	WebElement loggedBagSummary;

	@FindBy(id = "logBag-home-tag-ohd-helper-text")
	WebElement bagTagOHDerrorMsg;

	@FindBy(id = "alert-dialog-logbag-description")
	WebElement errorMessageBSM;

	@FindBy(id = "alert-logbag-no-button")
	WebElement noOptionNoBSM;

	@FindBy(id = "alert-logbag-yes-button")
	WebElement yesOptionNoBSM;

	@FindBy(id = "list-log-bags-select-pax-label")
	WebElement multiBSMlist;

	@FindBy(id = "bagtag-list")
	WebElement PaxSelectMultiBSM;

	@FindBy(id = "log-summary-fltNo-label")
	WebElement logSummaryFlightNumber;

	@FindBy(id = "log-summary-date-label")
	WebElement logSummaryDate;

	@FindBy(id ="log-summary-pax-label")
	WebElement logSummaryPax;

	@FindBy(id = "log-summary-route-label")
	WebElement logSummaryRoute;

	@FindBy(id = "log-summary-area-label")
	WebElement logSummaryArea;

	@FindBy(id = "log-summary-bay-label")
	WebElement logSummaryBay;

	@FindBy(id = "log-summary-class-label")
	WebElement logSummaryClass;

	@FindBy(id = "log-summary-item-label")
	WebElement logSummarySpecialItem;

	@FindBy(id = "log-summary-fltNo")
	WebElement logSummaryFlightNumberVal;

	@FindBy(id = "log-summary-date")
	WebElement logSummaryDateVal;

	@FindBy(id = "log-summary-pax")
	WebElement logSummaryPaxVal;

	@FindBy(id = "log-summary-route")
	WebElement logSummaryRouteVal;

	@FindBy(id = "log-summary-area")
	WebElement logSummaryAreaVal;

	@FindBy(id = "log-summary-bay")
	WebElement logSummaryBayVal;

	@FindBy(id = "log-summary-class")
	WebElement logSummaryClassVal;

	@FindBy(id = "log-summary-item")
	WebElement logSummarySpecialItemVal;

	@FindBy(id = "logBag-home-tag-ohd")
	WebElement enteredTagNumberField;

	@FindBy(xpath = "(//*[@id='specialLogItemClass'])[2]/following-sibling::input")
	WebElement enteredSpecialLogField;

	@FindBy(name = "Force")
	WebElement forceButton;

	@FindBy(name = "Clear")
	WebElement clearButton;
	
	@FindBy(id = "client-snackbar-icon")
	WebElement loggedBagSummaryToastMsg;
	
	@FindBy(id = "log-summary-item-label")
	WebElement loggedBagSummaryLabel;
	
	@FindBy(id = "alert-logbag-ok-button")
	WebElement multiBSMOkButton;
	// Home Page Actions as Methods

	public String getLogBagPageTitle() {
		String logBagTitle = logBagPageTitle.getText();
		return logBagTitle;
	}

	public void clickMainMenu() {
		mainMenuButton.click();
	}
	
	public void clickMultiBSMOkOption() {
		multiBSMOkButton.click();
	}

	public String getSelectedLocation() {
		String svedLocation = selectedLocation.getText();

		return svedLocation;
	}

	public void clickLocationEdit() {
		locationEdit.click();
	}
	
	public void clickSpecialLogItem() {
		ddspecialLogField.click();
	}
	
	public void enterTagNumber(String tagNumber) {
			tagNumberField.sendKeys(tagNumber);
	}

	public void chooseSpecialLog(String specialLogItem) {
		specialLogField.sendKeys(specialLogItem);
	}

	public void chooseMultipleSpecialLog(String specialLogItem) {
		multipleSepcialLogOption.click();
	}

	public void verifySpecialItems() {
		selectedSpecialLogItem.getText();
	}

	public String getBagLoggedToastMsg() {
		String loggedBagSummaryLable = loggedBagSummaryToastMsg.getText();
		return loggedBagSummaryLable;
	}
	
	public boolean verifyBagLoggedDisplayed() {
		boolean bagLoggedFlag = loggedBagSummaryLabel.isDisplayed();
		return bagLoggedFlag;
	}

	public String getBagLoggedLable() {
		String loggedBagSummaryLable = loggedBagSummaryLabel.getText();
		return loggedBagSummaryLable;
	}

	public String getBagTagOHDerror() {
		String getBagTagOHDerrorMsg = bagTagOHDerrorMsg.getText();
		return getBagTagOHDerrorMsg;
	}

	public String getBSMerrorMsg() {
		String getBSMerrorMsg = errorMessageBSM.getText();
		return getBSMerrorMsg;
	}

	public void clickNoOption() {
		noOptionNoBSM.click();
	}

	public void clickYesOption() {
		yesOptionNoBSM.click();
	}

	public boolean verifyMultiBSM() {
		boolean multiBSMflag = multiBSMlist.isDisplayed();
		return multiBSMflag;
	}

	public void selectPaxMultiBSM() {
		PaxSelectMultiBSM.click();
	}

	public String getSummaryLogFlightNumberLbl() {
		String getSummaryLogFlightNumberLable = logSummaryFlightNumber.getText();
		return getSummaryLogFlightNumberLable;
	}

	public String getSummaryLogDateLbl() {
		String getSummaryLogDateLable = logSummaryDate.getText();
		return getSummaryLogDateLable;
	}

	public String getSummaryLogPaxLbl() {
		String getSummaryLogPaxLable = logSummaryPax.getText();
		return getSummaryLogPaxLable;
	}

	public String getSummaryLogRouteLbl() {
		String getSummaryLogRouteLable = logSummaryRoute.getText();
		return getSummaryLogRouteLable;
	}

	public String getSummaryLogAreaLbl() {
		String getSummaryLogAreaLable = logSummaryArea.getText();
		return getSummaryLogAreaLable;
	}

	public String getSummaryLogBayLbl() {
		String getSummaryLogBayValueLable = logSummaryBay.getText();
		return getSummaryLogBayValueLable;
	}

	public String getSummaryLogClassLbl() {
		String getSummaryLogClassValueLable = logSummaryClass.getText();
		return getSummaryLogClassValueLable;
	}

	public String getSummaryLogSpecialItemLbl() {
		String getSummaryLogSpecialItemValueLable = logSummarySpecialItem.getText();
		return getSummaryLogSpecialItemValueLable;
	}

	public String getSummaryLogFlightNumberVal() {
		String getSummaryLogFlightNumberValue = logSummaryFlightNumberVal.getText();
		return getSummaryLogFlightNumberValue;
	}

	public String getSummaryLogDateVal() {
		String getSummaryLogDateValue = logSummaryDateVal.getText();
		return getSummaryLogDateValue;
	}

	public String getSummaryLogPaxVal() {
		String getSummaryLogPaxValue = logSummaryPaxVal.getText();
		return getSummaryLogPaxValue;
	}

	public String getSummaryLogRouteVal() {
		String getSummaryLogRouteValue = logSummaryRouteVal.getText();
		return getSummaryLogRouteValue;
	}

	public String getSummaryLogAreaVal() {
		String getSummaryLogAreaValue = logSummaryAreaVal.getText();
		return getSummaryLogAreaValue;
	}

	public String getSummaryLogBayVal() {
		String getSummaryLogBayValue = logSummaryBayVal.getText();
		return getSummaryLogBayValue;
	}

	public String getSummaryLogClassVal() {
		String getSummaryLogClassValue = logSummaryClassVal.getText();
		return getSummaryLogClassValue;
	}

	public String getSummaryLogSpecialItemVal() {
		String getSummaryLogSpecialItemValue = logSummarySpecialItemVal.getText();
		return getSummaryLogSpecialItemValue;
	}

	public String getBagTagFieldValue() {
		String bagTagEntered = enteredTagNumberField.getAttribute("value");
		return bagTagEntered;
	}

	public String getSpecialFieldValue() {
		String bagTagEntered = enteredSpecialLogField.getAttribute("value");
		return bagTagEntered;
	}

	public void clickClear() {
		clearButton.click();
	}

	public void clickForce() {
		forceButton.click();
	}

	public void selectSpecialLog() {
		specialLogField.click();
		specialLogField.click();
	}

	public void selectStroller() {

		specialItemStroller.click();
	}
	
}
