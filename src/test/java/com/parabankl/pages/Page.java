package com.parabankl.pages;

import org.openqa.selenium.WebDriver;

public abstract class Page {
    public static WebDriver driver;

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
