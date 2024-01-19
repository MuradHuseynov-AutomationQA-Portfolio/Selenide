package pages.apps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import pages.base.BasePage;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.switchTo;

public class FavoritesPage extends BasePage {

    private final SelenideElement appCard = $x("//img[@src='https://app.3commas.io/rails/active_storage/representations/redirect/eyJfcmFpbHMiOnsibWVzc2FnZSI6IkJBaHBBbTM5IiwiZXhwIjpudWxsLCJwdXIiOiJibG9iX2lkIn19--537fc69cb2861ed60ef4477d9f9f3b4a0faa9c41/eyJfcmFpbHMiOnsibWVzc2FnZSI6IkJBaDdCam9MWm05eWJXRjBTU0lJY0c1bkJqb0dSVlE9IiwiZXhwIjpudWxsLCJwdXIiOiJ2YXJpYXRpb24ifX0=--451566e43432d5d1662eef11a653813e542d73af/Untitled%20design%20(1).png']");
    private SelenideElement messageAboutEmpty = $x("//div[@class='empty-placeholder']//span[text()='Nothing in here yet.']");

    /**
     * Check if the app is added to favorites
     */
    public FavoritesPage checkIfTheAppIsAddedToFavorite() {
        switchTo().activeElement();
        appCard.shouldBe(Condition.visible);
        return this;
    }

    /**
     * Check if the app is removed from favorites
     */
    public FavoritesPage checkIfTheAppIsRemovedFromFavorite() {
        switchTo().activeElement();
        messageAboutEmpty.shouldBe(Condition.visible);
        return this;
    }

    /**
     * Click to app card and redirect to App page
     */
    public FavoritesPage clickToAppCard() {
        switchTo().activeElement();
        appCard.should(Condition.interactable).click();
        return this;
    }
}
