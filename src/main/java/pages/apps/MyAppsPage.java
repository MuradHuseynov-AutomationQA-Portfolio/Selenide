package pages.apps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import pages.base.BasePage;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.switchTo;

public class MyAppsPage extends BasePage {
    private final SelenideElement appCard = $x("//img[@src='https://app.3commas.io/rails/active_storage/representations/redirect/eyJfcmFpbHMiOnsibWVzc2FnZSI6IkJBaHBBbTM5IiwiZXhwIjpudWxsLCJwdXIiOiJibG9iX2lkIn19--537fc69cb2861ed60ef4477d9f9f3b4a0faa9c41/eyJfcmFpbHMiOnsibWVzc2FnZSI6IkJBaDdCam9MWm05eWJXRjBTU0lJY0c1bkJqb0dSVlE9IiwiZXhwIjpudWxsLCJwdXIiOiJ2YXJpYXRpb24ifX0=--451566e43432d5d1662eef11a653813e542d73af/Untitled%20design%20(1).png']");

    /**
     * Click to app card in order to redirect to App page
     */
    public MyAppsPage clickToAppCard() {
        switchTo().activeElement();
        appCard.should(Condition.interactable).click();
        return this;
    }

    /**
     * Check the app has been deleted
     */
    public MyAppsPage checkIfTheAppIsDeleted() {
        switchTo().activeElement();
        appCard.shouldNotBe(Condition.visible);
        return this;
    }
}
