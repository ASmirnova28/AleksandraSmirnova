package hw3.pageobject_model.steps;

import hw3.pageobject_model.pages.HomePage;
import org.openqa.selenium.WebElement;

import java.io.IOException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePageSteps {
    public static void login(HomePage homePage) throws IOException {
        homePage.login();
    }

    public static void assertUserName(HomePage homePage) {
        assertEquals(homePage.getUserName(), "ROMAN IOVLEV");
    }

    public static void assertHeader(HomePage homePage) {
        assertTrue(homePage.isHeaderDisplayed());
        assertEquals(homePage.getHomeItemText(), "HOME");
        assertEquals(homePage.getContactFormItemText(), "CONTACT FORM");
        assertEquals(homePage.getServiceItemText(), "SERVICE");
        assertEquals(homePage.getMetalAndColoursItemText(), "METALS & COLORS");
    }

    public static void assertImages(HomePage homePage) {
        for (WebElement image : homePage.getImages()) {
            assertTrue(image.isDisplayed());
        }
        assertEquals(homePage.getImages().size(), 4);
    }

    public static void assertTextsUnderIcons(HomePage homePage) {
        assertEquals(homePage.getTexts().size(), 4);
        for (WebElement text : homePage.getTexts()) {
            assertTrue(text.isDisplayed());
        }
    }

    public static void assertIframe(HomePage homePage) {
        assertTrue(homePage.isIframeDispayed());
    }

    public static void isFrameButtonDisplayed(HomePage homePage) {
        assertTrue(homePage.getFrameButton().isDisplayed());
    }

    public static void assertLeftMenu(HomePage homePage) {
        assertTrue(homePage.isLeftMenuDisplayed());
    }
}
