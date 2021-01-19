package hw4.tests;

import hw4.utils.PropertiesReader;
import org.testng.annotations.BeforeMethod;

public class CommonStepsTest extends AbstractTest {

    protected static final String USERNAME = PropertiesReader.get("name");
    protected static final String PASSWORD = PropertiesReader.get("password");

    @BeforeMethod
    public void fourInitialSteps() {

        // 1 Open test site by URL
        homePageStep.open();

        // 2 Assert Browser title
        homePageStep.browserTitleShouldBe("Home Page");

        // 3 Perform login
        homePageStep.login(USERNAME, PASSWORD);

        // 4 Assert Username is logged in
        homePageStep.usernameShouldBeLoggedIn("ROMAN IOVLEV");
    }
}





