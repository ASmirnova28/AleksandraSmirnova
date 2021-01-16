package hw3.pageobject_model.tests.ex2;

import hw3.pageobject_model.pages.DiffElemPage;
import hw3.pageobject_model.pages.HomePage;
import hw3.pageobject_model.tests.AbstractTest;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class PageObjectEx2Test extends AbstractTest {

    @Test
    public void ex2PageObjectTest() {

        HomePage homePage = new HomePage(webDriver);

        // 2 Assert Browser title
        assertEquals(homePage.getBrowserTitle(), "Home Page");

        // 3 Perform login
        homePage.login(USERNAME, PASSWORD);

        // 4 Assert Username is logged
        assertTrue(homePage.isUserNameDisplayed());
        assertEquals(homePage.getUserName(), "ROMAN IOVLEV");

        // 5 Open through the header menu Service -> Different Elements Page
        WebDriverWait wait = new WebDriverWait(webDriver, 5);
        homePage.goToDifferentElementsPage();

        // 6 Select checkboxes "Water", "Wind"
        String checkBoxOne = "Water";
        String checkBoxTwo = "Wind";
        DiffElemPage diffElemPage = new DiffElemPage(webDriver);
        diffElemPage.setCheckBox(checkBoxOne);
        diffElemPage.setCheckBox(checkBoxTwo);

        // 7 Select radio "Selen"
        String radio = "Selen";
        diffElemPage.setRadio(radio);

        // 8 Select in dropdown "Yellow"
        String color = "Yellow";
        diffElemPage.setColorDropDown(color);

        // 9 Assert that
        //   for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        assertTrue(diffElemPage.isCheckboxLogDisplayed(checkBoxOne, "true"));
        assertTrue(diffElemPage.isCheckboxLogDisplayed(checkBoxTwo, "true"));

        //   for radio button there is a log row and value is corresponded to the status of radio button
        assertTrue(diffElemPage.isRadioLogDisplayed(radio));

        //   for dropdown there is a log row and value is corresponded to the selected value
        assertTrue(diffElemPage.isDropdownLogDisplayed(color));
    }
}
