package org.example.utils;

import org.openqa.selenium.WebDriver;


public class HomePage extends WebDriverSetup {

    //private String URL = "https://www.amazon.com/";

    public HomePage(WebDriver driver){
        this.driver = driver;
        }

    public void navigateToURL(String URL) {
        try {
            driver.navigate().to(URL);
            WaitsMethods.waitForURLToBeVisible(driver,URL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
