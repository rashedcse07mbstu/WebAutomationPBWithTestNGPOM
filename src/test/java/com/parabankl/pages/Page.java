package com.parabankl.pages;

import org.openqa.selenium.WebDriver;

public abstract class Page {
    public static WebDriver driver;

    //get every Page title
    public abstract String getPageTitle();

    //Method which will return every page Class
    public <T extends BasePage> AccountOverviewPage getInstance(Class<AccountOverviewPage> pageClass) {
        try {
            return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
