package com.telran.fw;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AppManager {
    AppiumDriver driver;

    DesiredCapabilities capabilities;

    MainScreenHelper mainScreen;
    ArticleHelper article;

    public MainScreenHelper getMainScreen() {
        return mainScreen;
    }

    public ArticleHelper getArticle() {
        return article;
    }

    public void init() throws MalformedURLException {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("deviceName", "qa32_mob");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", "org.wikipedia.main.MainActivity");
        capabilities.setCapability("app", "/Users/rodionglezerov/Desktop/Tools/org.wikipedia.apk");

        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        mainScreen = new MainScreenHelper(driver);
        article = new ArticleHelper(driver);


    }

    public void stop() {
        driver.quit();
    }
}


