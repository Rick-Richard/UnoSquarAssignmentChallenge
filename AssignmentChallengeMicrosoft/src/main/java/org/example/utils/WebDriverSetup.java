package org.example.utils;

import org.example.driverfactory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class WebDriverSetup {

    public WebDriver driver;

    public void SetUp(){
        try {
            driver = new DriverFactory().create();
            driver.manage().window().maximize();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void TearDown(){
        try {
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
