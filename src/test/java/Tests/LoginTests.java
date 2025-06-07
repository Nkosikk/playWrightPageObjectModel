package Tests;

import Base.BaseTest;
import BrowserFactory.PlayWrightFactory;
import Pages.LoginPage;
import com.microsoft.playwright.Page;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {




    @Test
    public void login() {
        String title = loginPage.getLandingPageTile();
        Assert.assertEquals(title, "Swag Labs");
    }


}
