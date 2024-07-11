package com.parabank.test;

import com.parabank.pages.AccountOverviewPage;
import com.parabank.pages.BasePage;
import com.parabank.pages.ParaBankLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountOverviewTest extends ParaBankBaseTest{
    AccountOverviewPage accountOverviewPage;
    ParaBankLoginPage paraBankLoginPage;

    @Test
    public void validateAccountOverviewSuccessMessage() {
        paraBankLoginPage = page.getInstance(ParaBankLoginPage.class);
        paraBankLoginPage.fillUserName(System.getProperty("userName"));
        paraBankLoginPage.fillPassword(System.getProperty("password"));
        paraBankLoginPage.clickLoginBtn();

        accountOverviewPage = page.getInstance(AccountOverviewPage.class);
        Assert.assertEquals(accountOverviewPage.validateSuccessfulMessageOnAccountOverviewPage(), BasePage.successfulMessageOnAccountOverviewPage);
    }
}
