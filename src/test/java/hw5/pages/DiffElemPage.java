package hw5.pages;

import hw5.components.LogRows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DiffElemPage extends AbstractPage {

    private LogRows logRows;

    @FindBy(css = ".colors select")
    private WebElement colorsDropdown;

    @FindBy(className = "label-radio")
    private List<WebElement> radioElements;

    @FindBy(className = "label-checkbox")
    private List<WebElement> checkBoxElements;

    public DiffElemPage(WebDriver webDriver) {
        super(webDriver);
        this.logRows = new LogRows(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public boolean isCheckboxLogDisplayed(String checkboxName, String status) {
        return logRows.isCheckboxLogDisplayed(checkboxName, status);
    }

    public boolean isRadioLogDisplayed(String radioName) {
        return logRows.isRadioLogDisplayed(radioName);
    }

    public boolean isDropdownLogDisplayed(String dropdownValue) {
        return logRows.isDropdownLogDisplayed(dropdownValue);
    }

    public void setColorDropDown(String color) {
        colorsDropdown = wait.until(ExpectedConditions.visibilityOf(colorsDropdown));
        Select select = new Select(colorsDropdown);
        select.selectByVisibleText(color);
    }

    public void setCheckBox(String checkboxName) {
        putElementsInAList(checkboxName, checkBoxElements);
    }

    public void setRadio(String radioName) {
        putElementsInAList(radioName, radioElements);
    }
}

