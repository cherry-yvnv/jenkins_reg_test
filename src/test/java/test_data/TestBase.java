package test_data;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Map;

import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;

public class TestBase {

    @BeforeAll
    static void setupSelenideConfig() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = "chrome";
        Configuration.browserVersion = "148.0";
        Configuration.timeout = 15000;
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-dev-shm-usage", "--no-sandbox");
        chromeOptions.setCapability("se:cdpEnabled", false);
        chromeOptions.setCapability("selenoid:options", Map.of(
                "enableVNC", true,
                "enableVideo", false
        ));
        Configuration.browserCapabilities = chromeOptions;
        Configuration.remote = "https://user1:1234@selenoid.qa.guru/wd/hub";
    }

    @BeforeEach
    void setupTest() {

        open("/automation-practice-form");

        executeJavaScript("""
                document.getElementById('fixedban')?.remove();
                document.querySelector('footer')?.remove();
                """);
    }

    @AfterEach
    void afterEach() {
        Selenide.closeWebDriver();
    }
}