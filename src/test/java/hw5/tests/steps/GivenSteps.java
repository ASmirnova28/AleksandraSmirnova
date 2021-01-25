package hw5.tests.steps;

import hw5.data_models.User;
import hw5.pages.HomePage;
import hw5.utils.PropertiesReader;
import hw5.utils.WebDriverSingleton;
import io.cucumber.java.en.Given;
import hw5.utils.PropertiesReader;

import java.io.IOException;

public class GivenSteps extends AbstractStep {

    public GivenSteps() throws IOException {
        super();
    }

    @Given("I open JDI GitHub site")
    public void iAmOnHomePage() {
        homePage.open(PropertiesReader.getProperty("Url"));
    }

    @Given("I login as user \"Roman Iovlev\"")
    public void iLoginOnHomePage() {
        homePage.login(User.builder().setName(PropertiesReader.getProperty("name"))
                .setPassword(PropertiesReader.getProperty("password")).build());
    }
}


