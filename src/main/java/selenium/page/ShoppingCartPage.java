package selenium.page;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import selenium.decorator.elements.Button;

public class ShoppingCartPage extends BasePage{
    private static final Logger logger = LogManager.getLogger(ShoppingCartPage.class);
    private static final ThreadLocal<WebDriver> DRIVER_POOL = new ThreadLocal<>();

    @FindBy(xpath = "//div[@class='cart-receipt__sum-price']/span[1]")
    private Button price;

    @FindBy(xpath = "//button[@class='header__button ng-star-inserted header__button--active']")
    private Button shoppingCartButton;



    @FindBy (xpath = "//button[@class='modal__close']")
    private Button closeShoppingCartButton;

    private final String PRICE = "//div[@class='cart-receipt__sum-price']/span[1]";



    public String getPriceOfItem () {
        String  priceOfItem;
        if (!price.isElementPresent()) {
            shoppingCartButton.click();
        }
        priceOfItem = price.getText();
        logger.info("The price of product was taken");
        return priceOfItem;
    }
//    public void closeShoppingCart(){
//        closeShoppingCartButton.click();
//    }

    public void closeShoppingCart(){
        if (isElementPresent()) {
            closeShoppingCartButton.click();
        }
    }
   private Boolean isElementPresent() {
        return closeShoppingCartButton.isElementPresent();
   }

}
