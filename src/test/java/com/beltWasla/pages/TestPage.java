package com.beltWasla.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestPage {

	WebDriver driver;

	// Page Constructor
	public TestPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// All Page Elements With Locators

	@FindBy(xpath = "//*[contains(text(),'Sign in')]")
	WebElement signInLink;

	@FindBy(id = "email")
	WebElement emailField;

	@FindBy(id = "passwd")
	WebElement passwordField;

	@FindBy(id = "SubmitLogin")
	WebElement signInButton;

	@FindBy(xpath = "(//*[@title='T-shirts'])[2]")
	WebElement tshirtsMenuLink;

	@FindBy(xpath = "//*[@class='product-container']")
	WebElement productIcon;

	@FindBy(xpath = "//*[text()='Add to cart']")
	WebElement addToCartButton;

	@FindBy(xpath = "//*[@title='Proceed to checkout']")
	WebElement proceedToCheckoutButton;

	@FindBy(xpath = "//*[@class='icon-plus']")
	WebElement increaseQuantity;

	@FindBy(xpath = "//*[text()='Proceed to checkout']")
	WebElement proceedToCheckoutNextButton;
	
	@FindBy(xpath = "(//*[contains(text(),'Proceed to checkout')])[2]")
	WebElement proceedToCheckoutLast;

	@FindBy(name = "message")
	WebElement messageBox;
	
	@FindBy(id = "cgv")
	WebElement agreeTermsCheckbox;

	@FindBy(xpath = "//*[@title='Pay by check.']")
	WebElement payByCheckOption;

	@FindBy(xpath = "//*[text()='I confirm my order']")
	WebElement confirmOrder;

	@FindBy(xpath = "//*[text()='Your order on My Store is complete.']")
	WebElement confirmationText;

	@FindBy(xpath = "//*[contains(text(),'Sign out')]")
	WebElement signOutLink;

	
	// Test Page Actions as Methods
	public void clickSignInLink() throws InterruptedException {
		// These seep times are given for all steps just for demo purpose. This will pass each action for 2 seconds so that we can look and notice what's happening. Otherwise it will be faster execution.
		Thread.sleep(2000);
		signInLink.click();
		Thread.sleep(2000);
	}
	
	public void enterUsername(String username) throws InterruptedException {
		emailField.sendKeys(username);
		Thread.sleep(2000);
	}
	
	public void enterPassworde(String password) throws InterruptedException {
		passwordField.sendKeys(password);
		Thread.sleep(2000);
	}
	
	public void clickSignInButton() throws InterruptedException {
		signInButton.click();
		Thread.sleep(2000);
	}
	
	public void clickTshirts() throws InterruptedException {
		tshirtsMenuLink.click();
		Thread.sleep(2000);
	}
	
	public void moveToItem() throws InterruptedException {
		productIcon.click();
		Thread.sleep(2000);
	}
	
	public void clickAddToCart() throws InterruptedException {
		addToCartButton.click();
		Thread.sleep(2000);
	}
	
	public void clickProceedToCheckout() throws InterruptedException {
		proceedToCheckoutButton.click();
		Thread.sleep(2000);
	}
	
	public void increaseQuantityTo2() throws InterruptedException {
		increaseQuantity.click();
		Thread.sleep(2000);
	}
	
	public void clickProceedToCheckoutNext() throws InterruptedException {
		proceedToCheckoutNextButton.click();
		Thread.sleep(2000);
	}

	public void clickProceedToCheckoutLast() throws InterruptedException {
		proceedToCheckoutLast.click();
		Thread.sleep(2000);
	}
	
	public void enterMessage(String msg) throws InterruptedException {
		messageBox.sendKeys(msg);
		Thread.sleep(2000);
	}
	
	public void clickAgreeTerms() throws InterruptedException {
		agreeTermsCheckbox.click();
		Thread.sleep(2000);
	}
	
	public void clickPayByCheck() throws InterruptedException {
		payByCheckOption.click();
		Thread.sleep(2000);
	}
	
	public void clickConfirmOrder() throws InterruptedException {
		confirmOrder.click();
		Thread.sleep(2000);
	}
	public String getConfirmationText() throws InterruptedException {
		String text = confirmationText.getText();
		Thread.sleep(2000);
		return text;
	}
	
	public void clickSignOut() throws InterruptedException {
		signOutLink.click();
		Thread.sleep(2000);
	}
	
}
