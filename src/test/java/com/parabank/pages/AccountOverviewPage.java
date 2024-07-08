package com.parabank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountOverviewPage extends BasePage {
    public AccountOverviewPage(WebDriver driver) {
        super(driver);
    }

    By successMessageEle = By.xpath("//p[text()='Your account was created successfully. You are now logged in.']");
}
