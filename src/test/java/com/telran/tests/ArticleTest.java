package com.telran.tests;

import org.testng.annotations.Test;

public class ArticleTest extends TestBase{

    @Test
    public void addArticleToFavoriteAndRemoveTest(){
        System.out.println("launch");
        app.getMainScreen().searchArticle();
        app.getArticle().pause(4000);
        app.getArticle().addToFavorites();
        app.getArticle().pause(2000);
        app.getArticle().createReadingList();
        app.getArticle().pause(2000);
        app.getArticle().close();
        app.getMainScreen().pause(4000);
        app.getMainScreen().selectFavorites();
//        app.getArticle().removeFromFavorites();


    }
}
