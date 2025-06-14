package Pages;

import com.microsoft.playwright.Page;

public class LoginPage {

    private Page page;
    private String usernameID ="#user-name";
    private  String passwordID = "#password";
    private String loginButtonID = "#login-button"; // Add login button selector


    public LoginPage(Page page){
        this.page=page;
    }

    public String getLoginPageTile() {
        return page.title();
    }

    public boolean login(String userName, String password) {
//        page.waitForSelector("#username"); // Updated selector with '#'

//        page.isVisible(usernameID);
        page.fill(usernameID, userName);
        page.fill(passwordID, password);
        page.click(loginButtonID); // Click login button

        return false;
    }
}
