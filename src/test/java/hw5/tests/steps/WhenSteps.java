package hw5.tests.steps;

import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.List;

public class WhenSteps extends AbstractStep {

    public WhenSteps() throws IOException {
        super();
    }

    @When("I click on \"Service\" button in Header")
    public void iClickOnServiceButtonInHeader() {
        homePage.openServiceMenu();
    }

    @When("I click on {string} button in Service dropdown")
    public void iClickOnButtonInServiceDropdown(String button) {
        homePage.navigateToPageFromServiceMenu(button.toUpperCase());
    }

    @When("I set checkboxes")
    public void iSelectCheckboxesOnDifferentElementsPage(List<String> checkboxes) {
        checkboxes = checkboxes.subList(1, checkboxes.size());
        checkboxes.forEach(e -> diffElemPage.setCheckBox(e));
    }

    @When("I set radio {string}")
    public void iSelectRadioOnDifferentElementsPage(String radio) {
        diffElemPage.setRadio(radio);
    }

    @When("I set dropdown {string}")
    public void iSelectDropdownOnDifferentElementsPage(String color) {
        diffElemPage.setColorDropDown(color);
    }

    @When("I select 'vip' checkbox for {string}")
    public void iSelectCheckbox(String username) {
        userTablePage.setVipCheckbox(username);
    }
}

