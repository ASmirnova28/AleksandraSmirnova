package hw3.pageobject_model.pages;

import hw3.pageobject_model.components.HeaderMenu;
import hw3.pageobject_model.components.LeftMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class AbstractPage {

    protected WebDriver webDriver;
    protected LeftMenu leftMenu;
    protected HeaderMenu headerMenu;
    protected WebDriverWait wait;

    protected AbstractPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver,this);
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, 2);
    }

    protected void putElementsInAList(String elementName, List<WebElement> webElementsList) {
        for (WebElement element : webElementsList) {
            if (!element.isSelected() & element.getText().equals(elementName))
                element.click();
        }
    }
}

