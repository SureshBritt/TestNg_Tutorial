package com.suresh.learning.testng.pages;

import java.util.List;

import com.suresh.learning.testng.elements.Ebay_Advanced_Search_Page_Elements;
import com.suresh.learning.testng.elements.Ebay_Search_Results_Page_Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class Ebay_Advanced_Search_Page {

	WebDriver driver;
	Ebay_Advanced_Search_Page_Elements advSearchElements;
	Ebay_Search_Results_Page_Elements searchResultsElements;
	
	public Ebay_Advanced_Search_Page(WebDriver driver) {
		this.driver = driver;
		advSearchElements = new Ebay_Advanced_Search_Page_Elements(driver);
		searchResultsElements = new Ebay_Search_Results_Page_Elements(driver);	
	}
	
	/**
	 * Is Advanced Search Button Enabled
	 */
	public boolean isAdvSearchButtonEnabled() {
		return advSearchElements.advSearchBtn.isEnabled();
	}
	
	/**
	 * Get all catagory dropdown options
	 */
	public List<WebElement> getAllCatOptions(){
		return advSearchElements.allCatSelectBoxOptions;
	}
	
	/**
	 * Click on Ebay logo
	 */
	public void clickOnEbayLogo() {
		advSearchElements.ebayLogo.click();
	}
	
	/**
	 * Enter search string in keywords field
	 */
	public void enterSearchStringInKeywordsField(String srcString) {
		advSearchElements.keywordsField.sendKeys(srcString);
	}
	
	/**
	 * Click advanced search button
	 */
	public void clickAdvSearchButton() {
		advSearchElements.advSearchBtn.click();
	}
}
