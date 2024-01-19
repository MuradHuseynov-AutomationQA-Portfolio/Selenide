package tests.invitefriends.positive;

import tests.base.BaseTest;
import org.testng.annotations.*;

import static testdata.TestData.URLs.AUTH_URL;

public class InviteFriendsPositiveTest extends BaseTest {
    @Test
    public void checkToCreateNewLink() {
        basePage.goToUrl(AUTH_URL);
        basePage.signIn();
        basePage.closeModalWindowAboutCookies();
        basePage.goToInviteFriendsPage();
        inviteFirendsPage.openFormToCreateNewLink()
                .enterCode()
                .enterDescription()
                .submitFormToCreateNewLink()
                .checkNewLinkIsCreated();
    }
}