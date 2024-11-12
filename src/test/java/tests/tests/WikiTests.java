package tests.tests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.screens.WikiScreen;

import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.className;

public class WikiTests extends BaseTest {
    WikiScreen wiki = new WikiScreen();

    @Tag("browserstack")
    @Test
    @DisplayName("Open first article from search")
    void openFirstArticleTest() {
        String expectedArticleName = "Appium";
        wiki
            .clickSearch()
            .searchFor(expectedArticleName)
            .clickOnFirstItem();

        Assertions.assertThat($$(className("android.widget.TextView")).get(0).getAttribute("text")
                .equals(expectedArticleName));
    }
}
