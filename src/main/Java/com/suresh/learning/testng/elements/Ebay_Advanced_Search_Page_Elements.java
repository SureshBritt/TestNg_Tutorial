package com.suresh.learning.testng.elements;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Ebay_Advanced_Search_Page_Elements {

    WebDriver driver;

    @FindBy(css="button.btn-prim") public WebElement advSearchBtn;

    @FindBy(id="gh-logo") public WebElement ebayLogo;

    @FindBy(xpath="//input[@id='_nkw']") public WebElement keywordsField;

    @FindBy(name="_sacat") public List<WebElement> allCatSelectBoxOptions;

    public Ebay_Advanced_Search_Page_Elements(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
