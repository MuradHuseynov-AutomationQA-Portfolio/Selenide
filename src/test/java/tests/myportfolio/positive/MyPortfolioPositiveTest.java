package tests.myportfolio.positive;

import tests.base.BaseTest;
import org.testng.annotations.*;

import static testdata.TestData.URLs.AUTH_URL;

public class MyPortfolioPositiveTest extends BaseTest {

    @Test
    public void checkToConnectNewExchange() {
        basePage.goToUrl(AUTH_URL);
        basePage.signIn();
        basePage.closeModalWindowAboutCookies();
        basePage.goToMyAccountsPage();
        myPortfolioPage.openTheWidgetToConnectExchange()
                .chooseExchange()
                .enterName()
                .enterApiKey()
                .enterApiSecret()
                .submitFormToConnectExchange()
                .checkIfTheExchangeIsConnected();
    }

    @Test(dependsOnMethods = "checkToConnectNewExchange")
    public void checkToRemoveConnectedExchange() {
        basePage.goToUrl(AUTH_URL);
        basePage.signIn();
        basePage.closeModalWindowAboutCookies();
        basePage.goToMyAccountsPage();
        myPortfolioPage.openSettingsDropDownOfConnectedExchange()
                .clickToDeleteButtonInTheDropDown()
                .approveDeletingConnectedExchange()
                .checkIfTheExchangeIsDeleted();
    }
}