package hw3.pageobject_model.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import static org.testng.Assert.assertEquals;

public class HomePage {

    protected WebDriver webDriver;
    protected String URL = "https://jdi-testing.github.io/jdi-light/index.html";


    @FindBy(id = "name")
    private WebElement loginField;
    @FindBy(css = "#password")
    private WebElement passwordField;
    @FindBy(id = "login-button")
    private WebElement enterButton;
    @FindBy(xpath = "//*[@class='profile-photo']//span")
    private WebElement user;
    @FindBy(css = "ul.uui-navigation.nav")
    private WebElement headerItems;
    @FindBy(linkText = "HOME")
    private WebElement homeItem;
    @FindBy(linkText = "CONTACT FORM")
    private WebElement contactFormItem;
    @FindBy(linkText = "SERVICE")
    private WebElement serviceItem;
    @FindBy(linkText = "METALS & COLORS")
    private WebElement metalsAndColorsItem;
    @FindBy(css = ".benefit-icon span")
    private List<WebElement> images;
    @FindBy(css = ".benefit-txt")
    private List<WebElement> texts;
    @FindBy(id = "frame")
    private WebElement iframe;
    @FindBy(id = "button-frame")
    private WebElement frameButton;
    @FindBy(css = "ul.sidebar-menu")
    private WebElement leftMenu;
    @FindBy(className = "profile-photo")
    private WebElement dropDownMenu;

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void openHomePage() {
        webDriver.navigate().to(URL);
    }

    public void assertTitle(String title) {
        assertEquals(webDriver.getTitle(), title);
    }

    public void login() throws IOException {
        InputStream input = new FileInputStream("src/test/resources/hw3/prop.properties");
        Properties prop = new Properties();
        prop.load(input);
        dropDownMenu.click();
        loginField.sendKeys(prop.getProperty("name"));
        passwordField.sendKeys(prop.getProperty("password"));
        enterButton.click();
    }

    public String getUserName() {
        return user.getText();
    }

    public List<WebElement> getImages() {
        return images;
    }

    public List<WebElement> getTexts() {
        return texts;
    }

    public String getHomeItemText() {
        return homeItem.getText();
    }

    public String getContactFormItemText() {
        return contactFormItem.getText();
    }

    public String getServiceItemText() {
        return serviceItem.getText();
    }

    public String getMetalAndColoursItemText() {
        return metalsAndColorsItem.getText();
    }

    public boolean isIframeDispayed() {
        return iframe != null;
    }

    public WebElement getIframe() {
        return iframe;
    }

    public WebElement getFrameButton() {
        return frameButton;
    }

    public Boolean isLeftMenuDisplayed() {
        return leftMenu.isDisplayed();
    }

    public Boolean isHeaderDisplayed() {
        return headerItems.isDisplayed();
    }

}
