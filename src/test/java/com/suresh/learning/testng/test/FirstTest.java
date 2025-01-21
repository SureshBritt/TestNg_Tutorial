package com.suresh.learning.testng.test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
public class FirstTest {
    @Test
    public void MyFirstTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/Automation/drivers/chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ebay.com/");
        Thread.sleep(3000);
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
        driver.close();
    }
}
