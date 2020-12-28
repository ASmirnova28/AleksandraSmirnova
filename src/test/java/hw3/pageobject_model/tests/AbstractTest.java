package hw3.pageobject_model.tests;

import hw3.pageobject_model.pages.HomePage;
import hw3.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class AbstractTest {

    protected WebDriver webDriver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp() {
        webDriver = DriverManager.setupChrome();
        homePage = new HomePage(webDriver);
        // 1. Open test site by URL
        homePage.openHomePage();
    }

    @AfterClass
    public void tearDown() {
        // 10./12. Close Browser
        webDriver.quit();
    }
}
