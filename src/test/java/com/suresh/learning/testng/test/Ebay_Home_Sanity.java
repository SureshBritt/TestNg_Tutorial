package com.suresh.learning.testng.test;

import com.suresh.learning.testng.elements.Ebay_Home_Page_Elements;
import com.suresh.learning.testng.pages.Ebay_Home_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.Assert;

public class Ebay_Home_Sanity extends AbstractBaseTest{



   /*
      *** Assertions ***
      Assert.assertEquals(actual, expected, message);
	  Assert.assertNotEquals(actual1, actual2, message);
	  Assert.assertTrue(condition, message);
	  Assert.assertFalse(condition, message);
	  Assert.assertNull(object, message);
	  Assert.assertNotNull(object, message);
   */


    @Test(groups = {"sanity","Regression"})
    public void empty_search_test() throws Exception {

        App().Flow().navigateToUrl("https://www.ebay.com/");

        Thread.sleep(2000);

        String expectedURL = "https://www.ebay.com/v/allcategories";
        String expectedTitle = "All Categories - Browse and Discover more | eBay";

        Assert.assertTrue(App().Pages().HomePage().isSearchButtonEnabled(), "Verify Search Button Enabled");

        App().Pages().HomePage().clickSearchButton();
        Thread.sleep(2000);
        String newUrl = App().Flow().getCurrentPageUrl();
        String newTitle = App().Flow().getCurrentPageTitle();
        System.out.println(newUrl);
        System.out.println(newTitle);

        Assert.assertEquals(newUrl, expectedURL, "Verify URL of the new page");
        Assert.assertEquals(newTitle, expectedTitle, "Verify Title of the new page");

    }

    @Test(groups = {"smoke","Regression"})
    public void empty_search_test_softassert() throws Exception {

        App().Flow().navigateToUrl("https://www.ebay.com/");
        Thread.sleep(2000);

        SoftAssert sa = new SoftAssert();

        String expectedURL = "https://www.ebay.com/v/allcategories";
        String expectedTitle = "All Categories - Browse and Discover more | eBay";

        sa.assertTrue(App().Pages().HomePage().isSearchButtonEnabled(), "Verify Search Button Enabled");

        App().Pages().HomePage().clickSearchButton();
        Thread.sleep(2000);
        String newUrl = App().Flow().getCurrentPageUrl();
        String newTitle = App().Flow().getCurrentPageTitle();
        System.out.println(newUrl);
        System.out.println(newTitle);

        sa.assertEquals(newUrl, expectedURL, "Verify URL of the new page");
        sa.assertEquals(newTitle, expectedTitle, "Verify Title of the new page");

        sa.assertAll();
    }
}
