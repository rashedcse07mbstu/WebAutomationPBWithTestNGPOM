package com.parabank.test;

import com.parabank.pages.Page;
import com.parabank.pages.ParaBankHomePage;
import com.parabank.pages.ParaBankLoginPage;
import com.parabank.pages.ParaBankRegisterPage;
import com.thedeanda.lorem.LoremIpsum;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class ParaBankRegisterTest extends ParaBankBaseTest {

    String firstName = LoremIpsum.getInstance().getFirstName();
    String lastName = LoremIpsum.getInstance().getLastName();
    String addressStreet = LoremIpsum.getInstance().getTitle(2);
    String city = LoremIpsum.getInstance().getCity();
    String state = LoremIpsum.getInstance().getStateAbbr();
    String zipCode = LoremIpsum.getInstance().getZipCode();
    String phoneNumber = LoremIpsum.getInstance().getPhone();
    String ssn = LoremIpsum.getInstance().getTitle(2);
    String username = LoremIpsum.getInstance().getName();
    String password = LoremIpsum.getInstance().getTitle(2);

    Page page;
    ParaBankLoginPage paraBankLoginPage;
    ParaBankRegisterPage paraBankRegisterPage;
    ParaBankHomePage paraBankHomePage;

    @Test
    public void registrationShouldSucceed() {
        paraBankLoginPage = page.getInstance(ParaBankLoginPage.class);
        paraBankRegisterPage = paraBankLoginPage.clickRegisterLink();
        paraBankRegisterPage.fillFirstNameField(firstName)
                .fillLastNameField(lastName)
                .fillAddressStreetField(addressStreet)
                .fillCityField(city)
                .fillStateField(state)
                .fillZipCodeField(zipCode)
                .fillPhoneNoField(phoneNumber)
                .fillSsnNoField(ssn)
                .fillUserNameField(username)
                .fillPasswordField(password)
                .fillConfirmPass(password);
        paraBankHomePage = paraBankRegisterPage.clickRegisterBtn();
        Assert.assertEquals(paraBankHomePage.getWelcomeParaBnkText(), ParaBankHomePage.WelcomeParaBankMessage);
    }

    public void readDataFromExcel() throws IOException {
        File file = new File("E:\\WebAutomationPBWithTestNGPOM\\src\\test\\resources\\TestData.xlsx");
        FileInputStream fileInputStream = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet xssfSheet = workbook.getSheetAt(0);
        String cellValue = xssfSheet.getRow(0).getCell(0).getStringCellValue();
        System.out.println("Cell value is: " + cellValue);
        workbook.close();
        fileInputStream.close();
    }
}
