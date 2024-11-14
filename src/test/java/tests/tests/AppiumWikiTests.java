package tests.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.screens.*;


public class AppiumWikiTests extends BaseTest {

    WikiScreen wiki = new WikiScreen();
    WikiOnboardingScreen onboardingScreen = new WikiOnboardingScreen();
    WikiOnboardingFirstScreen firstScreen = new WikiOnboardingFirstScreen();
    WikiOnboardingSecondScreen secondScreen = new WikiOnboardingSecondScreen();
    WikiOnboardingThirdScreen thirdScreen = new WikiOnboardingThirdScreen();

    @Tag("appium")
    @Test
    @DisplayName("")
    void onboardingScreenTest() {
        String titleFirst = "New ways to explore";
        String titleSecond = "Reading lists with sync";
        String titleThird = "Data & Privacy";

        onboardingScreen.clickContinueButton();
        firstScreen.checkPageTitleIsDisplayed(titleFirst)
                   .clickContinueButton();
        secondScreen.checkPageTitleIsDisplayed(titleSecond)
                    .clickContinueButton();
        thirdScreen.checkPageTitleIsDisplayed(titleThird)
                   .clickGetStartedButton();
        wiki.search.isDisplayed();
    }
}
