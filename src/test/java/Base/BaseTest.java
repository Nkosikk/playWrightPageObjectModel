package Base;

import BrowserFactory.PlayWrightFactory;
import Pages.LoginPage;
import com.microsoft.playwright.Page;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.Properties;

public class BaseTest {
    PlayWrightFactory pf;
    protected Page page;
    protected LoginPage loginPage;
    Properties prop;


    @BeforeTest
    public void setup() {
        pf = new PlayWrightFactory();
        prop = pf.init_prop(); // Initialize properties if needed
        pf.initBrowser(prop);
        page = pf.getPage(); // Ensure the page is retrieved here
        loginPage = new LoginPage(page); // Pass the initialized page to LoginPage
    }

    @AfterTest
    public void tearDown() {
        pf.closeBrowser(); // Use the factory's close method to clean up
    }
}
