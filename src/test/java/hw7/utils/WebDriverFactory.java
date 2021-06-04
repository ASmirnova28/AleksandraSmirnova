package hw7.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class WebDriverFactory {

    private static final String CHROME = "chrome";
    private static final String FIREFOX = "firefox";

    public static WebDriver createWebDriver(final String browserName) {
        WebDriver webDriver;

        if (CHROME.equalsIgnoreCase(browserName)) {
            webDriver = createChromeDriver();
        } else if (FIREFOX.equalsIgnoreCase(browserName)) {
            webDriver = createFirefoxDriver();
        } else {
            throw new IllegalArgumentException(String.format("Unsupported browser %s",
                    browserName));
        }
        return webDriver;
    }

    private static WebDriver createChromeDriver() {
        WebDriver webDriver = null;
        try {
            webDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),
                    new ChromeOptions());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return webDriver;
    }

    private static WebDriver createFirefoxDriver() {
        WebDriver webDriver = null;
        try {
            webDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),
                    new FirefoxOptions());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return webDriver;
    }
}
