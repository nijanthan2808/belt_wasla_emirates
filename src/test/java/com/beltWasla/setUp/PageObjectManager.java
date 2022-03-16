package com.beltWasla.setUp;

import org.openqa.selenium.WebDriver;

import com.beltWasla.pages.BRSLoadBagPage;
import com.beltWasla.pages.BaggageDeliveryOptionPage;
import com.beltWasla.pages.BeltQohPage;
import com.beltWasla.pages.CustomsPage;
import com.beltWasla.pages.DfsPage_BELT;
import com.beltWasla.pages.DisruptionLoadBagPage;
import com.beltWasla.pages.HomeScreen_BELT;
import com.beltWasla.pages.LeftLuggagePage;
import com.beltWasla.pages.LocationPage_BELT;
import com.beltWasla.pages.LogBagPage_BELT;
import com.beltWasla.pages.LoginPage_BELT;
import com.beltWasla.pages.RackBagPage;
import com.beltWasla.pages.SearchOptionsPage;
import com.beltWasla.pages.TestPage;
import com.beltWasla.pages.WaslaQohPage;


public class PageObjectManager {
	private WebDriver driver;
	private LoginPage_BELT loginPage;
	private HomeScreen_BELT homePage;
	private LocationPage_BELT locationPage;
	private LogBagPage_BELT logBagPage;
	private DfsPage_BELT dfsPage;
	private BeltQohPage beltQohPage;
	private WaslaQohPage waslaQohPage;
	private RackBagPage rackBagPage;
	private LeftLuggagePage leftLuggagePage;
	private BaggageDeliveryOptionPage bdoPage;
	private SearchOptionsPage tagSearchPage;
	private CustomsPage customsPage;
	private BRSLoadBagPage brsLoadBagPage;
	private DisruptionLoadBagPage disruptionPage;
	private TestPage testPage;
	
	
	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	
	public TestPage getTestPage(){
		return (testPage == null) ? testPage = new TestPage(driver) : testPage;
	}
	
	public LoginPage_BELT getLoginPage(){
		return (loginPage == null) ? loginPage = new LoginPage_BELT(driver) : loginPage;
	}
	
	public HomeScreen_BELT getHomePage() {
		return (homePage == null) ? homePage = new HomeScreen_BELT(driver) : homePage;
	}
	
	public LocationPage_BELT getLocationPage() {
		return (locationPage == null) ? locationPage = new LocationPage_BELT(driver) : locationPage;
	}
	
	public LogBagPage_BELT getLogBagPage() {
		return (logBagPage == null) ? logBagPage = new LogBagPage_BELT(driver) : logBagPage;
	}
	
	public DfsPage_BELT getDfsPage() {
		return (dfsPage == null) ? dfsPage = new DfsPage_BELT(driver) : dfsPage;
	}
	
	public BeltQohPage getBeltQohPage() {
		return (beltQohPage == null) ? beltQohPage = new BeltQohPage(driver) : beltQohPage;
	}
	
	public WaslaQohPage getWaslaQohPage() {
		return (waslaQohPage == null) ? waslaQohPage = new WaslaQohPage(driver) : waslaQohPage;
	}
	
	public RackBagPage getRackBagPage() {
		return (rackBagPage == null) ? rackBagPage = new RackBagPage(driver) : rackBagPage;
	}
	
	public LeftLuggagePage getLeftLuggagePage() {
		return (leftLuggagePage == null) ? leftLuggagePage = new LeftLuggagePage(driver) : leftLuggagePage;
	}
	
	public BaggageDeliveryOptionPage getBdoPage() {
		return (bdoPage == null) ? bdoPage = new BaggageDeliveryOptionPage(driver) : bdoPage;
	}
	
	public SearchOptionsPage getTagSearchPage() {
		return (tagSearchPage == null) ? tagSearchPage = new SearchOptionsPage(driver) : tagSearchPage;
	}
	
	public CustomsPage getCustomsPage() {
		return (customsPage == null) ? customsPage = new CustomsPage(driver) : customsPage;
	}
	
	public BRSLoadBagPage getBrsLoadBagPage() {
		return (brsLoadBagPage == null) ? brsLoadBagPage = new BRSLoadBagPage(driver) : brsLoadBagPage;
	}
	
	public DisruptionLoadBagPage getDisruptionPage() {
		return (disruptionPage == null) ? disruptionPage = new DisruptionLoadBagPage(driver) : disruptionPage;
	}
	
	
	
	
}
