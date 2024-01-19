package tests.base;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import common.CommonActions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.apps.AppPage;
import pages.apps.FavoritesPage;
import pages.apps.MyAppsPage;
import pages.base.BasePage;
import pages.invitefriends.InviteFirendsPage;
import pages.myportfolio.MyPortfolioPage;


public class BaseTest {
    protected BasePage basePage;
    protected InviteFirendsPage inviteFirendsPage;
    protected MyPortfolioPage myPortfolioPage;
    protected AppPage appPage;
    protected MyAppsPage myAppsPage;
    protected FavoritesPage favoritesPage;

    @BeforeMethod
    public void setUp() {
        basePage = new BasePage();
        inviteFirendsPage = new InviteFirendsPage();
        myPortfolioPage = new MyPortfolioPage();
        appPage = new AppPage();
        myAppsPage = new MyAppsPage();
        favoritesPage = new FavoritesPage();
    }

    @AfterMethod
    public void closeWebDriverAndClearCookies() {
        CommonActions.clearBrowserCookiesAndStorage();
        Selenide.closeWebDriver();
    }

//    /**
//     *  Delete old screenshots
//     * */
//    static {
//        if (CLEAR_REPORTS_DIR) {
//            Path path = Path.of("build/reports/tests");
//            try {
//                DirectoryStream<Path> files = Files.newDirectoryStream(path);
//                for(Path file : files){
//                    Files.delete(file);
//                }
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
}
