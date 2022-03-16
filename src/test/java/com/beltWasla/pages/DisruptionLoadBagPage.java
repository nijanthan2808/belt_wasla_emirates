package com.beltWasla.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DisruptionLoadBagPage {

	WebDriver driver;

	// Page Constructor
	public DisruptionLoadBagPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// All Page Elements With Locators
	@FindBy(xpath = "//span[text()='Disruption mode: ON']")
	WebElement disruptionModeOn;
	
	@FindBy(id = "DispLastBagScanned")
	WebElement lastBagLogged;
	
	@FindBy(xpath = "//span[@id='dispFlightdestination']/b")
	WebElement dispULDdestination;
	
	@FindBy(xpath = "//span[@id='dispUldClass'][1]/b")
	WebElement dispUldClass;
	
	@FindBy(xpath = "//p[text()='Category']/following-sibling::span/b")
	WebElement dispUldCategory;
	
	@FindBy(xpath = "//span[@id='dispsUldbagCount']/b")
	WebElement dispsUldBagCount;
	
	@FindBy(xpath = "//h6[@id='disptextTopUldNo']/span")
	WebElement dispUldNo;
	
	@FindBy(id = "disrup-load-pax-label")
	WebElement disrupLoadPaxLabel;
	
	@FindBy(id = "disrup-load-route-label")
	WebElement disrupLoadRouteLabel;
	
	@FindBy(id = "disrup-load-status-label")
	WebElement disrupLoadStatusLabel;
	
	@FindBy(id = "disrup-load-fltNo-label")
	WebElement disrupLoadFltNoLabel;
	
	@FindBy(id = "disrup-load-fltDate-label")
	WebElement disrupLoadFltDateLabel;
	
	@FindBy(id = "disrup-load-pax")
	WebElement disrupLoadPax;
	
	@FindBy(id = "disrup-load-route")
	WebElement disrupLoadRoute;
	
	@FindBy(id = "disrup-load-status")
	WebElement disrupLoadStatus;
	
	@FindBy(id = "disrup-load-fltDate")
	WebElement disrupLoadFltDate;
	
	@FindBy(id = "disrup-load-fltNo")
	WebElement disrupLoadFltNo;
	
	public boolean verifyDisruptionMode() {
		boolean disruptionMode = disruptionModeOn.isDisplayed();
		return disruptionMode;
	}
	
	public String getDispLoadPaxLbl() {
		String getDispLoadPaxLabel = disrupLoadPaxLabel.getText();
		return getDispLoadPaxLabel;
	}
	
	public String getDispLoadRouteLbl() {
		String getDispLoadRouteLabel = disrupLoadRouteLabel.getText();
		return getDispLoadRouteLabel;
	}
	
	public String getDispLoadStatusLbl() {
		String getDispLoadStatusLabel = disrupLoadStatusLabel.getText();
		return getDispLoadStatusLabel;
	}
	
	public String getDispLoadFltNoLbl() {
		String getDispLoadFltNoLabel = disrupLoadFltNoLabel.getText();
		return getDispLoadFltNoLabel;
	}
	
	public String getDispLoadFltDateLbl() {
		String getDispLoadFltDateLabel = disrupLoadFltDateLabel.getText();
		return getDispLoadFltDateLabel;
	}
	
	public String getDispLoadPaxVal() {
		String getDispLoadPaxValue = disrupLoadPax.getText();
		return getDispLoadPaxValue;
	}
	
	public String getDispLoadRouteVal() {
		String getDispLoadRouteValue = disrupLoadRoute.getText();
		return getDispLoadRouteValue;
	}
	
	public String getDispLoadStatusVal() {
		String getDispLoadStatusValue = disrupLoadStatus.getText();
		return getDispLoadStatusValue;
	}
	
	public String getDispLoadFltNoVal() {
		String getDispLoadFltNoValue = disrupLoadFltNo.getText();
		return getDispLoadFltNoValue;
	}
	
	public String getDispLoadFltDateVal() {
		String getDispLoadFltDateValue = disrupLoadFltDate.getText();
		return getDispLoadFltDateValue;
	}
	
	public String getUldClass() {
		String getUldClassValue = dispUldClass.getText();
		return getUldClassValue;
	}
	
	public String getDispUldNo() {
		String getDispUldNo = dispUldNo.getText();
		return getDispUldNo;
	}
	
	public String getULDdestination() {
		String getULDdestinationValue = dispULDdestination.getText();
		return getULDdestinationValue;
	}
	
	public String getlastBagLogged() {
		String getlastBagLoggedMessage = lastBagLogged.getText();
		return getlastBagLoggedMessage;
	}
	
	public String getUldCategory() {
		String dispUldCategoryValue = dispUldCategory.getText();
		return dispUldCategoryValue;
	}
	
	public String getUldBagCount() {
		String getUldBagCountNumber = dispsUldBagCount.getText();
		return getUldBagCountNumber;
	}
}
