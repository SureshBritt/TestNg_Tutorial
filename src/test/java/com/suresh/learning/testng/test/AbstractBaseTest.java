package com.suresh.learning.testng.test;
import com.suresh.learning.testng.lib.AppLib;
import com.suresh.learning.testng.pages.Ebay_Advanced_Search_Page;
import com.suresh.learning.testng.pages.Ebay_Home_Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class AbstractBaseTest {
    WebDriver driver;
    private AppLib app;
    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional("Chrome") String browser) throws Exception {
    if (browser.equals("Chrome")) {
        System.setProperty("webdriver.chrome.driver", "C:/Automation/drivers/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
    }
    else if (browser.equals("Firefox")) {
        System.setProperty("webdriver.gecko.driver", "C:/Automation/drivers/geckodriver/geckodriver.exe");
        driver = new FirefoxDriver();
    }
        driver.get("https://www.ebay.com/sch/ebayadvsearch");
        Thread.sleep(2000);
        app = new AppLib(driver);

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.close();
    }
    public AppLib App() {
        return app;
    }

}
