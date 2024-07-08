package com.parabank.test;

import com.parabank.pages.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ParaBankBaseTest {
    public Properties properties;
    public String projectDir = System.getProperty("user.dir");
    public FileInputStream inputStream;
    public String browserName;
    public String url;
    public BasePage page;
    public static WebDriver driver;

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
        } else if (browserName.equals("firefoxBrowserHeadless")) {
            //initializing and starting the chrome browser with Headless Mode
            WebDriverManager.firefoxdriver().clearDriverCache().browserVersion("107").setup();
            //create object of firefox options
            FirefoxOptions options = new FirefoxOptions();
            //add the headless argument
            options.addArguments("--headless");

            //pass the options parameter in the firefox driver declaration
            driver = new FirefoxDriver(options);
        } else if (browserName.equals("chromeBrowserHeadless")) {
            //initializing and starting the chrome browser with Headless Mode
            WebDriverManager.chromedriver().clearDriverCache().browserVersion("107").setup();
            //create object of chrome options
            ChromeOptions options = new ChromeOptions();
            //add the headless argument
            options.addArguments("--headless");

            //pass the options parameter in the Chrome driver declaration
            driver = new ChromeDriver(options);
        } else {
            System.out.println("Browser not found");
        }

        url = System.getProperty("applicationUrl");
        driver.get(url);
        driver.manage().window().maximize();
        page = new BasePage(driver);
    }

    //Close browser session
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
