package com.beltWasla.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeScreen_BELT {

	WebDriver driver;

	// Page Constructor
	public HomeScreen_BELT(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// All Page Elements With Locators
	
	@FindBy(id = "main-page-title-label")
	WebElement homePageTitle;
	
	@FindBy(id = "")
	WebElement mainMenuButton;
	
	@FindBy(xpath="//*[@id='selectLocation']/div[2]/span")
	WebElement addLocationLable;
	
	@FindBy(id = "selectLocation")
	WebElement addLocationButton;
	
	@FindBy(id = "locationCode")
	WebElement getSelectedLocation;
	
	@FindBy(id="editLocation")
	WebElement editLocation;
	
	@FindBy(id = "alert-dialog-slide-description")
	WebElement getAddLocationPromptMessage;

	@FindBy(id = "Show_Locations")
	WebElement addLocationPromptOkButton;
	
	@FindBy(id = "menuItemIDLogBag")
	WebElement logBagIcon;

	@FindBy(id = "home-dfs-icon")
	WebElement dfsIcon;
	
	@FindBy (id= "menuItemIDQuickon-hand")
	WebElement createQohIcon;
	
	@FindBy(id="menuItemIDRack")
	WebElement rackBagIcon;
	
	@FindBy(id="menuItemIDLeftLugagge")
	WebElement leftLuggageIcon;
	
	@FindBy(id="menuItemIDTagSearch")
	WebElement tagSearchIcon;
	
	@FindBy(id="menuItemIDBDO")
	WebElement bdoIcon;
	
	@FindBy(id="hamburgermenuID")
	WebElement hamburgerMenu;
	
	@FindBy(id="HamburgerMenuHome")
	WebElement hamburgerHome;
	
	@FindBy(xpath="(//*[@id='HamburgerMenuLogBag'])[1]/div/span")
	WebElement hamburgerLogBag;
	
	@FindBy(id="HamburgerMenuQuickon-hand")
	WebElement hamburgerQOH;
	
	@FindBy(id="HamburgerMenuTagSearch")
	WebElement hamburgerTagSearch;
	
	@FindBy(id="HamburgerMenuLeftLugagge")
	WebElement hamburgerLL;
	
	@FindBy(id="HamburgerMenuBDO")
	WebElement hamburgerBDO;
	
	@FindBy(id="HamburgerMenuCustomClearance")
	WebElement hamburgerCustom;
	
	@FindBy(xpath="(//*[@id='HamburgerMenuRack'])[1]")
	WebElement hamburgerRackBag;
	
	@FindBy(id="HamburgerMenuBRSLoadBag")
	WebElement hamburgerBRSLoadBag;
	
	@FindBy(id="HamburgerMenuDepartureFlightSummary")
	WebElement hamburgerDFS;
	
	@FindBy(id="HamburgerMenuDisruptionLoadBag")
	WebElement hamburgerDisruptionLoadBag;
	
	
	
	

	// Home Page Actions as Methods
	
	public String getHomePageTitle() {
		String homeTitle = homePageTitle.getText();
	    return homeTitle;
	}
	
	public void clickMainMenu() {
		mainMenuButton.click();
	}
	
	public String getAddLocationLable() {
		String addLocationText = addLocationLable.getText();
		
		return addLocationText;
	}

	public void clickAddLocationButton() {
		addLocationButton.click();
	}
	
	public String getSelectedLocationData() {
		String selectedLocation = getSelectedLocation.getText();
	    
		return selectedLocation;
	}
	
	public void editLocationCode() {
		editLocation.click();
	}
	
	public boolean locationPromptAvailable() {
		boolean locationPromptShown = addLocationPromptOkButton.isDisplayed();
		return locationPromptShown ;
	}
	
	public String getAddLocationPromptMessage() {
		String promptMessage = getAddLocationPromptMessage.getText();
		
		return promptMessage;
	}

	public void clickAddLocationPromptOkButton() {
		addLocationPromptOkButton.click();
	}
	
	public void clickLogBagIcon() {
		logBagIcon.click();
	}

	public void clickDfsIcon() {
		dfsIcon.click();
	}
	
	public void clickQOH() {
		createQohIcon.click();
	}
	
	public void clickRackBagIcon() {
		rackBagIcon.click();
	}
	
	public void clickLLicon() {
		leftLuggageIcon.click();
	}
	
	public boolean llIconExist() {
		boolean llIconAvailable = leftLuggageIcon.isDisplayed();
		return llIconAvailable;
	}
	
	public void clickTagSearchIcon() {
		tagSearchIcon.click();
	}
	
	public boolean bdoIconExist() {
		boolean bdoIconAvailable = bdoIcon.isDisplayed();
		return bdoIconAvailable;
	}
	
	public void clickBdoIcon() {
		bdoIcon.click();
	}
	
	public void clickHamburgerMenu() {
		hamburgerMenu.click();
	}

	public void clickHamburgerLogBag() {
		hamburgerLogBag.click();
	}
	
	public void clicHamburgerHome() {
		hamburgerHome.click();
	}
	
	public void clickHamburgerQOH() {
		hamburgerQOH.click();
	}
	
	public void clickHamburgerTagSearch() {
		hamburgerTagSearch.click();
	}
	
	public void clickHamburgerLL() {
		hamburgerLL.click();
	}
	
	public void clickHamburgerBDO(){
		hamburgerBDO.click();
	}
	
	public void clickHamburgerCustoms() {
		hamburgerCustom.click();
	}
	
	public void clickHamburgerRack() {
		hamburgerRackBag.click();
	}
	
	public void clickHamburgerBRSLoadBag() {
		hamburgerBRSLoadBag.click();
	}
	
	public boolean verifyHamburgerBRSLoadBag() {
		return hamburgerBRSLoadBag.isDisplayed();
	}
	
	public void clickHamburgerDFS() {
		hamburgerDFS.click();
	}
	
	public void clickHamburgerDisruptionLoadBag() {
		hamburgerDisruptionLoadBag.click();
	}

}
