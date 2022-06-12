package selenium.actions;


import io.qameta.allure.Step;
import selenium.page.ItemPage;
import selenium.page.SearchResultPage;

public class BuyActions {
    private final ItemPage itemPage;
    private final SearchResultPage searchResultPage;

    public BuyActions(){
        itemPage = new ItemPage();
        searchResultPage = new SearchResultPage();
    }
    @Step("Buy product")
    public void buyItem(){
        searchResultPage.chooseFirstItemFromTheList();
        itemPage.clickOnAddToCartButton();
    }
}
