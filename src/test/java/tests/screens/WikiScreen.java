package tests.screens;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;

public class WikiScreen {
    SelenideElement
        search = $(accessibilityId("Search Wikipedia")),
        searchInput = $(id("org.wikipedia.alpha:id/search_src_text"));
    ElementsCollection articleTitles = $$(id("org.wikipedia.alpha:id/page_list_item_title"));


    @Step("Click on search")
    public WikiScreen clickSearch() {
        search.click();
        return this;
    }

    @Step("Search for {item}")
    public WikiScreen searchFor(String item) {
        searchInput.sendKeys(item);
        return this;
    }

    @Step("Open first article")
    public WikiScreen clickOnFirstItem() {
        articleTitles.first().click();
        return this;
    }

}
