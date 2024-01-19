package pages.myportfolio;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.base.BasePage;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.switchTo;
import static constants.Constants.TimeOutVariables.EXPLICIT_WAIT;
import static testdata.TestData.MyAccountsTestData.*;

public class MyPortfolioPage extends BasePage {
    private final SelenideElement connectExchangeButton = $x("//button[@class='sc-iAKWXU ikmowm zL9zZ']");
    private final SelenideElement exchangeLabel = $x("//div[@data-e2e='huobi']");
    private final SelenideElement nameField = $x("//input[@id='account-name']");
    private final SelenideElement apiKeyField = $x("//input[@id='account-api_key']");
    private final SelenideElement apiSecretField = $x("//input[@id='account-secret']");
    private final SelenideElement connectExchangeButtonInTheWidget = $x("//button[@class='sc-iAKWXU hFwqSh hPaHz']");
    private final SelenideElement connectedExchangeSettingsButton = $x("//button[@class='sc-iAKWXU bkQfGk']");
    private final SelenideElement deleteButtonInTheDropdown = $x("//button//span[text()='Delete']");
    private final SelenideElement deleteButtonInTheWidget = $x("//button[@class='sc-iAKWXU frbySU']");
    private final By connectedExchangeName = By.xpath("//span[@data-e2e='title']");

    /**
     * Open the widget for connecting new exchange
     */
    public MyPortfolioPage openTheWidgetToConnectExchange() {
        switchTo().activeElement();
        connectExchangeButton.should(Condition.interactable).click();
        return this;
    }

    /**
     * Choose exchange
     */
    public MyPortfolioPage chooseExchange() {
        exchangeLabel.should(Condition.interactable).click();
        return this;
    }

    /**
     * Enter name to the name field
     */
    public MyPortfolioPage enterName() {
        nameField.sendKeys(Keys.SHIFT, Keys.HOME, Keys.DELETE);
        nameField.setValue(NAME);
        return this;
    }

    /**
     * Enter api key to the field
     */
    public MyPortfolioPage enterApiKey() {
        apiKeyField.should(Condition.interactable).setValue(API_KEY);
        return this;
    }

    /**
     * Enter api secret to the field
     */
    public MyPortfolioPage enterApiSecret() {
        apiSecretField.setValue(API_SECRET);
        return this;
    }

    /**
     * Connect exchange to the account on 3commas
     */
    public MyPortfolioPage submitFormToConnectExchange() {
        connectExchangeButtonInTheWidget.click();
        return this;
    }

    /**
     * Check that exchange is connected to account on 3commas
     */
    public MyPortfolioPage checkIfTheExchangeIsConnected() {
        WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), Duration.ofSeconds(EXPLICIT_WAIT));
        WebElement actualTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(connectedExchangeName));
        Assert.assertEquals(actualTitle.getText(),NAME);
        return this;
    }

    /**
     * Open settings dropdown of connected exchange
     */
    public MyPortfolioPage openSettingsDropDownOfConnectedExchange() {
        switchTo().activeElement();
        connectedExchangeSettingsButton.should(Condition.interactable).click();
        return this;
    }

    /**
     * Click to delete button in the settings dropdown of connected exchange
     */
    public MyPortfolioPage clickToDeleteButtonInTheDropDown() {
        deleteButtonInTheDropdown.should(Condition.interactable).click();
        return this;
    }

    /**
     * Approve in the opened widget to delete connected exchange
     */
    public MyPortfolioPage approveDeletingConnectedExchange() {
        deleteButtonInTheWidget.should(Condition.interactable).click();
        return this;
    }

    /**
     * Check that connected exchange is deleted
     */
    public MyPortfolioPage checkIfTheExchangeIsDeleted() {
        WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), Duration.ofSeconds(EXPLICIT_WAIT));
        Assert.assertTrue(wait.until(ExpectedConditions.invisibilityOfElementLocated(connectedExchangeName)));
        return this;
    }

}
