package hw3.pageobject_model.tests.ex2;

import hw3.pageobject_model.pages.DiffElemPage;
import hw3.pageobject_model.tests.AbstractTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static hw3.pageobject_model.steps.DiffElemPageSteps.*;
import static hw3.pageobject_model.steps.HomePageSteps.assertUserName;
import static hw3.pageobject_model.steps.HomePageSteps.login;

public class PageObjectEx2Test extends AbstractTest {

    protected DiffElemPage diffElemPage;

    @Test
    public void ex2PageObjectTest() throws IOException {
        diffElemPage = new DiffElemPage(webDriver);
        // 2. Assert Browser title
        homePage.assertTitle("Home Page");

        // 3. Perform login
        login(homePage);

        //4.Assert Username is logged in
        assertUserName(homePage);

        //5.Open through the header menu Service -> Different Elements Page
        openDiffElemPage(diffElemPage);

        //6.Select checkboxes
        selectWaterCheckbox(diffElemPage);
        selectWindCheckbox(diffElemPage);

        //7.Select radio
        selectRadio(diffElemPage);

        //8.Select in dropdown
        diffElemPage.selectColourInDropDown();

        //9.Assert that for each checkbox there is an individual log row and value is corresponded to the
        //status of checkbox
        assertCheckboxes(diffElemPage);

        //9.Assert that for radio button there is a log row and value is corresponded to the status of radio button
        assertRadio(diffElemPage);

        //9.Assert that for dropdown there is a log row and value is corresponded to the selected value
        assertInDropdown(diffElemPage);
    }
}
