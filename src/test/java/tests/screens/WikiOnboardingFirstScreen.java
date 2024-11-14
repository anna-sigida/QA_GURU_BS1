package tests.screens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WikiOnboardingFirstScreen {

    private final SelenideElement skipButton = $(id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")),
            continueButton = $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")),
            getStartedButton = $(id("org.wikipedia.alpha:id/fragment_onboarding_done_button")),
            onboardingTitle = $(id("org.wikipedia.alpha:id/primaryTextView"));

    @Step("Click on Continue button")
    public WikiOnboardingFirstScreen clickContinueButton() {
        continueButton.click();
        return this;
    }

    @Step("Click on Get started button")
    public WikiOnboardingFirstScreen clickGetStartedButton() {
        getStartedButton.click();
        return this;
    }

    @Step("Check title appears")
    public WikiOnboardingFirstScreen checkPageTitleIsDisplayed(String title) {
        assertThat(onboardingTitle.getText()).isEqualTo(title);
        return this;
    }
}
