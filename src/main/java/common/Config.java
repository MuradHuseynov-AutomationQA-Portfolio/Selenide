package common;

import com.codeborne.selenide.Configuration;

public class Config {
    /**
     * Specify the browser for test
     * chrome
     * firefox
     **/
    public static final String BROWSER = "chrome";

    /**
     * Close the browser after each test method
     */
    public static final Boolean HOLD_BROWSER_OPEN = false;

    // Clear the directory with the screenshots before the build
    public static final Boolean CLEAR_REPORTS_DIR = true;

    // Clean browser cookies after each test method
    public static final Boolean CLEAR_COOKIES = true;

    static {
        Configuration.browser = BROWSER;
        Configuration.reportsFolder = "build/reports/tests";
        Configuration.holdBrowserOpen = HOLD_BROWSER_OPEN;
        Configuration.timeout = 15000;
    }
}
