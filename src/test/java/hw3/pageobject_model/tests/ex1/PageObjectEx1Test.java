package hw3.pageobject_model.tests.ex1;

import hw3.pageobject_model.pages.HomePage;
import hw3.pageobject_model.tests.AbstractTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static hw3.pageobject_model.steps.HomePageSteps.*;

public class PageObjectEx1Test extends AbstractTest {

    protected String windowHandle;

    @Test
    public void ex1PageObjectTest() throws IOException {
        homePage = new HomePage(webDriver);
        // 2. Assert Browser title
        homePage.assertTitle("Home Page");

        // 3. Perform login
        login(homePage);

        // 4.Assert Username is logged in
        assertUserName(homePage);

        // 5. Assert that there are 4 items on the header section are displayed and they have proper texts
        assertHeader(homePage);

        // 6. Assert that there are 4 images on the Index Page and they are displayed
        assertImages(homePage);

        // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        assertTextsUnderIcons(homePage);

        //8.Assert that there is the iframe with “Frame Button”
        assertIframe(homePage);

        //9.Switch to the iframe and check that there is “Frame Button” in the iframe
        windowHandle = webDriver.getWindowHandle();
        webDriver.switchTo().frame(homePage.getIframe());
        isFrameButtonDisplayed(homePage);

        // 10. Switch to original window back
        webDriver.switchTo().window(windowHandle);

        // 11. Assert that there is Left Section
        assertLeftMenu(homePage);

    }
}

