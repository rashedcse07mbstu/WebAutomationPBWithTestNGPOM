package com.parabank.pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BasePage extends Page {
    public static WebDriver driver;
    public static String successfulMessageOverviewPage= "Your account was created successfully. You are now logged in.";

    //Constructor
    public BasePage(WebDriver driver) {
        super(driver);
    }

    //Input value in Input field
    public void inputText(By element, String text) {
        driver.findElement(element).sendKeys(text);
    }

    //Click on any link or button
    public void clickBtn(By element) {
        driver.findElement(element).click();
    }

    //Get text
    public String getText(By element) {
        return driver.findElement(element).getText();
    }

    //select dropdown value from list
    public void selectValueByIndex(WebElement element, int index) {
        Select selectEle = new Select(element);
        selectEle.selectByIndex(1);
    }

    public void selectValueByValue(WebElement element, String value) {
        Select selectEle = new Select(element);
        selectEle.selectByValue(value);
    }

    public void selectValueByVisibleText(WebElement element, String text) {
        Select selectEle = new Select(element);
        selectEle.selectByValue(text);
    }

    //Get error message
    public String getErrorMessage(By element) {
        return driver.findElement(element).getText();
    }

    //Take screenshot
    public static String getScreenShot(WebDriver driver, String screenShotName) throws IOException {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        String source = ts.getScreenshotAs(OutputType.BASE64);
        String destination = System.getProperty("user.dir") + "/Screenshots/" + screenShotName + dateName + ".png";
        File fileDestination = new File(destination);
        FileUtils.copyFile(new File(source), fileDestination);
        return destination;
    }

    @Override
    public String getPageTitle() {
        return driver.getTitle();
    }
}
