package hw5.tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/hw5/cucumber_features",
        glue = "hw5"
)
public class RunCucumberTests extends AbstractTestNGCucumberTests {
}

