package hw4.steps;

import hw3.utils.PropertiesReader;
import hw4.pageobject_model.pages.HomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePageStep {

    private static final String URL = PropertiesReader.get("Url");
    private WebDriver webDriver;
    private HomePage homePage;

    public HomePageStep(WebDriver webDriver) {
        this.webDriver = webDriver;
        homePage = new HomePage(webDriver);
    }

    @Step("Opening Home page")
    public void open() {
        webDriver.manage().window().maximize();
        webDriver.get(URL);
    }

    @Step("Browser title should be '{0}'")
    public void browserTitleShouldBe(String expectedValue) {
        String actualValue = webDriver.getTitle();
        assertEquals(actualValue, expectedValue);
    }

    @Step("Logging in as username:'{0}' password:'{1}'")
    public void login(String username, String password) {
        homePage.login(username, password);
    }

    @Step("User name should be '{0}' and displayed")
    public void usernameShouldBeLoggedIn(String value) {
        assertTrue(homePage.isUserNameDisplayed());
        assertEquals(homePage.getUserName(), value);
    }

    @Step("Header menu should be displayed, has '{0}' items, which have proper texts: '{1}'")
    public void headerMenuShouldHaveItems(int amountOfItems, List<String> expectedHeaderText) {
        assertTrue(homePage.isHeaderMenuItemsDisplayed());
        assertEquals(homePage.getHeaderMenuText().size(), amountOfItems);
        List<String> actualHeaderMenuItemsText = homePage.getHeaderMenuText();
        assertEquals(actualHeaderMenuItemsText.size(), 4);
        assertEquals(actualHeaderMenuItemsText, expectedHeaderText);
    }

    @Step("Home page should have '{0}' images")
    public void amountOfImagesShouldBe(int amountOfItems) {
        assertTrue(homePage.isBenefitIconsDisplayed());
        assertEquals(homePage.getBenefitImagesCount(), amountOfItems);
    }

    @Step("There should be '{0}' texts under images on Home page: '{1}'")
    public void textsUnderImagesShouldBe(int amountOfTexts, List<String> expectedImageText) {
        assertEquals(homePage.getBenefitTextsCount(), amountOfTexts);
        List<String> actualBenefitTexts = homePage.getBenefitTexts();
        assertEquals(actualBenefitTexts, expectedImageText);
    }

    @Step("Frame with the button should be displayed")
    public void frameWithTheButtonShouldBeDisplayed() {
        assertTrue(homePage.isFrameDisplayed());
    }

    @Step("Switch to the frame, button in the frame should be displayed")
    public void buttonInFrameShouldBeDisplayed() {
        homePage.switchToFrame();
        assertTrue(homePage.isFrameButtonDisplayed());
    }

    @Step("Switch back to default")
    public void switchToOriginalWindow() {
        homePage.switchToDefault();
    }

    @Step("There should be '{0}' items in the Left Section and they should have proper text: '{1}'")
    public void itemsOnLeftSectionShouldBe(int value, List<String> expectedText) {
        assertEquals(homePage.getSidebarElementsCount(), value);
        assertTrue(homePage.isSidebarElementsDisplayed());
        assertEquals(homePage.getSideBarMenuElementsText(), expectedText);
    }

    @Step("Open through the header menu Service -> Different Elements Page")
    public void goToDifferentElementsPage() {
        homePage.goToDifferentElementsPage();
    }
}
