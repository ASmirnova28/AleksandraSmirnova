package hw3.pageobject_model.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class AbstractComponent {

    protected WebDriver webDriver;
    protected WebDriverWait wait;

    public AbstractComponent(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, 5);
        PageFactory.initElements(webDriver, this);
    }

    protected boolean isElementsDisplayed(List<WebElement> webElements) {
        wait.until(ExpectedConditions.visibilityOfAllElements(webElements));
        boolean isDisplayed = false;
        for (WebElement element : webElements) {
            isDisplayed = element.isDisplayed();
        }
        return isDisplayed;
    }
}
