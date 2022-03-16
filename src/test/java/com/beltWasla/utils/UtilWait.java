package com.beltWasla.utils;

import java.util.function.Function;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilWait {

	// To wait for the page to load
	public static void waitForPageLoaded(WebDriver webDriver) {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver webDriver) {
				UtilThread.sleep(500);
				return Boolean.valueOf((((JavascriptExecutor) webDriver)
						.executeScript("return document.readyState", new Object[0]).equals("complete")
						|| ((JavascriptExecutor) webDriver)
								.executeScript("return document.readystatechange", new Object[0])
								.equals("interactive")));
			}
		};
		WebDriverWait webDriverWait = new WebDriverWait(webDriver, 20);
		try {
			webDriverWait.until((Function<WebDriver, Boolean>) expectation);
		} catch (Exception exception) {
		}
	}

	// To wait till the AJAX executer to complete
	public static void waitAjaxLoaded(WebDriver webDriver) {
		JavascriptExecutor ajaxExe = (JavascriptExecutor) webDriver;
		Boolean loading = Boolean.valueOf(true);
		int counter = 1;
		UtilThread.sleep(1000);
		if (ajaxExe == null)
			return;
		while (loading.booleanValue()) {
			try {
				loading = (Boolean) ajaxExe.executeScript("return Ext.Ajax.isLoading();", new Object[0]);
				Thread.sleep(500L);
			} catch (InterruptedException interruptedException) {

			} catch (WebDriverException e) {
				return;
			}
			counter++;
			if (counter == 90) {
				loading = Boolean.valueOf(false);
			}
		}
	}

	// To wait for all elements in the page to load
	public static void waitLoadAll(WebDriver driver) {
		waitForPageLoaded(driver);
		waitAjaxLoaded(driver);
	}

}
