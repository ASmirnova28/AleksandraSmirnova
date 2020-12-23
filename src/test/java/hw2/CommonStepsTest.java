package hw2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public class CommonStepsTest extends AbstractTest {

    private WebDriver webDriver;
    private SoftAssert softAssert;

    public CommonStepsTest(WebDriver webdriver, SoftAssert softAssert) {
        this.webDriver = webdriver;
        this.softAssert = softAssert;
    }

    @BeforeMethod
    public void fourInitialSteps() {

        // 1. Open test site by URL
        String url = "https://jdi-testing.github.io/jdi-light/index.html";
        webDriver.navigate().to(url);
        softAssert.assertEquals(webDriver.getCurrentUrl(), url);

        // 2. Assert Browser title
        softAssert.assertEquals(webDriver.getTitle(), "Home Page");

        // 3. Perform login
        webDriver.findElement(By.id("user-icon")).click();
        webDriver.findElement(By.id("name")).sendKeys("Roman");
        webDriver.findElement(By.id("password")).sendKeys("Jdi1234");
        webDriver.findElement(By.id("login-button")).click();
        softAssert.assertTrue(webDriver.findElement(By.className("logout")).isDisplayed());

        // 4. Assert Username is logged in
        WebElement userName = webDriver.findElement(By.id("user-name"));
        softAssert.assertEquals(userName.getText(), "ROMAN IOVLEV");
    }
}
