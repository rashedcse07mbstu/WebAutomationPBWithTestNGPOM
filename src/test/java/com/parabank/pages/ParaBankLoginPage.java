package com.parabank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ParaBankLoginPage extends BasePage {
    public ParaBankLoginPage(WebDriver driver) {
        super(driver);
    }

    By userNameEle = By.id("username");
    By passwordEle = By.id("inputPassword");
    By loginBtnEle = By.id("submit-login-form");
    By registerLinkEle = By.cssSelector("a[href='register.htm']");

    public ParaBankLoginPage fillUserName(String user) {
        inputText(userNameEle, user);
        return this;
    }

    public ParaBankLoginPage fillPassword(String pas) {
        inputText(passwordEle, pas);
        return this;
    }

    public AccountOverviewPage clickLoginBtn() {
        clickBtn(loginBtnEle);
        return new AccountOverviewPage(driver);
    }

    public ParaBankRegisterPage clickRegisterLink() {
        driver.findElement(registerLinkEle).click();
        return new ParaBankRegisterPage(driver);
    }

    @Override
    public String getPageTitle() {
        return "ParaBank | Customer Created";
    }

}
