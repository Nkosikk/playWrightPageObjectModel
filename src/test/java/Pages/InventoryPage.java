package Pages;

import com.microsoft.playwright.Page;

public class InventoryPage {

    private Page page;
    private String productSelector = ".inventory_item_name"; // Update with the correct selector for product names
// Add login button selector


    public InventoryPage(Page page){
        this.page=page;
    }

    public String getLandingPageTile() {
        page.waitForSelector(".inventory_item_name"); // Updated selector with '#'
        return page.title();
    }

    public boolean verifyLoginSuccess() {
        page.isVisible(productSelector);
        if(page.isVisible(productSelector)) {
            System.out.println("Login successful and product page is visible.");
            return true;
        } else {
            System.out.println("Login failed or product page is not visible.");
            return false;
        }

    }
}
