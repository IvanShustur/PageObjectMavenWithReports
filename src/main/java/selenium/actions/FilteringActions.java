package selenium.actions;

import io.qameta.allure.Step;
import selenium.page.SearchResultPage;

public class FilteringActions {
    private final SearchResultPage searchResultPage;

    public FilteringActions(){searchResultPage = new SearchResultPage();}

    @Step("Filter product by additional parameters")
    public void filteringProduct(String brand) throws InterruptedException {
        searchResultPage.searchInTheSideBarSearchBoxByKeyword(brand);
        searchResultPage.clickOnTheFirstBrandBox(brand);
        searchResultPage.sortingFromHighToLowPrice();
    }
}
