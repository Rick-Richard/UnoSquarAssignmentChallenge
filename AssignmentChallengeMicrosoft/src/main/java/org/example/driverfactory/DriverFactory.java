package org.example.driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    public WebDriver create(){
        ChromeOptions options = new ChromeOptions();

        options.addArguments("test-type");
        options.addArguments("start-maximized");
        options.addArguments("--js-flags=--expose-gc");
        options.addArguments("--enable-precise-memory-info");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-default-apps");
        options.addArguments("test-type=browser");
        options.addArguments("disable-infobars");

        try {
            String pathToChromeDriver = System.getProperty("user.dir") + "/src/main/java/org/example/driverfactory/chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", pathToChromeDriver);
            return new ChromeDriver(options);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
