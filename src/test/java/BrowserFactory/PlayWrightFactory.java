package BrowserFactory;

import com.microsoft.playwright.*;

import java.beans.beancontext.BeanContext;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PlayWrightFactory {

    private Browser browser;
    private Page page;
    BrowserContext browserContext;
    Properties prop;

    public void initBrowser(Properties prop) {

        String browserName = prop.getProperty("browser").trim();
        Playwright playwright = Playwright.create();
        switch (browserName.toLowerCase()) {
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
                throw new IllegalArgumentException("Unsupported browser type: " + browserName);
        }
        browserContext = browser.newContext();
        page = browser.newContext().newPage();
        page.navigate(prop.getProperty("url").trim());
    }

    public Page getPage() {
        return page;
    }

    public void closeBrowser() {
        if (browser != null) {
            browser.close();
        }
    }

    public Properties init_prop() {
        try {
            FileInputStream ip = new FileInputStream("src/test/resources/config/config.properties");
            prop = new Properties();
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}
