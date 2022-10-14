package com.telran.fw;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

import java.awt.event.KeyEvent;

public class MainScreenHelper extends  HelperBase{

    public MainScreenHelper(AppiumDriver driver) {
        super(driver);
    }

    public void searchArticle() {
        click(By.id("fragment_feed_header"));
        click(By.id("search_src_text"));
        fillSearchTextMain("TCP/IP",10);
        pause(3000);
        pressOnEnter(998,1688);



    }

    public void fillSearchTextMain(String text, int timeOut) {
        waitForElementAndType(By.id("search_src_text"), timeOut, text);

    }

    public void selectFavorites() {
        click(By.xpath("//android.widget.FrameLayout[@content-desc=\"My lists\"]"));
        click(By.id("item_container"));
    }
}
