package selenium.asserts;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import selenium.page.HomePage;
import selenium.page.ShoppingCartPage;

public class PriceAsserter {
    private final ShoppingCartPage shoppingCartPage;
    private static final Logger logger = LogManager.getLogger(HomePage.class);

    public PriceAsserter(){shoppingCartPage = new ShoppingCartPage();}

    @Step("Verify price of the product with given [{filter.getSum()}]")
    public void compareThatThePriceHigherThenGivenSum(String sum){
        Assert.assertTrue(Integer.parseInt(shoppingCartPage.getPriceOfItem()) > Integer.parseInt(sum));
        logger.info("The price of product was compared to given price");

    }
}
