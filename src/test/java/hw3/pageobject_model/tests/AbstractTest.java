package hw3.pageobject_model.tests;

import hw3.utils.DriverManager;
import hw3.utils.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class AbstractTest {

    protected WebDriver webDriver;
    protected WebDriverWait wait;
    protected static final String URL = PropertiesReader.get("Url");
    protected static final String USERNAME = PropertiesReader.get("name");
    protected static final String PASSWORD = PropertiesReader.get("password");

    @BeforeClass
    public void setUp() {
        webDriver = DriverManager.setupChrome();
        wait = new WebDriverWait(webDriver, 1000);
        // 1. Open test site by URL
        webDriver.navigate().to(URL);
    }

    @AfterClass
    public void tearDown() {
        // 10./12. Close Browser
        webDriver.quit();
    }
}
