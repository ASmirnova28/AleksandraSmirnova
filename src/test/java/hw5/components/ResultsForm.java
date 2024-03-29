package hw5.components;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ResultsForm extends AbstractComponent {
    @FindBy(className = "summ-res")
    private WebElement summResult;

    @FindBy(className = "col-res")
    private WebElement colorResult;

    @FindBy(className = "met-res")
    private WebElement metalResult;

    @FindBy(className = "sal-res")
    private WebElement vegetablesResult;

    @FindBy(className = "elem-res")
    private WebElement elementsResult;

    public ResultsForm(WebDriver driver) {
        super(driver);
    }

    public Integer getSumResult() {
        return Integer.parseInt(getElementText(summResult));
    }

    public String getColorResult() {
        return getElementText(colorResult);
    }

    public String getMetalResult() {
        return getElementText(metalResult);
    }

    public String getVegetableResult() {
        return getElementText(vegetablesResult);
    }

    public String getElementsResult() {
        try {
            return getElementText(elementsResult);
        } catch (TimeoutException e) {
            return "";
        }
    }

    private String getElementText(WebElement webElement) {
        String elementName = wait.until(ExpectedConditions.visibilityOf(webElement)).getText();
        return elementName.substring(elementName.indexOf(':') + 1)
                .trim().toUpperCase().replace(",", "").replace(" ", "");
    }
}
