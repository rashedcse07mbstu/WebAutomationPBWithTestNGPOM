package com.parabankl.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    public WebDriver driver;

    //Constructor
    BasePage(WebDriver driver) {
        this.driver = driver;
    }

    //get every Page title
    public abstract String getPageTitle();

    //Input value in Input field
    public void inputText(By element, String text) {
        driver.findElement(element).sendKeys(text);
    }

    //Click on any link or button
    public void clickBtn(By element) {
        driver.findElement(element).click();
    }

    //Get text
    public String getText(By element){
        return driver.findElement(element).getText();
    }

}
