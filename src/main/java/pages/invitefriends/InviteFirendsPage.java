package pages.invitefriends;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;
import pages.base.BasePage;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.switchTo;
import static testdata.TestData.InviteFriendsTestData.CODE;
import static testdata.TestData.InviteFriendsTestData.DESCRIPTION;

public class InviteFirendsPage extends BasePage {
    private final SelenideElement createNewLinkButton = $x("//button[@class='sc-iAKWXU bmeOME']");

    private final SelenideElement codeField = $x("//div[@class='col-xs-12 col-lg-4']//input");

    private final SelenideElement descriptionField = $x("//div[@class='col-xs-12 col-lg-6']//input");

    private final SelenideElement createButton = $x("//button[@class='sc-iAKWXU btJRIb js-create-tracking-code-form']");

    private final SelenideElement valueInTheTable = $x("//table[@class='table-info tracking-code-table table-info_has-border-bottom']//*[text()='" + CODE + "']");


    // Open form for creating new link
    public InviteFirendsPage openFormToCreateNewLink() {
        switchTo().activeElement();
        createNewLinkButton.should(Condition.interactable).click();
        return this;
    }

    /**
     * Enter code to codeField
     */
    public InviteFirendsPage enterCode() {
        codeField.should(Condition.interactable).setValue(CODE);
        return this;
    }

    /**
     * Enter description to descriptionField
     */
    public InviteFirendsPage enterDescription() {
        descriptionField.should(Condition.interactable).setValue(DESCRIPTION);
        return this;
    }

    /**
     * Submit form of creating new link
     */
    public InviteFirendsPage submitFormToCreateNewLink() {
        createButton.should(Condition.interactable).click();
        return this;
    }

    // Check if created new link is existed
    public InviteFirendsPage checkNewLinkIsCreated() {
        String actualValue = valueInTheTable.should(Condition.visible).getText();
        Assert.assertEquals(CODE, actualValue);
        return this;
    }
}
