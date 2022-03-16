package com.beltWasla.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BaggageDeliveryOptionPage {

	WebDriver driver;

	// Page Constructor
	public BaggageDeliveryOptionPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// All Page Elements With Locators
	
	@FindBy(id = "main-page-title-label")
	WebElement bdoPageTitle;
	
	@FindBy(id = "hamburgermenuID")
	WebElement mainMenuButton;
	
	@FindBy(id="editLocation")
	WebElement editLocation;
	
	@FindBy(id="locationCode")
	WebElement selectedLocation;
	
	@FindBy(id="checkbox-list-secondary-label-Logbag")
	WebElement logBagOption;
	
	@FindBy(id="checkbox-list-secondary-label-Paxcollection")
	WebElement paxCollectionOption;
	
	@FindBy(id="checkbox-list-secondary-label-Vendordelivery")
	WebElement vendorDeliveryOption;
	
	@FindBy(id="tagNo")
	WebElement tagNumberField;
	
	@FindBy(xpath="//*[@id='isDamagedCheckBoxBDO']/span/span/input")
	WebElement isDamagedCheckBox;
	
	@FindBy(id="damageRemark")
	WebElement damagedText;
	
	@FindBy(id="Cancel")
	WebElement cancelButton;
	
	@FindBy(id="submit")
	WebElement logBagSubmitButton;
	
	@FindBy(id="Submit")
	WebElement deliverySubmitButton;
	
	@FindBy(xpath="(//*[@id='alert-dialog-slide-description'])[2]")
	WebElement alertMessage;
	
	@FindBy(id="Dismiss")
	WebElement dismissOption;
	
	@FindBy(id="BDOref")
	WebElement bdoRefNumberField;
	
	@FindBy(id="bdoStepBackButton")
	WebElement formBackButton;
	
	@FindBy(id="bdoStepNextButton")
	WebElement formNextButton;
	
	@FindBy(id="checkBoxAll")
	WebElement selectAllbags;
	
	@FindBy(id="checkBox0")
	WebElement selectFirstBag;

	@FindBy(id="checkBox1")
	WebElement selectSecondBag;
	
	@FindBy(id="checkBox2")
	WebElement selectThirdBag;
	
	@FindBy(id="checkBox3")
	WebElement selectFourthBag;

	@FindBy(id="checkBox4")
	WebElement selectFifthBag;
	
	@FindBy(xpath="//*[@value='PAX']")
	WebElement PAXoption;
	
	@FindBy(xpath="//*[@value='OTHERS']")
	WebElement OTHERSoption;
	
	@FindBy(id="BDODeliveryName")
	WebElement bdoNameField;
	
	@FindBy(id="BDODeliveryAddress")
	WebElement bdoAddressField;
	
	@FindBy(id="BDODeliveryPhone")
	WebElement bdoPhoneField;
	
	@FindBy(id="BDODeliveryIDType")
	WebElement bdoIdTypeDD;
	
	@FindBy(xpath="//*[@data-value='UAE ID card']")
	WebElement uaeIdType;
	
	@FindBy(xpath="//*[@data-value='OTHER ID cards']")
	WebElement otherIdType;
	
	@FindBy(xpath="//*[@data-value='Collector Passport Number']")
	WebElement passportNumberType;
	
	@FindBy(id="BDODeliveryIDNumber")
	WebElement bdoIdNumberField;
	
	//Helper text error messages
	@FindBy(id="BDODeliveryName-helper-text")
	WebElement nameHelperError;
	
	@FindBy(id="BDODeliveryPhone-helper-text")
	WebElement phoneHelperError;
	
	@FindBy(id="BDODeliveryIDNumber-helper-text")
	WebElement idNumberHelperError;
	
	@FindBy(id="makeStyles-sigPad")
	WebElement signPad;
	
	@FindBy(id="termsandconditions-link-bdo")
	WebElement termsAndCondition;
	
	@FindBy(id="termsandconditions-bdo")
	WebElement termsAndConditionCheckbox;
	
	@FindBy(xpath="(//p[1])[2]")
	WebElement term1;
	
	@FindBy(xpath="//p[2]")
	WebElement term2;
	
	@FindBy(xpath="//tbody/tr/td[5]")
	WebElement deliveryStatus;
	
	@FindBy(name="CLEAR")
	WebElement clearSign;
	
	@FindBy(id="Agree")
	WebElement agreeButton;
	
	@FindBy(id="onClose")
	WebElement closeButton;
	
	@FindBy(id ="client-snackbar-icon")
	WebElement loggedBagSummaryToastMsg;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
/*	@FindBy(tagName="//textarea")
	WebElement remarksCusScan;
	
	@FindBy(id="Accept")
	WebElement acceptCusScan;
	
	@FindBy(id="Reject")
	WebElement rejectCusScan;
	
*/
	
	
	// Home Page Actions as Methods

	public String verifyBdoPageTitle() {
		String pageTitle = bdoPageTitle.getText();
		return pageTitle;
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
	
	public boolean bdoLogBagAvailablity() {
		boolean bdoLogBagAvailable = logBagOption.isDisplayed();
		return bdoLogBagAvailable;
	}
	
	public boolean bdoVendorDelAvailablity() {
		boolean bdoVendorDelAvailable = vendorDeliveryOption.isDisplayed();
		return bdoVendorDelAvailable;
	}
	
	public boolean bdoPaxCollAvailablity() {
		boolean bdoPaxCollAvailable = paxCollectionOption.isDisplayed();
		return bdoPaxCollAvailable;
	}
	
	public void openLogBagBDO() {
		logBagOption.click();
	}
	
	public void openVendorDelivery() {
		vendorDeliveryOption.click();
	}
	
	public void openPaxCollection() {
		paxCollectionOption.click();
	}
	
	public void enterTagBdoLog(String bdoLogBagTag) {
		tagNumberField.sendKeys(bdoLogBagTag);
	}
	
	public void selectDamagedOption() {
		isDamagedCheckBox.click();
	}
	
	public void enterDamagedRemarks(String damagedRemarks) {
		damagedText.sendKeys(damagedRemarks);
	}
	
	public void clickCancel() {
		cancelButton.click();
	}
	
	public void logBagClickSubmit() {
		logBagSubmitButton.click();
	}

	public void deliveryClickSubmit() {
		deliverySubmitButton.click();
	}

	public boolean logBagSubmitButtonEnabled() {
		boolean submitButtonStatus = logBagSubmitButton.isEnabled();
		return submitButtonStatus;
	}
	
	public boolean deliverySubmitButtonEnabled() {
		boolean submitButtonStatus = deliverySubmitButton.isEnabled();
		return submitButtonStatus;
	}
	
	public String getErrorMEssage() {
		String errorMessage = alertMessage.getText();
		return errorMessage;
	}
	
	public void dismissError() {
		dismissOption.click();
	}
	
	public void enterBdoRefNumber(String bdoRefNumber) {
		bdoRefNumberField.sendKeys(bdoRefNumber);
	}
	
	public void clickStepNext() {
		formNextButton.click();
	}
	
	public void clickStepBack() {
		formBackButton.click();
	}
	
	public void selectAllBags() {
		selectAllbags.click();
	}
	
	public void selectFirstBag() {
		selectFirstBag.click();
	}
	
	public void selectSecondBag() {
		selectSecondBag.click();
	}
	
	public void selectThirdBag() {
		selectThirdBag.click();
	}
	
	public void selectFourthBag() {
		selectFourthBag.click();
	}
	
	public void selectFifthBag() {
		selectFifthBag.click();
	}
	
	public void selectPAXoption() {
		PAXoption.click();
	}
	
	public void selectOTHERSoption() {
		OTHERSoption.click();
	}
	
	public void enterBdoDeliveryName(String bdoPaxName) {
		bdoNameField.sendKeys(bdoPaxName);
	}
	
	public void enterBdoDeliveryAddress(String bdoPaxAddress) {
		bdoNameField.sendKeys(bdoPaxAddress);
	}
	
	public void enterBdoDeliveryPhone(String bdoPaxPhone) {
		bdoPhoneField.sendKeys(bdoPaxPhone);
	}
	
	public void clickBdoDeliveryIdType() {
		bdoIdTypeDD.click();
	}
	
	public void selectUaeIdType() {
		uaeIdType.click();
	}
	
	public void selectOtherIdType() {
		otherIdType.click();
	}
	
	public void selectPasportIdType() {
		passportNumberType.click();
	}
	
	public void enterBdoIdNumberField(String bdoIdNumber) {
		bdoIdNumberField.sendKeys(bdoIdNumber);
	}
	
	public String getNameErrorHelper() {
		String nameError =nameHelperError.getText();
		return nameError;
	}
	
	public String getPhoneErrorHelper() {
		String phoneError =phoneHelperError.getText();
		return phoneError;
	}
	
	public String getIdNumberErrorHelper() {
		String idNumberError =idNumberHelperError.getText();
		return idNumberError ;
	}
	
	public void captureSign() {
		signPad.click();
	}
	
	public void clickClear() {
		clearSign.click();
	}
	
	public void clickTerms() {
		termsAndCondition.click();
	}
	
	public void clickTermsCheckBox() {
		termsAndConditionCheckbox.click();
	}
	
	public String getTermsAndCondition1() {
		String tnc1 = term1.getText(); 
		return tnc1;
	}
	
	public String getTermsAndCondition2() {
		String tnc2 = term2.getText(); 
		return tnc2;
	}
	
	public boolean checkboxSelectStatus() {
		boolean checkboxstatus = termsAndConditionCheckbox.isSelected();
		return checkboxstatus;
	}
	
	public String getBagDeliveryStatus() {
		String bagDelStatus = deliveryStatus.getText();
		return bagDelStatus;
	}
	
	public void clickAgree() {
		agreeButton.click();
	}
	
	public void clickClose() {
		closeButton.click();
	} 
	
	public String getSuccessToastMsg() {
		String loggedBagSummaryLable = loggedBagSummaryToastMsg.getText();
		return loggedBagSummaryLable;
	}		
}
