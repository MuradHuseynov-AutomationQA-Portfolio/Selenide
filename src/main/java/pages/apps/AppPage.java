package pages.apps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import pages.base.BasePage;


import static com.codeborne.selenide.Selenide.$x;

public class AppPage extends BasePage {
    private final SelenideElement iframeOFApp = $x("//iframe[@sandbox='allow-forms allow-popups allow-scripts allow-same-origin ']");
    private final SelenideElement settingsButton = $x("//button[@class='sc-iAKWXU hgDMkb']");
    private final SelenideElement addToFavoriteButton = $x("//p[text()='Add to favorite']");
    private final SelenideElement removeFromFavoriteButton = $x("//p[text()='Remove from favorite']");
    private final SelenideElement deleteAppButton = $x("//p[text()='Delete']");
    private final SelenideElement confirmOfDeletingAppButton = $x("//button[@class='button button_danger button_md']");
    private final SelenideElement getFreeButton = $x("//a[@class='sc-iAKWXU gLHXqu sc-fDMmqs aXyBS']");
    private final SelenideElement confirmButtonInTheModalWindow = $x("//button[@class='sc-iAKWXU jmUdjc']");
    private final SelenideElement launchButtonInTheModalWindow = $x("//button[@class='sc-iAKWXU ikmowm']");

    /**
     * Check that application is set
     */
    public AppPage checkApplicatinIsSet() {
        iframeOFApp.shouldBe(Condition.visible);
        return this;
    }

    /**
     * Click to setting button
     */
    public AppPage clickToSettingsButton() {
        settingsButton.shouldBe(Condition.interactable).click();
        return this;
    }

    /**
     * Click to delete button in the drop down
     */
    public AppPage clickToDeleteAppButtonInTheDropDown() {
        deleteAppButton.shouldBe(Condition.interactable).click();
        return this;
    }

    /**
     * Click to add to favorite button in the dropdown
     */
    public AppPage clickToAddToFavoriteButtonInTheDropDown() {
        addToFavoriteButton.shouldBe(Condition.interactable).click();
        return this;
    }

    /**
     * Click to remove from favorite button in the dropdown
     */
    public AppPage clickToRemoveFromFavoriteButtonInTheDropDown() {
        removeFromFavoriteButton.shouldBe(Condition.interactable).click();
        return this;
    }

    /**
     * Confirm deleting app
     */
    public AppPage confirmDeletingApp() {
        confirmOfDeletingAppButton.shouldBe(Condition.interactable).click();
        return this;
    }

    public AppPage clickGetFreeButton() {
        getFreeButton.shouldBe(Condition.interactable).click();
        return this;
    }

    /**
     * Click to confirm button in modal window
     */
    public AppPage clickConfirmButtonInTheModalWindow() {
        confirmButtonInTheModalWindow.shouldBe(Condition.interactable).click();
        return this;
    }

    /**
     * Click to launch button in the modal window
     */
    public AppPage clicklaunchButtonInTheModalWindow() {
        launchButtonInTheModalWindow.shouldBe(Condition.interactable).click();
        return this;
    }
}
