package tests.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import tests.drivers.BrowserStackDriver;
import tests.drivers.LocalDriver;
import tests.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    public static String env = System.getProperty("env");

    @BeforeAll
    static void beforeAll() {
        switch (env) {
            case "browserstack":
                Configuration.browser = BrowserStackDriver.class.getName();
                break;
            case "appium":
                Configuration.browser = LocalDriver.class.getName();
                break;
            default:
                Configuration.browser = LocalDriver.class.getName();
        }

        Configuration.browserSize = null;
        Configuration.timeout = 30000;
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    void addAttachments() {
        String sessionId = Selenide.sessionId().toString();
        if (env.equals("appium")) {
            Attach.screenshotAs("Last screenshot");
        }

        Attach.pageSource();
        closeWebDriver();

        if (env.equals("browserstack")) {
            Attach.addVideo(sessionId);
        }
    }
}
