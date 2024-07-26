package com.parabank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ParaBankRegisterPage extends BasePage {
    public ParaBankRegisterPage(WebDriver driver) {
        super(driver);
    }

    By customerFirstNameEle = By.id("customer.firstName");
    By customerLastNameEle = By.id("customer.lastName");
    By customerAddressStreetEle = By.id("customer.address.street");
    By customerCityEle = By.id("customer.address.city");
    By customerStateEle = By.id("customer.address.state");
    By customerZipCodeEle = By.id("customer.address.zipCode");
    By customerPhoneNoEle = By.id("customer.phoneNumber");
    By customerPhoneSSNEle = By.id("customer.ssn");
    By customerUserNameEle = By.id("customer.username");
    By customerPasswordEle = By.id("customer.password");
    By customerConfirmPassEle = By.id("repeatedPassword");
    By registerBtnEle = By.cssSelector("input.button[value='Register']");

    public ParaBankRegisterPage fillFirstNameField(String firstName) {
        driver.findElement(customerFirstNameEle).sendKeys(firstName);
        return this;
    }

    public ParaBankRegisterPage fillLastNameField(String lastName) {
        driver.findElement(customerLastNameEle).sendKeys((lastName));
        return this;
    }

    public ParaBankRegisterPage fillAddressStreetField(String addressStreet) {
        driver.findElement(customerAddressStreetEle).sendKeys((addressStreet));
        return this;
    }

    public ParaBankRegisterPage fillCityField(String city) {
        driver.findElement(customerCityEle).sendKeys((city));
        return this;
    }

    public ParaBankRegisterPage fillStateField(String state) {
        driver.findElement(customerStateEle).sendKeys((state));
        return this;
    }

    public ParaBankRegisterPage fillZipCodeField(String zipCOde) {
        driver.findElement(customerZipCodeEle).sendKeys((zipCOde));
        return this;
    }

    public ParaBankRegisterPage fillPhoneNoField(String phoneNo) {
        driver.findElement(customerPhoneNoEle).sendKeys((phoneNo));
        return this;
    }

    public ParaBankRegisterPage fillSsnNoField(String ssn) {
        driver.findElement(customerPhoneSSNEle).sendKeys((ssn));
        return this;
    }

    public ParaBankRegisterPage fillUserNameField(String userName) {
        driver.findElement(customerUserNameEle).sendKeys((userName));
        return this;
    }

    public ParaBankRegisterPage fillPasswordField(String password) {
        driver.findElement(customerPasswordEle).sendKeys((password));
        return this;
    }

    public ParaBankRegisterPage fillConfirmPass(String confirmPass) {
        driver.findElement(customerConfirmPassEle).sendKeys((confirmPass));
        return this;
    }

    public ParaBankHomePage clickRegisterBtn() {
        driver.findElement(registerBtnEle).click();
        return new ParaBankHomePage(driver);
    }

}
