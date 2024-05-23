package com.parabankl.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GeneralUtils {
    public static final int WAIT_TIME = 30;
    public static WebDriver driver;

    public static void getImplicitWait() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WAIT_TIME));
    }

    /**
     * wait For Element Visibility on the webpage
     *
     * @param driver
     * @param element
     */
    public void waitForElementVisibility(WebDriver driver, By element) {
        try {
            WebDriverWait waitForElementVisibility = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME));
            waitForElementVisibility.until(ExpectedConditions.visibilityOfElementLocated(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * wait For Element clickable on the webpage
     *
     * @param driver
     * @param element
     */
    public void waitForElementClickable(WebDriver driver, By element) {
        try {
            WebDriverWait waitForElementClickable = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME));
            waitForElementClickable.until(ExpectedConditions.visibilityOfElementLocated(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
