package hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public abstract class AbstractTest {

    protected WebDriver webDriver;
    protected CommonStepsTest commonTS;
    protected SoftAssert softAssert;

    @BeforeMethod
    //подумать, мб другая анн
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        webDriver = new ChromeDriver();
        softAssert = new SoftAssert();
        commonTS = new CommonStepsTest(webDriver, softAssert);
    }

    @AfterMethod
    public void tearDown() {
        webDriver.quit();
    }
}
