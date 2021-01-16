package hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

public abstract class AbstractTest {

    protected WebDriver webDriver;
    protected CommonStepsTest commonTS;
    protected SoftAssert softAssert;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        softAssert = new SoftAssert();
        commonTS = new CommonStepsTest(webDriver, softAssert);
    }

    @AfterClass
    public void tearDown() {
        webDriver.quit();
    }
}
