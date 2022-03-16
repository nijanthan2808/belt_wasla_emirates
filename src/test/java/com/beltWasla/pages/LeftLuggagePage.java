package com.beltWasla.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeftLuggagePage  {

	 WebDriver driver;
	
	//Actions act = new Actions(driver);

	// Page Constructor
	public LeftLuggagePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// All Page Elements With Locators

	@FindBy(id = "main-page-title-label")
	WebElement rackBagPageTitle;

	@FindBy(id = "hamburgermenuID")
	WebElement mainMenuButton;

	@FindBy(id = "editLocation")
	WebElement editLocation;

	@FindBy(id = "locationCode")
	WebElement selectedLocation;

	@FindBy(id = "checkbox-list-secondary-label-Deposit")
	WebElement depositLL;

	@FindBy(id = "checkbox-list-secondary-label-Racking")
	WebElement rackingLL;

	@FindBy(id = "checkbox-list-secondary-label-Collection")
	WebElement collectionLL;

	@FindBy(id = "ll-deposit-home-ll-ref")
	WebElement receiptNumberFieldDeposit;

	@FindBy(id = "listItem0")
	WebElement selectReceiptNumberDeposit;
	
	@FindBy(id = "listItem0")
	WebElement selectReceiptNumberCollection;

	@FindBy(xpath = "//canvas")
	WebElement signPad;

	@FindBy(id = "ll-enter-rack-No")
	WebElement llRackNumberField;

	@FindBy(id = "rack-storage-id")
	WebElement llRackTagNumberField;

	@FindBy(id = "enter-rack-number")
	WebElement llSearchRackNumberField;

	@FindBy(xpath = "//*[@id='RackList']/div")
	WebElement llFirstRackNumber;

	@FindBy(id = "goBack")
	WebElement llRackSearchGoBack;

	@FindBy(id = "llSearchReceiptNumber")
	WebElement llCollectionReceiptField;

	@FindBy(id = "back-icon-ll-home")
	WebElement llBackButton;

	@FindBy(xpath="//*[@type='checkbox']")
	WebElement llAcceptTerms;

	@FindBy(id = "Submit")
	WebElement llSubmitButton;
	
	@FindBy(id= "rack-submit-for-rack")
	WebElement rackingSubmit;

	@FindBy(name = "CLEAR")
	WebElement llClearSign;

	@FindBy(xpath = "(//p[@id='alert-dialog-slide-description'])[2]")
	WebElement llErrorMsg;

	@FindBy(id = "title")
	WebElement llReceiptErrorTitle;

	@FindBy(id = "msg")
	WebElement llReceiptErrorMsg;

	@FindBy(id = "ll-deposit-list-LLrefNum")
	WebElement collectionResultReceiptNumber;

	@FindBy(id = "llScanorEnterTagNumber")
	WebElement collectionScanBag;

	@FindBy(id = "ll-collect-sign")
	WebElement llCollectSign;
	
	@FindBy(xpath="//*[@type='checkbox']")
	WebElement collectionCheckBox;
	
	@FindBy(xpath="//*[@id='alert-dialog-slide-description']/div/div")
	WebElement rackBagSucessMsg;

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

	public void clickDepositLL() {
		depositLL.click();
	}

	public void clickRackingLL() {
		rackingLL.click();
	}

	public void clickCollectionLL() {
		collectionLL.click();
	}

	public void enterReceiptDeposit(String receiptDeposit) {
		
		receiptNumberFieldDeposit.sendKeys(receiptDeposit);
		//receiptNumberFieldDeposit.sendKeys("0");
		//act.sendKeys(Keys.BACK_SPACE).build().perform();
		//receiptNumberFieldDeposit.clear();
		//receiptNumberFieldDeposit.sendKeys(receiptDeposit);
	}

	public void selectDepositReceipt() {
		selectReceiptNumberDeposit.click();
	}

	public void sign() {
		signPad.click();
	}

	public void clickRackField() {
		llRackNumberField.click();
	}

	public void enterRackNumberSearch(String rackNumber) {
		llSearchRackNumberField.sendKeys(rackNumber);
	}

	public void selectFirstRack() {
		llFirstRackNumber.click();
	}

	public void rackSearchGoBack() {
		llRackSearchGoBack.click();
	}

	public void enterTagToRack(String tagToRackLL) {
		llRackTagNumberField.sendKeys(tagToRackLL);
	}

	
	public void enterCollectionReceipt(String collectionReceipt) {
		llCollectionReceiptField.sendKeys(collectionReceipt);
		//llCollectionReceiptField.sendKeys("0");
		//act.sendKeys(Keys.BACK_SPACE).build().perform();
		//llCollectionReceiptField.clear();
		//llCollectionReceiptField.sendKeys(collectionReceipt);
	}
	
	public void selectCollectionReceipt() {
		selectReceiptNumberCollection.click();
	}

	public void llBackButton() {
		llBackButton.click();
	}

	public void clickAcceptTerms() {
		llAcceptTerms.click();
	}

	public void clickSubmit() {
		llSubmitButton.click();
	}
	
	public void clickRackingSubmit() {
		rackingSubmit.click();
	}

	public void clickClear() {
		llClearSign.click();
	}

	public boolean submitButtonStatus() {
		boolean submitDisabled = llSubmitButton.isEnabled();
		return submitDisabled;
	}

	public String getFullErrorMsg() {
		String errorMsg = llReceiptErrorTitle.getText() + "... " + llReceiptErrorMsg.getText();
		return errorMsg;

	}

	public String getCollectionReciptNumber() {
		String resultCollectionReceiptNumber = collectionResultReceiptNumber.getText();
		return resultCollectionReceiptNumber;
	}

	public void enterCollectionBagScan(String llBagTagCollection) {
		collectionScanBag.sendKeys(llBagTagCollection);
		//collectionScanBag.sendKeys("0");
		//act.sendKeys(Keys.BACK_SPACE).build().perform();
		//collectionScanBag.clear();
		//collectionScanBag.sendKeys(llBagTagCollection);
		
	}

	public String getLLErrorMsg() {
		String llErrorMessage = llErrorMsg.getText();
		return llErrorMessage;
	}

	public void clickSign() {
		llCollectSign.click();
	}
	
	public boolean signPadDisplayed() {
		boolean signPadAvailable = signPad.isDisplayed();
		return signPadAvailable;
	}
	
	public boolean llCollectSignStatus() {
		boolean llColSignStatus = llCollectSign.isEnabled();
		return llColSignStatus;
	}
	
	public boolean llSignPadAvailability() {
		boolean llColSignAvailable = signPad.isDisplayed();
		return llColSignAvailable;
	}
	
	public void clickColTermsCheckBox() {
		collectionCheckBox.click();
	}
	
	public String getRackBagSuccessMsg() {
		String rackBagSuccessMessage = rackBagSucessMsg.getText();
		return rackBagSuccessMessage;
	}

}
