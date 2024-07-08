package com.parabank.pages;

import org.openqa.selenium.WebDriver;

public abstract class Page {
    public static WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    //get every Page title
    public abstract String getPageTitle();

    //Method which will return every page Class
    public <T extends BasePage> T getInstance(Class<T> pageClass) {
        try {
            return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
