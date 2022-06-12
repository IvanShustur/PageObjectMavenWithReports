package selenium.page;

import DriverFactory.DriverProvider;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import selenium.decorator.elements.Button;
import selenium.decorator.elements.Label;

public class ItemPage extends BasePage {
    private static final Logger logger = LogManager.getLogger(ItemPage.class);



    @FindBy(xpath = "//button[@class='buy-button button button--with-icon button--green button--medium ng-star-inserted']")
    private Button buyButton;

    @FindBy(xpath = "//li[@class='header-actions__item header-actions__item--cart']")
    private Button openCartButton;

    @FindBy(xpath = "//img[@alt='Rozetka Logo']")
    private Label rozetkaLogo;

    @FindBy (xpath = "//button//span[@class='counter counter--green ng-star-inserted']")
    private Button cartButton;



    public void clickOnAddToCartButton(){
        logger.info("scroll...");
        Actions hover = new Actions(DriverProvider.getDriver());
        hover.moveToElement(rozetkaLogo.getWebElement()).build().perform();
        buyButton.click();

        logger.info("Item was added to the cart");
   }

   public void openShoppingCart (){
        openCartButton.click();
        logger.info("Shopping cart was opened");
    }
    public void AddToCartButton(){
        Actions hover = new Actions(DriverProvider.getDriver());
        hover.moveToElement(rozetkaLogo.getWebElement()).build().perform();
        buyButton.click();

        logger.info("Item was added to the cart");
    }

    public int getAmountOfProductsInTheShoppingCart(){
       int numberOfProductsInTheCart= Integer.parseInt(cartButton.getText());
       return numberOfProductsInTheCart;
    }


}

