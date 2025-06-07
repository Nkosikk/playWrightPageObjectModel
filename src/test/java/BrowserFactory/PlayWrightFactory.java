package BrowserFactory;

import com.microsoft.playwright.*;

public class PlayWrightFactory {

    private Browser browser;
    private Page page;

    public void initBrowser(String browserType) {
        Playwright playwright = Playwright.create();
        switch (browserType.toLowerCase()) {
            case "chromium":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "webkit":
                browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser type: " + browserType);
        }
        page = browser.newContext().newPage();
    }

    public Page getPage() {
        return page;
    }

    public void closeBrowser() {
        if (browser != null) {
            browser.close();
        }
    }
}
