package com.parabank.test;

import com.parabank.pages.Page;
import com.parabank.pages.ParaBankHomePage;
import com.parabank.pages.ParaBankLoginPage;
import com.parabank.pages.ParaBankRegisterPage;
import com.thedeanda.lorem.LoremIpsum;
import org.apache.poi.xssf.usermodel.XSSFRow;
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

    String cellData; //store cell value

    //Read Data From Excel using Java Generic Concept
    public String readDataFromExcel(String excelFilePath, int sheetNumber, int rowNumber, int colNumber) throws IOException {
        try {
            File file = new File(excelFilePath);
            FileInputStream fileInputStream = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            XSSFSheet xssfSheet = workbook.getSheetAt(sheetNumber);
            cellData = xssfSheet.getRow(rowNumber).getCell(colNumber).getStringCellValue();
            System.out.println("Cell value is: " + cellData);
            int rowCount = xssfSheet.getPhysicalNumberOfRows();
            for (int i = 0; i < rowCount; i++) {
                XSSFRow row = xssfSheet.getRow(i);
                int cellCount = row.getPhysicalNumberOfCells();
            }

            workbook.close();
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cellData;
    }


}
