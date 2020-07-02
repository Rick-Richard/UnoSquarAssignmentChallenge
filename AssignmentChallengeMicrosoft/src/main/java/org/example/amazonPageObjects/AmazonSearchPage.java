package org.example.amazonPageObjects;

import org.example.utils.WaitsMethods;
import org.example.utils.WebDriverSetup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class AmazonSearchPage extends WebDriverSetup {

    /**
     * Page Objects defined by @FindBy
     * WebElements for Search Page
     */
    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchBox;

    @FindBy(className = "nav-input")
    public WebElement searchButton;

    @FindBy(className = "a-price-symbol")
    public WebElement getPriceSymbol;

    @FindBy(className = "a-price-whole")
    public WebElement getPricewhole;

    @FindBy(className = "a-price-fraction")
    public WebElement getPriceFraction;

    @FindBy(id = "price_inside_buybox")
    public WebElement priceInsideBuyBox;

    @FindBy(id = "priceblock_ourprice")
    public WebElement priceName;

    @FindBy(id = "add-to-cart-button")
    public WebElement addToCartButton;

    @FindBy(id = "a-alert-heading")
    public WebElement alertHeading;

    /**
     * @param driver
     */
    public AmazonSearchPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,  this);
    }

    /**
     * Search for Samsung Galaxy 9 device and send item to cart page.
     * Implements Utilities Class Wait methods.
     * Assert equals.
     */
    public void searchSamsungDevice() {
        try {
            searchBox.sendKeys("Samsung Galaxy S9");
            searchButton.click();
            WaitsMethods.waitForElementToBeVisible(driver,getPriceSymbol);
            String getpricesymbol = getPriceSymbol.getText();
            String getpriceswhole = getPricewhole.getText();
            String getpricefraction = getPriceFraction.getText();
            String pricewholeText = (getpricesymbol+" "+getpriceswhole+"."+getpricefraction);
            getPricewhole.click();
            WaitsMethods.waitForElementToBeClickable(driver,priceName);
            String priceInsideBuyBoxText = priceName.getText();
            Assert.assertEquals(pricewholeText,priceInsideBuyBoxText,"Same Price");
            addToCartButton.click();
            WaitsMethods.waitForElementToBeVisible(driver,alertHeading);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
