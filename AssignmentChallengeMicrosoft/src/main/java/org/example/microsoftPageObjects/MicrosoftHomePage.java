package org.example.microsoftPageObjects;

import org.example.utils.WaitsMethods;
import org.example.utils.WebDriverSetup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class MicrosoftHomePage extends WebDriverSetup {

    /**
     * Page Objects defined by @FindBy
     * WebElements for Microsoft Page
     */
    @FindBy(css = "#shellmenu_0")
    public WebElement microsoft365MenuButton;

    @FindBy(css = "#shellmenu_1")
    public WebElement officeMenuButton;

    @FindBy(css = "#shellmenu_2")
    public WebElement windowsMenuButton;

    @FindBy(css = "#shellmenu_3")
    public WebElement surfaceMenuButton;

    @FindBy(css = "#shellmenu_4")
    public WebElement xbixMenuButton;

    @FindBy(css = "#shellmenu_5")
    public WebElement dealsMenuButton;

    @FindBy(css = "#c-shellmenu_50")
    public WebElement windows10DropDownMenu;

    @FindBy(css = "#uhf-g-nav li:nth-child(2) div ul li")
    public List<WebElement> windows10Menu;

    @FindBy(id = "search")
    public WebElement searchIcon;

    @FindBy(id = "cli_shellHeaderSearchInput")
    public WebElement searchInput;

    @FindBy(id = "div.m-channel-placement h2 spant")
    public WebElement softwareText;

    @FindBy(css = "div.c-channel-placement-price > div > span:nth-child(3) > span:nth-child(1)")
    public List<WebElement> searchPrice;

    @FindBy(css = "#ProductPrice_productPrice_PriceContainer span")
    public WebElement searchPriceDetails;

    @FindBy(id = "buttonPanel_AddToCartButton")
    public WebElement addToCartButton;

    @FindBy(css = "div.item-price div span span:nth-child(3) span")
    public WebElement priceCart;

    @FindBy(css = "#store-cart-root > div > div > div > section._3LWrsBIG > div > div > div:nth-child(2) > div > span:nth-child(1) > span:nth-child(2) > div > span > span:nth-child(3) > span")
    public WebElement priceCartTwo;
    @FindBy(css = "#store-cart-root > div > div > div > section._3LWrsBIG > div > div > div:nth-child(4) > div > span > span:nth-child(2) > strong > span")
    public WebElement priceCart3;

    @FindBy(id = "#store-cart-root > div > div > div > section._3a6I5TkT > div > div > div > div > div > div.item-details > div.item-quantity-price > div.item-quantity > select > option:nth-child(20)")
    public WebElement listSelect;

    /**
     * @param driver
     */
    public MicrosoftHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Validate elements are visible on Windows page.
     * Implements Utilities Class Wait methods.
     * Assert equals.
     */
    public void microsoftPageValidateElements() {
        try {
            WaitsMethods.waitForElementToBeVisible(driver,microsoft365MenuButton);
            WaitsMethods.waitForElementToBeVisible(driver,officeMenuButton);
            WaitsMethods.waitForElementToBeVisible(driver,windowsMenuButton);
            WaitsMethods.waitForElementToBeVisible(driver,surfaceMenuButton);
            WaitsMethods.waitForElementToBeVisible(driver,xbixMenuButton);
            WaitsMethods.waitForElementToBeVisible(driver,dealsMenuButton);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void windows10MenuPrint() {
        try {
            windowsMenuButton.click();
            WaitsMethods.waitForElementToBeClickable(driver,windows10DropDownMenu);
            windows10DropDownMenu.click();
            windows10MenuList(windows10Menu);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        public void windows10MenuList(List<WebElement> list) {
            try {
                for(WebElement item : list) {
                    System.out.println(item.getText());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    public void visualStudioValidateElements() {
        searchIcon.click();
        searchInput.sendKeys("Visual Studio");
        searchInput.submit();
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOf(softwareText));
        searchPriceList(searchPrice);
        WebElement price = searchPrice.get(0);
        String stringPrice = price.getText();
        price.click();
        String stringPriceDetails = searchPriceDetails.getText();
        Assert.assertEquals(stringPrice,stringPriceDetails,"Match");
        addToCartButton.click();
        WaitsMethods.waitForElementToBeClickable(driver,priceCart);
        String pricecart = priceCart.getText();
        String pricecart2 = priceCartTwo.getText();
        String pricecar3 = priceCart3.getText();
        Assert.assertEquals(pricecart,pricecart2);
        Assert.assertEquals(pricecart2,pricecar3);
        listSelect.click();

    }

    public void searchPriceList(List<WebElement> list) {
        try {
            for(WebElement item : list) {
                System.out.println(item.getText());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}