package selenium;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import selenium.actions.BuyActions;
import selenium.actions.FilteringActions;
import selenium.actions.NavigationActions;
import selenium.actions.SearchingActions;
import selenium.asserts.PriceAsserter;
import selenium.model.Filter;
import selenium.util.FileReader;

import java.util.List;


public class RozetkaTest extends  BaseTest {


    @DataProvider(parallel = true)
    public Object[] filters() {
        List<Filter> filterList = FileReader.readListOfObject("src/main/resources/filters.json", Filter.class);
        return  filterList.toArray();
    }


    @Test(dataProvider = "filters")
    public void checkThatThePriceOFProductHigherThanGivenPrice(Filter filter) throws InterruptedException {
        NavigationActions navigationActions = new NavigationActions();
        SearchingActions searchingActions = new SearchingActions();
        FilteringActions filteringActions = new FilteringActions();
        BuyActions buyActions = new BuyActions();
        PriceAsserter priceAsserter = new PriceAsserter();
        navigationActions.navigateToHomePage();
        searchingActions.searchProduct(filter.getName());
       // filteringActions.filteringProduct(filter.getBrand());
        buyActions.buyItem();
        priceAsserter.compareThatThePriceHigherThenGivenSum(filter.getSum());

    }
}







