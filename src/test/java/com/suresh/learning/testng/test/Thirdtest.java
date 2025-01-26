package com.suresh.learning.testng.test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class Thirdtest {
    WebDriver driver;
    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class----executed");
    }
    @AfterClass
    public void afterClass() {
        System.out.println("After Class----executed");
    }
    @BeforeMethod
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:/Automation/drivers/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.ebay.com/");
        Thread.sleep(3000);
        System.out.println("Before Method---Executed");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.close();
        System.out.println("After Method---Executed");
    }
    @Test
    public void MyThirdtest() throws InterruptedException {

        driver.findElement(By.id("gh-search-btn")).click();
        Thread.sleep(3000);
        String title = driver.getTitle();
        System.out.println(title);
        String LoadedUrl = driver.getCurrentUrl();
        System.out.println(LoadedUrl);
        Assert.assertEquals(title,"Shop by Category | eBay","assertions on title equals ");
        Assert.assertNotSame(LoadedUrl,"https://www.ebay.com/","assertions on initial url and url after clicking submit are not same");
        assert LoadedUrl != null;
        Assert.assertTrue(LoadedUrl.contains("ebay"),"Assert true if loaded url contains ebay text");
        Assert.assertFalse(LoadedUrl.isEmpty(),"Assert false if loaded url is empty");

    }
    @Test
    public void MyThirdTestWithSoftAssert() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        driver.findElement(By.id("gh-search-btn")).click();
        Thread.sleep(3000);
        String title = driver.getTitle();
        System.out.println(title);
        String LoadedUrl = driver.getCurrentUrl();
        System.out.println(LoadedUrl);
        softAssert.assertEquals(title,"Shop by Category | eBay","assertions on title equals ");
        softAssert.assertNotSame(LoadedUrl,"https://www.ebay.com/","assertions on initial url and url after clicking submit are not same");
        assert LoadedUrl != null;
        softAssert.assertTrue(LoadedUrl.contains("ebay"),"Assert true if loaded url contains ebay text");
        softAssert.assertFalse(LoadedUrl.isEmpty(),"Assert false if loaded url is empty");
        softAssert.assertAll();
    }
}
