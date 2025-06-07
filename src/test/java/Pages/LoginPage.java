package Pages;

import com.microsoft.playwright.Page;

public class LoginPage {

    private Page page;
    private String username ="username";
    private  String password = "div#password";

    public LoginPage(Page page){
        this.page=page;
    }

    public String getLandingPageTile() {
        return page.title();
    }

    public void enterUsername(String userName) {
        page.fill(username, userName);
    }
}
