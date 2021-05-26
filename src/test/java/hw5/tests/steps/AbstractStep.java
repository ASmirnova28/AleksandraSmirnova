package hw5.tests.steps;

import hw5.pages.HomePage;
import hw5.pages.DiffElemPage;
import hw5.pages.UserTablePage;
import hw5.utils.WebDriverSingleton;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public abstract class AbstractStep {

    HomePage homePage;
    DiffElemPage diffElemPage;
    UserTablePage userTablePage;

    protected AbstractStep() throws IOException {
        WebDriver webDriver = WebDriverSingleton.getWebDriver();
        homePage = new HomePage(webDriver);
        diffElemPage = new DiffElemPage(webDriver);
        userTablePage = new UserTablePage(webDriver);
    }
}
