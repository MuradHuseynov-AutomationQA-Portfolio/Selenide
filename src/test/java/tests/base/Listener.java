package tests.base;//package tests.base;
//
//import com.codeborne.selenide.Selenide;
//import org.junit.jupiter.api.extension.AfterEachCallback;
//import org.junit.jupiter.api.extension.ExtensionContext;
//import org.junit.jupiter.api.extension.TestWatcher;
//import org.junit.platform.commons.logging.Logger;
//import org.junit.platform.commons.logging.LoggerFactory;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//
//import static common.CommonActions.clearBrowserCookiesAndStorage;
//
//public class Listener implements TestWatcher, AfterEachCallback {
//    public static final Logger LOGGER = LoggerFactory.getLogger(Listener.class);
//
//    /**
//     * Make screenshot if test failed
//     * */
//    @Override
//    public void testFailed(ExtensionContext context, Throwable cause) {
//
//        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy MM dd_HH mm ms"));
//        String screenshotName = context.getTestMethod().get().getName() + timestamp;
//        Selenide.screenshot(screenshotName);
//    }
//
//    /**
//     * Make screenshot if test passed
//     * */
//    @Override
//    public void testSuccessful(ExtensionContext context) {
//
//        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy MM dd_HH mm ms"));
//        String screenshotName = context.getTestMethod().get().getName() + timestamp;
//        Selenide.screenshot(screenshotName);
//    }
//
//    @Override
//    public void afterEach(ExtensionContext extensionContext){
//        clearBrowserCookiesAndStorage();
//    }
//
//}
