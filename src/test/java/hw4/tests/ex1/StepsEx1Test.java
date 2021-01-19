package hw4.tests.ex1;

import hw4.tests.CommonStepsTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import java.util.Arrays;

@Feature("Home page")
public class StepsEx1Test extends CommonStepsTest {

    @Story("Log in to the Home page and verify web elements")
    @Test
    public void ex1StepsTest() {

        //5 Assert that there are 4 items on the header section are displayed and they have proper texts
        homePageStep.headerMenuShouldHaveItems(4, Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"));

        // 6 Assert that there are 4 images on the Index Page and they are displayed
        homePageStep.amountOfImagesShouldBe(4);

        // 7 Assert that there are 4 texts on the Index Page under icons and they have proper text
        homePageStep.textsUnderImagesShouldBe(4, Arrays.asList("To include good practices\n" +
                        "and ideas from successful\n" +
                        "EPAM project",
                "To be flexible and\n" +
                        "customizable", "To be multiplatform",
                "Already have good base\n" +
                        "(about 20 internal and\n" +
                        "some external projects),\n" +
                        "wish to get more…"));

        // 8 Assert that there is the iframe with “Frame Button” exist
        homePageStep.frameWithTheButtonShouldBeDisplayed();

        // 9 Switch to the iframe and check that there is “Frame Button” in the iframe
        homePageStep.buttonInFrameShouldBeDisplayed();

        // 10 Switch to original window back
        homePageStep.switchToOriginalWindow();

        // 11 Assert that there are 5 items in the Left Section are displayed and they have proper text
        homePageStep.itemsOnLeftSectionShouldBe(5, Arrays.asList("Home", "Contact form", "Service",
                "Metals & Colors", "Elements packs"));
    }
}