package hw4.tests.ex1;

import hw4.tests.CommonStepsTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Feature("Different elements page")
public class StepsEx2Test extends CommonStepsTest {

    @Story("Verify all selectors on the page")
    @Test
    public void ex2StepsTest() {

        // 5 Open through the header menu Service -> Different Elements Page
        homePageStep.goToDifferentElementsPage();

        // 6 Select checkboxes "Water", "Wind"
        String checkBoxOne = "Water";
        String checkBoxTwo = "Wind";
        diffElemPageStep.checkCheckbox(checkBoxOne);
        diffElemPageStep.checkCheckbox(checkBoxTwo);

        // 7 Select radio "Selen"
        String radio = "Selen";
        diffElemPageStep.checkRadio(radio);

        // 8 Select in dropdown "Yellow"
        String dropdownColor = "Yellow";
        diffElemPageStep.setColorDropdownTo(dropdownColor);

        // 9 Assert that
        //    • for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        diffElemPageStep.individualLogRowForCheckboxShouldBe(checkBoxOne, "true");
        diffElemPageStep.individualLogRowForCheckboxShouldBe(checkBoxTwo, "true");

        //    • for radio button there is a log row and value is corresponded to the status of radio button
        diffElemPageStep.individualLogRowForRadioShouldBeDisplayed(radio);

        //    • for dropdown there is a log row and value is corresponded to the selected value
        diffElemPageStep.individualLogRowForDropdownShouldBeDisplayed(dropdownColor);
    }
}
