package hw5.utils;

import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class WebDriverSingleton {

    private static WebDriver webDriver;

    private WebDriverSingleton() {
    }

    public static WebDriver getWebDriver() {
        if (Objects.isNull(webDriver)) {
            webDriver = DriverManager.setupChrome();
        }
        return webDriver;
    }

    public static void closeWebDriver() {
        webDriver.quit();
        webDriver = null;
    }
}
