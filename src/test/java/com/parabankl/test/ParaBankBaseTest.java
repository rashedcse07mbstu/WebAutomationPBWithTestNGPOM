package com.parabankl.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ParaBankBaseTest {

    public WebDriver driver;
    private Properties properties;
    protected String projectDir = System.getProperty("user.dir");
    public FileInputStream inputStream;
    public String browserName;

    @BeforeMethod
    public void setUp() {
        try {
            //Get properties File
            String configFilePath = projectDir + "/src/test/resources/config.properties";
            properties = new Properties();

            //Load Properties File
            inputStream = new FileInputStream(configFilePath);
            properties.load(inputStream);
        } catch (IOException e) {
            System.out.println("Configuration properties file is not found");
        }

        browserName = properties.getProperty("browserName");
        if (browserName.equals("firefox")) {
            WebDriverManager.firefoxdriver().clearDriverCache().browserVersion("107").setup();
        } else if (browserName.equals("chrome")) {
            //initializing and starting the chrome browser
            WebDriverManager.chromedriver().clearDriverCache().browserVersion("107").setup();
            driver = new ChromeDriver();
        }

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
