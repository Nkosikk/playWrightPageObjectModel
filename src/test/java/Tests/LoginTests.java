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

import java.util.Properties;

import static Constants.ApplicationConstants.Landing_Page_Title;
import static Constants.ApplicationConstants.Login_Page_Title;

public class LoginTests extends BaseTest {


    @Test
    public void verifyLoginDisplayed() {
        String title = loginPage.getLoginPageTile();
        Assert.assertEquals(title, Login_Page_Title, "Title does not match");
    }

    @Test(dependsOnMethods = "verifyLoginDisplayed")
    public void login() {
        loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
    }

    @Test(dependsOnMethods = "login")
    public void verifyLandingPageDisplayed() {
        String title = inventoryPage.getLandingPageTile();
        Assert.assertEquals(title, Login_Page_Title, "ProductsN");
    }

    @Test(dependsOnMethods = "verifyLandingPageDisplayed")
    public void verifyLoginSuccess() {
        inventoryPage.verifyLoginSuccess();
    }


}
