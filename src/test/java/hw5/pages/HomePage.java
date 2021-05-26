package hw5.pages;

import hw5.components.HeaderMenu;
import hw5.components.SidebarMenu;
import hw5.data_models.User;
import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractPage {

    public HomePage(WebDriver webDriver) {
        super(webDriver);
        this.headerMenu = new HeaderMenu(webDriver);
        this.sidebarMenu = new SidebarMenu(webDriver);
    }

    public void open(String url) {
        webDriver.get(url);
    }

    public void login(User user) {
        headerMenu.login(user.getName(), user.getPassword());
    }

    public boolean isUserNameDisplayed() {
        return headerMenu.isUserNameDisplayed();
    }

    public String getUserName() {
        return headerMenu.getUserName();
    }

    public String getBrowserTitle() {
        return webDriver.getTitle();
    }

    public void openServiceMenu() {
        headerMenu.openServiceMenu();
    }

    public void navigateToPageFromServiceMenu(String page) {
        headerMenu.navigateToPageFromServiceMenu(page);
    }

    public void navigateToMetalsColorsPage() {
        headerMenu.navigateToMetalsColorsPage();
    }
}

