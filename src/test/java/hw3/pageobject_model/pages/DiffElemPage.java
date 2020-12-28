package hw3.pageobject_model.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DiffElemPage {

    protected WebDriver webDriver;

    @FindBy(xpath = "//a/span[contains(text(),'Service')]")
    private WebElement diffElemPage;
    @FindBy(xpath = "//a/span[contains(text(),'Different elements')]")
    private WebElement diffElemItemInHeaderMenu;
    @FindBy(xpath = "//li[contains(text(), '%s')]")
    private static List<WebElement> logRows;
    @FindBy(xpath = "//*[@class = 'checkbox-row']/label[contains(., 'Water')]")
    private WebElement waterCheckbox;
    @FindBy(xpath = "//*[@class = 'checkbox-row']/label[contains(., 'Wind')]")
    private WebElement windCheckbox;
    @FindBy(xpath = "//*[@class = 'checkbox-row']/label[contains(., 'Selen')]")
    private WebElement radioSelen;
    @FindBy(xpath = "//select[@class = 'uui-form-element']")
    private WebElement colourInDropDown;

    public DiffElemPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    public void selectDiffElemPage() {
        diffElemPage.click();
    }

    public void selectDiffElemItemInHeaderMenu() {
        diffElemItemInHeaderMenu.click();
    }

    public void selectWaterCheckbox() {
        waterCheckbox.click();
    }

    public void selectWindCheckbox() {
        windCheckbox.click();
    }

    public void selectRadioSelen() {
        radioSelen.click();
    }

    public void selectColourInDropDown() {
        Select colour = new Select(colourInDropDown);
        colour.selectByVisibleText("Yellow");
    }

    public static List<WebElement> getLogRows(String logWord) {
        return logRows;
    }

    public List<WebElement> logWaterCheckbox() {
        return getLogRows("Water");
    }

    public List<WebElement> logWindCheckbox() {
        return getLogRows("Wind");
    }

    public List<WebElement> logSelenRadio() {
        return getLogRows("metal");
    }

    public List<WebElement> colourDropDown() {
        return getLogRows("Colors");
    }
}
