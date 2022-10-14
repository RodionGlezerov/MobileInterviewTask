package com.telran.fw;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HelperBase {
    AppiumDriver driver;

    public HelperBase(AppiumDriver driver) {
        this.driver = driver;
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void waitForElementAndClick(By locator, int timeOut) {
        new WebDriverWait(driver, timeOut)
                .until(ExpectedConditions.presenceOfElementLocated(locator)).click();
    }

    public void waitForElementAndType(By locator, int timeOut, String text) {
        if (text != null) {
            waitForElementAndClick(locator, timeOut);
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
    }


    public void type(By locator, String text) {
        if (text != null) {
            if (!text.equals(driver.findElement(locator).getText())) {
                click(locator);
                driver.findElement(locator).clear();
                driver.findElement(locator).sendKeys(text);
            }
        }
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public void hideKeyboard() {
        driver.hideKeyboard();
    }

    public void pause(int i) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void swipeUp() {
        TouchAction action = new TouchAction(driver);

        Dimension size = driver.manage().window().getSize();

        int x = size.width / 2;

        int startY = (int) (size.height * 0.8);
        int stopY = (int) (size.height * 0.3);

        action.longPress(PointOption.point(x, startY))
                .moveTo(PointOption.point(x, stopY))
                .release()
                .perform();

    }

    public void swipeDown() {
        TouchAction action = new TouchAction(driver);

        Dimension size = driver.manage().window().getSize();

        int x = size.width / 2;

        int startY = (int) (size.height * 0.5);
        int stopY = (int) (size.height * 0.8);

        action.longPress(PointOption.point(x, startY))
                .moveTo(PointOption.point(x, stopY))
                .release()
                .perform();

    }

    public void moveUp(By locator) {
        TouchAction action = new TouchAction(driver);

        Dimension size = driver.manage().window().getSize();

        int downPoint = (int) (size.height * 0.6);
        int upPoint = (int) (size.height * 0.5);
//      get Element's point
        WebElement element = driver.findElement(locator);
        int leftX = element.getLocation().getX();
        int rightX = leftX + element.getSize().getWidth();
        int middleX = (leftX + rightX) / 2;

        action.longPress(PointOption.point(middleX, downPoint))
                .moveTo(PointOption.point(middleX, upPoint))
                .release()
                .perform();
    }

    public void moveDown(By locator) {
        TouchAction action = new TouchAction(driver);

        Dimension size = driver.manage().window().getSize();

        int downPoint = (int) (size.height * 0.6);
        int upPoint = (int) (size.height * 0.5);
//      get Element's point
        WebElement element = driver.findElement(locator);
        int leftX = element.getLocation().getX();
        int rightX = leftX + element.getSize().getWidth();
        int middleX = (leftX + rightX) / 2;

        action.longPress(PointOption.point(middleX, upPoint))
                .moveTo(PointOption.point(middleX, downPoint))
                .release()
                .perform();
    }

    public void pressOnTimer(int x, int y){
        TouchAction action = new TouchAction(driver);

        Dimension size = driver.manage().window().getSize();

        action.tap(PointOption.point(x,y))
                .release()
                .perform();

    }

    public String isTitlePresent() {
        String recycle_title = driver.findElement(By.id("recycle_title")).getText();
        System.out.println(recycle_title);
        return recycle_title;
    }

    public void fillSearchText(String text, int timeOut) {
        waitForElementAndType(By.id("fragment_feed_header"), timeOut, text);
        hideKeyboard();
    }

    public void pressOnEnter(int x, int y){
        TouchAction action = new TouchAction(driver);

        Dimension size = driver.manage().window().getSize();

        action.tap(PointOption.point(x,y))
                .release()
                .perform();

    }




}
