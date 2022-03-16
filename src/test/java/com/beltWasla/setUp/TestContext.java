package com.beltWasla.setUp;

import com.beltWasla.runners.TestRunner;

public class TestContext extends TestRunner {
	// private WebDriverManager webDriverManager;
	private PageObjectManager pageObjectManager;

	public TestContext() {
		// webDriverManager = new WebDriverManager();
		pageObjectManager = new PageObjectManager(driver);
	}

	// public WebDriverManager getWebDriverManager() {
	// return webDriverManager;
	// }

	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}

}
