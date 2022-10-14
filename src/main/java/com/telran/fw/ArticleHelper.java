package com.telran.fw;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class ArticleHelper extends HelperBase{
    public ArticleHelper (AppiumDriver driver){
        super(driver);
    }

    public void addToFavorites() {
        click(By.xpath("//android.widget.ImageView[@content-desc=\"Add this article to a reading list\"]"));
        pause(2000);
        clickGotIt("GOT IT");
    }

    public void createReadingList() {
        fillNameOfTheList("WISH",20);
        pause(2000);
        click(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v7.widget.LinearLayoutCompat/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[2]"));

    }

    public void fillNameOfTheList(String text, int timeOut) {
        waitForElementAndType(By.id("text_input"), timeOut, text);
        hideKeyboard();
    }

    public void clickGotIt(String td) {
        if (td.equals("GOT IT")){
            click(By.id("onboarding_button"));
        } else {
            click(By.id("create_button"));
        }
    }

    public void close() {
        click(By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]"));
    }

    public void removeFromFavorites() {
        click(By.id("item_overflow_menu"));
        click(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.RelativeLayout/android.widget.TextView"));
    }
}
