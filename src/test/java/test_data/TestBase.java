package test_data;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;


public class TestBase {

    @BeforeAll
    static void setupSelenideConfig() {
        String baseUrl  = System.getProperty("baseUrl", "https://demoqa.com");

        String selenoidHost = System.getProperty("selenoidHost", "selenoid.qa.guru");
        String selenoidLogin = System.getProperty("selenoidLogin", "user1");
        String selenoidPassword = System.getProperty("selenoidPassword", "1234");
        String selenoidPath = System.getProperty("selenoidPath", "wd/hub");

        String browser = System.getProperty("browser", "chrome");
        String browserVersion = System.getProperty("browserVersion", "148.0");
        boolean headless = Boolean.parseBoolean(System.getProperty("headless", "false"));
        String browserSize = System.getProperty("browserSize", "1920x1080");

        String remoteUrl = String.format(
                "https://%s:%s@%s/%s",
                selenoidLogin, selenoidPassword, selenoidHost, selenoidPath
        );

        Configuration.baseUrl = baseUrl;
        Configuration.remote = remoteUrl;
        Configuration.browser = browser;
        Configuration.browserVersion = browserVersion;
        Configuration.headless = headless;
        Configuration.browserSize = browserSize;

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-dev-shm-usage", "--no-sandbox");
        chromeOptions.setCapability("se:cdpEnabled", false);
        chromeOptions.setCapability("selenoid:options", Map.of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = chromeOptions;
    }


    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide().screenshots(true).savePageSource(true));
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }
}