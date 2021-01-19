package hw4.tests;

import hw4.steps.DiffElemPageStep;
import hw4.steps.HomePageStep;
import hw4.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class AbstractTest {

    protected WebDriver webDriver;
    public DiffElemPageStep diffElemPageStep;
    public HomePageStep homePageStep;

    @BeforeClass
    public void setUp(ITestContext testContext) {
        webDriver = DriverManager.setupChrome();
        diffElemPageStep = new DiffElemPageStep(webDriver);
        homePageStep = new HomePageStep(webDriver);
        testContext.setAttribute("webdriver", webDriver);
    }

    @AfterClass
    public void tearDown() {
        // 10./12. Close Browser
        webDriver.quit();
    }
}
