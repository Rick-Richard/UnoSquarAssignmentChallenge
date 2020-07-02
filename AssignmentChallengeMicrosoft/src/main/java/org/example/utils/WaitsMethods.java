package org.example.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class WaitsMethods extends WebDriverSetup {

    public static void waitForElementToBeVisible(WebDriver driver, WebElement targetElement){
        final WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(targetElement));
    }

    public static void waitForElementToBeClickable(WebDriver driver, WebElement targetElement){
       final WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(targetElement));
    }

    public static void waitForURLToBeVisible(WebDriver driver, String targetElement){
        final WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.urlToBe(targetElement));

    }

}
