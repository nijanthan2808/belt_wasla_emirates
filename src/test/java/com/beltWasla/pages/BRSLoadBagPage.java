package com.beltWasla.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BRSLoadBagPage {
	

	WebDriver driver;

	// Page Constructor
	public BRSLoadBagPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// All Page Elements With Locators
	
	@FindBy(id = "uldNo")
	WebElement enterULD;
	
	@FindBy(xpath = "(//p[@id='alert-dialog-slide-description'])[2]")
	WebElement errorMessageNoULD;

	@FindBy(id = "ULD_INVALID")
	WebElement dismissOptionNoULD;
	
	@FindBy(id = "Dismiss")
	WebElement dismissOption;
	
	@FindBy(id = "bagTagNo")
	WebElement enterBagTagNo;
	
	@FindBy(id = "CLOSE ULD")
	WebElement closeULD;
	
	@FindBy(id = "OFFLOAD BAG")
	WebElement offLoadBag;
	
	@FindBy(id = "client-snackbar-icon")
	WebElement toastMessage;
	
	@FindBy(id = "Last-bag-loaded")
	WebElement lastBagLogged;
	
	public void enterULD(String uldNumber) {
		enterULD.sendKeys(uldNumber);
	}
	
	public String getULD() {
		String getULD = enterULD.getText();
		return getULD;
	}
	
	public String getNoULDErrMsg() {
		String getNoULDErrMsg = errorMessageNoULD.getText();
		return getNoULDErrMsg;
	}

	public void clickDismissOption() {
		dismissOptionNoULD.click();
	}
	
	public void clickDismissOptionBagTag() {
		dismissOption.click();
	}
	
	public void enterBagTagNo(String bagTagNo) {
		enterBagTagNo.sendKeys(bagTagNo);
	}
	
	public boolean verifyCloseULDButton() {
		boolean isCloseULDEnabled = closeULD.isEnabled();
		return isCloseULDEnabled;
	}
	
	public boolean verifyOffloadBagButton() {
		boolean isOffloadBagEnabled = offLoadBag.isEnabled();
		return isOffloadBagEnabled;
	}
	
	public boolean checkSuccessMsg() {
		boolean logSuccessMsg = toastMessage.isDisplayed();
		return logSuccessMsg;
	}
	
	public String gettoastMessage() {
		String gettoastMessage = toastMessage.getText();
		return gettoastMessage;
	}
	
	public String getlastBagLogged() {
		String getlastBagLoggedMessage = lastBagLogged.getText();
		return getlastBagLoggedMessage;
	}
}
