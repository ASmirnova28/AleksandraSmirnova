package hw4.steps;

import hw4.pageobject_model.pages.DiffElemPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertTrue;

public class DiffElemPageStep {

    private WebDriver webDriver;
    private DiffElemPage diffElemPage;

    public DiffElemPageStep(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.diffElemPage = new DiffElemPage(webDriver);
    }

    @Step("Check checkbox '{0}'")
    public void checkCheckbox(String checkboxName) {
        diffElemPage.setCheckBox(checkboxName);
    }

    @Step("Check radio '{0}'")
    public void checkRadio(String radioName) {
        diffElemPage.setRadio(radioName);
    }

    @Step("Set dropdown color to '{0}'")
    public void setColorDropdownTo(String color) {
        diffElemPage.setColorDropDown(color);
    }

    @Step("For checkbox '{0}' there is individual log row with status '{1}'")
    public void individualLogRowForCheckboxShouldBe(String checkBox, String status) {
        assertTrue(diffElemPage.isCheckboxLogDisplayed(checkBox, status));
    }

    @Step("For radio '{0}' there is individual log")
    public void individualLogRowForRadioShouldBeDisplayed(String radio) {
        assertTrue(diffElemPage.isRadioLogDisplayed(radio));
    }

    @Step("For dropdown value '{0}' there is individual log row")
    public void individualLogRowForDropdownShouldBeDisplayed(String dropdownValue) {
        assertTrue(diffElemPage.isDropdownLogDisplayed(dropdownValue));
    }
}



