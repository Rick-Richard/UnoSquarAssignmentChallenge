package org.example.amazontest;

import org.example.amazonPageObjects.AmazonCreateYourAccountPage;
import org.example.utils.HomePage;
import org.example.amazonPageObjects.AmazonSearchPage;
import org.example.utils.WebDriverSetup;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AmazonTest extends WebDriverSetup {
    String amazonurl = "https://www.amazon.com/";

    @BeforeTest
    public void webDriverLoad() {
        SetUp();
    }

    @Test(priority = 0)
    public void AmazonAddItemToCartTest() {
        HomePage home = new HomePage(driver);
        AmazonSearchPage searchPage = new AmazonSearchPage(driver);
        home.navigateToURL(amazonurl);
        searchPage.searchSamsungDevice();
    }

    @Test(priority = 1)
    public void AmazonCreateYourAccountTest() {
        HomePage home = new HomePage(driver);
        AmazonCreateYourAccountPage accountPage = new AmazonCreateYourAccountPage(driver);
        home.navigateToURL(amazonurl);
        accountPage.createYourAccountPage();
    }

    @AfterTest
    public void webDriverQuit() {
        TearDown();
    }
}