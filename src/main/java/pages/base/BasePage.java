package pages.base;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.refresh;
import static constants.Constants.TimeOutVariables.EXPLICIT_WAIT;
import static testdata.TestData.SignInTestData.SESSION_ID_KEY;
import static testdata.TestData.SignInTestData.SESSION_ID_VALUE;

public class BasePage {
    public final SelenideElement inviteFriendsPageLink = $x("//a[@data-name='invite_friends']");
    public final SelenideElement myAccountsPageLink = $x("//a[@data-name='my_portfolio']");
    private final SelenideElement allowAllCookiesButton = $x("//button[@class='ch2-btn ch2-allow-all-btn ch2-btn-primary']");
    private final SelenideElement appsLinksDropdown = $x("//li[@data-name='apps_store']");
    private final SelenideElement myAppsPageLink = $x("//a[@data-name='my_apps']");
    private final SelenideElement favoritesPageLink = $x("//a[@data-name='favorites']");
    private final By iframe = By.xpath("//iframe[@id='wiz-iframe']");
    private final By buttonInIframe = By.xpath("//div[@class='ct-banner-button-container']//button");

    /**
     * This method for redirect to InviteFriends page
     */
    public void goToInviteFriendsPage() {
        inviteFriendsPageLink.shouldBe(Condition.interactable).click();
        try {
            WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), Duration.ofSeconds(EXPLICIT_WAIT));
            WebElement iframeElement = wait.until(ExpectedConditions.presenceOfElementLocated(iframe));
            WebDriverRunner.getWebDriver().switchTo().frame(iframeElement);
            WebDriverRunner.getWebDriver().findElement(buttonInIframe).click();
        } catch (Exception e) {
            //
        }
    }

    /**
     * This method for redirect to MyAppsPage page
     */
    public void goToMyAppsPage() {
        appsLinksDropdown.shouldBe(Condition.interactable).click();
        myAppsPageLink.shouldBe(Condition.interactable).click();
        try {
            WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), Duration.ofSeconds(EXPLICIT_WAIT));
            WebElement iframeElement = wait.until(ExpectedConditions.presenceOfElementLocated(iframe));
            WebDriverRunner.getWebDriver().switchTo().frame(iframeElement);
            WebDriverRunner.getWebDriver().findElement(buttonInIframe).click();
        } catch (Exception e) {
            //
        }
    }

    /**
     * This method for redirect to MyAccount page
     */
    public void goToMyAccountsPage() {
        myAccountsPageLink.shouldBe(Condition.interactable).click();
        try {
            WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), Duration.ofSeconds(EXPLICIT_WAIT));
            WebElement iframeElement = wait.until(ExpectedConditions.presenceOfElementLocated(iframe));
            WebDriverRunner.getWebDriver().switchTo().frame(iframeElement);
            WebDriverRunner.getWebDriver().findElement(buttonInIframe).click();
        } catch (Exception e) {
            //
        }
    }

    /**
     * This method for redirect to Favorites page
     */
    public void goToFavoritesPage() {
        appsLinksDropdown.shouldBe(Condition.interactable).click();
        favoritesPageLink.shouldBe(Condition.interactable).click();
        try {
            WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), Duration.ofSeconds(EXPLICIT_WAIT));
            WebElement iframeElement = wait.until(ExpectedConditions.presenceOfElementLocated(iframe));
            WebDriverRunner.getWebDriver().switchTo().frame(iframeElement);
            WebDriverRunner.getWebDriver().findElement(buttonInIframe).click();
        } catch (Exception e) {
            //
        }
    }

    /**
     * The method for navigating to a specific URL
     */
    public void goToUrl(String url) {
        Selenide.open(url);
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    /**
     * The method for authorization to a specific site
     */
    public void signIn() {
        Cookie authCookie = new Cookie(SESSION_ID_KEY, SESSION_ID_VALUE);
        WebDriverRunner.getWebDriver().manage().addCookie(authCookie);
        refresh();
    }

    /**
     * Allow all cookies in modal window
     */
    public void closeModalWindowAboutCookies() {
        WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), Duration.ofSeconds(EXPLICIT_WAIT));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(allowAllCookiesButton)).click();
        } catch (Exception e) {
            //
        }
    }
}
