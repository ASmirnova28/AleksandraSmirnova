package hw3.pageobject_model.steps;

import hw3.pageobject_model.pages.DiffElemPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class DiffElemPageSteps {

    public static void openDiffElemPage(DiffElemPage diffElemPage) {
        diffElemPage.selectDiffElemPage();
        diffElemPage.selectDiffElemItemInHeaderMenu();
    }

    public static void selectWaterCheckbox(DiffElemPage diffElemPage) {
        diffElemPage.selectWaterCheckbox();
    }

    public static void selectWindCheckbox(DiffElemPage diffElemPage) {
        diffElemPage.selectWindCheckbox();
    }

    public static void selectRadio(DiffElemPage diffElemPage) {
        diffElemPage.selectRadioSelen();
    }

    public static void assertCheckboxes(DiffElemPage diffElemPage) {
        for (WebElement checkbox : diffElemPage.logWaterCheckbox()) {
            Assert.assertTrue(checkbox.isDisplayed());
        }
        for (WebElement checkbox : diffElemPage.logWindCheckbox()) {
            Assert.assertTrue(checkbox.isDisplayed());
        }
    }

    public static void assertRadio(DiffElemPage diffElemPage) {
        for (WebElement logRadio : diffElemPage.logSelenRadio()) {
            Assert.assertTrue(logRadio.isDisplayed());
        }
    }

    public static void assertInDropdown(DiffElemPage diffElemPage) {
        for (WebElement logDropdrown : diffElemPage.colourDropDown()) {
            Assert.assertTrue(logDropdrown.isDisplayed());
        }
    }
}



