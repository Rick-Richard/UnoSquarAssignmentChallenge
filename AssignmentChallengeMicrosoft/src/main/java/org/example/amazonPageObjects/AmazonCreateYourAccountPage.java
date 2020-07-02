package org.example.amazonPageObjects;

import org.example.utils.WaitsMethods;
import org.example.utils.WebDriverSetup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AmazonCreateYourAccountPage extends WebDriverSetup {

    /**
     * Page Objects defined by @FindBy
     * WebElements for Create your account page.
     */
    @FindBy(id = "nav-link-accountList")
    public WebElement accountList;

    @FindBy(id = "auth-create-account-link")
    public WebElement createAccountlink;

    @FindBy(id = "ap_customer_name")
    public WebElement setCustomerName;

    @FindBy(id = "ap_email")
    public WebElement setCustomerEmail;

    @FindBy(id = "ap_password")
    public WebElement setCustomerPassword;

    @FindBy(id = "ap_password_check")
    public WebElement setCustomerPasswordCheck;

    @FindBy(id = "createAccountSubmit")
    public WebElement createAccountButton;

    @FindBy(className = "a-button-text")
    public WebElement continueButton;


    /**
     * @param driver
     */
    public AmazonCreateYourAccountPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,  this);
    }


    /**
     * Fill customers labels on Create account page.
     * Implements Utilities Class Wait methods.
     * Assert equals.
     */
    public void createYourAccountPage() {
        try {
            accountList.click();
            WaitsMethods.waitForElementToBeVisible(driver,createAccountButton);
            createAccountButton.click();
            WaitsMethods.waitForElementToBeClickable(driver,setCustomerName);
            setCustomerName.sendKeys("test user one");
            setCustomerEmail.sendKeys("testUserOne@testmail.com");
            setCustomerPassword.sendKeys("HelloWorld01");
            setCustomerPasswordCheck.sendKeys("HelloWorld01");
            String continueButtonText =  continueButton.getText();
            Assert.assertEquals(continueButtonText,"Crea tu cuenta de Amazon");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}
