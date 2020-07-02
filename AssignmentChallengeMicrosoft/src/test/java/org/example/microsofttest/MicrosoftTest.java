package org.example.microsofttest;

import org.example.amazonPageObjects.AmazonCreateYourAccountPage;
import org.example.microsoftPageObjects.MicrosoftHomePage;
import org.example.utils.HomePage;
import org.example.amazonPageObjects.AmazonSearchPage;
import org.example.utils.WebDriverSetup;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MicrosoftTest extends WebDriverSetup {
    String microsofturl = "https://www.microsoft.com/en-us/";

    @BeforeTest
    public void webDriverLoad() {
        SetUp();
    }

    @Test(priority = 0)
    public void MicrosoftValidateElements() {
        HomePage home = new HomePage(driver);
        MicrosoftHomePage microsoftTest = new MicrosoftHomePage(driver);
        home.navigateToURL(microsofturl);
        microsoftTest.microsoftPageValidateElements();
        microsoftTest.windows10MenuPrint();
        microsoftTest.visualStudioValidateElements();
    }

  /*  @Test(priority = 1)
    public void AmazonCreateYourAccountTest() {
        HomePage home = new HomePage(driver);
        AmazonCreateYourAccountPage accountPage = new AmazonCreateYourAccountPage(driver);
        home.navigateToURL(microsofturl);
        accountPage.createYourAccountPage();
    }
*/
/*    @AfterTest
    public void webDriverQuit() {
        TearDown();
    }*/
}