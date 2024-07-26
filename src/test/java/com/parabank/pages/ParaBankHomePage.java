package com.parabank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ParaBankHomePage extends BasePage {
    public static String WelcomeParaBankMessage = "Welcome parabank";

    public ParaBankHomePage(WebDriver driver) {
        super(driver);
    }

    By welcomeTitleEle = By.cssSelector("h1[class='title']");

    public String getWelcomeParaBnkText() {
       return driver.findElement(welcomeTitleEle).getText();
    }
}
