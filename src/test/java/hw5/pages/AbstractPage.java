package hw5.pages;

import hw5.components.HeaderMenu;
import hw5.components.SidebarMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class AbstractPage {

    protected WebDriver webDriver;
    protected SidebarMenu sidebarMenu;
    protected HeaderMenu headerMenu;
    protected WebDriverWait wait;

    protected AbstractPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, 5);
    }

    protected void putElementsInAList(String elementName, List<WebElement> webElementsList) {
        for (WebElement element : webElementsList) {
            if (!element.isSelected() & element.getText().equals(elementName))
                element.click();
        }
    }
}


