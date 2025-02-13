package com.suresh.learning.testng.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.suresh.learning.testng.elements.Ebay_Advanced_Search_Page_Elements;
import com.suresh.learning.testng.elements.Ebay_Home_Page_Elements;
import com.suresh.learning.testng.pages.Ebay_Advanced_Search_Page;
import com.suresh.learning.testng.pages.Ebay_Home_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Ebay_Advanced_Search_Sanity extends AbstractBaseTest{




    @Test(groups = {"smoke","sanity","Regression"})
    public void empty_advanced_search_test() throws Exception {

        App().Flow().navigateToUrl("https://www.ebay.com/sch/ebayadvsearch");

        Thread.sleep(2000);

        String expectedURL = "https://www.ebay.com/v/allcategories";
        String expectedTitle = "All Categories - Browse and Discover more | eBay";

        Assert.assertTrue(App().Pages().AdvancedSearchPage().isAdvSearchButtonEnabled(), "Verify Search Button Enabled");

        App().Pages().AdvancedSearchPage().clickAdvSearchButton();
        Thread.sleep(2000);

        String newUrl = App().Flow().getCurrentPageUrl();
        String newTitle = App().Flow().getCurrentPageTitle();
        System.out.println(newUrl);
        System.out.println(newTitle);

        Assert.assertEquals(newUrl, expectedURL, "Verify URL of the new page");
        Assert.assertEquals(newTitle, expectedTitle, "Verify Title of the new page");
    }

    @Test(groups = {"Regression"})
    public void category_options_in_ascending_order_test() throws Exception {

        App().Flow().navigateToUrl("https://www.ebay.com/sch/ebayadvsearch");
        Thread.sleep(2000);

        List<WebElement> category_options = App().Pages().AdvancedSearchPage().getAllCatOptions();
        List<String> arr1 = new ArrayList<String>();

        for (WebElement option : category_options) {
            arr1.add(option.getText());
        }
        List<String> arr2 = new ArrayList<String>(arr1);
        Collections.sort(arr2);

        System.out.println("Actual List:" + arr1);
        System.out.println("Sorted List:" + arr2);
        Assert.assertTrue(arr1.equals(arr2), "Verify Category Items Sorted");
    }

    @Test(groups = {"smoke","sanity"})
    public void ebay_logo_link_navigates_home_page_test() throws Exception {

        App().Flow().navigateToUrl("https://www.ebay.com/sch/ebayadvsearch");
        Thread.sleep(2000);

        String expectedURL = "https://www.ebay.com/";
        String expectedTitle = "Electronics, Cars, Fashion, Collectibles, Coupons and More | eBay";

        App().Pages().AdvancedSearchPage().clickOnEbayLogo();
        Thread.sleep(2000);
        String newUrl = App().Flow().getCurrentPageUrl();
        String newTitle = App().Flow().getCurrentPageTitle();

        System.out.println(newUrl);
        System.out.println(newTitle);
        Assert.assertEquals(newUrl, expectedURL, "Verify URL of the new page");
        Assert.assertEquals(newTitle, expectedTitle, "Verify Title of the new page");
    }

    @Test(groups = {"sanity","Regression"})
    public void advanced_search_keywords_test() throws Exception {

        App().Flow().navigateToUrl("https://www.ebay.com/sch/ebayadvsearch");
        Thread.sleep(2000);

        String keyword1 = "unlocked";
        String keyword2 = "ios";
        String searchString = keyword1 + " " + keyword2;

        App().Pages().AdvancedSearchPage().enterSearchStringInKeywordsField(searchString);
        App().Pages().AdvancedSearchPage().clickAdvSearchButton();
        Thread.sleep(2000);

        String firstResultTitle = App().Pages().SearchResultsPage().getFirstResultTitle();

        Assert.assertTrue(firstResultTitle.toLowerCase().contains(keyword1),
                "Result Title Contains First Keyword " + keyword1);
        Assert.assertTrue(firstResultTitle.toLowerCase().contains(keyword2),
                "Result Title Contains Second Keyword " + keyword2);
    }

}

