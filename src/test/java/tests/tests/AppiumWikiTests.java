package tests.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.screens.WikiOnboardingScreen;
import tests.screens.WikiScreen;


public class AppiumWikiTests extends BaseTest {

    WikiScreen wiki = new WikiScreen();
    WikiOnboardingScreen onboardingScreen = new WikiOnboardingScreen();

    @Tag("appium")
    @Test
    @DisplayName("")
    void onboardingScreenTest() {
        String titleFirst = "New ways to explore";
        String titleSecond = "Reading lists with sync";
        String titleThird = "Data & Privacy";

        onboardingScreen
                .clickContinueButton()
                .checkPageTitleIsDisplayed(titleFirst)
                .clickContinueButton()
                .checkPageTitleIsDisplayed(titleSecond)
                .clickContinueButton()
                .checkPageTitleIsDisplayed(titleThird)
                .clickGetStartedButton();
        wiki.search.isDisplayed();
    }
}
