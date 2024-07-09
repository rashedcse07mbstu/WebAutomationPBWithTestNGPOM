package com.parabank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ParaBankLoginPage extends BasePage {
    public ParaBankLoginPage(WebDriver driver) {
        super(driver);
    }

    By userName = By.id("username");
    By password = By.id("inputPassword");
    By loginBtn = By.id("submit-login-form");

    public ParaBankLoginPage fillUserName(String user) {
        inputText(userName, user);
        return this;
    }

    public ParaBankLoginPage fillPassword(String pas) {
        inputText(password, pas);
        return this;
    }

    public AccountOverviewPage clickLoginBtn() {
        clickBtn(loginBtn);
        return new AccountOverviewPage(driver);
    }

    @Override
    public String getPageTitle() {
        return "ParaBank | Customer Created";
    }

}
