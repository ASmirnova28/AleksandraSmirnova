package hw7.pageobjects.tests.ex1;

import hw7.pageobjects.pages.HomePage;
import hw7.pageobjects.tests.AbstractTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.List;

public class PageObjectEx1Test extends AbstractTest {

    @Test
    public void ex1PageObjectTest() {

        HomePage homePage = new HomePage(webDriver);

        // 2 Assert Browser title
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(homePage.getBrowserTitle(), "Home Page");

        // 3 Perform login
        homePage.login(USERNAME, PASSWORD);

        // 4 Assert Username is logged
        softAssert.assertTrue(homePage.isUserNameDisplayed());
        softAssert.assertEquals(homePage.getUserName(), "ROMAN IOVLEV");

        // 5 Assert that there are 4 items on the header section are displayed and
        // they have proper texts
        softAssert.assertTrue(homePage.isHeaderMenuItemsDisplayed());
        List<String> actualHeaderMenuItemsText = homePage.getHeaderMenuText();
        List<String> expectedHeaderMenuItemsText = Arrays.asList("HOME", "CONTACT FORM",
                "SERVICE", "METALS & COLORS");
        softAssert.assertEquals(actualHeaderMenuItemsText.size(), 4);
        softAssert.assertEquals(actualHeaderMenuItemsText, expectedHeaderMenuItemsText);

        // 6 Assert that there are 4 images on the Index Page and they are displayed
        softAssert.assertEquals(homePage.getBenefitImagesCount(), 4);
        softAssert.assertTrue(homePage.isBenefitIconsDisplayed());

        // 7 Assert that there are 4 texts on the Index Page under icons and
        // they have proper text
        List<String> actualBenefitTexts = homePage.getBenefitTexts();
        List<String> expectedBenefitTexts = Arrays.asList("To include good practices\n"
                        + "and ideas from successful\n"
                        + "EPAM project",
                "To be flexible and\n"
                        + "customizable",
                "To be multiplatform",
                "Already have good base\n" +
                        "(about 20 internal and\n" +
                        "some external projects),\n" +
                        "wish to get more…");

        softAssert.assertEquals(actualBenefitTexts, expectedBenefitTexts);
        softAssert.assertEquals(homePage.getBenefitTextsCount(), 4);

        // 8 Assert that there is the iframe with “Frame Button” exist
        softAssert.assertTrue(homePage.isFrameDisplayed());

        // 9 Switch to the iframe and check that there is “Frame Button” in the iframe
        homePage.switchToFrame();
        softAssert.assertTrue(homePage.isFrameButtonDisplayed());

        // 10 Switch to original window back
        homePage.switchToDefault();

        // 11 Assert that there are 5 items in the Left Section are displayed and
        // they have proper text
        softAssert.assertEquals(homePage.getSidebarElementsCount(), 5);
        softAssert.assertTrue(homePage.isSidebarElementsDisplayed());
        List<String> expectedSideBarElementsText = Arrays.asList("Home", "Contact form", "Service",
                "Metals & Colors", "Elements packs");
        List<String> actualSideBarElementsText = homePage.getSideBarMenuElementsText();
        softAssert.assertEquals(actualSideBarElementsText, expectedSideBarElementsText);
        softAssert.assertAll();
    }
}

