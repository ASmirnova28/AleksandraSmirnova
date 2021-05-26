package hw5.tests.steps;

import hw5.JDIUser;
import hw5.pages.DiffElemPage;
import hw5.pages.UserTablePage;
import hw5.utils.WebDriverSingleton;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Then;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ThenSteps extends AbstractStep {

    public ThenSteps() throws IOException {
        super();
    }

    @Then("There is an individual log row for each checkbox")
    public void iAssertCheckboxLogsOnDifferentElementsPage(List<String> checkboxes) {
        checkboxes = checkboxes.subList(1, checkboxes.size());
        checkboxes.forEach(e -> assertTrue(diffElemPage.isCheckboxLogDisplayed(e, "true")));
    }

    @Then("There is a log row for radio button {string}")
    public void iAssertRadioLogsOnDifferentElementsPage(String radioName) {
        assertTrue(diffElemPage.isRadioLogDisplayed(radioName));
    }

    @Then("There is a log row for dropdown value {string}")
    public void iAssertDropdownLogsOnDifferentElementsPage(String color) {
        assertTrue(diffElemPage.isDropdownLogDisplayed(color));
    }

    @Then("\"User Table\" page should be opened")
    public void iAssertTablePageTitle() {
        assertEquals(WebDriverSingleton.getWebDriver().getTitle(), "User Table");
    }

    @Then("{int} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void iAssertDropdownsOnUserTablePage(int expectedDropdownsAmount) {
        assertEquals(userTablePage.getUsersSelects().size(), expectedDropdownsAmount);
        assertTrue(userTablePage.isUsersDropdownsDisplayed());
    }

    @Then("{int} Usernames should be displayed on Users Table on User Table Page")
    public void iAssertUsernamesOnUserTablePage(int expectedUsernamesAmount) {
        assertEquals(userTablePage.getUsersNames().size(), expectedUsernamesAmount);
        assertTrue(userTablePage.isUsersNamesDisplayed());
    }

    @Then("{int} Description texts under images should be displayed on Users Table on User Table Page")
    public void iAssertDescriptionsUnderImagesOnUserTablePage(int expectedDescriptionsAmount) {
        assertEquals(userTablePage.getUsersImagesDescriptions().size(), expectedDescriptionsAmount);
        assertTrue(userTablePage.isUsersImagesDescriptionDisplayed());
    }

    @Then("{int} checkboxes should be displayed on Users Table on User Table Page")
    public void iAssertCheckboxesOnUserTablePage(int expectedCheckboxesAmount) {
        assertEquals(userTablePage.getUsersCheckboxes().size(), 6);
        assertTrue(userTablePage.isUsersCheckboxesDisplayed());
    }

    @DataTableType
    public JDIUser JdiUserEntry(Map<String, String> entry) {
        return new JDIUser(
                entry.get("numberType"),
                entry.get("user"),
                entry.get("description"));
    }

    @Then("User table should contain following values:")
    public void iAssertContentOfTableOnUserTablePage(List<JDIUser> users) {
        List<JDIUser> actualUserTable = new ArrayList<>();
        List<String> numbers = userTablePage.getUsersIds();
        List<String> usernames = userTablePage.getUsersNames();
        List<String> description = userTablePage.getUsersImagesDescriptions();
        for (int i = 0; i < numbers.size(); i++) {
            actualUserTable.add(new JDIUser(numbers.get(i), usernames.get(i), description.get(i)));
        }
        assertThat(actualUserTable).isEqualTo(users);
    }

    @Then("droplist should contain values in column Type for user Roman")
    public void iAssertRolesOfUser(List<String> args) {
        List<String> actualUserRoles = userTablePage.getUserRoles("Roman");
        List<String> expectedUserRoles = args.subList(1, args.size());
        assertThat(actualUserRoles).isEqualTo(expectedUserRoles);
    }

    @Then("1 log row has {string} text in log section")
    public void iAssertLogRow(String expectedLogText) {
        assertTrue(userTablePage.isLogTextDisplayed(expectedLogText));
    }
}
