package com.parabankl.test;

import com.parabankl.pages.AccountOverviewPage;
import com.parabankl.pages.ParaBankLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ParaBankLoginTest extends ParaBankBaseTest {
    ParaBankLoginPage paraBankLoginPage;
    AccountOverviewPage accountOverviewPage;

    @Test
    public void loginShouldSucceed() {
        paraBankLoginPage = page.getInstance(ParaBankLoginPage.class);
        paraBankLoginPage.fillUserName(System.getProperty("userName"));
        paraBankLoginPage.fillPassword(System.getProperty("password"));
        paraBankLoginPage.clickLoginBtn();
        Assert.assertTrue(paraBankLoginPage.getPageTitle().contains(driver.getTitle()));
    }
}
