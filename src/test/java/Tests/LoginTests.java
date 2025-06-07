package Tests;

import BrowserFactory.PlayWrightFactory;
import Pages.LoginPage;
import com.microsoft.playwright.Page;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTests {
    PlayWrightFactory pf;
    Page page;
    LoginPage loginPage;

    @BeforeTest
    public void setup() {
        pf = new PlayWrightFactory();
        pf.initBrowser("chromium");
        page = pf.getPage(); // Ensure the page is retrieved here
        loginPage = new LoginPage(page); // Pass the initialized page to LoginPage
    }

    @Test
    public void login() {
        String title = loginPage.getLandingPageTile();
        Assert.assertEquals(title, "Products");
    }

    @AfterTest
    public void tearDown() {
        pf.closeBrowser(); // Use the factory's close method to clean up
    }
}
