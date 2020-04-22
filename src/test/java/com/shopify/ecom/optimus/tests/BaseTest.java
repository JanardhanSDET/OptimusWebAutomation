package com.shopify.ecom.optimus.tests;

import com.shopify.ecom.optimus.pages.HomePage;
import com.shopify.ecom.optimus.pages.OptimusEcomsComingSoonPage;
import com.shopify.ecom.optimus.pages.PageGenerator;
import com.shopify.ecom.optimus.pages.StorePasswordPage;
import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wait;
    public PageGenerator page;
    OptimusEcomsComingSoonPage optimusEcomsComingSoonPage;
    StorePasswordPage storePasswordPage;
    HomePage homePage;
    @BeforeMethod
    public void setup() {

        String browserName = null;
        String url = null;

        try {
            FileReader fileReader = new FileReader("src/test/resources/TestData.properties");
            Properties properties = new Properties();
            properties.load(fileReader);
            browserName = properties.getProperty("browserName");
            url = properties.getProperty("url");
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        }

        if (browserName.equalsIgnoreCase("CHROME")) {
            WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("FIREFOX")) {
            WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
            driver = new FirefoxDriver();
        }

        wait = new WebDriverWait(driver, 15);

        driver.manage().window().maximize();

        page = new PageGenerator(driver);
        instantiatePages(page);
        driver.navigate().to(url);

        optimusEcomsComingSoonPage.verifyHomePage().navigateStorePasswordPage();

        storePasswordPage.verifyStorePasswordPage().nagivagateToHomePage();

        homePage.verifyHomePage();


    }

    public void instantiatePages(PageGenerator page) {
        optimusEcomsComingSoonPage = page.getInstance(OptimusEcomsComingSoonPage.class);
        storePasswordPage = page.getInstance(StorePasswordPage.class);
        homePage = page.getInstance(HomePage.class);
    }

    @AfterMethod
    public void teardown() {
        //driver.quit();
    }
}