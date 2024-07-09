package com.parabank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountOverviewPage extends BasePage {

    public AccountOverviewPage(WebDriver driver) {
        super(driver);
    }

    String successMessage = driver.findElement(By.xpath("//p[text()='Your account was created successfully. You are now logged in.']")).getText();

    public String validateSuccessfulMessage() {
        try {
            if (successMessage.equals(BasePage.successfulMessageOverviewPage)) {
                return successfulMessageOverviewPage;
            }
        }
        catch (Exception e){
            System.out.println(e + "Successful message not found");
        }
        return null;
    }
}
