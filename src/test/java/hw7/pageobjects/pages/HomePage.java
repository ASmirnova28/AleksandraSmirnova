package hw7.pageobjects.pages;

import hw7.pageobjects.components.Benefits;
import hw7.pageobjects.components.ButtonFrame;
import hw7.pageobjects.components.HeaderMenu;
import hw7.pageobjects.components.SidebarMenu;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class HomePage extends AbstractPage {

    private Benefits benefits;
    private ButtonFrame buttonFrame;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
        this.headerMenu = new HeaderMenu(webDriver);
        this.benefits = new Benefits(webDriver);
        this.buttonFrame = new ButtonFrame(webDriver);
        this.sidebarMenu = new SidebarMenu(webDriver);
    }

    public void login(String username, String password) {
        headerMenu.login(username, password);
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

    public List<String> getHeaderMenuText() {
        return headerMenu.getHeaderMenuElementsText();
    }

    public boolean isHeaderMenuItemsDisplayed() {
        return headerMenu.isHeaderMenuItemsDisplayed();
    }

    public int getBenefitImagesCount() {
        return benefits.getBenefitImagesNumber();
    }

    public int getBenefitTextsCount() {
        return benefits.getBenefitTextsNumber();
    }

    public List<String> getBenefitTexts() {
        return benefits.getBenefitTexts();
    }

    public boolean isBenefitIconsDisplayed() {
        return benefits.isBenefitIconsDisplayed();
    }

    public boolean isFrameDisplayed() {
        return buttonFrame.isFrameDisplayed();
    }

    public boolean isFrameButtonDisplayed() {
        return buttonFrame.isButtonDisplayed();
    }

    public void switchToFrame() {
        buttonFrame.switchToFrame();
    }

    public void switchToDefault() {
        buttonFrame.switchToDefaultWindow();
    }

    public boolean isSidebarElementsDisplayed() {
        return sidebarMenu.isSidebarElementsDisplayed();
    }

    public List<String> getSideBarMenuElementsText() {
        return sidebarMenu.getSideBarMenuElementsText();
    }

    public int getSidebarElementsCount() {
        return sidebarMenu.getSidebarElementsCount();
    }

    public void goToDifferentElementsPage() {
        headerMenu.goToDifferentElementPage();
    }
}

