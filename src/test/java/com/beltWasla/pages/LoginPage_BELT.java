package com.beltWasla.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.beltWasla.utils.ApplicationLauncher;

public class LoginPage_BELT extends ApplicationLauncher {

	WebDriver driver;

	// Page Constructor
	public LoginPage_BELT(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	

	// All Page Elements With Locators
	@FindBy(id = "userId")
	WebElement userIdField;

	@FindBy(id= "password")
	WebElement passwordField;
	
	@FindBy(className= "MuiButton-label")
	WebElement loginButton;
	
	// Login Page Actions as Methods
	
	
	
	public void enterUserId(String userIdVal) {
		userIdField.sendKeys(userIdVal);
	}

	public void enterPassword(String passwordVal) {
		passwordField.sendKeys(passwordVal);
	}
	public void clickLogin() {
		loginButton.click();
	}
	
}
