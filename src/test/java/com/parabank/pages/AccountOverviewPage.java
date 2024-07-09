package com.parabank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountOverviewPage extends BasePage {
    public AccountOverviewPage(WebDriver driver) {
        super(driver);
    }

    String successMessage = driver.findElement(By.xpath("//p[text()='Your account was created successfully. You are now logged in.']")).getText();

    public String validateSuccessfulMessageOnAccountOverviewPage() {
        try {
            if (successMessage.equals(BasePage.successfulMessageOnAccountOverviewPage)) {
                return successfulMessageOnAccountOverviewPage;
            }
        } catch (Exception e) {
            System.out.println(e + " " + successMessage + "Element not found");
        }
        return null;
    }
}
