package hw5.tests.hooks;

import hw5.utils.WebDriverSingleton;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class CucumberHooks {

    @Before
    public void setUp() {
        WebDriverSingleton.getWebDriver();
    }

    @After
    public void tearDown() {
        WebDriverSingleton.closeWebDriver();
    }
}
